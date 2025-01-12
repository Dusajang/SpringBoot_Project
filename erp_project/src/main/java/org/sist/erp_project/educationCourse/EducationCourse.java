package org.sist.erp_project.educationCourse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_courses")
public class EducationCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "education_courses_seq", sequenceName = "EDUCATION_COURSES_SEQ", allocationSize = 1)
    @Column(name = "course_id")
    private Long id; // ID (Primary Key)

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Classification classification; // 구분 (재직자교육, 취업자교육)

    @Column(name = "center_name", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Center center; // 기관 (강남점, 강북점)

    @Column(name = "course_name", nullable = false)
    private String courseName; // 교육과정명

    @Column(name = "list_image_url")
    private String listImage; // 목록 이미지 URL

    @OneToMany(mappedBy = "educationCourse", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "detail_image_url")
    private List<DetailImage> detailImage = new ArrayList<>(); // 다수의 상세 이미지
    
    @Column(name = "is_visible", nullable = false)
    private Boolean isVisible; // 노출 여부 (true: 노출, false: 미노출)

    @Column(nullable = false)
    private int price; // 가격 (교육비)

    @Column(name = "education_start_date", nullable = false)
    private String educationStartDate; // 교육기간(시작)

    @Column(name = "education_end_date", nullable = false)
    private String educationEndDate; // 교육기간(종료)

    @Column(name = "recruitment_start_date", nullable = false)
    private String recruitmentStartDate; // 모집기간(시작)

    @Column(name = "recruitment_end_date", nullable = false)
    private String recruitmentEndDate; // 모집기간(종료)

    @Column(name = "education_room", nullable = false)
    private String educationRoom; // 교육장소

    @Column(name = "education_time", nullable = false)
    private String educationTime; // 교육시간 (09:00~18:00)

    @Column(name = "recruitment_capacity", nullable = false)
    private int recruitmentCapacity; // 모집인원

    @Column(name = "description", columnDefinition = "TEXT")
    private String description; // 상세설명

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt; // 생성일 (자동 설정)

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
