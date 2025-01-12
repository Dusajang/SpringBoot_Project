package org.sist.erp_project.online;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Edu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=200)
	private String title;
	
	@Column(columnDefinition = "TEXT")//문자열 길이 제한 없어져
	private String content;
	
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	
	private Integer viewCount;
	   @PrePersist
	     public void prePersist() {
	      this.viewCount = 0;
	  }
	
	//@ManyToOne
	//private Member author;
	private String author;
	private String password;
	private String contact;
	private String phone;
	private String email1;
	private String email2;
}

