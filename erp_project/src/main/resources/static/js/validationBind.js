var formObj;
function validation(obj){
var chackCount = 1;
var result = true;
formObj =  $(obj).prop("tagName") == 'FORM' ? $(obj).children().parents("form") : $(obj).parents("form");
var input = $(formObj).find("input:not('input[type=hidden]'), select, textarea");
var textareacount = 0;

$(input).each(function(){
	if($(this).attr("name") == undefined){return true;}
	var type = $(this).attr("type");
	var tag = $(this).get(0).tagName;
	
	if(tag == 'SELECT'){
		result = fn_select(this);
		return result;
	}else if(tag == 'TEXTAREA'){
		result = fn_textarea(this);
		textareacount++;
		return result;
		
	}else if(type == 'password'){
		result = fn_text_password(this);
		return result;
	}else if(type == 'radio'){
		result = fn_radio(this);
		return result;
	}else if(type == 'checkbox'){
		result = fn_checkbox(this);
		return result;
	}else{
		result = fn_text(this);
		return result;
	}
	
})
return result;
}

var passwordLavel = true; //비밀번호 조건
//from name: wform 비밀번호 확인까지 체크 , default 그외 폼 
var passwordConfirm = "";
function fn_text_password(obj){
	var rsCheck = true;
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){return rsCheck;}
	
	var formId = $(obj).parents("form").attr("id");
	if($(obj).val().trim() == ""){
		alert($(obj).data("value"));
		passwordConfirm = "";
		$(obj).focus();
		rsCheck = false;
	}else{
		
		if(passwordConfirm == ""){
			passwordConfirm = $(obj).val().trim();
		}
	} 
	
	
	//로직 바꿔야됨..꼭!
	if(formId == 'wform'){
		if($(obj).attr("id") == 'password' && passwordLavel && rsCheck){
			//회원가입 비밀번호 유효성 체크
			if(!validPasswordCheck($(obj))){
				passwordConfirm = "";
				$(obj).val("");
				rsCheck = false;
			}
		}
		
		if(passwordConfirm != "" && rsCheck){
			if($(obj).val().trim() != passwordConfirm){
				alert($(obj).data("value"));
				passwordConfirm = "";
				$(obj).val("");
				$(obj).focus();
				rsCheck = false;
			}
		}
		
	}else{
		if( rsCheck ){
			if(formId != 'login'){
			//일반 게시판 저장할대 비밀번호 유효성 체크
			rsCheck = validPasswordCheck( $(obj) );
			}
		}
	}
	
	
	return rsCheck;
}

function fn_textarea(obj){
	var rsCheck = true;
	
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){
		
		return rsCheck;
	}else{
	
	
		if($(obj).val().trim() == ""){
			alert($(obj).data("value"));
			$(obj).focus();
			rsCheck = false;
		}
	}

	return rsCheck;
}


function fn_textarea_smarteditor_20170811(obj,pEditors){
	var rsCheck = true;
	
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){
		if($(obj).next().prop("tagName") == "IFRAME"){
			var sHTML = pEditors.getById[$(obj).attr("id")].getIR();
			if (sHTML == "" || sHTML == "&nbsp;") {
				rsCheck = true;
			} else {
				pEditors.getById[$(obj).attr("id")].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
			}
			
		}
		return rsCheck;
	}else{
	
	
		if($(obj).next().prop("tagName") == "IFRAME"){
			var sHTML = pEditors.getById[$(obj).attr("id")].getIR();
			if (sHTML == "" || sHTML == "&nbsp;") {
				alert($(obj).data("value"));
				$($(obj).attr("id")).focus();
				rsCheck = false;
			} else {
				pEditors.getById[$(obj).attr("id")].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
			}
			
		}else{
			if($(obj).val().trim() == ""){
				alert($(obj).data("value"));
				$(obj).focus();
				rsCheck = false;
			}
		}
	
	}

	return rsCheck;
}


function fn_text(obj){
	var rsCheck = true;
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){
		
	}else{
		if($(obj).val().trim() == ""){
			alert($(obj).data("value"));
			$(obj).focus();
			rsCheck = false;
		}
	}
	if(rsCheck){
				
		if(($(obj).attr("name") == "email" || $(obj).attr("name") == "email1" || $(obj).attr("name") == "receiveemail" || $(obj).attr("name") == "sendman") && $(obj).val().trim() != ""){
			
			
			var regExp = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			
			var emailValue = $(obj).val().trim();
			if($(obj).attr("name") == "email1"){
				emailValue +="@"+$(obj).parent().find("[name=email2]").val(); 
			}

			var strValue = emailValue;
			//이메일 형식에 맞지않으면
	        if (!regExp.test(strValue)){ 
	        	alert("이메일 형식이 맞지않습니다.");
				$(obj).focus();
				rsCheck = false;
	        }
	 
		}
	}
	
	return rsCheck;
}

function fn_checkbox(obj){
	var rsCheck = true;
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){return rsCheck;}
	if($(formObj).find("[name="+$(obj).attr("name")+"]").size() > 1){
		if ($("[name="+$(obj).attr("name")+"]:checked").size() == 0){
			alert($(obj).data("value"));
			$(obj).focus();
			rsCheck = false;
		}
	}else{
		if (!$(obj).prop("checked")){
			alert($(obj).data("value"));
			$(obj).focus();
			rsCheck = false;
		}
	}
	return rsCheck;
}

//라디오 버튼은 필수일 경우 첫번째 태그 값만 data-value 값을 넣어준다.
function fn_radio(obj){
	var rsCheck = true;
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){return rsCheck;}
	if($(formObj).find("input[name="+$(obj).attr('name')+"]:checked").size() <= 0){
		alert($(obj).data("value"));
		$(obj).focus();
		rsCheck = false;
	}
	return rsCheck;
}

function fn_select(obj){
	var rsCheck = true;
	if($(obj).data("value") == "" || $(obj).data("value") == undefined){return rsCheck;}
	var ovalue = $(obj).find("option:selected").val();
	if(ovalue == "" || ovalue == "-1"){
		alert($(obj).data("value"));
		$(obj).focus();
		rsCheck = false;
	}
	return rsCheck;
}

function validPasswordCheck(password) {
	var jQuerypass = password.val();
	var jQuerystr = /^[a-zA-Z0-9~!@#$%^&*()_+|<>?{}]{6,12}$/;
	var jQuerystr2 = /(\w)\1\1\1/;
	var jQuerychk_num = jQuerypass.search(/[0-9]/g);
	var jQuerychk_eng = jQuerypass.search(/[a-z]/ig);
	var jQuerychk_star = jQuerypass.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	var check = false;
	if(!jQuerystr.test(jQuerypass) || jQuerypass.indexOf(' ') > -1 || jQuerychk_star <0){
		alert("비밀번호는 영문,숫자,특수문자 6~12자리를 입력해 주세요.");
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


/***
	등록일을 지정 할 수 있는 게시글을 업로드시
	데이트 타입이 맞지 않으면 맞게 해서 넣어줍니다.
*/
function mkAutoDateFormat(){
	var _url = location.pathname;
	if( _url.indexOf('/manage/board/') > -1){
		var date = $('#registdate');
		if(date.length > 0){
			date.parents('form').on('submit', function(){
				chkDateFormat(date);
			});
		}
	}
}

/***
	등록일 데이터 형식이 이상하면 return true;
	yyyy-mm-dd hh:mm:ss 이 아니면 이 형식으로 맞춰 준다.
*/
function chkDateFormat( target){
	var dateVal = target.val();
	var rtnBool = false;
	
	if(dateVal == ""){
		rtnBool = true;
	}else{
		if( /[0-9]{4}[\-][0-1][0-9][\-][0-3][0-9]\s[0-2][0-9]:[0-6][0-9]:[0-6][0-9]$/i.test(dateVal) ){
			// 완벽히 맞을 경우.
			rtnBool = true;
		}else if( /[0-9]{4}[\-][0-1][0-9][\-][0-3][0-9]$/i.test(dateVal) ){
			target.val(dateVal + ' 00:00:00');
			rtnBool = true;
		}else if( /[0-9]{4}[\-][0-1][0-9][\-][0-3][0-9]\s[0-2][0-9]:[0-6][0-9]:[0-6][0-9].[0-9]$/i.test(dateVal) ){
			target.val(dateVal.substring(0, dateVal.length-2) );
			rtnBool = true;
		}else{
			alert('날짜를 확인해 주십시오.');
		}
	}
	return rtnBool;
}







//maxlength 자동 삽입
var maxInput0 = [4,"tel2","tel3","cell2","cell3"];
var maxInput1 = [6,"readno"];
var maxInput2 = [8,"reserdate"];
var maxInput3 = [13,"tel","cell"];
var maxInput4 = [200,"consult_admin_tel","reser_admin_tel"];
var maxInput5 = [20,"id","name","password","password_temp","password_del"];
var maxInput6 = [50,"relation_url"];
var maxInput7 = [100,"title","email1","email2"];
var maxInput8 = [200,"addr0","addr1","email"];

function inputMaxLength(){
	var objMaxInput = new Array(maxInput0,maxInput1,maxInput2,maxInput3,maxInput4,maxInput5,maxInput6,maxInput7);
	
	if(objMaxInput.length > 0){
		for(var key in objMaxInput){
			var cObj = objMaxInput[key];
			
			for(var ckey in cObj){
				
				if(ckey > 0){
					$("input[name="+cObj[ckey]+"]:not('input[type=hidden]')").each(function(){
						if($(this).attr("maxlength") != undefined){return true;}
						$(this).attr("maxlength",cObj[0]);	
					})
				}
				
			}
			
			
		}
	}
	
}


$(function(){
	
	var obj = $("form table th").next().find("input,select,textarea").filter(function(){if($(this).data("value") != "" && $(this).data("value") != undefined){return this}})
	var star = "*";
	$(obj).closest("td").prev().each(function(){
		var etc = $(this).text();
		var txt = '<span class="col01">'+star+'</span>'+etc;
		$(this).html(txt);
	
	});
});

fn_addDel_object = function(fcount){
	
	$("#addFile").click(function(){
		if(fcount < $("#useFile input[type=file]").size()+1){return;}
		var html = "<p><input type='file' id='filenames"+($("#useFile input[type=file]").size()+1)+"' name='filenames"+($("#useFile input[type=file]").size()+1)+"' class='input50p' style='display:inline-block;' title='첨부파일을 업로드 해주세요.' /></p>";
		$("#useFile").append(html);
	})
	
	$("#delFile").click(function(){
		
		if($("#useFile input[type=file]").size() > 1){
			if($("#useFile > p:last").attr("class") == 'pre_file'){
				//var uno = $("#useFile > p:last input[name=filenames_chk]").val();
				
			}else{
				$("#useFile > p:last").remove();
			}
		}
	})
	
}
//파일 추가 삭제