package org.sist.erp_project.educationCourse;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EducationCourseForm {

    @NotNull(message = "분류는 필수입니다.")
    private int classification;

    @NotNull(message = "센터는 필수입니다.")
    private int center;

    @NotNull(message = "과정명은 필수입니다.")
    @Size(min = 1, max = 100, message = "과정명은 1~100자 사이여야 합니다.")
    private String courseName;

    @NotNull(message = "노출 여부는 필수 입니다.")
    private Boolean isVisible; // 노출 여부 (true: 노출, false: 미노출)
    
    @NotNull(message = "가격은 필수입니다.")
    @Pattern(regexp = "^\\d+$", message = "가격은 숫자여야 합니다.")
    private int price;

    @NotNull(message = "교육 시작일은 필수입니다.")
    private String educationStartDate;

    @NotNull(message = "교육 종료일은 필수입니다.")
    private String educationEndDate;

    @NotNull(message = "모집 시작일은 필수입니다.")
    private String recruitmentStartDate;

    @NotNull(message = "모집 종료일은 필수입니다.")
    private String recruitmentEndDate;

    @NotNull(message = "위치는 필수입니다.")
    private String educationRoom;

    @NotNull(message = "교육 시간은 필수입니다.")
    private String educationTime;

    @NotNull(message = "모집 인원은 필수입니다.")
    @Pattern(regexp = "^\\d+$", message = "모집 인원은 숫자여야 합니다.")
    private int recruitmentCapacity;

    private String description;

    private MultipartFile listImage;
    private MultipartFile[] detailImage; // 다중 파일 업로드를 위한 배열

}