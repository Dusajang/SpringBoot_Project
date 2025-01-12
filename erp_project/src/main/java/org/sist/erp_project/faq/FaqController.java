package org.sist.erp_project.faq;

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
@RequestMapping("/FAQ")
@RequiredArgsConstructor//final로 자동 주입 마치 autowired
public class FaqController {

	private final FaqService faqService;
	
	@GetMapping("/registerFAQ")
		public String create (FaqForm faqForm, Model model) {
		System.out.println("@@@@@@@@@@@FAQController create method  들어옴~");
		return "/sist/FAQ/registerFAQ";	
	}
	
	// FAQ 등록 처리
	@PostMapping("/registerFAQ")
		public String create (@Valid FaqForm faqForm, BindingResult bindingResult) {
		//, Principal principal
		int authorid = 0;
		
		/*if( authorid > 0) {
			
		}else {
			
		}*/
		
		System.out.println("@@@@@@@@@@@FAQController post로 create method  들어옴~");
		
		if (bindingResult.hasErrors()) {
			System.out.println("@@@@@@@@@@@create 하다가 binding 에러남");
			return "/sist/FAQ/registerFAQ";
		}
		String title = faqForm.getTitle();
		String content = faqForm.getContent();
		//Member member = this.memberService.getMember(principal.getName());
		String name ="test유저";
		String email ="testManager@gmail.com";
		this.faqService.register(title, content, name, email);
		//this.faqService.register(title, content, member);
		return "redirect:/FAQ/list";
	}
	
	// 상세보기
	@GetMapping("/{id}")  
	   public String detail(@PathVariable("id") Long id, Model model) {
			System.out.println("@@@@@@@@@@@FAQController detail method  들어옴~");
	       Faq faq = faqService.getFaq(id);
	       model.addAttribute("faq", faq);
	       
	       Faq previousFaq = faqService.getPreviousFaq(id);
	       model.addAttribute("previousFaq", previousFaq);
	       
	       Faq nextFaq = faqService.getNextFaq(id);
	       model.addAttribute("nextFaq", nextFaq);
	       
	       return "/sist/FAQ/FAQDetail";
	   }
	
	//목록 보기
	 @GetMapping("/list")
		public String getFAQList(Model model,@RequestParam(value = "page", defaultValue = "0")int page,
				@RequestParam(value = "type", defaultValue = "")String type,
				@RequestParam(value = "kw", defaultValue = "")String kw) {
		Page<Faq> faqList = this.faqService.getList(page, type, kw);
		
		model.addAttribute("type", type);
		model.addAttribute("kw", kw);
		
		int startPage = (page / 10) * 10;  // 현재 페이지의 시작점
		int endPage = Math.min(startPage + 9, faqList.getTotalPages() - 1);  // 시작점 + 9가 전체 페이지수보다 크면 전체 페이지수를 끝점으로
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);

		model.addAttribute("faqList", faqList);
		return "/sist/FAQ/FAQ";
	}
	
	// 수정
	@GetMapping("/modify/{id}")
	public String modifyFAQ(FaqForm faqForm, @PathVariable("id") Long id, Model model) {
		System.out.println("@@@@@@@@@@@FAQController @GetMapping으로 modifyFAQ method  들어옴~");
		Faq faq = this.faqService.getFaq(id);
		
		faqForm.setTitle(faq.getTitle());
		faqForm.setContent(faq.getContent());
		return "/sist/FAQ/registerFAQ";
	}
	
	// POST: 실제 수정 처리
	@PostMapping("/modify/{id}")
	public String modifyFAQ(@Valid FaqForm faqForm, BindingResult bindingResult, @PathVariable("id") Long id) {
		System.out.println("@@@@@@@@@@@FAQController @PostMapping으로 modifyFAQ method  들어옴~");
		 if (bindingResult.hasErrors()) {
			 System.out.println("@@@@@@@@modify 하다가 binding 에러남");
	           return "/sist/FAQ/FAQDetail";
	       }
	       Faq faq = this.faqService.getFaq(id);
	       this.faqService.modifyFaq(faq, faqForm.getTitle(), faqForm.getContent());
	       
	       return "redirect:/FAQ/" + id;
		}
	
	@GetMapping("/delete/{id}")
	   public String deleteFAQ(@PathVariable("id") Long id) {
		   Faq faq = this.faqService.getFaq(id);
	       this.faqService.delete(faq);
	       return "redirect:/FAQ/list";
	   }
	
	@PostMapping("/delete")
	@ResponseBody
	public ResponseEntity<String> deleteSelected(@RequestBody List<Long> ids ) {
	    try {
	        faqService.deleteMultiple(ids);
	        return ResponseEntity.ok("삭제 성공쓰~");
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body("삭제하다가 망함쓰~");
	    }
	}
}//class
