package org.sist.erp_project.educationCourse;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EducationCourseService {
	
	// SearchDTO를 사용하여 교육과정 목록 조회
	Page<EducationCourse> getEduList(SearchDTO searchDTO, Pageable pageable);
	
	// 교육과정 상세 보기
	EducationCourse getCourse(Long id);
	
    // 교육과정 저장
    void saveCourse(EducationCourse educationCourse);
    
    // 교육과정 파일 업로드
    EducationCourse FileUpload(EducationCourse educationCourse, EducationCourseForm form) throws IOException;
}

