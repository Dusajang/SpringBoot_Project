package org.sist.erp_project.faq;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface FaqService {
	//이전버전
	//public void register(String title, String content);
	//public void register(String title, String content, String name);
	public void register(String title, String content, String name, String email);
	//아마 나중에 쓸 거
	//public void register(String title, String content, Member member);
	
	//public Page<Faq> getList(int page);
	public Faq getFaq(Long id);
	public void modifyFaq(Faq faq, String title, String content);
	public void delete(Faq faq);
	public void deleteMultiple(List<Long> ids);
	public Page<Faq> getList(int page, String type, String kw);
	public Specification<Faq> search(String type, String kw);
	public Faq getPreviousFaq(Long id);
	public Faq getNextFaq(Long id);
}
