package org.sist.erp_project.member;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberSecurityService implements UserDetailsService{
	
	private final MemberRepository memberRepository;

	
	@Override                                              //InternalAuthenticationServiceException
	public UserDetails loadUserByUsername(String username) throws AuthenticationException{
		
	 return  memberRepository.findByUsername(username)
			                 .map(CustomUserDetails::new)
			                 .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));		
	}

}//class

/*
isPresent()	값이 존재하면 true, 없으면 false를 반환.
ifPresent(Consumer c)	값이 존재하면 처리할 로직(Consumer)을 실행.
orElse(T other)	값이 있으면 반환, 없으면 other를 반환.
orElseThrow()	값이 없을 경우 지정된 예외를 던짐.
map(Function f)	값이 있으면 함수(Function)을 적용하여 결과 반환, 없으면 빈 Optional 반환.
*/

/*
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    Member member = memberRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username));
    
  
    return new CustomUserDetails(member);
}
*/