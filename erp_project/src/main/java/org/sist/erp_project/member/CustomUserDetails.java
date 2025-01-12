package org.sist.erp_project.member;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	
        // Member의 권한 리스트 -> Spring Security GrantedAuthority 변환
        return member.getAuthorities().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        
        return member.getPassword();
    }

    @Override
    public String getUsername() {
       
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정이 만료되지 않았다고 가정
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정이 잠겨있지 않았다고 가정
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 자격 증명이 만료되지 않았다고 가정
        return true;
    }

    @Override
    public boolean isEnabled() {
    	
        // Status으로 결정하자
        return member.getStatus() == Status.ACTIVE;
    }
    
} //class