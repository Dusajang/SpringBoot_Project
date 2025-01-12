package org.sist.erp_project.educationCourse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EducationCourseRepository extends JpaRepository<EducationCourse, Long> {

    @Query("SELECT e FROM EducationCourse e " +
            "WHERE (:keyword IS NULL OR e.courseName LIKE %:keyword%) " +
            "AND (:classification IS NULL OR e.classification = :classification) " +
            "AND (:center IS NULL OR e.center = :center)")
     Page<EducationCourse> findBySearchCriteria(@Param("keyword") String keyword,
                                                @Param("stype") String stype,
                                                @Param("classification") Classification classification,
                                                @Param("center") Center center,
                                                Pageable pageable);
}