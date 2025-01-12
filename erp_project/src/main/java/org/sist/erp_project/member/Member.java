package org.sist.erp_project.member;

import java.time.LocalDate;
import java.util.List;

import org.sist.erp_project.educationCourse.EducationCourse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "member")
@Builder
public class Member {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // 회원번호 자동 증가
    private Long memberId;

    @Column(nullable = false, unique = true) 
    private String username;

    @Column(nullable = false)
    @ToString.Exclude
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate; // 생일

    @Column(nullable = false, unique = true)
    private String phone; //폰
     
    private String contect; // 연락처

    @Column(unique = true, nullable = false) // 이메일 고유값 설정
    private String email;
    
    @NotNull
    @Enumerated(EnumType.ORDINAL) 
    private Gender gender; // Enum 타입 변경

    private boolean smsOptIn = false; // SMS 수신 여부

    private boolean emailOptIn = false; // 이메일 수신 여부

    @Column(updatable = false) // 가입일은 수정 불가
    private LocalDate joinDate;

    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.ACTIVE; 
   
    //한명의 멤버가 하나의 아이디니까
    @ManyToOne
    @JoinColumn(name = "course_id")
    private EducationCourse educationCourse;
    
    @Enumerated(EnumType.ORDINAL)
    private Location location;

    @Column(nullable = false)
    private String postalCode; // 우편번호

    @Column(nullable = false)
    private String address; // 기본 주소

    @Column(nullable = false)
    private String addressDetail; // 나머지 주소
    
    //        member필드와 연결                  연쇄 저장, 삭제     
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Authority> authorities; // 권한 리스트
    
    @PrePersist
    public void prePersist() {
    	
        if (this.status == null) {
            this.status = Status.ACTIVE;
        }
    	
        if (this.joinDate == null) {
            this.joinDate = LocalDate.now();
        }
    }

}//class
