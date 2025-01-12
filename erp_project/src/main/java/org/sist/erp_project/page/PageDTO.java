package org.sist.erp_project.page;

import lombok.Getter;
import lombok.ToString;

// 페이징 블럭 1 2 [3] 4 5 6 7 8 9 10 >
@Getter
@ToString
public class PageDTO {

	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int total;
	private Criteria criteria;
	
	
	public PageDTO(Criteria criteria, int total) {
	      this.criteria = criteria;
	      this.total = total;
	      
	      this.endPage = (int)(Math.ceil(criteria.getPageNum()/
	               (double)criteria.getAmount())) * criteria.getAmount();
	      this.startPage = this.endPage - criteria.getAmount() + 1;
	      
	      int realEndPage = (int)(Math.ceil((double)total/criteria.getAmount()));
	      if(realEndPage < this.endPage) this.endPage = realEndPage;
	      
	      this.prev = this.startPage > 1;
	      this.next = this.endPage < realEndPage;
	   }

}// class
