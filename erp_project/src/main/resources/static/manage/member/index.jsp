















<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko" lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title>쌍용교육센터</title>
<meta http-equiv="X-UA-compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<meta name="description" content="페이지설명">
<meta name="keywords" content="검색키워드등록">
<meta name="classification" content="검색사이트 카테고리 등록">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet" />

<link href="/manage/css/nanumgothic.css" rel="stylesheet" type="text/css" />
<link href="/manage/css/notosanskr.css" rel="stylesheet" type="text/css" />
<link href="/css/poppins.css" rel="stylesheet" type="text/css" />
<link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
<link href='//cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="/manage/css/basic.css" rel="stylesheet" type="text/css" />
<link href="/manage/css/layout.css" rel="stylesheet" type="text/css" />
<link href="/manage/css/board.css" rel="stylesheet" type="text/css" />
<link href="/manage/css/manage.css" rel="stylesheet" type="text/css" />
<link href="/css/colorPicker.css" rel="stylesheet" type="text/css" />
<link href="/summernote/jquery-ui.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/js/jstree_/css/style.min.css" />
<link rel="stylesheet" href="/css/jquery.datetimepicker.css" type="text/css" media="all" />

<script type="text/javascript" src="/js/function.js"></script>
<script type="text/javascript" src="/js/menu.js"></script>
<script type="text/javascript" src="/js/calendar_beans_v2.0.js"></script>
<script type="text/javascript" src="/js/jquery-1.8.0.min.js"></script>

<!-- 달력 변경 jquery.js 버젼업, datetimepicker.full.js 달력 js -->
<script src="/js/jquery.js"></script>
<script src="/js/jquery.datetimepicker.full.js"></script>
<!-- 달력 변경 끝 -->
<script src="/js/dev.js"></script>

<script src="/js/jstree_/js/jstree.min.js"></script>
<!-- summernote editor-->

<link href="/summernote/bootstrap-3.3.2-dist/css/bootstrap.css" rel="stylesheet">
<link href="/summernote/summernote.css" rel="stylesheet">

<script src="/summernote/bootstrap-3.3.2-dist/js/bootstrap.js"></script> 
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script src="/summernote/summernote.js"></script>
<script src="/summernote/lang/summernote-ko-KR.js"></script>

<!-- include summernote css/js-->



<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> -->
<script type="text/javascript" src="/js/function_jquery.js"></script>

<script type="text/javascript" src="/smarteditor/js/HuskyEZCreator.js"></script>
<script type="text/javascript" src="/js/jquery.colorPicker.js"></script>
<script type='text/javascript' src='/js/validationBind.js'></script> 


<link rel="stylesheet/less" type="text/css" href="/manage/css/color.less">
<script type="text/javascript" src="/manage/include/less.min.js"></script>


<script type="text/javascript">
$(window).load(function() {
	jQuery.datetimepicker.setLocale('ko');		// 달력 언어 설정
	var mobileKeyWords = new Array('iPhone', 'iPod', 'BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson'); 
	for (var word in mobileKeyWords){ 
		if (navigator.userAgent.match(mobileKeyWords[word]) != null){ 
			// 모바일
			$("div#menu > ul > li > a").attr("href","javascript:;");
		} 
	} 	
});
</script>


<!-- template CSS 모음 -->


<!-- Custom CSS -->
<link href="/manage/template/dist/css/style.css" rel="stylesheet" type="text/css">

<!-- 작업 CSS -->
<link href="/manage/template/css/layout.css" rel="stylesheet" type="text/css" />
<link href="/manage/template/css/content.css" rel="stylesheet" type="text/css" />

<!-- template JS 모음 -->
<!-- jQuery -->
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script>  -->
<!-- <script src="/template/vendors/bower_components/jquery/dist/jquery.min.js"></script> -->

<script src="/js/manage_viewport.js"></script>

<script>
function groupDelete() {	
	if ( isSeleted(document.frm.no) ){
		document.frm.submit();
	} else {
		alert("삭제할 항목을 하나 이상 선택해 주세요.");
	}
}

function groupDormant() {	
	if ( isSeleted(document.frm.no) ){
		document.frm.cmd.value = "dormant";
 		document.frm.submit();
	} else {
		alert("휴면상태 변경을 원하는 항목을 하나 이상 선택해주세요.");
	}
}
function groupEmail() {	
	if ( isSeleted(document.frm.no) ){
		document.frm.cmd.value = "dormantEmail";
 		document.frm.submit();
	} else {
		alert("휴면안내 메일발송을 원하는 항목을 하나 이상 선택해주세요.");
	}
}

function groupSend(){
	if ( isSeleted(document.frm.push) ){
	$("input[name=cmd]").val("group");
	$("#frm").attr("action","/manage/member/push.jsp").submit();
	} else {
		alert("문자를 발송할 사람들을 선택해주세요");
	}
}


// 달력부분
$(window).load(function() {
	$("#sstartdate").datetimepicker({
		format:'Y-m-d',
		 onShow:function( ct ){
		 this.setOptions({
			maxDate:$('#senddate').val()?$('#senddate').val():false
		  })
		},
		timepicker:false
	});
		$("#start_button").click(function(){
			$('#sstartdate').datetimepicker('show');
		})	
	$("#senddate").datetimepicker({
	format:'Y-m-d',
	  onShow:function( ct ){
	   this.setOptions({
		minDate:$('#sstartdate').val()?$('#sstartdate').val():false
	   })
	  },
	  timepicker:false
	});
		$("#end_button").click(function(){
			$('#senddate').datetimepicker('show');
		})	
	//initCal({id:"sstartdate",type:"day",today:"y"});			
	//initCal({id:"senddate",type:"day",today:"y"});
	
	$("#sval").keydown(function(e){
		entKeyEventListener(e.keyCode, "searchForm");
	});
});

// 목록 'search' form 정렬 
function goOrderBy(by, type) {
	var f = document.searchForm;
	f.ordertype.value = type;
	f.orderby.value = by;
	f.submit();
}

$(document).ready(function(){
	$("#excel").click(function(){
		$("#searchForm")[0].action = "excel.jsp";
		$("#searchForm").submit();
	});
});

function goExcel() {
	$("#searchForm")[0].action = "excel.jsp";
	$("#searchForm").submit();
}

function searchDate(startDay, endDay) {
	$("#searchForm [name=sstartdate]").val(startDay);
	$("#searchForm [name=senddate]").val(endDay);
	$("#searchForm").submit();
}

</script>
<style type="text/css">
	body {font-family:'Noto Sans KR';}
	#bbs #blist table thead th {font-weight:500;}
	#bbs #blist table tbody td {font-weight:300;}
</style>
</head>
<body> 



<!-- 
<div id="com1" style="width:0px; height:0px; position:absolute; left:0px; top:0px; z-index:1"> 
<script type='text/javascript' src="http://weblog2.vizensoft.com/stat_js.jsp?sitenum="></script>
</div>
 -->



<div id="com2" style="width:0px; height:0px; position:absolute; left:0px; top:0px; z-index:1;"> 
<form name="urlMaintain" id="urlMaintain" action="/member/login.jsp" method="post">
		<input type="hidden" name="url" id="main_url" value="/manage/member/index.jsp">
		<input type="hidden" name="param" id="main_param" value="">
</form>
</div>



<div id="layerTop" class="helper">
	<div>
		<p>
			<strong>공지함 : </strong>현재 게시판 목록 페이지에서 최상에 노출됩니다.<br />
			<strong>공지안함 : </strong>현재 게시판 목록에 TOP공지 되지 않습니다.
		</p>
		<p class="point">* TOP공지를 선택하였을 경우 현재 게시판이 메인 페이지에 노출되어 있어도 노출되지 않습니다.</p>
	</div>
</div>

<div id="layerMain" class="helper">
	<div>
		<p>
			<strong>노출함 : </strong>현재 게시판의 내용이 메인 페이지에 있을 경우 메인 페이지에 노출되게 됩니다.<br />
			<strong>노출안함 : </strong>현재 게시판의 내용이 메인 페이지에 노출되지 않습니다.
		</p>
		<p class="point">* 현재 게시판의 내용이 메인 페이지에 있으면서 메인노출 선택을 하나도 하지 않을 경우 최근에 등록된 게시물이 메인 페이지에 노출 됩니다.</p>
	</div>
</div>

<div id="layerNew" class="helper"> 
	<div>
		<p>
			<strong>항상 : </strong>현재 게시판 목록페이지에서 해당 글 앞에 NEW아이콘이 표기됩니다.<br />
			<strong>하루만 : </strong>현재 게시판 목록페이지에서 해당 글 앞에 하루동안만 NEW아이콘이 표기됩니다.<br />
			<strong>표기안함 : </strong> NEW아이콘이 표기 되지 않습니다.
		</p>
	</div>
</div>

<div id="layer13" class="helper">
	<div>
		<p>
			<strong>HTML : </strong>순수한 HTML로 작성될 경우<br />
			<strong>TEXT : </strong> TEXT 또는 부분적인 HTML이 포함될 수 있습니다.
		</p>
		<p class="point">* TEXT 선택 시 읽기페이지에서 문단 단락 마다 &ltbr&gt태그를 삽입합니다.</p>
	</div>
</div>


<div id="layerReadno" class="helper">
	<div>
		<p>
			<strong>조회 수 : </strong>입력하지 않으시면 0부터 시작합니다.
		</p>
	</div>
</div>


<div id="layerRegistdate" class="helper"> 
	<div>
		<p>
			<strong>작성일 : </strong>입력하지 않으시면 현재 날짜로 등록됩니다.<br />
			ex) 2007-02-01 09:00:00
		</p>
	</div>
</div>

<div id="layerHoly" class="helper"> 
	<div>
		<p>
			추석연휴와 설날연휴를 제외한 공휴일 진료시 진료시간 설정입니다.
		</p>
	</div>
</div>

<div id="layerSecret" class="helper"> 
	<div>
		<p>
			<strong>공개 : </strong>사용자페이지에 노출됩니다.<br />
			<strong>비공개 : </strong>사용자페이지에 노출 되지 않습니다.
		</p>
	</div>
</div>
<div id="layerSmsh" class="helper size01"> 
	<div>
		<p>
			클릭 시 문자발송이 가능합니다.
		</p>
	</div>
</div>
<div id="layerEmailh" class="helper size01"> 
	<div>
		<p>
			클릭 시 메일발송이 가능합니다.
		</p>
	</div>
</div>

<script type="text/javaScript">
function helpComment(type, input) {
	var ev = window.event;	
	var mousePos = mouseCoords(ev);	
	
	if($("#"+input).width()+mousePos.x > $(window).width()){
		mousePos.x = mousePos.x -$("#"+input).width(); 
	}

	document.getElementById(input).style.top = mousePos.y+"px";
    document.getElementById(input).style.left = mousePos.x+"px";
	document.getElementById(input).style.visibility = type;

}

function mouseCoords(ev) {	
	if(ev.pageX || ev.pageY){		
		return {x:ev.pageX, y:ev.pageY};	
	}	
	return {
		x:ev.clientX + document.body.scrollLeft - document.body.clientLeft,
		y:ev.clientY + document.body.scrollTop  - document.body.clientTop	
	};
}

jQuery(document).ready(function(){
	jQuery(".helpComment").filter("#Registdate").css("margin-left","15px");
	jQuery(".helpComment").hover(
		function(){
			var id = jQuery(this).attr("id");
			helpComment("visible","layer"+id);
		},function(){
			var id = jQuery(this).attr("id");
			$("#layer"+id).css("visibility","hidden");
		}
	);
	
	jQuery(".helpComment").focusin(function(){
		var id = jQuery(this).attr("id");
		helpComment("visible","layer"+id);
	});
			
	jQuery(".helpComment").focusout(function(){
		var id = jQuery(this).attr("id");
		$("#layer"+id).css("visibility","hidden");
	});
});
</script>


	<!-- top-->
	


<script>
function popRecharge() {
	var str,width,height;
	str="'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,copyhistory=no,";
	str=str+"width=1024";
	str=str+",height=768',top=100,left=100";

	window.open("https://hosting.vizensoft.com/customer/indexPayment.jsp?projectfk=3119&costomerfk=3038&tran_id=9999",'recharge',str);
}

$(function(){
	$.ajax({
		url: "https://hosting.vizensoft.com/customer/rechargeJquery.jsp?projectfk=3119&costomerfk=3038&tran_id=9999", // 클라이언트가 요청을 보낼 서버의 URL 주소
		type: "GET",                             // HTTP 요청 방식(GET, POST)
		dataType: "jsonp",                         // 서버에서 보내줄 데이터의 타입
		success: function(data){
			$("#recharge").text(data);
		},
		error : function(error){
			console.log(error);
		}
	});
});

function popMaintenance() {
	var str,width,height;
	str="'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,copyhistory=no,";
	str=str+"width=1024";
	str=str+",height=768',top=100,left=100";

	window.open("http://vizen.vizensoft.com/site/maintenance/customer/index.jsp?customerfk=3038&projectfk=3119",'maintenance',str);
}
function popMaintenance() {
	var str,width,height;
	str="'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=no,copyhistory=no,";
	str=str+"width=1024";
	str=str+",height=768',top=100,left=100";

	window.open("http://vizen.vizensoft.com/site/maintenance/customer/index.jsp?customerfk=3038&projectfk=3119",'maintenance',str);
}

function OpenWinCount(URL,width,height) {

	var str;
	str="'toolbar=yes, location=yes, directories=yes, status=no, menubar=yes, scrollbars=yes,resizable=yes,copyhistory=no,";
	str=str+"width="+width;
	str=str+",height="+height+"',top=100,left=100";

	window.open(URL,'_blank');
}

var parent = $(".parent");
$(document).ready(function(){
	if(isMobileTablet()) $(".parent").attr("href", "javascript: void(0); ");

	// 1depth 메뉴들
	
	//현재 주소
	// 주소중 manage이후 폴더 경로 자르기 ex) /manage/board/index.jsp -> board
	var curUrl = document.location.pathname;
	curUrl = location.pathname.substring(0,  location.pathname.lastIndexOf("/") ).substring( location.pathname.substring(0,  location.pathname.lastIndexOf("/") ).lastIndexOf("/"));
	
	$(".parent").parent().find("a").each(function(){
		$(this).find("span").removeClass("bg");

		// 1depth 메뉴 href 담기
		href = $(this)[0].href;

		// 가장 가까운 부모 디렉토리명
		href = href.substring(0,  href.lastIndexOf("/") ).substring( href.substring(0,  href.lastIndexOf("/") ).lastIndexOf("/"));
		
		// 현재 주소에서 href가 포함 되어 있으면 그 메뉴에 배경색 지정
		
		if(curUrl == href){
			$(this).parents('li:last').find(".parent span").addClass("bg");
		}
	});
	
	// 방문자 통계 클릭시 메뉴 유지
	parent.click(function(){
		// 1depth 메뉴 href 담기
		href = $(this)[0].href;
		
		if(href.indexOf("OpenWinCount") >= 0){
			parent.find("span").removeClass("bg");
			$(this).find("span").addClass("bg");
		}
	});

	// 메뉴 수에 맞게 width 값 수정.
	$("ul.menu > li").css("width", (100 / $("ul.menu > li").length) + "%");
});

</script>

	<!-- Preloader -->
	<div class="preloader-it">
		<div class="la-anim-1"></div>
	</div>
	<!-- /Preloader -->

	<!-- #wrapper -->
    <div class="wrapper theme-2-active pimary-color-blue">

		<!-- Top Menu Items -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="mobile-only-brand">
				<div class="nav-header">
					<div class="logo-wrap">
						<a href="/manage/eduStatistics/all/index.jsp">
							<img class="brand-img" src="/manage/img/logo.png" alt="shop_logo"/>
						</a>
					</div>
				</div>

				<!-- 모바일 메뉴 토글 버튼 -->
				<a id="toggle_nav_btn" class="toggle-left-nav-btn inline-block ml-20 pull-left" href="javascript:void(0);">
					<i class="zmdi zmdi-menu"></i>
					<img src="/manage/template/img/nav_close_btn.png" alt="">
				</a>
				<!-- 모바일 우측 토글 버튼 -->
				<a id="toggle_mobile_nav" class="mobile-only-view" href="javascript:void(0);"><i class="zmdi zmdi-more"></i></a>

			</div>
			<div id="mobile_only_nav" class="mobile-only-nav pull-right">
				<div class="nav navbar-right top-nav pull-right">
					
					<!--
					<ul class="line">
						<li><a href="javascript:;" onclick="popMaintenance();"><i><img src="/manage/img/top-nav_icon03.png" alt=""></i>유지보수요청</a></li>
						<li><a href="http://www.vizensoft.com" target="_blank"><i><img src="/manage/img/top-nav_icon04.png" alt=""></i>비젠소프트 방문</a></li>
					</ul>
					-->
					<ul class="box_a">
						<li ><a href="javascript:;" onclick="window.open('https://www.sist.co.kr/');">홈페이지 바로가기</a></li>
						<li><a href="/manage/include/logout.jsp">로그아웃</a></li>
					</ul>
				</div>
			</div>	
		</nav>
		<!-- /Top Menu Items -->
		
		<!-- Left Sidebar Menu -->
		<div class="fixed-sidebar-left">
			<ul class="nav navbar-nav side-nav nicescroll-bar depth_custom" style="overflow:hidden;">
				<li class="navigation-header">
					<span></span> 
					<i class="zmdi zmdi-more"></i>
				</li>
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-landscape mr-20"></i><span class="right-nav-text">게시판관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_1" class=""> -->
<!-- 						<li id="menu1_1" class="/manage/board/notice/"><a href="/manage/board/notice/index.jsp">공지/보도/동영상</a></li> -->
<!-- 						<li id="menu1_2" class="/manage/board/NoticeListImage/"><a href="/manage/board/NoticeListImage/index.jsp">공지/보도/동영상<br/>(이미지목록형)</a></li> -->
<!-- 						<li id="menu1_3" class="/manage/board/reply/"><a href="/manage/board/reply/index.jsp">답변형 게시판</a></li> -->
<!-- 						<li id="menu1_4" class="/manage/board/reply_comment/"><a href="/manage/board/reply_comment/index.jsp">답변댓글형 게시판</a></li> -->
<!-- 						<li id="menu1_5" class="/manage/board/gallery/"><a href="/manage/board/gallery/index.jsp">갤러리</a></li> -->
<!-- 						<li id="menu1_6" class="/manage/board/faq/"><a href="/manage/board/faq/index.jsp">FAQ</a></li> -->
<!-- 						<li id="menu1_7" class="/manage/board/faq/FaqCatagory/"><a href="/manage/board/faq/FaqCatagory/index.jsp">FAQ분류관리</a></li> -->
<!-- 						<li id="menu1_8" class="/manage/board/common/"><a href="/manage/board/common/index.jsp">공통게시판</a></li> -->
<!-- 						<li id="menu1_9" class="/manage/board/popup/"><a href="/manage/board/popup/index.jsp">팝업관리</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-shopping-basket mr-20"></i><span class="right-nav-text">상품관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_2" class=""> -->
<!-- 						<li id="menu2_1" class="/manage/product/product/"><a href="/manage/product/product/index.jsp">상품관리</a></li> -->
<!-- 						<li id="menu2_2" class="/manage/product/elcategory/"><a href="/manage/product/elcategory/index.jsp">전자상거래 상품정보관리</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
						
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-apps mr-20"></i><span class="right-nav-text">주문관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_3" class=""> -->
<!-- 						<li id="menu3_1" class="/manage/order/order/"><a href="/manage/order/order/index.jsp">주문관리</a></li> -->
<!-- 						<li id="menu3_2" class="/manage/order/product_review/"><a href="/manage/order/product_review/index.jsp">상품평</a></li> -->
<!-- 						<li id="menu3_3" class="/manage/order/product_qna/"><a href="/manage/order/product_qna/index.jsp">상품 Q&amp;A</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-flag mr-20"></i><span class="right-nav-text">매출통계</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_4" class=""> -->
<!-- 						<li id="menu4_1" class="/manage/statistics/stat/"><a href="/manage/statistics/stat/index.jsp">매출통계</a></li> -->
<!-- 						<li id="menu4_2" class="/manage/statistics/brand/"><a href="/manage/statistics/brand/index.jsp">브랜드별 통계</a></li> -->
<!-- 						<li id="menu4_3" class="/manage/statistics/prdt/"><a href="/manage/statistics/prdt/index.jsp">상품별 통계</a></li> -->
<!-- 						<li id="menu4_4" class="/manage/statistics/ctgr/"><a href="/manage/statistics/ctgr/index.jsp">카테고리별 통계</a></li> -->
<!-- 						<li id="menu4_5" class="/manage/statistics/mem/"><a href="/manage/statistics/mem/index.jsp">회원 통계</a></li> -->
<!-- 						<li id="menu4_6" class="/manage/statistics/cart/"><a href="/manage/statistics/cart/index.jsp">장바구니 분석</a></li> -->
<!-- 						<li id="menu4_7" class="/manage/statistics/jjim/"><a href="/manage/statistics/jjim/index.jsp">관심상품 분석</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-smartphone-setup mr-20"></i><span class="right-nav-text">배너관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_5" class=""> -->
<!-- 						<li id="menu5_1" class="/manage/banner/category/"><a href="/manage/banner/category/index.jsp">카테고리 배너관리</a></li> -->
<!-- 						li id="menu5_2" class="/manage/banner/main/"><a href="/manage/banner/main/index.jsp">메인 배너관리</a></li -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-edit mr-20"></i><span class="right-nav-text">쿠폰관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_6" class=""> -->
<!-- 						<li id="menu6_1" class="/manage/coupon/mng/"><a href="/manage/coupon/mng/index.jsp">쿠폰관리</a></li> -->
<!-- 						<li id="menu6_2" class="/manage/coupon/apply/"><a href="/manage/coupon/apply/index.jsp">쿠폰발급</a></li> -->
<!-- 						<li id="menu6_3" class="/manage/coupon/use/"><a href="/manage/coupon/use/index.jsp">쿠폰사용</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-chart-donut mr-20"></i><span class="right-nav-text">적립금관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_7" class=""> -->
<!-- 						<li id="menu7_1" class="/manage/point/point/"><a href="/manage/point/point/index.jsp">적립금관리</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-account-box mr-20"></i><span class="right-nav-text">회원관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_8" class=""> -->
<!-- 						<li id="menu8_1" class="/manage/member/"><a href="/manage/member/index.jsp">회원관리</a></li> -->

<!-- 						<li id="menu8_2" class="/manage/member/"><a href="/manage/member/dormant_index.jsp">휴면회원</a></li> -->

<!-- 						<li id="menu8_3" class="/manage/member/"><a href="/manage/member/secede_index.jsp">탈퇴회원</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-account-box mr-20"></i><span class="right-nav-text">판매자 관리</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_9" class=""> -->
<!-- 						<li id="menu9_1" class="/manage/seller/"><a href="/manage/seller/index.jsp">판매자 관리</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-account-box mr-20"></i><span class="right-nav-text">회원관리</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_7" class="">
						<li id="menu7_1" class="/manage/member/"><a href="/manage/member/index.jsp">회원관리</a></li>
						<li id="menu7_2" class="/manage/member/"><a href="/manage/member/dormant_index.jsp">휴면회원</a></li>
						<li id="menu7_3" class="/manage/member/"><a href="/manage/member/secede_index.jsp">탈퇴회원</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-flag mr-20"></i><span class="right-nav-text">지원자 관리</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_4" class="">
						<li id="menu4_1" class="/manage/eduStatistics/all/"><a href="/manage/eduStatistics/all/index.jsp">전체 지원 현황</a></li>
						<li id="menu4_2" class="/manage/eduStatistics/employment/allstatistics/"><a href="/manage/eduStatistics/employment/allstatistics/index.jsp">취업자 과정별 지원현황</a></li>
						<li id="menu4_3" class="/manage/eduStatistics/employment/typestatistics/"><a href="/manage/eduStatistics/employment/typestatistics/index.jsp">취업자 과정별 지원자 관리</a></li>
						<li id="menu4_4" class="/manage/eduStatistics/incumbent/allstatistics/"><a href="/manage/eduStatistics/incumbent/allstatistics/index.jsp">재직자 과정별 지원현황</a></li>
						<li id="menu4_5" class="/manage/eduStatistics/incumbent/typestatistics/"><a href="/manage/eduStatistics/incumbent/typestatistics/index.jsp">재직자 과정별 지원자 관리</a></li>
						<li id="menu4_6" class="/manage/boardAdmin/reservation/"><a href="/manage/boardAdmin/reservation/index.jsp">방문상담예약</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-apps mr-20"></i><span class="right-nav-text">연수 지원서</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_3" class="">
						<li id="menu3_1" class="/manage/apply/employment/"><a href="/manage/apply/employment/index.jsp">취업교육 지원서관리</a></li>
						<li id="menu3_2" class="/manage/apply/incumbent/"><a href="/manage/apply/incumbent/index.jsp">재직자교육 지원서관리</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-shopping-basket mr-20"></i><span class="right-nav-text">교육과정 관리</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_2" class="">
						<li id="menu2_1" class="/manage/edu/"><a href="/manage/edu/index.jsp">교육과정</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-landscape mr-20"></i><span class="right-nav-text">게시판관리</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_1" class="">
						<li id="menu1_1" class="/manage/boardAdmin/notice/"><a href="/manage/boardAdmin/notice/index.jsp">공지사항</a></li>
						<li id="menu1_2" class="/manage/boardAdmin/consult/"><a href="/manage/boardAdmin/consult/index.jsp">교육문의</a></li>
						<li id="menu1_3" class="/manage/boardAdmin/faq/"><a href="/manage/boardAdmin/faq/index.jsp">FAQ</a></li>
						<li id="menu1_4" class="/manage/boardAdmin/faq/FaqCatagory/"><a href="/manage/boardAdmin/faq/FaqCatagory/index.jsp">FAQ분류관리</a></li>
						<li id="menu1_5" class="/manage/boardAdmin/employment/"><a href="/manage/boardAdmin/employment/index.jsp">취업현황</a></li>
						<li id="menu1_6" class="/manage/boardAdmin/eduReview/"><a href="/manage/boardAdmin/eduReview/index.jsp">수강후기</a></li>
						<li id="menu1_7" class="/manage/boardAdmin/portfolio/"><a href="/manage/boardAdmin/portfolio/index.jsp">포트폴리오</a></li>
						<li id="menu1_8" class="/manage/boardAdmin/popup/"><a href="/manage/boardAdmin/popup/index.jsp">팝업관리</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-account-box mr-20"></i><span class="right-nav-text">구인의뢰관리</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_8" class="">
						<li id="menu8_1" class="/manage/request/"><a href="/manage/request/index.jsp">구인의뢰</a></li>
					</ul>
				</li>
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-flag mr-20"></i><span class="right-nav-text">지원 통계</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_6" class="">
						<li id="menu6_1" class="/manage/statistics/kind/"><a href="/manage/statistics/kind/index.jsp">과정별 통계</a></li>
						<li id="menu6_1" class="/manage/statistics/info/"><a href="/manage/statistics/info/index.jsp">가입경위 통계</a></li>
						<li id="menu6_1" class="/manage/statistics/mem/"><a href="/manage/statistics/mem/index.jsp">회원별 통계</a></li>
					</ul>
				</li>
				
				
				
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-smartphone-setup mr-20"></i><span class="right-nav-text">문자보내기</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_10" class=""> -->
<!-- 						<li id="menu10_1" class="/manage/sms/"><a href="/manage/sms/write.jsp">문자보내기</a></li> -->
<!-- 						<li id="menu10_2" class="/manage/sms/"><a href="/manage/sms/member.jsp">회원문자발송</a></li> -->
<!-- 						<li id="menu10_3" class="/manage/sms/"><a href="/manage/sms/reservation.jsp">예약내역</a></li> -->
<!-- 						<li id="menu10_4" class="/manage/sms/"><a href="/manage/sms/index.jsp">발송내역</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-edit mr-20"></i><span class="right-nav-text">메일보내기</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_11" class=""> -->
<!-- 						<li id="menu11_1" class="/manage/email/"><a href="/manage/email/write.jsp">메일보내기</a></li> -->
<!-- 						<li id="menu11_2" class="/manage/email/"><a href="/manage/email/member.jsp">회원메일발송</a></li> -->
<!-- 						<li id="menu11_3" class="/manage/email/"><a href="/manage/email/index.jsp">발송내역</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:void(0);"> -->
<!-- 						<div class="pull-left"><i class="zmdi zmdi-chart-donut mr-20"></i><span class="right-nav-text">방문자통계</span></div> -->
<!-- 						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div> -->
<!-- 						<div class="clearfix"></div> -->
<!-- 					</a> -->
<!-- 					<ul id="menu_12" class=""> -->

<!-- 					</ul> -->
<!-- 				</li> -->
				<li>
					<a href="javascript:void(0);">
						<div class="pull-left"><i class="zmdi zmdi-settings mr-20"></i><span class="right-nav-text">환경설정</span></div>
						<div class="pull-right"><i class="zmdi zmdi-caret-down"></i></div>
						<div class="clearfix"></div>
					</a>
					<ul id="menu_10" class="">
						<li id="menu10_1" class="/manage/environment/admin/"><a href="/manage/environment/admin/index.jsp">관리자관리</a></li>
						<li id="menu10_2" class="/manage/environment/loginhistory/"><a href="/manage/environment/loginhistory/index.jsp"><span>관리자접속기록</span></a></li>
						<li id="menu10_3" class="/manage/environment/stipulation/"><a href="/manage/environment/stipulation/stipulation.jsp"><span>개인정보취급방침/<br/>회원약관</span></a></li>
<!-- 						<li id="menu10_8" class="/manage/management/resertime/"><a href="/manage/management/resertime/index.jsp"><span>예약시간설정</span></a></li> -->
<!-- 						<li id="menu10_8" class="/manage/management/resercalendar/"><a href="/manage/management/resercalendar/index.jsp"><span>예약달력설정</span></a></li> -->
						
					</ul>
				</li>

				

			</ul>
		</div>
		<!-- /Left Sidebar Menu -->

		<!-- Main Content -->
		<div class="page-wrapper">
			<div class="container-fluid pt-25">



<script type="text/javascript">
	$(window).load(function(){
		$("#blist table tr td").mouseenter(function(){
		$(this).parent("tr").addClass("on");
		});
		$("#blist table tr td").mouseleave(function(){
			$("#blist table tr").removeClass("on");
		});		
	});	
</script>


<script>
	/* 현재 디렉토리를 구해서 menu마다 넣어놓은 class 이름이랑 같을때, active 클래스 추가 */
	$(window).load(function(){
		var url = window.location.pathname;
		var urlPathname = url.substring( 0, url.substring(1).lastIndexOf('/') + 2 );
		//console.log(urlPathname);

		//$(".side-nav > li > ul").removeClass("in");
		
		$(".depth_custom > li > ul").hide();
		$(".depth_custom > li > a").click(function(){
			var subcont = $(this).next("ul");

			if( subcont.is(":visible") ){ //닫을 때
				subcont.slideUp();
				$(this).removeClass("active");
			}else{
				subcont.slideDown(); // 열릴 때						 
				$(".depth_custom > li > ul").not(subcont).slideUp();
				$(".depth_custom > li").not(this).removeClass("on");
				$(".depth_custom > li > a").removeClass("active");
				$(this).addClass("active");
			}         
		});
		

		$(".depth_custom > li > ul > li > a").each(function(){
			if($(this).parent().attr('class') == urlPathname){
				$(this).css("color","#307dd4");
				$(this).parent().parent().addClass("in");	//메뉴펼침
				$(this).parent().parent().show();
				$(this).parent().parent().parent().find(">a").addClass("active").addClass("active_important");
			}
		});


		/* 모바일에서 메뉴 펼쳤을때 컨텐츠 영역 선택하면 메뉴 닫히게*/
		$(".page-wrapper").click(function(){
			$(".wrapper").removeClass("slide-nav-toggle");
		});

		$(".collapse > li > a").click(function(){
			if ( navigator.appName == "Microsoft Internet Explorer" ) {
				var nowUrl = window.location.href;
				saveHash(setTime);
			}
		});	
	});
	
</script>

	<script>
		// 메뉴효과
		$('#menu8_2 a').addClass('off');
		$('#menu8_3 a').addClass('off');
	</script>
	<!-- /top-->
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default card-view">
					<div class="panel-heading">
						<div class="pull-left">
							<!-- property:목록 -->
							<h4 class="panel-title txt-dark">회원 관리 - [목록]</h4>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="panel-wrapper collapse in">
						<div class="panel-body">
							<form name="searchForm" id="searchForm" action="index.jsp" method="post">
							<div class="form-wrap">
								<div class="form-horizontal">
									<div class="row">
										<div class="col-md-3">
											<label for="" class="col-md-4 title">
												<span class="asterisk">*</span>
												회원상태
											</label>
											<select name="ssecession" class="form-control w140" onchange="$('#searchForm').submit();">
												<option value="-1">전체</option>
												<option value='0' >회원</option><option value='1' >탈퇴신청</option>
											</select>
										</div>
										<div class="col-md-3">
											<label for="" class="col-md-4 title">
												<span class="asterisk">*</span>
												sms수신
											</label>
											<select name="sissms" class="form-control w140" onchange="$('#searchForm').submit();">
												<option value="-1">전체</option>
												<option value='0' >수신안함</option><option value='1' >수신</option>
											</select>
										</div>
										<div class="col-md-3">
											<label for="" class="col-md-4 title">
												<span class="asterisk">*</span>
												email수신
											</label>
											<select name="sisemail" class="form-control w140" onchange="$('#searchForm').submit();">
												<option value="-1">전체</option>
												<option value='0' >수신안함</option><option value='1' >수신</option>
											</select>
										</div>
									</div>
									
									
									<div class="light-grey-hr"></div>
									<div class="row">
										<div class="col-md-12 all">
											<label for="" class="col-md-2 title">
												<span class="asterisk">*</span>
												성별
											</label>
											<select name="sgender" class="form-control w140" onchange="$('#searchForm').submit();">
												<option value="0">전체</option>
												<option value='1' >남자</option><option value='2' >여자</option>
											</select>
										</div>
									</div>
									
									<div class="light-grey-hr"></div>
									<div class="row">
										<div class="col-md-12 all">
											<label for="" class="col-md-2 title">
												<span class="asterisk">*</span>
												가입일
											</label>
											<div class="form-box hauto">
												<input type="hidden" name="sdatetype" id="sdatetype" value="registdate"/>
												<input type="text" id="sstartdate" name="sstartdate" class="form-control w140" value="" />&nbsp;
												<span id="CalregistdateIcon" class="cal_btn">
												<button type="button" id="start_button"><img src="/manage/img/calendar_icon.png" id="CalregistdateIconImg" style="cursor:pointer;"/></button>
												</span>
												&nbsp;&nbsp;-&nbsp;&nbsp;
												<input type="text" id="senddate" name="senddate" class="form-control w140" value=""/>&nbsp;
												<span id="CalregistdateIcon" class="cal_btn">
												<button type="button" id="end_button"><img src="/manage/img/calendar_icon.png" id="CalregistdateIconImg" style="cursor:pointer;"/></button>
												</span>
												<p class="pc_inline_block_m_block">
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-05','2024-12-05');"><strong>전일</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-06','2024-12-06');"><strong>오늘</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-07','2024-12-07');"><strong>후일</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-11-29','2024-12-06');"><strong>1주</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-11-29','2024-12-05');"><strong>전주</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-01','2024-12-07');"><strong>금주</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-07','2024-12-13');"><strong>차주</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-11-06','2024-12-06');"><strong>1개월</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-11-01','2024-11-30');"><strong>전월</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2024-12-01','2024-12-31');"><strong>금월</strong></a>
													<a class="btns btns_black_line" href="#" onclick="searchDate('2025-01-01','2025-01-31');"><strong>익월</strong></a>
												</p>
											</div>
										</div>
									</div>
									<div class="light-grey-hr"></div>
									<div class="row">
										<div class="col-md-12 all">
											<label for="" class="col-md-2 title">
												<span class="asterisk">*</span>
												검색어 검색
											</label>
											<div class="form-box hauto">
												<select name="stype" class="form-control w140" id="stype" title="검색을 선택해주세요." onchange="$('#searchForm').submit();">
													<option value="name" >
														이름
													</option>
													<option value="id" >
														아이디
													</option>
													<option value="cell" >
														휴대폰
													</option>
													<option value="email" >
														이메일
													</option>
													<option value="addr0" >
														주소
													</option>


<!-- 													</option> -->
												</select>
												<input type="text" id="sval" name="sval" value=""  class="text_box form-control upserch06" onkeyup="entKeyEventListener(event.keyCode, 'searchForm');"/>
												<a class="btns btns_blue_line" href="#" onclick="$('#searchForm').submit();">검색</a>
												<a class="downl_icon btns btns_black_line" href="javascript:;" onclick="goExcel();"><img src="/manage/img/down_icon.png" />엑셀다운로드</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-default card-view">
					<div class="panel-wrapper collapse in">
						<div class="panel-body">
							<div id="bbs">
								<div class="page_num">
									<span>
										<strong>
											총 22324개
										</strong>
									</span>
									<span>
										1/2233페이지
									</span>
								</div>
								<form name="frm" id="frm" action="process.jsp" method="post">
								<div class="table_wrap table_scroll1400">
									<table width="100%" border="0" cellspacing="0" cellpadding="0" summary="관리자 관리목록입니다.">
										<colgroup>
											<col class="t_w5" />
											<col class="t_w8" />
											<col class="t_w11" />
											<col class="t_w11" />
											<col class="t_w14" />
											<col class="t_w14" />
											<col class="t_w12" />
											<col class="t_w12" />
											<col class="t_w7" />
											<col class="t_w7" />
											<!-- <col class="t_w7" />
											 <col class="t_w10" /> -->
											
										</colgroup>
										<thead>
											<tr>
												<th scope="col" class="first">
													<label class="b_first_c"><input type="checkbox" name="allChk" id="allChk" onClick="check(this, document.frm.no)"/>
													<i></i>
													</label>
												</th>
												<th scope="col">번호</th>
												<th scope="col">회원</th> 
												<th scope="col">아이디</th> 
												<th scope="col">휴대폰</th> 
												<th scope="col">이메일</th>
												<th scope="col">회원상태</th> 
												<th scope="col">sms수신</th> 
												<th scope="col">email수신</th> 
												<!--<th scope="col">쿠폰보유수</th> -->
												<th scope="col">가입일</th>
												
		<!-- 										<th scope="col" class="last"><input type="checkbox" name="allChk" id="allChk" onClick="check(this, document.frm.push)"/></th> -->
											</tr>
										</thead>
										<tbody>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22695"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">22324</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">권용범</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">dgf8513</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-5049-4067'">010-5049-4067</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=kyb7458@naver.com'">kyb7458@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">수신안함</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">수신안함</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22695'">2024-12-06</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22694"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">22323</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">장승우</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">jsw7980</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-8460-2714'">010-8460-2714</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=jsw7980@naver.com'">jsw7980@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">수신안함</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22694'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22693"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">22322</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">이우형</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">leewh0419</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-8952-4916'">010-8952-4916</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=leewh0519@naver.com'">leewh0519@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">수신</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22693'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22692"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">22321</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">배준협</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">2019219033</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-7562-3007'">010-7562-3007</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=wnsguq_kr@naver.com'">wnsguq_kr@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">수신안함</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22692'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22691"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">22320</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">최승재</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">csj103140</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-9955-2185'">010-9955-2185</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=csj103140@gmail.com'">csj103140@gmail.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">수신</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22691'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22690"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">22319</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">홍준성</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">wnstjd626</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-3482-1423'">010-3482-1423</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=015jun@naver.com'">015jun@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">수신</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22690'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22689"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">22318</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">김민진</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">kmj46231</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-5551-2174'">010-5551-2174</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=kmj46231@naver.com'">kmj46231@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">수신안함</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">수신안함</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22689'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22688"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">22317</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">오진우</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">sesgodgood3</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-9978-7837'">010-9978-7837</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=sesgodgood3@naver.com'">sesgodgood3@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">수신</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22688'">2024-12-05</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22687"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">22316</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">이채은</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">donggle0519</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-5845-7113'">010-5845-7113</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=donggle0519@naver.com'">donggle0519@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">수신안함</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22687'">2024-12-04</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
											<tr>
												<td class="first">
													<label class="b_nor_c"><input type="checkbox" name="no" id="no" value="22686"/>
													<i></i>
													</label> 
												</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">22315</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">박주연</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">plk9065</td>
												<td  class="helpComment" id="Smsh" style='cursor:pointer;' onclick="location.href='/manage/sms/write.jsp?stype=&sval=&reqPageNo=1&receiver=010-4193-9065'">010-4193-9065</td>
												<td class="helpComment" id="Emailh" style='cursor:pointer;' onclick="location.href='/manage/email/write.jsp?stype=&sval=&reqPageNo=1&receiveEmail=pjy3385067@naver.com'">pjy3385067@naver.com</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">회원</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">수신</td>
												<td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">수신</td>
												
												
												
												 <td style='cursor:pointer;' onclick="location.href='read.jsp?reqPageNo=1&no=22686'">2024-12-04</td> 
												
		<!-- 										<td class="last"><input type="checkbox" name="push" id="push" value="null"/></td> -->
											</tr>
										
										</tbody>
									</table>
								</div>
									<input type="hidden" name="cmd" id="cmd" value="groupDelete"/>
									<input type="hidden" name="stype" id="stype" value=""/>
									<input type="hidden" name="sval" id="sval" value=""/>
									<input type="hidden" name="sgender" id="sgender" value="0"/>
									<input type="hidden" name="sbranch_fk" id="sbranch_fk" value="0"/>
									<input type="hidden" name="sconsultnum" id="sconsultnum" value="-1"/>
									<input type="hidden" name="sresernum" id="sresernum" value="-1"/>
									<input type="hidden" name="sage" id="sage" value="-1"/>
									<input type="hidden" name="ssecession" id="ssecession" value="-1"/>
									<input type="hidden" name="sissms" id="sissms" value="-1"/>
									<input type="hidden" name="sisemail" id="sisemail" value="-1"/>
									<input type="hidden" name="sendtype" id="sendtype" value=""/>
									<input type="hidden" name="sdormanttype" id="sdormanttype" value="0"/>
								</form>

								<!-- 페이징 처리 -->
								<div class="paging_wrap">
								<div class='page'> <strong>1</strong><a href='/manage/member/index.jsp?reqPageNo=2' class='b_num'>2</a><a href='/manage/member/index.jsp?reqPageNo=3' class='b_num'>3</a><a href='/manage/member/index.jsp?reqPageNo=4' class='b_num'>4</a><a href='/manage/member/index.jsp?reqPageNo=5' class='b_num'>5</a><a href='/manage/member/index.jsp?reqPageNo=6' class='b_num'>6</a><a href='/manage/member/index.jsp?reqPageNo=7' class='b_num'>7</a><a href='/manage/member/index.jsp?reqPageNo=8' class='b_num'>8</a><a href='/manage/member/index.jsp?reqPageNo=9' class='b_num'>9</a><a href='/manage/member/index.jsp?reqPageNo=10' class='b_num'>10</a> <a href='/manage/member/index.jsp?reqPageNo=11' class='next'><img src='/img/li_next_b.png' alt='' /></a> <a href='/manage/member/index.jsp?reqPageNo=2233' class='next no03'><img src='/img/li_next_end.png' alt='' /></a></div> 
								</div>
								<!-- //페이징 처리 -->

								<div class="btns_wrap list">
									<div class="pull-left">
										<a class="btns btns_red" href="#" onclick="groupDelete();">삭제 </a>
										
									</div>
									<div class="pull-right">
	<!-- 									<a class="btns btns_blue" href="#" onclick="groupSend();"><strong>어플푸쉬</strong> </a> -->
	<a class="btns btns_blue" href="write.jsp">회원추가 </a>
									</div>
								</div>
								<!--//btn-->
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</div>
	<!-- /top_tab_area -->

	<!-- Footer -->
	<footer class="footer container-fluid pl-30 pr-30">
		<div class="row">
			<div class="col-sm-12">
				<p>COPYRIGHTS (C) 2020 VIZENSOFT. ALL RIGHTS RESERVED</p>
			</div>
		</div>
	</footer>
	<!-- /Footer -->

	</div>
    <!-- /Main Content -->
</div>
<!-- /#wrapper -->


	<!-- JavaScript -->
	
    <!-- Bootstrap Core JavaScript -->
    
	<!-- Data table JavaScript -->
	<script src="/manage/template/vendors/bower_components/datatables/media/js/jquery.dataTables.min.js"></script>
	
	<!-- Slimscroll JavaScript -->
	<script src="/manage/template/dist/js/jquery.slimscroll.js"></script>
	
	<!-- Progressbar Animation JavaScript -->
	<script src="/manage/template/vendors/bower_components/waypoints/lib/jquery.waypoints.min.js"></script>
	<script src="/manage/template/vendors/bower_components/jquery.counterup/jquery.counterup.min.js"></script>
	
	<!-- Fancy Dropdown JS -->
	<script src="/manage/template/dist/js/dropdown-bootstrap-extended.js"></script>
	
	<!-- Sparkline JavaScript -->
	<!--<script src="/manage/template/vendors/jquery.sparkline/dist/jquery.sparkline.min.js"></script>-->
	
	<!-- Owl JavaScript -->
	<script src="/manage/template/vendors/bower_components/owl.carousel/dist/owl.carousel.min.js"></script>
	
	<!-- Switchery JavaScript -->
	<script src="/manage/template/vendors/bower_components/switchery/dist/switchery.min.js"></script>
	
	<!-- Toast JavaScript -->
	<script src="/manage/template/vendors/bower_components/jquery-toast-plugin/dist/jquery.toast.min.js"></script>
	
	<!-- Init JavaScript -->
	<script src="/manage/template/dist/js/init.js"></script>
	<script src="/manage/template/dist/js/dashboard-data.js"></script>
</body>
</html>
