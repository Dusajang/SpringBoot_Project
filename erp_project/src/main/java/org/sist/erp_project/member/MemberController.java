package org.sist.erp_project.member;



import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	private final MemberSecurityService memberSecurityService;
	private final PasswordEncoder passwordEncoder;
	
	@GetMapping("/main")
	public String main() {
		log.info(">메인페이지 접근..");
		
		return "sist/sist_main";
	}
	
	@GetMapping("/managermode")
	public String system() {
		
		log.info(">관리자 모드..");
		
		return "sist/member/go_manage";
	}
	
    @GetMapping("/admin/member_manage")
    public String memberManage(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
    	
        Page<Member> members = memberService.getMembers(page);
        
        model.addAttribute("paging", members);
        
        return "sist/member/member_manage";
    }
	
	
	@GetMapping("/login")
	public String login(Model model) {
	    log.info(">로그인페이지 접근..");

	    return "sist/member/login";
	}
	
	@GetMapping("/go_managelogin")
	public String adminLogin() {
	    log.info("> 관리자 모드 로그인 페이지 접근");
	    return "sist/member/go_managelogin";
	}

	
	@GetMapping("/join")
	public String join(MemberForm form) {
		log.info(">회원가입페이지 접근..");
		
		return "sist/member/join";
	}
	
	@GetMapping("/joined")
	public String joined() {
		log.info(">회원가입완료");
		
		return "sist/member/joincomplete";
	}
	
	
	@GetMapping("/find")	
	public String find(Model model, FindIdForm findIdForm, FindPwForm findPwForm) {
		
		log.info(">찾기페이지..");
				
		return "sist/member/findac";
	}
	
	//아이디 찾기
	@PostMapping("/findid")
	public String findIdSubmit(@Valid FindIdForm findIdForm, BindingResult bindingResult, Model model) {
		
	    if (bindingResult.hasErrors()) {
	    	
	        return "sist/member/findac";
	    }

	    String username = memberService.findUsername(findIdForm.getName(), findIdForm.getEmail());
	    
	    model.addAttribute("username", username);
	    model.addAttribute("name", findIdForm.getName());
	    
	    return "sist/member/showid";
	}
	
	//비밀번호 찾기
	@PostMapping("/findpw")
	public String findPwSubmit(@Valid FindPwForm findPwForm, BindingResult bindingResult, Model model) {
		
	    if (bindingResult.hasErrors()) {
	    	
	        return "sist/member/findac";
	    }

	    String tempPassword = memberService.issueTemporaryPassword(findPwForm.getName(), 
	    		                                                   findPwForm.getUsername(), 
	    		                                                   findPwForm.getEmail());
	    
	    model.addAttribute("tempPassword", tempPassword);
	    model.addAttribute("name", findPwForm.getName());
	    
	    return "sist/member/showpw";
	}
	
	
	@GetMapping("/showid")
	public String showfind() {
		log.info(">찾기페이지..");
		
		return "sist/member/showid";
	}
	
	//회원가입
	@PostMapping("/join")
	public String reg(@Valid MemberForm form, BindingResult result) {
				
		log.info(">회원가입 요청...");
				    	    
	    if (result.hasErrors()) {
	        result.getAllErrors().forEach(error -> {
	            log.error("유효성 검증 실패 - 필드: {}, 메시지: {}", 
	                error.getObjectName(), error.getDefaultMessage());
	        });
	        return "sist/member/join";
	    }

	    //회원가입 서비스 호출
	    this.memberService.reg(form);
	    		
	    return "redirect:/login";
	}
	
	
    @GetMapping("/mypage")
    public String manage(Authentication authentication, Model model, MemberForm memberForm) {
    	
    	log.info("마이페이지 요청..");
    	
    	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    	
    	String email = userDetails.getMember().getEmail();
    	
    	Gender gender = userDetails.getMember().getGender();
    	
    	Location location = userDetails.getMember().getLocation();
    	
    	log.info("성별 {} ", gender); //FEMALE
    	
    	
	   	
    	String[] parts = email.split("@");

    	String local = parts[0];
    	String domain = parts[1];

    	model.addAttribute("local", local);
    	model.addAttribute("domain", domain);
    	model.addAttribute("gender", gender);
    	
    	model.addAttribute("location", location);
    	
    	log.info("이메일" + local);
    	log.info("이메일" + domain);
    
        return "sist/member/mypage";
    }
    
    @PostMapping("/mypage")
    public String change(Authentication authentication, @Valid MemberForm memberForm, BindingResult result) {
        if (result.hasErrors()) {
            return "sist/member/mypage";
        }

        // 정보 수정
        memberService.updateMember(memberForm);

        // 수정된 사용자 정보 로드
        CustomUserDetails updatedUserDetails = (CustomUserDetails) memberSecurityService.loadUserByUsername(memberForm.getUsername());

        // SecurityContext 갱신
        SecurityContextHolder.getContext().setAuthentication(
        		
        		                                    //update 정보                        인증 자격                              권한
            new UsernamePasswordAuthenticationToken(updatedUserDetails, authentication.getCredentials(), updatedUserDetails.getAuthorities())
        );

        
        return "redirect:/mypage";
    }


	@GetMapping("/withdraw")
	public String withdraw() {
		
		log.info(">탈퇴..");
		
		return "sist/member/withdraw";
	}
	
	@PostMapping("/withdraw")
	
	public String gowithdraw(@RequestParam("username") String username,
	                         @RequestParam("password") String password,
	                         Authentication authentication) {
		
	    log.info("> 탈퇴 신청 요청...");

	   
	    CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

	    String realUsername = userDetails.getMember().getUsername();
	    String realPassword = userDetails.getMember().getPassword();

	   
	    if (!username.equals(realUsername)) {
	        log.error("아이디가 일치하지 않습니다.");
	        return "redirect:/withdraw?error=idMismatch";
	    }

	   
	    if (!passwordEncoder.matches(password, realPassword)) {
	        log.error("비밀번호가 일치하지 않습니다.");
	        return "redirect:/withdraw?error=passwordMismatch";
	    }

	    // 탈퇴 서비스 호출
	    memberService.withdraw(username);

	    log.info("회원 탈퇴 완료: {}", username);
	    
	    return "redirect:/withdraw?result=success";
	}

        

    @GetMapping("/principal")
    public String principal(Authentication authentication, Model model) {
    	
    	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    	
    	LocalDate time =  userDetails.getMember().getBirthDate();
    	    	
        // 사용자 정보와 권한 리스트를 뷰에 전달
        model.addAttribute("member", userDetails.getMember());
        model.addAttribute("authorities", userDetails.getAuthorities());
    	
        return "sist/member/principal";
    }
  
    

}//class

/*
 
         log.info("인증 정보 확인: {}", authentication);

        // Principal에서 사용자 정보 추출
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        log.info("사용자 이름: {}", userDetails.getUsername());
        log.info("사용자 이메일: {}", userDetails.getMember().getEmail());
 
 */







