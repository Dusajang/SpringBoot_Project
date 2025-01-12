package org.sist.erp_project.faq;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sist.erp_project.exception.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class FaqServiceImpl implements FaqService{

	private final FaqRepository faqRepository;
	
	
	//게시글 등록
	/*
	@Override
	public void register(String title, String content) {
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setCreateDate(LocalDateTime.now());
		
		this.faqRepository.save(faq);
		
	}
	
	@Override
	public void register(String title, String content, String name) {
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setCreateDate(LocalDateTime.now());
		faq.setAuthor(name);
		this.faqRepository.save(faq);
		
	}*/

	@Override
	public void register(String title, String content, String name, String email) {
		Faq faq = new Faq();
		faq.setTitle(title);
		faq.setContent(content);
		faq.setCreateDate(LocalDateTime.now());
		faq.setAuthor(name);
		faq.setEmail(email);
		this.faqRepository.save(faq);
		
	}
	//페이징 된 목록 가져와
	/*
	@Override
	public Page<Faq> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));//정렬기준이 여러 개일 때가 있기 때문에 굳이 List로 만든 것
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		//현재 페이지 받아와서 10개씩 뿌려 direction이랑 property라는 parameter도 있으니 공부할 것
		return this.faqRepository.findAll(pageable); // 1번 페이지 끝
	}*/
	
	//상세보기
	@Override
	public Faq getFaq(Long id) {
		Optional<Faq> faq = this.faqRepository.findById(id);
        if(faq.isPresent()) {
        	this.faqRepository.updateViewCount(id);
            return faq.get();
        } else {
            throw new DataNotFoundException("@@@@@@faq가 업서요~!");
        }
	}
	
	//게시글 수정
	@Override
	public void modifyFaq(Faq faq, String title, String content) {
		faq.setTitle(title);
		faq.setContent(content);
		faq.setModifyDate(LocalDateTime.now());
		this.faqRepository.save(faq);
	}
	
	//게시글 삭제
	@Override
	public void delete(Faq faq) {
		this.faqRepository.delete(faq);
	}

	//선택해서 지워
	 public void deleteMultiple(List<Long> ids) {
	        faqRepository.deleteAllById(ids);
	    }
	 
	 
	 
	 //페이징 + 검색 된 목록 가져와
	 
	 @Override
		public Page<Faq> getList(int page, String type, String kw) {
			List<Sort.Order> sorts = new ArrayList<>();
			sorts.add(Sort.Order.desc("id"));//정렬기준이 여러 개일 때가 있기 때문에 굳이 List로 만든 것
			
			Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
			//현재 페이지 받아와서 10개씩 뿌려 direction이랑 property라는 parameter도 있으니 공부할 것
			 if (type.isEmpty() || kw.isEmpty()) {
			        return this.faqRepository.findAll(pageable);//검색조건, 검색어, 없으면 걍 날려
			    }
			    Specification<Faq> spec = search(type, kw);//있으면 Spectification에 넣어서
			    return this.faqRepository.findAll(spec, pageable);//날려
		}
	 
	 public Specification<Faq> search(String type, String kw) {//매개변수로 검색어
			return new Specification<Faq>() {
				

				private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<Faq> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
					query.distinct(true);  // 중복을 제거
					
					if(type == null || kw == null) {
						System.out.println("검색조건이나 키워드가 null인디?");
					}
	               if(type.equals("all")) {
	            	   return criteriaBuilder.or(criteriaBuilder.like(root.get("title"), "%"+kw+"%"),
	            			   					criteriaBuilder.like(root.get("content"), "%"+kw+"%")
	            			   					);
	               }else if (type.equals("contents")) {
	            	   return criteriaBuilder.like(root.get("content"), "%" + kw +"%");
	               }else if (type.equals("name")) {
	            	   return criteriaBuilder.like(root.get("author"), "%" + kw +"%");
	               }else if (type.equals("email")) {
	            	   return criteriaBuilder.like(root.get("email"), "%" + kw +"%");
	               }
	               return null;
				}
			};
	 }
	 //이전 글, 다음 글
	public Faq getPreviousFaq(Long id) {
		    return faqRepository.findPreviousFaq(id).orElse(null);
		}

	public Faq getNextFaq(Long id) {
	    return faqRepository.findNextFaq(id).orElse(null);
	}
}
