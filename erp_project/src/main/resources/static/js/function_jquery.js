// 댓글 부분 포커스일때 텍스트 삭제
function focusTextRemove(obj){
	var str = '';
	var name = jQuery(obj).attr("name");
	var val = jQuery(obj).val();
	
	if(name == "name") {
		str = "이름";
		if (str == val) {
			jQuery(obj).val("");
			return; 
		}else{
			return;
		}
	}else if(name == "password_temp") {
		str = "비밀번호";
		if (str == val) {
			jQuery(obj).css("display","none");
			jQuery(obj).parent().find("#password").remove();
			jQuery(obj).parent().append("<input type='password' name='password' id='password' class='focus_zone' title='비밀번호를 입력해주세요'>");
			jQuery("#password").bind("blur",function(){
				blurTextInsert(this);
			});
			jQuery("#password").focus();
			return; 
		}else{
			return;
		}
	}
}

// 댓글 부분 포커스잃었을때 텍스트 삽입
function blurTextInsert(obj){
	
	var str = '';
	var name = jQuery(obj).attr("name");
	if (jQuery(obj).val() == "") {
		if (name == "name") {
			str = "이름";
		}else if (name == "password") {
			jQuery(obj).remove();
			jQuery(obj).val("");
			jQuery("#password_temp").css("display","block");
		}
	}else{
		
		str = jQuery(obj).val();
		
	}
	jQuery(obj).val(str);
}

// 댓글 부분 포커스일때 텍스트 삭제
function focusAltRemove(obj){
	var str = '';
	var name = jQuery(obj).attr("name");
	var val = jQuery(obj).val();
	
	if(name == "image_alt") {
		str = "이미지입니다.";
		if (str == val) {
			jQuery(obj).val("");
			return; 
		}else{
			return;
		}
	}else if(name.indexOf("beforeimage") >= 0) {
		str = "치료 전 사진입니다.";
		if (str == val) {
			jQuery(obj).val("");
			return; 
		}else{
			return;
		}
	}else if(name.indexOf("afterimage") >= 0) {
		str = "치료 후 사진입니다.";
		if (str == val) {
			jQuery(obj).val("");
			return; 
		}else{
			return;
		}
	}
}

// 이미지 alt 부분 포커스잃었을때 텍스트 삽입
function blurAltInsert(obj){
	
	var str = '';
	var name = jQuery(obj).attr("name");
	if (jQuery(obj).val() == "") {
		if (name == "image_alt") {
			str = "이미지입니다.";
		}else if (name.indexOf("beforeimage") >= 0) {
			str = "치료 전 사진입니다.";
		}else if (name.indexOf("afterimage") >= 0) {
			str = "치료 후 사진입니다.";
		}
	}else{
		
		str = jQuery(obj).val();
		
	}
	jQuery(obj).val(str);
}

// FAQ 분류별 클릭시 노출시키기
jQuery(function(){
	jQuery(".faq_open").click(function(){
		if(jQuery(this).children("dd").css("display")=="none") {
			jQuery(this).children("dd").css("display","block");
		}else if(jQuery(this).children("dd").css("display")=="block") {
			jQuery(this).children("dd").css("display","none");
		}
		
	});
});

// 비밀번호 유효성체크
function validPassword(password) {
	var jQuerypass = password.val();
	var jQuerystr = /^[\w]{6,20}$/;
	var jQuerystr2 = /(\w)\1\1\1/;
	var jQuerychk_num = jQuerypass.search(/[0-9]/g);
	var jQuerychk_eng = jQuerypass.search(/[a-z]/ig);
	var check = false;
	if (jQuerypass == "") {
		alert("비밀번호를 입력해 주세요.");
		password.focus();
	}else if(!jQuerystr.test(jQuerypass) || jQuerypass.indexOf(' ') > -1){
		alert("비밀번호는 최소 6자, 최대 20자까지 입력가능합니다.");
		password.focus();
	}else if(jQuerystr2.test(jQuerypass)){
		alert("비밀번호에 반복되는 문자 및 숫자가 있습니다.");
		password.focus();
	}else if(jQuerychk_num < 0 || jQuerychk_eng < 0) {
		alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
		password.focus();
	}else{
		check = true;
	}
	return check;
}


// 비밀번호 유효성체크(비밀번호확인)
function validConfirmPassword(password, confirmPassword) {
	var jQuerypass = password.val();
	var jQueryconfirm = confirmPassword.val();
	var jQuerystr = /^[a-zA-Z0-9@]{6,12}$/;
	var jQuerystr2 = /(\w)\1\1\1/;
	var jQuerychk_num = jQuerypass.search(/[0-9]/g);
	var jQuerychk_eng = jQuerypass.search(/[a-z]/ig);
	var check = false;
	if (jQuerypass == "") {
		alert("비밀번호를 입력해 주세요.");
		password.focus();
	}else if (jQuerypass != jQueryconfirm) {
		alert("입력한 비밀번호가 서로 다릅니다.");
		confirmPassword.focus();
	}else if(!jQuerystr.test(jQuerypass) || jQuerypass.indexOf(' ') > -1){
		alert("비밀번호는 영문+숫자 6~12자리를 입력해 주세요.");
		password.focus();
	}else if(jQuerystr2.test(jQuerypass)){
		alert("비밀번호에 반복되는 문자 및 숫자가 있습니다.");
		password.focus();
	}else if(jQuerychk_num < 0 || jQuerychk_eng < 0) {
		alert("비밀번호는 숫자와 영문자를 혼용하여야 합니다.");
		password.focus();
	}else{
		check = true;
	}
	return check;
}

// 엔터키 이벤트
function entKeyEventListener(keycode, formID){
	if(keycode == 13){
		jQuery("#"+formID).submit();
	}
}

