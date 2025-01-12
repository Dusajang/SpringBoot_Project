package org.sist.erp_project.educationCourse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDTO {
    private String keyword;       // 검색어
    private String stype;         // 검색 타입 (예: courseName, center 등)
    private Classification classification; // 교육 분류
    private Center center;        // 교육 기관
    private int reqPageNo;
}