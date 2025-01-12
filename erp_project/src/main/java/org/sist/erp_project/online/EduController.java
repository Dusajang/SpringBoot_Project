package org.sist.erp_project.online;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/edu")
@RequiredArgsConstructor//final로 자동 주입 마치 autowired
public class EduController {
	
	private final EduService eduService;
	
	@GetMapping("/create")
	public String create(EduForm eduForm) {
		 eduForm.setName("나다놔");
	    eduForm.setEmail1("asdfasdf");
	    eduForm.setEmail2("gmail.com");
	    eduForm.setPassword("password");
	    eduForm.setContact("031-111-2222");
	    eduForm.setPhone("031-1111-2222");
		return "/sist/online/edu_create";
	}
	
	
	@PostMapping("/create")//회원이
	public String create(@Valid EduForm eduForm, BindingResult bindingResult) {
		//, Principal principal
		int authid = 0;
		/*if( authId > 0) {
			
		}else {
			
		}*/
		System.out.println("@@@@@@@@@@@EduController post로 create method  들어옴~");
		
		if (bindingResult.hasErrors()) {
			System.out.println("@@@@@@@@@@@create 하다가 binding 에러남");
			return "/sist/edu/eduCreate";
		}
		String name = eduForm.getName();
		String email1 = eduForm.getEmail1();
		String email2 = eduForm.getEmail2();
		String password = eduForm.getPassword();
		String contact = eduForm.getContact();
		String phone = eduForm.getPhone();
		String title = eduForm.getTitle();
		String content = eduForm.getContent();
		//Member member = this.memberService.getMember(principal.getName());
		
		this.eduService.write(name, email1, email2, password, contact, phone, title, content);
		//this.faqService.register(title, content, member);
		
		return "redirect:/edu/list";
	}
	
	
	@GetMapping("/list")//관리자가
	public String getEduList(Model model,@RequestParam(value = "page", defaultValue = "0")int page,
			@RequestParam(value = "type", defaultValue = "")String type,
			@RequestParam(value = "kw", defaultValue = "")String kw) {
		Page<Edu> eduList = this.eduService.getList(page, type, kw);
		model.addAttribute("type", type);
		model.addAttribute("kw", kw);
		int startPage = (page / 10) * 10;  // 현재 페이지의 시작점
		int endPage = Math.min(startPage + 9, eduList.getTotalPages() - 1);  // 시작점 + 9가 전체 페이지수보다 크면 전체 페이지수를 끝점으로
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("eduList", eduList);
		return "/sist/online/edu_list";
	}
	
	@GetMapping("/{id}")//상세 보기
	public String showDetail(@PathVariable("id") Long id, Model model) {
		System.out.println("@@@@@@@@@@@EduController showDetail method  들어옴~");
		Edu edu = eduService.getEdu(id);
		model.addAttribute("edu", edu);
		Edu previousEdu = eduService.getPreviousEdu(id);
        model.addAttribute("previousEdu", previousEdu);
       
        Edu nextEdu = eduService.getNextEdu(id);
	    model.addAttribute("nextEdu", nextEdu);
		return "/sist/online/edu_detail";
	}
	
	// 수정
	@GetMapping("/modify/{id}")
	public String modify(EduForm eduForm, @PathVariable("id") Long id, Model model) {
		System.out.println("@@@@@@@@@@@EduController @GetMapping으로 modify method  들어옴~");
		Edu edu = this.eduService.getEdu(id);
		eduForm.setName(edu.getAuthor());
		eduForm.setContact(edu.getContact());
		eduForm.setPhone(edu.getPhone());
		eduForm.setEmail1(edu.getEmail1());
		eduForm.setEmail2(edu.getEmail2());
		eduForm.setPassword(edu.getPassword());
		eduForm.setTitle(edu.getTitle());
		eduForm.setContent(edu.getContent());
		return "/online/edu_create";
	}
	
	// POST: 실제 수정 처리
	@PostMapping("/modify/{id}")
	public String modify(@Valid EduForm eduForm, BindingResult bindingResult, @PathVariable("id") Long id) {
		System.out.println("@@@@@@@@@@@EduController @PostMapping으로 modify method  들어옴~");
		 if (bindingResult.hasErrors()) {
			 System.out.println("@@@@@@@@modify 하다가 binding 에러남");
	           return "/online/edu_detail";
	       }
	       Edu edu = this.eduService.getEdu(id);
	       String email = eduForm.getEmail1() + eduForm.getEmail2();
	       this.eduService.modifyEdu(edu, eduForm.getName(), eduForm.getEmail1(), eduForm.getEmail2(), eduForm.getPassword(), eduForm.getContact(), eduForm.getPhone() ,eduForm.getTitle(), eduForm.getContent());
	       
	       return "redirect:/edu/" + id;
		}
	
	
	@GetMapping("/delete/{id}")
	   public String deleteEdu(@PathVariable("id") Long id) {
		   Edu edu = this.eduService.getEdu(id);
	       this.eduService.delete(edu);
	       return "redirect:/sist/edu/list";
	   }
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<String> deleteSelected(@RequestBody List<Long> ids ) {
	    try {
	        eduService.deleteMultiple(ids);
	        return ResponseEntity.ok("삭제 성공쓰~");
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("삭제하다가 망함쓰~");
	    }
	}
}
