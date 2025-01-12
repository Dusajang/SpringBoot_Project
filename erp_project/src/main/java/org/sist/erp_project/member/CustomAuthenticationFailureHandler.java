package org.sist.erp_project.member;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	                                    AuthenticationException exception) throws IOException, ServletException {
	    String errorType;

	    if (exception instanceof UsernameNotFoundException) {
	        errorType = "username"; // 아이디가 틀린 경우
	    } else if (exception instanceof BadCredentialsException) {
	        errorType = "password"; // 비밀번호가 틀린 경우
	    } else {
	        errorType = "unknown"; // 기타 오류
	    }

	    String redirectUrl = "/login?error=" + errorType;
	    getRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

} //class


/*
예외 전달 과정

UsernamePasswordAuthenticationFilter → 인증 실패.

Spring Security가 AuthenticationException으로 예외 래핑.

등록된 AuthenticationFailureHandler 호출(CustomAuthenticationFailureHandler).

CustomAuthenticationFailureHandler에서 AuthenticationException 수행

*/
