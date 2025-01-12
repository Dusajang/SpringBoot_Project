package org.sist.erp_project.online;

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
public class EduServiceImpl implements EduService{

	private final EduRepository eduRepository;
	

	@Override
	public void write(String name, String email1, String email2, String password, String contact, String phone, String title,
			String content) {
		Edu edu = new Edu();
		edu.setAuthor(name);
		edu.setEmail1(email1);
		edu.setEmail2(email2);
		edu.setPassword(password);
		edu.setContact(contact);
		edu.setPhone(phone);
		edu.setTitle(title);
		edu.setContent(content);
		edu.setCreateDate(LocalDateTime.now());
		
		this.eduRepository.save(edu);
		
	}
	
	
	@Override
	public Page<Edu> getList(int page, String type, String kw) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("id"));//정렬기준이 여러 개일 때가 있기 때문에 굳이 List로 만든 것
		
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		//현재 페이지 받아와서 10개씩 뿌려 direction이랑 property라는 parameter도 있으니 공부할 것
		 if (type.isEmpty() || kw.isEmpty()) {
		        return this.eduRepository.findAll(pageable);//검색조건, 검색어, 없으면 걍 날려
		    }
		    Specification<Edu> spec = search(type, kw);//있으면 Spectification에 넣어서
		    return this.eduRepository.findAll(spec, pageable);//날려
	}
 
	 public Specification<Edu> search(String type, String kw) {//매개변수로 검색어
			return new Specification<Edu>() {
				
	
				private static final long serialVersionUID = 1L;
	
				@Override
				public Predicate toPredicate(Root<Edu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
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
	public Edu getPreviousEdu(Long id) {
	    return eduRepository.findPreviousEdu(id).orElse(null);
		}
	
	public Edu getNextEdu(Long id) {
		return eduRepository.findNextEdu(id).orElse(null);
	}
	
	//상세보기
	@Override
	public Edu getEdu(Long id) {
		Optional<Edu> edu = this.eduRepository.findById(id);
        if(edu.isPresent()) {
        	this.eduRepository.updateViewCount(id);
            return edu.get();
        } else {
            throw new DataNotFoundException("@@@@@@edu가 업서요~!");
        }
	}
	
	//게시글 수정
	@Override
	public void modifyEdu(Edu edu, String name, String email1, String email2, String password, String contact, String phone, String title,
			String content) {
		edu.setAuthor(name);
		edu.setEmail1(email1);
		edu.setEmail2(email2);
		edu.setPassword(password);
		edu.setContact(contact);
		edu.setPhone(phone);
		edu.setTitle(title);
		edu.setContent(content);
		edu.setCreateDate(LocalDateTime.now());
		this.eduRepository.save(edu);
	}
	
	
	//게시글 삭제
	@Override
	public void delete(Edu edu) {
		this.eduRepository.delete(edu);
	}

		//선택해서 지워
	@Override
	 public void deleteMultiple(List<Long> ids) {
	        eduRepository.deleteAllById(ids);
	    }
}
