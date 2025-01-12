package org.sist.erp_project.educationCourse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "detail_images")
public class DetailImage {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_images_seq")
	@SequenceGenerator(name = "detail_images_seq", sequenceName = "DETAIL_IMAGES_SEQ", allocationSize = 1)
	@Column(name = "image_id")
	private Long id; // 이미지 ID (Primary Key)


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private EducationCourse educationCourse; // 관련 교육 과정 (다수의 이미지가 하나의 과정에 연결)

    @Column(name = "image_url", nullable = false)
    private String imageUrl; // 이미지 파일 URL 또는 경로
}
