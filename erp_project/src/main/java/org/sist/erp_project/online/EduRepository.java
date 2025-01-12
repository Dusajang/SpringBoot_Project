package org.sist.erp_project.online;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EduRepository extends JpaRepository<Edu, Long>{
	Page<Edu> findAll(Pageable pageable);
	@Modifying
    @Query("UPDATE Edu e SET e.viewCount = e.viewCount + 1 WHERE e.id = :id")
    void updateViewCount(@Param("id") Long id);
	
	//페이징 처리 + 검색 Specification<Faq>
	Page<Edu> findAll(Specification<Edu> spec, Pageable pageable);
	
	// native 쿼리로 수정:
	@Query(value = "SELECT * FROM (SELECT * FROM Edu WHERE id < :id ORDER BY id DESC) WHERE ROWNUM = 1", nativeQuery = true)
	Optional<Edu> findPreviousEdu(@Param("id") Long id);

	@Query(value = "SELECT * FROM (SELECT * FROM Edu WHERE id > :id ORDER BY id ASC) WHERE ROWNUM = 1", nativeQuery = true)
	Optional<Edu> findNextEdu(@Param("id") Long id);
}
