package org.sist.erp_project.educationCourse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.sist.erp_project.exception.DataNotFoundException;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationCourseServiceImpl implements EducationCourseService{

	private final EducationCourseRepository educationCourseRepository;
	private final DetailImageRepository detailImageRepository;
	
    @Override
    public Page<EducationCourse> getEduList(SearchDTO searchDTO, Pageable pageable) {
        return educationCourseRepository.findBySearchCriteria(searchDTO.getKeyword(), 
                                                              searchDTO.getStype(),
                                                              searchDTO.getClassification(), 
                                                              searchDTO.getCenter(), 
                                                              pageable);
    }

    // 교육과정 상세 가져오기
    @Override
    public EducationCourse getCourse(Long id) {
        return this.educationCourseRepository.findById(id)
            .orElseThrow(() -> new DataNotFoundException("EducationCourse not found."));
    }

	
    @Override
    public void saveCourse(EducationCourse educationCourse) {
        educationCourseRepository.save(educationCourse);
    }
    
    @Override
    public EducationCourse FileUpload(EducationCourse educationCourse, EducationCourseForm form) throws IOException {
        // 목록 이미지 처리
        if (form.getListImage() != null && !form.getListImage().isEmpty()) {
            String listImageUrl = saveFile(form.getListImage());
            educationCourse.setListImage(listImageUrl);  // 목록 이미지 URL 설정
        }

        // EducationCourse 먼저 저장
        educationCourse = educationCourseRepository.save(educationCourse); // 교육 과정 저장

        // 상세 이미지 처리 (다중 파일)
        if (form.getDetailImage() != null && form.getDetailImage().length > 0) {
            for (MultipartFile file : form.getDetailImage()) {
                if (!file.isEmpty()) {
                    // 파일 저장 로직 호출
                    String detailImageUrl = saveFile(file);

                    // DetailImage 엔티티 생성 및 설정
                    DetailImage detailImage = new DetailImage();
                    detailImage.setEducationCourse(educationCourse); // 연관된 교육 과정 설정
                    detailImage.setImageUrl(detailImageUrl);         // 저장된 파일 URL 설정

                    // 데이터베이스에 저장
                    detailImageRepository.save(detailImage);
                }
            }
        }

        return educationCourse;
    }


    // 파일을 서버에 저장하고 URL을 반환하는 메서드
    private String saveFile(MultipartFile file) throws IOException {
        // String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filename = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/upload/product/" + filename);  // 외부 경로로 변경

        // 디렉토리가 없으면 생성
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        Files.write(path, file.getBytes());
        return "/upload/product/" + filename;  // URL 형식 반환
    }


    
}
