// OS 버전 보기
// Check OS
// 김진규 추가
var userAgentInfoValueFrom = navigator.userAgent.replace(/ /g,'');
// 김진규 추가

var appname = navigator.userAgent.toLowerCase();

var uanaVigatorOs = navigator.userAgent;
var AgentUserOs= uanaVigatorOs.replace(/ /g,'');
var Ostxt="";
var OSName="";
var OsVers="";

// This script sets OSName variable as follows:
// "Windows"    for all versions of Windows
// "MacOS"      for all versions of Macintosh OS
// "Linux"      for all versions of Linux
// "UNIX"       for all other UNIX flavors 
// "Unknown OS" indicates failure to detect the OS

new function() {
    var OsNo = navigator.userAgent.toLowerCase(); 

    jQuery.os = {
        Linux: /linux/.test(OsNo),
        Unix: /x11/.test(OsNo),
        Mac: /mac/.test(OsNo),
        Windows: /win/.test(OsNo),
		Wing: /wing/.test(OsNo) //wing 때문에 윈도우로 인식한다.
    }
}

function OSInfoDev(){
	
	if($.os.Windows && !$.os.Wing) {
	
		
		if(AgentUserOs.indexOf("WindowsCE") != -1) OSName="Windows||CE";
		else if(AgentUserOs.indexOf("Windows95") != -1) OSName="Windows||95";
		else if(AgentUserOs.indexOf("Windows98") != -1) {
			if (AgentUserOs.indexOf("Win9x4.90") != -1){
				OSName="Windows||ME"
			}else{ 
				OSName="Windows||98"; 
			}
	   }else if(AgentUserOs.indexOf("WindowsNT4.0") != -1) OSName="Windows||NT 4.0";
		else if(AgentUserOs.indexOf("WindowsNT5.0") != -1) OSName="Windows||2000";
		else if(AgentUserOs.indexOf("WindowsNT5.01") != -1) OSName="Windows||2000, Service Pack 1 (SP1)";
		else if(AgentUserOs.indexOf("WindowsNT5.1") != -1) OSName="Windows||XP";
		else if(AgentUserOs.indexOf("WindowsNT5.2") != -1) OSName="Windows||2003";
		else if(AgentUserOs.indexOf("WindowsNT6.0") != -1) OSName="Windows||Vista/Server 2008";
		else if(AgentUserOs.indexOf("WindowsNT6.1") != -1) OSName="Windows||7";
		else if(AgentUserOs.indexOf("WindowsNT6.2") != -1) OSName="Windows||8";
		else if(AgentUserOs.indexOf("WindowsNT6.3") != -1) OSName="Windows||8.1";
		else if(AgentUserOs.indexOf("WindowsNT6.4") != -1 || AgentUserOs.indexOf("WindowsNT10.0") != -1) OSName="Windows||10";
		else if(appname.indexOf("nt 6.4") != -1 ) OSName="Windows||10";
		else if(AgentUserOs.indexOf("WindowsPhone8.0") != -1) OSName="Windows||Phone 8.0";
		else if(AgentUserOs.indexOf("WindowsPhoneOS7.5") != -1) OSName="Windows||Phone 7.5";
		else if(AgentUserOs.indexOf("Xbox") != -1) OSName="Xbox||360";
		else if(AgentUserOs.indexOf("XboxOne") != -1) OSName="Xbox||One";
		else if(AgentUserOs.indexOf("Win16") != -1) OSName="Windows||3.x";
		else if(AgentUserOs.indexOf("ARM") != -1) OSName="Windows||RT";
		else OSName="Windows||";
	
		OsVers="";
	
	} else if ($.os.Linux) {
		if(AgentUserOs.indexOf("Android") != -1) { OSName = getAndroidDevName(); }
		else if(AgentUserOs.indexOf("BlackBerry9000") != -1) OSName="BlackBerry||9000";
		else if(AgentUserOs.indexOf("BlackBerry9300") != -1) OSName="BlackBerry||9300";
		else if(AgentUserOs.indexOf("BlackBerry9700") != -1) OSName="BlackBerry||9700";
		else if(AgentUserOs.indexOf("BlackBerry9780") != -1) OSName="BlackBerry||9780";
		else if(AgentUserOs.indexOf("BlackBerry9900") != -1) OSName="BlackBerry||9900";
		else if(AgentUserOs.indexOf("BlackBerry;Opera Mini") != -1) OSName="Opera||9.80";
		else if(AgentUserOs.indexOf("Symbian/3") != -1) OSName="Symbian||OS3";
		else if(AgentUserOs.indexOf("SymbianOS/6") != -1) OSName="Symbian||OS6";
		else if(AgentUserOs.indexOf("SymbianOS/9") != -1) OSName="Symbian||OS9";
		else if(AgentUserOs.indexOf("Ubuntu") != -1) OSName="Ubuntu||";
		else if(AgentUserOs.indexOf("PDA") != -1) OSName="PDA||";
		else if(AgentUserOs.indexOf("NintendoWii") != -1) OSName="Nintendo||Wii";	
		else if(AgentUserOs.indexOf("PSP") != -1) OSName="PlayStation||Portable";
		else if(AgentUserOs.indexOf("PS2;") != -1) OSName="PlayStation||2";
		else if(AgentUserOs.indexOf("PLAYSTATION3") != -1) OSName="PlayStation||3";	
		else OSName="Linux||";
	
		OsVers = "";
	
	} else if ($.os.Unix) {
		OSName="UNIX||";
	} else if ($.os.Mac) {
		
			
	   if(AgentUserOs.indexOf("iPad") != -1 || AgentUserOs.indexOf("iPhone") != -1){
			var iOS = parseFloat(
				    ('' + (/CPU.*OS ([0-9_]{1,5})|(CPU like).*AppleWebKit.*Mobile/i.exec(navigator.userAgent) || [0,''])[1])
				    .replace('undefined', '3_2').replace('_', '.').replace('_', '')
			) || false;
			if(!iOS){
				OSName = "IOS||";
			}else{
				OSName = "IOS||"+iOS
			}
	   }else if((AgentUserOs.indexOf("MacOSX")) != -1) OSName="Mac||";
		else OSName="Mac||";
		
		
	} else {
		OSName="ETC||";
	}
  var OSDev = OSName + OsVers;
  return OSDev;
}

// Android의 단말 이름을 반환
function getAndroidDevName() {
    ua = navigator.userAgent.toLowerCase(); 
    var match = ua.match(/android\s([0-9\.]*)/);
        return match ? match[0].replace(" ","||") : false;
};

//자바스크립트 버전
function get_js_version ()
{
    this.jsv = {
            versions: [
                "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8", "1.9", "2.0"
            ],
            version: ""
        };

    var d = document;

    for (i = 0; i < jsv.versions.length; i++) {
        var g = d.createElement('script'),
            s = d.getElementsByTagName('script')[0];

            g.setAttribute("language", "JavaScript" + jsv.versions[i]);
            g.text = "this.jsv.version='" + jsv.versions[i] + "';";
            s.parentNode.insertBefore(g, s);
    }

    return jsv.version;
}

// OSInfoDev() 는 OS이름과 버전 출력하는 함수
// AgentUserOs 는 userAgent 출력

var sessionid = "SESSIONID_newweblog";
var connectid = "CONNECTID_newweblog";
var refid	  = "REFID_newweblog";

navigator.sayswho= (function(){
    var ua= navigator.userAgent, tem, 
    M= ua.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [];
    if(/trident/i.test(M[1])){
        tem=  /\brv[ :]+(\d+)/g.exec(ua) || [];
        return 'Internet Explorer||'+(tem[1] || '');
    }else if(/msie/i.test(M[1].toLowerCase())){
      
        return 'Internet Explorer||'+(M[2] || '');
    }

    if(M[1]=== 'Chrome'){
		if(ua.indexOf("Whale") > -1){
		//naver Whale 브라우저
		tem= ua.match(/\b(Whale)\/(\d+)\.(\d+)/);
		if(tem!= null) return tem.slice(1).join('||');
		}else{
        tem= ua.match(/\b(OPR|Edge)\/(\d+)/);
        if(tem!= null) return tem.slice(1).join('||').replace('OPR', 'Opera');
		}
    }
    M= M[2]? [M[1], M[2]]: [navigator.appName, navigator.appVersion, '-?'];
    if((tem= ua.match(/version\/(\d+)/i))!= null) M.splice(1, 1, tem[1]);
    return M.join('||');
})();




var os;
var osversion;
var browser;
var browsername;
var isfirst = false;

// 체크 해상도
var vn_screenx = screen.width; // 화면스크린 넓이
var vn_screeny = screen.height; // 화면스크린 높이

var resolution = vn_screenx + " * " + vn_screeny;

// 체크 타임존
var tz = new Date();
var tzStr = (tz.getTimezoneOffset()/60) * -1;

// 체크 사용언어별
var lang;

if (navigator.appName == "Netscape")
	lang = navigator.language;
else
	lang = navigator.userLanguage;

//var mobileKeyWords = new Array('iPhone', 'iPod', 'iPad','BlackBerry', 'Android', 'Windows CE', 'LG', 'MOT', 'SAMSUNG', 'SonyEricsson');

//if(appname.indexOf("iphone")>0) { os = "iPhone"; osversion="iPhone"; }
//else if(appname.indexOf("ipad")>0) { os = "iPad"; osversion="iPad"; }
//else if(appname.indexOf("blackberry")>0) { os = "Black Berry"; osversion="Black Berry"; }
//else if(appname.indexOf("sonyericsson")>0) { os = "Sony Ericsson"; osversion="Sony Ericsson"; }
//else if(appname.indexOf("mot")>0) { os = "motorola"; osversion="motorola"; }
//else if(appname.indexOf("samsung")>0) { os = "SAMSUNG smartphone"; osversion="SAMSUNG smartphone"; }
//else if(appname.indexOf("lg")>0) { os = "LG smartphone"; osversion="LG smartphone"; }
//else if(appname.indexOf("android")>0) { os = "Android"; osversion="Android"; }
//else if(appname.indexOf("windows ce")>0) { os = "Windows"; osversion="Windows CE"; }
//else if(appname.indexOf("nt 5.0")>0) { os = "Windows"; osversion = "2000"; }
//else if(appname.indexOf("nt 6.1")>0) { os = "Windows"; osversion = "7"; }
//else if(appname.indexOf("nt 6.0")>0) { os = "Windows"; osversion = "VISTA"; }
//else if(appname.indexOf("nt 5.1")>0) { os = "Windows"; osversion = "XP"; }
//else if(appname.indexOf("nt 5.2")>0) { os = "Windows"; osversion = "2003"; }
//else if(appname.indexOf("nt 6.2") != -1 ) { os="Windows"; osversion = "8" }
//else if(appname.indexOf("nt 6.3") != -1 ) { os="Windows"; osversion = "8.1" }
//else if(appname.indexOf("nt 6.4") != -1 ) { os="Windows"; osversion = "10" }

//else if(appname.indexOf("98")>0) { os = "Windows"; osversion = "98"; }
//else if(appname.indexOf("me")>0) { os = "Windows"; osversion = "ME"; }
//else if(appname.indexOf("mac os")>0) { os = "Mac OS"; osversion = "Mac"; }
//else if(appname.indexOf("linu")>0) { os = "LINUX"; osversion=""; }
//else { os = "ETC"; osversion="-"; }

var ros = OSInfoDev();

os = ros.split("||")[0]; osversion=(ros.split("||")[1] == "" ? "-" : ros.split("||")[1]);

//jquery 사용 2017-08-21 브라우저 버전체크
var browserversion = navigator.sayswho;
if(browserversion != undefined){
	browser=browserversion.replace("||"," ").toUpperCase()+".0"; browsername=browserversion.split("||")[0];
}else { 
	browser = "ETC"; browsername=navigator.platform; 
}

//if(appname.indexOf("trident/7.0")>0) { browser="INTERNET EXPLORER 11.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 10.0")>0) { browser="INTERNET EXPLORER 10.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 9.0")>0) { browser="INTERNET EXPLORER 9.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 8.0")>0) { browser="INTERNET EXPLORER 8.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 7.0")>0) { browser="INTERNET EXPLORER 7.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 6.0")>0) { browser="INTERNET EXPLORER 6.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 5.5")>0) { browser="INTERNET EXPLORER 5.5"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie 5.0")>0) { browser="INTERNET EXPLORER 5.0"; browsername="Internet Explorer"; }
//else if(appname.indexOf("msie")>0) { browser="MSIE"; browsername="Internet Explorer"; }
//else if(appname.indexOf("opera")>0) {browser = "OPERA"; browsername="Opera";}
//else if(appname.indexOf("firefox")>0) { browser="FIREFOX"; browsername="Firefox"; }
//else if(appname.indexOf("chrome")>0) { browser="CHROME "+browserversion; browsername="Chrome"; }
//else if(appname.indexOf("safari")>0) { browser="SAFARI"; browsername="Safari"; }
//else if(appname.indexOf("gecko")>0) { browser="GECKO"; browsername=navigator.appName;}
//else { browser = "ETC"; browsername=navigator.platform; }

var url = document.URL

var urls = url.split("?");
var urlhost = urls[0];
var urlquery = urls.length>1 ? urls[1] : "";
//alert(typeof("parent.document"));

var pref = "";//document==null ? "" : parent.document.referrer;
var ref = document.referrer;
var refs, refhost="", refquery="";

try{ pref = parent.document.referrer;}catch(_e){ try{ pref = top.document.referrer; }catch(_e){ pref = ""} }

if(pref != ref)
{
	ref = pref;
}

// 모바일 처리
if(url.indexOf("ref_val=") > -1) {
	ref = url.substring(url.indexOf("ref_val=")+8);
	url = url.substring(0, url.indexOf("ref_val=")-1);	
}

if(ref==url && url.indexOf("applicationDirect=on")== -1)
{
	ref = "";	
}
else
{

	if(url.indexOf("applicationDirect=on") > -1) {
		ref = url;
	}

	refs = ref.split("?");
	refhost = refs[0];
	refquery = refs.length>1 ? refs[1] : "";
}

// 유입경로별 인서트 로직추가
var cururl = url;
var cururl2 = "";

if(cururl.indexOf("http://www.") > -1) {
	cururl2 = cururl.substring(11, cururl.substring(11).indexOf("/") + 11);
} else if(cururl.indexOf("http://") > -1) {
	cururl2 = cururl.substring(7, cururl.substring(7).indexOf("/") + 7);
} else if(cururl.indexOf("https://www") > -1) {
	cururl2 = cururl.substring(12, cururl.substring(12).indexOf("/") + 12);
} else if(cururl.indexOf("https://") > -1) {
	cururl2 = cururl.substring(8, cururl.substring(8).indexOf("/") + 8);
}

var refurl = ref;
var refurl2 = "";

if(refurl.indexOf("http://www.") > -1) {
	refurl2 = refurl.substring(11, refurl.substring(11).indexOf("/") + 11);
} else if(refurl.indexOf("http://") > -1) {
	refurl2 = refurl.substring(7, refurl.substring(7).indexOf("/") + 7);
} else if(refurl.indexOf("https://www") > -1) {
	refurl2 = refurl.substring(12, refurl.substring(12).indexOf("/") + 12);
} else if(refurl.indexOf("https://") > -1) {
	refurl2 = refurl.substring(8, refurl.substring(8).indexOf("/") + 8);
}
// 유입경로별 인서트 로직추가 끝

var expire         = new Date();
var sessionid_val  = getCookie(sessionid);
var connectid_val  = getCookie(connectid);
var refid_val	   = getCookie(refid);
//var curdate        = new Date(expire.getMilliseconds() );
var curdate        = new Date();

expire.setTime(curdate.getTime() + 1000 * 3600 * 24 * 365);

if(sessionid_val=="")
{
	setCookie(sessionid, ""+curdate.getTime(), expire);
	sessionid_val = ""+curdate.getTime();
}

if(connectid_val == "")
{
	connectid_val = ""+curdate.getTime();
	setCookie(connectid,connectid_val,null);
	isfirst = true;
}

// 유입경로별 인서트 로직추가
if(refid_val == "") {
	if(refurl2 == "") {
		refid_val = "BOOKMARK";
	} else {
		refid_val = refurl2;
	}
	setCookie(refid,refid_val,null);
}

if( (refurl2 != "" && cururl2 != refurl2) && (refurl2 != refid_val) ) {
	
	connectid_val = ""+curdate.getTime();
	setCookie(connectid,connectid_val,null);
	setCookie(refid,refurl2,null);

	isfirst = true;
}

var scolos = screen.colorDepth; //색상수
var pcookie = navigator.cookieEnabled; //쿠키가능여부
var jscript = navigator.javaEnabled(); //자바스크립트 가능여부
var jsversion = get_js_version (); //자바스크립트 버전
// 유입경로별 인서트 로직추가 끝	

// 이미지 링크할 때는 절대 경로로 합니다. HOST명까지 적어 주어야 합니다.
//var img = "http://nweblog.vizensoft.com/main.vs?cururl="+cururl2+"&isfirst="+isfirst+"&sessionid="+sessionid_val+"&connectid="+connectid_val+"&os="+escape(os)+"&osversion="+escape(osversion)+"&browser="+escape(browser)+"&browsername="+escape(browsername)+"&ref="+escape((ref))+"&url="+escape((url))+"&resolution="+resolution+"&lang="+lang+"&scolos="+scolos+"&pcookie="+pcookie+"&jscript="+jscript+"&jsversion="+jsversion+"&tzone="+tzStr+"&useragent="+AgentUserOs;

//document.write("<img src='"+img+"' border=0 width=0 height=0>");


// COOKIE 설정
function getCookie(name)
{
	var nameOfCookie = name + "=";
	var x = 0;
	while (x <= document.cookie.length)
	{
		var y = (x+nameOfCookie.length);
		if (document.cookie.substring (x, y) == nameOfCookie)
		{
			if ((endOfCookie = document.cookie.indexOf (";", y)) == -1)
				endOfCookie = document.cookie.length;
			return unescape (document.cookie.substring(y, endOfCookie));
		}
		x = document.cookie.indexOf (" ", x) + 1;
		if (x == 0)
			break;
	}
	return "";
}

function setCookie (name, value, expires)
{
	if(expires==null) document.cookie = name + "=" + escape (value) + "; path=/";
	else document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
}



var data ={};
data.cururl = cururl2;
data.isfirst = isfirst;
data.sessionid = sessionid_val;
data.connectid = connectid_val;
data.os = (os);
data.osversion = (osversion);
data.browser = (browser);
data.browsername = (browsername);
data.ref = ((ref.replace(/\+/gi,' ')));
data.url = ((url.replace(/\+/gi,' ')));
data.resolution = resolution;
data.lang = lang; 
data.scolos = scolos;
data.pcookie = pcookie;
data.jscript = jscript;
data.jsversion = jsversion;
data.tzone = tzStr;
data.useragent = AgentUserOs;



$.ajax({
	url: "//nweblog.vizensoft.com/main.vs"
	, crossDomain: true
	, async: true
	, dataType: "jsonp"
	, type: 'post'
	, data: data
	, success: function( data, textStatus, jqXHR )
	{
	
	}
	, error: function( jqXHR, textStatus, errorThrown )
	{
	
	}
});