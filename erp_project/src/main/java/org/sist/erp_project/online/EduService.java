package org.sist.erp_project.online;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EduService {
	public void write(String name, String email1, String email2, String password, String contact, String phone, String title,
			String content);
	public Page<Edu> getList(int page, String type, String kw);
	public Edu getPreviousEdu(Long id);//이전 글
	public Edu getNextEdu(Long id);//다음 글
	public Edu getEdu(Long id);//상세보기
	public void modifyEdu(Edu edu, String name, String email1, String email2, String password, String contact, String phone, String title,
			String content);//수정
	public void delete(Edu edu);//삭제
	public void deleteMultiple(List<Long> ids);//여러 개 삭제
}
