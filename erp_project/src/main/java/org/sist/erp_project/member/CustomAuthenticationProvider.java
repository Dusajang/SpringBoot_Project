/*
package org.sist.erp_project.member;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CustomAuthenticationProvider extends DaoAuthenticationProvider{
	
	private final MemberSecurityService memberSecurityService;
	
	@PostConstruct
    public void init() {
        this.setUserDetailsService(memberSecurityService);
        this.setPasswordEncoder(new BCryptPasswordEncoder());
    }
	
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        try {
            // 기본 검증 로직 호출
            super.additionalAuthenticationChecks(userDetails, authentication);
        } catch (AuthenticationException ex) {
            // UsernameNotFoundException은 그대로 전달
            if (ex instanceof UsernameNotFoundException) {
            	log.info("UsernameNotFoundException");
                throw ex;
            }
            // 나머지는 BadCredentialsException으로 처리
            log.info("BadCredentialsException");
            throw new BadCredentialsException("비밀번호가 틀렸습니다.");
        }
    }

} //class
*/