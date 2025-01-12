package org.sist.erp_project.member;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    ACTIVE("회원"),
    DEACTIVE("탈퇴"),
	PENDING_DEACTIVATION("탈퇴 대기"); // 탈퇴 신청

    private final String description; 

}