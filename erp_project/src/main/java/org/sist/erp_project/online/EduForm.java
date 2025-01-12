package org.sist.erp_project.online;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EduForm {
	@NotBlank(message = "작성자는 필수항목입니다.")
	    private String name;
    @NotBlank(message = "제목은 필수항목입니다.")
    	private String title;
    
    @NotBlank(message = "내용은 필수항목입니다.")
    	private String content;
    @NotBlank(message = "비밀번호는 필수항목입니다.")
    	private String password;
    
    private String email1;
    private String email2;
    private boolean secret;  // 비공개 여부
    private String contact;  // 연락처
    private String phone;    // 휴대폰
}
