package org.sist.erp_project.faq;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
	Page<Faq> findAll(Pageable pageable);
	
	@Modifying
    @Query("UPDATE Faq f SET f.viewCount = f.viewCount + 1 WHERE f.id = :id")
    void updateViewCount(@Param("id") Long id);
	
	//페이징 처리 + 검색 Specification<Faq>
	Page<Faq> findAll(Specification<Faq> spec, Pageable pageable);
	
	//이전글, 다음글 쿼리 최적화
	@Query(value = "SELECT * FROM (SELECT * FROM FAQ WHERE id < :id ORDER BY id DESC) WHERE ROWNUM = 1", nativeQuery = true)
	Optional<Faq> findPreviousFaq(@Param("id") Long id);

	@Query(value = "SELECT * FROM (SELECT * FROM FAQ WHERE id > :id ORDER BY id ASC) WHERE ROWNUM = 1", nativeQuery = true)
	Optional<Faq> findNextFaq(@Param("id") Long id);
}	