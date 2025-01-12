package org.sist.erp_project.member;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
    	
        String redirectUrl = "/main"; // 기본 리다이렉트 경로

        if (authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN"))) {
        	
        	log.info("admin match success {} " , authentication.getAuthorities() );
        	
            redirectUrl = "/admin/member_manage"; // 관리자 페이지
        }
        
        log.info( "리다이렉트 {}, {}" , redirectUrl, authentication.getAuthorities());

        response.sendRedirect(redirectUrl);
    }
}
