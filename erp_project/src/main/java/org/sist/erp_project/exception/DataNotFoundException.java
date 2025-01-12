package org.sist.erp_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//url 문제만 404인데 id 문제도 앞으로 404 띄울거야
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found(해당 아이디 게시글이 없어~!)")
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DataNotFoundException(String message) {
		super(message);
	}
	
}
// 질문 ID가 존재하지 않을 때 발생하는 사용자 예외 class
// DataNotFoundException
// 위의 예외가 발생하면 스프링부트에서 HTTP 상태 코드 + 이유를 포함해서 응답 객체 생성