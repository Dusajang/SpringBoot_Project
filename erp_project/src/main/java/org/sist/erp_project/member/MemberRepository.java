package org.sist.erp_project.member;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Optional<Member> findByUsername(String username); //사용자 정보 가져오기
	
	Optional<Member> findByNameAndEmail(String name, String email);//아이디찾기
	
	Optional<Member> findByNameAndUsernameAndEmail(String name, String username, String email);//비밀번호 찾기
	
	@Modifying
	@Query("UPDATE Member m SET m.status = :status WHERE m.username = :username")
	void updateStatusByUsername(@Param("status") Status status, @Param("username") String username);
	
	//페이징 처리
	Page<Member> findAll(Pageable pageable);

	
}
