package org.sist.erp_project.member;

import java.time.LocalDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberForm {
	
	private String username;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 6, max = 12, message = "비밀번호는 6자 이상 12자 이하여야 합니다.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @NotNull(message = "생년월일을 입력해주세요.")
    private LocalDate birthDate;

    @NotBlank(message = "휴대폰 번호는 필수 입력 항목입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호는 000-0000-0000 형식이어야 합니다.")
    private String phone;

    private String contect;

    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    //@Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;
   
    @NotBlank(message = "성별을 선택해주세요.")
    private String gender;

    private boolean smsOptIn;
    private boolean emailOptIn;

    @NotBlank(message = "우편번호를 입력해주세요.")
    private String postalCode;

    @NotBlank(message = "주소를 입력해주세요.")
    private String address;

    private String addressDetail;

    @NotBlank(message = "소재지를 선택해주세요.")
    private String location;
}
