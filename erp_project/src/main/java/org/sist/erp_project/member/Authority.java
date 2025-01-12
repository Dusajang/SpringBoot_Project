package org.sist.erp_project.member;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authority")
@ToString
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private Long authId;

    @Column(nullable = false)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "member_id") //member_id로 fk 생성 후 Member와 연결
    @ToString.Exclude
    private Member member; // 권한을 소유한 사용자
}