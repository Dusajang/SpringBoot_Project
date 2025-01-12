package org.sist.erp_project.config;

import org.sist.erp_project.member.CustomAuthenticationFailureHandler;
import org.sist.erp_project.member.CustomAuthenticationSuccessHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity // SecurityFilterChain 적용.. 모든 요청에
@EnableMethodSecurity(prePostEnabled = true) // Method 활성화 (@PreAuthorize, @PostAuthorize)
@RequiredArgsConstructor
public class SecurityConfig {
	
	   private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	   private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	   @Bean                             
	   SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
	      
	      http
	      .csrf((csrf) -> csrf
	      .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))) //csrf제외
	      //접근권한 설정
	      .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
	    		    .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
	    		    .requestMatchers("/**").permitAll()
	    		)
	      .headers((headers) -> headers // Clickjacking 방지 X-Frame-Options 헤더 설정                    동일출처허용
	      .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
	      .formLogin(
	    		  (formLogin) -> formLogin
	    		  .loginPage("/login")
	    		  .defaultSuccessUrl("/main")
	    		  .successHandler(customAuthenticationSuccessHandler)
	    		  .failureHandler(customAuthenticationFailureHandler)
	    		  )
	      .logout((logout) -> logout
	              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	              .logoutSuccessUrl("/main")
	              .invalidateHttpSession(true));
	      
	      return http.build();
	   }
	   
	   
	   @Bean
	    PasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
		}
	   
	    @Bean
	    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
	        return authenticationConfiguration.getAuthenticationManager();
	    }
	
} //class


// /login -> UsernamePasswordAuthenticationFilter(UsernameNotFoundException) -> 실패시 : SimpleUrlAuthenticationFailureHandler
