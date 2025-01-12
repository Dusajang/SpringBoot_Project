package org.sist.erp_project.educationCourse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailImageRepository extends JpaRepository<DetailImage, Long> {
    // JpaRepository<엔티티, 기본 키 타입>
}