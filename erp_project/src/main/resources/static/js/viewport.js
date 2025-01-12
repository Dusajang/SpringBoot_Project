var deviceFilter = "win16|win32|win64|mac|macintel" 
var windowWidth = window.screen.width;
var pxFixed = "width=480, maximum-scale=1.0, user-scalable=no"
var deFault = "width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=yes"

// 가로모드, 세로모드 체인지할경우
function deviceChange (){
	var orientation = window.orientation;
	if(orientation != undefined){
		if(orientation == 0){
			// 세로모드
			$("meta[name=viewport]").attr("content", pxFixed)
		}else if(orientation == 90){
			// 가로모드
			setTimeout(function(){
				$("meta[name=viewport]").attr("content", deFault)
			},10)
		}
	}
}
function setViewPort(w_width) {
	if (w_width <= 480 ){
		$("meta[name=viewport]").attr("content", pxFixed)
	} else {
		$("meta[name=viewport]").attr("content", deFault)
	}
}
setViewPort(windowWidth);
deviceChange();

// 디바이스 기기 분석
if ( navigator.platform ){
	if ( deviceFilter.indexOf(navigator.platform.toLowerCase())<0){
		// 모바일기기
		$(window).on("orientationchange", function(event) {
			deviceChange();
		});

	} else{
		// 피시기기
		$(window).resize(function(){
			var windowWidth = window.screen.width
			setViewPort(windowWidth);
		});
	}
}
