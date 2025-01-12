/***
현재 프로젝트 전용  스크립트 소스들.
*/
$(function(){
	initForCommon();
});






/***
	기본적인 공통으로 실행되어야 하는 스크립트들
***/
function initForCommon(){
	$('#email2').change(function(){
		chgDomains(this);
	});
	if($("[name=directEmail]").size() > 0){
		if($('#email2').val() == ""){
			$('#email2').val("직접 입력");
			var _this = $('#email2').get(0);
			chgDomains(_this);
			$('#email2').val($("[name=directEmail]").val().split("@")[1]);
		}
	}
	//$('[type=password][name*=password]').attr("placeholder", "최소8자, 숫자+영문 혼용");
}



/***
email 셀렉트 옵션에 직접 입력 추가 스크립트.
직접선택이 선택 됬을 경우 select를 span으로 감싸고 그 span에 input에 select의 id, name을 부여하고 select의 id, name을 제거한다.
!(직접선택이 선택 됬을 경우) 직접선택으로 생겨난 input을 지우고 감싸던 span을 없앤다.
param _this : select
***/
function chgDomains(_this){
	var $_this = $(_this);
	if( _this.value == '직접 입력' ) {
		if( _this.parentNode.tagName.toUpperCase() != 'SPAN' ){
			$_this.wrap("<span></span>");
			var _attrId = $_this.attr("id");
			var _attrName = $_this.attr("name")
			$_this.parent().prepend("<input type='text' id='"+_attrId+"' name='"+_attrName+"'maxlength='100' class='inputEmail02'/> ");
			$_this.attr("id", "");
			$_this.attr("name", "");
			$_this.prev().focus();
		}
	}else{
		if( _this.parentNode.tagName.toUpperCase() == 'SPAN' ){
			var _attrId = $_this.parent().find('input').attr("id");
			var _attrName = $_this.parent().find('input').attr("name")
			$_this.attr("id", _attrId);
			$_this.attr("name", _attrName);
			$_this.parent().find('input').remove();
			$_this.unwrap();
		}
	}
}




// 휴대폰번호 4자리를 입력 시 다음 부분으로
function evtKeyUp_move4word( _this){
	var $this = $(_this);
	if($this.val().length ==4)
		$this.next().focus();
}



/***
	placeholder가 안되는 브라우져에서 
	value 로 대체
***/
function setPlaceHolderHtml4(targ, _val){
	var $targ = $(targ);
	if($targ.val() == "") $targ.val( _val);
	$targ.bind('focus', function(){
		if($targ.val() == _val) $targ.val( "");
	});
	$targ.bind('blur', function(){
		if($targ.val() == "") $targ.val( _val );
	});

}





//모바일(스마트폰+태블릿)일 때 실행 될 스크립트
function isMobileTablet(){
	if(navigator.userAgent.match(/Android|Mobile|iP(hone|od|ad)|BlackBerry|IEMobile|Kindle|NetFront|Silk-Accelerated|(hpw|web)OS|Fennec|Minimo|Opera M(obi|ini)|Blazer|Dolfin|Dolphin|Skyfire|Zune/)){
		return true;
	}else{
		return false;
	}
}



// 오직 숫자만
var numValue_past = '';
function isOnlyNumberNotHypen(obj){
	var exp = /[^0-9+]/g;
	if ( exp.test(obj.value) ) {
		//alert("숫자만 입력가능합니다.");
		obj.value = numValue_past;
		obj.focus();
	}else{
		numValue_past = obj.value;
	}
}


//무한 카테고리 생성
function fn_select_category(obj){
	
	var category = $(obj).val();
	var groupCategoryObj = $(obj).closest("#groupCategory");
	var key = ($(obj).parent().index()+1);
	var pcsorts = (key+1);
	
	$.post("/manage/include/productCategory/productCategorySelect.jsp",
	{
		rel_code:category,
		pcsorts : pcsorts
		
	},function(data){
		console.log($(obj))
		$(obj).parent().nextAll().remove();
		if(data.trim() == "0"){
							
		}else{
			if($(obj).parent().next().size() > 0){
				$(obj).parent().next().html(data);	
			}else{
				$(groupCategoryObj).append("<span>"+data+"</span>");
			}
			
		}
		
	}).fail(function(error){
		alert(error);
	})
}


function fn_select_category_value(value){
	
	$.post("/manage/include/productCategory/productCategorySelectList.jsp",
	{
		paramCategoryfk:value
		
	},function(data){
		if(data.trim() == "0"){
							
		}else{
			$("#groupCategory").append(data);
		}
		
	}).fail(function(error){
		alert(error);
	})
}