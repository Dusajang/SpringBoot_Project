package org.sist.erp_project.member;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;
	private final EmailService emailService;
	
	
	public void reg(MemberForm form) {
		
        log.info("> 회원가입 서비스 시작...");
        
        // 암호화
        String password = passwordEncoder.encode(form.getPassword());
        log.info("암호화된 비밀번호: {}", password);
        
        // Gender Enum 변환
        Gender genderEnum = Gender.fromValue(form.getGender());
        log.info("변환된 성별 Enum: {}", genderEnum);

        // Location Enum 변환
        Location location = Location.fromValue(form.getLocation());
        log.info("변환된 지역 Enum: {}", location);
        

        // Member 객체 생성
        Member member = Member.builder()
        	.username(form.getUsername())
            .password(password)
            .name(form.getName())
            .birthDate(form.getBirthDate())
            .phone(form.getPhone())
            .contect(form.getContect())
            .email(form.getEmail())
            .gender(genderEnum)
            .smsOptIn(form.isSmsOptIn())
            .emailOptIn(form.isEmailOptIn())
            .postalCode(form.getPostalCode())
            .address(form.getAddress())
            .addressDetail(form.getAddressDetail())
            .location(location)
            .joinDate(LocalDate.now())
            .build();
            
        // 권한 생성 및 설정
        Authority authority = new Authority();
        authority.setRoleName("USER"); // 기본 권한 설정
        authority.setMember(member); // 권한에 회원 설정

        // Member 객체에 권한 추가
        member.setAuthorities(List.of(authority)); // 권한 리스트에 추가
        
        
        log.info("저장된 Member 객체: {}", member);
        log.info("저장된 권한");
        
        member.getAuthorities().forEach( auth ->
        		                          log.info(auth.getRoleName())
        		                        );
        
        memberRepository.save(member);
        
    }
	
	
	//아이디 찾기
	public String findUsername(String name, String email) {
		
		return memberRepository.findByNameAndEmail(name, email) // Optional<Member> 반환(null값명시)
				               .map(Member::getUsername) // Member 존재하면 getUsername 
				               .orElseThrow(()-> new RuntimeException("사용자를 찾을 수 없습니다."));
		
	}
	
	//비밀번호 찾기
	
    public String issueTemporaryPassword(String name, String username, String email) {
    	
        	
        Member member = memberRepository.findByNameAndUsernameAndEmail(name, username, email)
                .orElseThrow(() -> new RuntimeException("회원 정보를 찾을 수 없습니다."));

        // 임시 비밀번호 생성
        String tempPassword = UUID.randomUUID().toString().substring(0, 6);

        // 암호화
        String encodedPassword = passwordEncoder.encode(tempPassword);
        
        //저장
        member.setPassword(encodedPassword);
              
        memberRepository.save(member);

        // 이메일 전송
        emailService.sendEmail(email, "임시 비밀번호가 발급되었습니다.", "임시 비밀번호는 " + tempPassword + "입니다.");

        return tempPassword;
    }
    
    
    //정보 수정
    public void updateMember(MemberForm memberForm) {
    	
        log.info("회원 정보 수정 시작: {}", memberForm);

        // 기존 회원 정보 조회 이때, JPA는 **엔티티의 초기 상태(Snapshot)**를 저장해 두고, 엔티티의 속성이 변경되는지 추적합니다.
        Member member = memberRepository.findByUsername(memberForm.getUsername()) //영속성 컨텍스트에 의해 관리 
                .orElseThrow(() -> new IllegalArgumentException("회원 정보를 찾을 수 없습니다."));

        String password = passwordEncoder.encode(memberForm.getPassword());
        //암호화
        member.setPassword(password);
        
        // Gender Enum 변환
        Gender genderEnum = Gender.fromValue(memberForm.getGender());
        log.info("변환된 성별 Enum: {}", genderEnum);

        // Location Enum 변환
        Location location = Location.fromValue(memberForm.getLocation());
        log.info("변환된 지역 Enum: {}", location);
        
        
        // 기타 정보 업데이트 엔티티의 필드 값이 변경되면, JPA는 이를 Dirty 상태로 표시
        member.setName(memberForm.getName());
        member.setBirthDate(memberForm.getBirthDate());
        member.setPhone(memberForm.getPhone());
        member.setContect(memberForm.getContect());
        member.setEmail(memberForm.getEmail());
        member.setGender(genderEnum);
        member.setSmsOptIn(memberForm.isSmsOptIn());
        member.setEmailOptIn(memberForm.isEmailOptIn());
        member.setPostalCode(memberForm.getPostalCode());
        member.setAddress(memberForm.getAddress());
        member.setAddressDetail(memberForm.getAddressDetail());
        member.setLocation(location);

        // 엔티티의 필드 값이 변경되면, JPA는 이를 Dirty 상태로 표시 -> @Transactional 덕분에 Dirty Checking으로 변경 사항 반영
       // memberRepository.save(member);
        
        log.info("회원 정보 수정 완료: {}", member);
        
    }

    //탈퇴
    public void withdraw(String username) {
    	
    	memberRepository.updateStatusByUsername(Status.PENDING_DEACTIVATION, username);       
    }
    
    //회원 가져오기
    public Page<Member> getMembers(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by(Sort.Order.desc("memberId")));
        return this.memberRepository.findAll(pageable);
    }


	
}//class

/*
 log.info("저장된 권한: {}", 
         member.getAuthorities().stream()
               .map(Authority::getRoleName)
               .toList());
*/
