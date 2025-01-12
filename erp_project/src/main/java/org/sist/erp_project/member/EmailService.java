package org.sist.erp_project.member;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	
	 private final JavaMailSender mailSender;
	 
	    public void sendEmail(String to, String subject, String text) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setTo(to); // 수신자 이메일 주소
	            message.setSubject(subject); // 제목
	            message.setText(text); // 내용
	            message.setFrom("rlatjsdn6259@naver.com"); // 발신자 이메일
	            mailSender.send(message);

	            System.out.println("이메일 발송 완료!");
	        } catch (Exception e) {
	            System.err.println("이메일 발송 실패: " + e.getMessage());
	        }
	    }

}//class
