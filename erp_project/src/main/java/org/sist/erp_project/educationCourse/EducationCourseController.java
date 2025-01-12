package org.sist.erp_project.educationCourse;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping({"/manage/edu","/employment/gangnam"})
public class EducationCourseController {

	private final EducationCourseService educationCourseService;

	@GetMapping("/index")
	public void getAllCourses(Model model, 
	                            @RequestParam(value = "keyword", defaultValue = "") String keyword,
	                            @RequestParam(value = "stype", defaultValue = "all") String stype,
	                            @RequestParam(value = "classification", required = false) Integer classification,
	                            @RequestParam(value = "center", required = false) Integer center,
	                            @RequestParam(value = "reqPageNo", defaultValue = "0") int page) {

	    log.info("> EducationCourseController getAllCourses()... 교육과정 리스트 가져오기 검색 페이징");

	    // SearchDTO 객체 생성 및 값 설정
	    SearchDTO searchDTO = new SearchDTO();
	    searchDTO.setKeyword(keyword);
	    searchDTO.setStype(stype);
	    
	    // classification과 center는 Enum으로 변환하여 DTO에 설정
	    if (classification != null) {
	        searchDTO.setClassification(Classification.fromCode(classification));  // Integer -> Enum 변환
	    }
	    if (center != null) {
	        searchDTO.setCenter(Center.fromCode(center));  // Integer -> Enum 변환
	    }
	    
	    searchDTO.setReqPageNo(page);

	    // 페이지 설정
	    Pageable pageable = PageRequest.of(page, 10);

	    // 검색 조건을 적용한 교육 과정 리스트를 가져옵니다.
	    Page<EducationCourse> educationCourses = educationCourseService.getEduList(searchDTO, pageable);

	    // 모델에 값 전달
	    model.addAttribute("courses", educationCourses);
	    model.addAttribute("searchForm", searchDTO);
	}

	@GetMapping("/read/{id}")
	public String getCourse(@PathVariable("id") Long id , Model model, EducationCourseForm educationCourseForm) {	
		log.info("> EducationCourseController getCourse()... 교육과정 00 가져오기");

		EducationCourse educationCourse = this.educationCourseService.getCourse(id);
		model.addAttribute("course", educationCourse);
		return "/employment/read";
	}

	// 교육과정 상세보기 및 수정하기
	@GetMapping("/edit/{id}")
	public String modifyCourse(@PathVariable("id") Long id , Model model, EducationCourseForm educationCourseForm) {	
		log.info("> EducationCourseController modifyCourse()... 교육과정 상세보기 및 수정하기");

		EducationCourse educationCourse = this.educationCourseService.getCourse(id);
		model.addAttribute("course", educationCourse);
		return "/manage/edit";
	}

	// 교육과정 등록 페이지 이동
	@GetMapping("/write")
	public void enrollCourse( EducationCourse educationCourse ) {
		log.info("> EducationCourseController saveCourse()... 교육과정 등록 페이지 이동");
	}

	// 교육과정 신청하기 페이지 이동
	@GetMapping("/write/{id}")
	public void applyCourse(@PathVariable("id") Long id , EducationCourse educationCourse ) {
		log.info("> EducationCourseController saveCourse()... 교육과정 신청하기 페이지 이동");
	}
	
	@PostMapping("/write")
	public String createCourse(@ModelAttribute EducationCourseForm educationCourseForm,
			RedirectAttributes redirectAttributes) {

		EducationCourse educationCourse = new EducationCourse();	

		// 일반 필드 복사
		BeanUtils.copyProperties(educationCourseForm, educationCourse);

		// center 열거형 변환
		educationCourse.setCenter(Center.fromCode(educationCourseForm.getCenter()));

		// classification 열거형 변환
		educationCourse.setClassification(Classification.fromCode(educationCourseForm.getClassification()));

		try {
			// 파일 업로드 처리 및 상세 이미지 처리
			educationCourse = educationCourseService.FileUpload(educationCourse, educationCourseForm);
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("errorMessage", "코스 저장 중 오류 발생");
			return "/manage/edu/write";
		}

		// 저장 로직 호출 (EducationCourse 저장)
		educationCourseService.saveCourse(educationCourse);

		return "redirect:/manage/edu/index"; // 저장 후 리다이렉트
	}
}
