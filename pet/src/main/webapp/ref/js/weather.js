// mobile 환경일때
function getLocationFromApp(latitude, longitude){
    try{
    	window.Map.Marker.pointMove(longitude, latitude, 13);
    }catch(err){
    	//console.log(err);
    	pointMove(longitude, latitude, 13, 'mylocation');
    }
    var rs = dfs_xy_conv("toXY",latitude,longitude);
    xml2jsonCurrentWth(rs.nx, rs.ny);
}
// web 환경일때
function getLocation(){
	$('#loading').show();
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(locationSuccess, locationError, geo_options);
    }else{
        console.log("지오 로케이션 없음")
    }
    $('#loading').hide();
};
// getLocation
function locationSuccess(p){
    var latitude = p.coords.latitude,
    longitude = p.coords.longitude;
    try{
    	window.Map.Marker.pointMove(longitude, latitude, 15);
    }catch(err){
    	//console.log(err);
    	pointMove(longitude, latitude, 16, 'mylocation');
    }
    var rs = dfs_xy_conv("toXY",latitude,longitude);
    // 위도/경도 -> 기상청 좌표x / 좌표 y 변환
    xml2jsonCurrentWth(rs.nx, rs.ny);
}
//locationSuccess

function locationError(error){
    var errorTypes = {
        0 : "error",
        1 : "need grant",
        2 : "cannot locate",
        3 : "timeout",
        4 : "moible gps err"
    };
    var errorMsg = errorTypes[error.code];
    console.log(errorMsg)
	if(typeof BeachApp==="undefined"){
		console.log(errorTypes[4]);
	}else{
		BeachApp.getGPS();
	}
}
// locationError

var geo_options = {
    enableHighAccuracy: true,
    maximumAge        : 1000,
    timeout           : 1000
};
// geo_options

//LCC DFS 좌표변환을 위한 기초 자료
//
var RE = 6371.00877; // 지구 반경(km)
var GRID = 5.0; // 격자 간격(km)
var SLAT1 = 30.0; // 투영 위도1(degree)
var SLAT2 = 60.0; // 투영 위도2(degree)
var OLON = 126.0; // 기준점 경도(degree)
var OLAT = 38.0; // 기준점 위도(degree)
var XO = 43; // 기준점 X좌표(GRID)
var YO = 136; // 기1준점 Y좌표(GRID)
//
// LCC DFS 좌표변환 ( code : "toXY"(위경도->좌표, v1:위도, v2:경도), "toLL"(좌표->위경도,v1:x, v2:y) )
//
function dfs_xy_conv(code, v1, v2) {
var DEGRAD = Math.PI / 180.0;
var RADDEG = 180.0 / Math.PI;

var re = RE / GRID;
var slat1 = SLAT1 * DEGRAD;
var slat2 = SLAT2 * DEGRAD;
var olon = OLON * DEGRAD;
var olat = OLAT * DEGRAD;

var sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
var sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
var ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
ro = re * sf / Math.pow(ro, sn);
var rs = {};
if (code == "toXY") {

    rs['lat'] = v1;
    rs['lng'] = v2;
    var ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
    ra = re * sf / Math.pow(ra, sn);
    var theta = v2 * DEGRAD - olon;
    if (theta > Math.PI) theta -= 2.0 * Math.PI;
    if (theta < -Math.PI) theta += 2.0 * Math.PI;
    theta *= sn;
    rs['nx'] = Math.floor(ra * Math.sin(theta) + XO + 0.5);
    rs['ny'] = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5);
}
else {
    rs['nx'] = v1;
    rs['ny'] = v2;
    var xn = v1 - XO;
    var yn = ro - v2 + YO;
    ra = Math.sqrt(xn * xn + yn * yn);
    if (sn < 0.0) - ra;
    var alat = Math.pow((re * sf / ra), (1.0 / sn));
    alat = 2.0 * Math.atan(alat) - Math.PI * 0.5;

    if (Math.abs(xn) <= 0.0) {
        theta = 0.0;
    }
    else {
        if (Math.abs(yn) <= 0.0) {
            theta = Math.PI * 0.5;
            if (xn < 0.0) - theta;
        }
        else theta = Math.atan2(xn, yn);
    }
    var alon = theta / sn + olon;
    rs['lat'] = alat * RADDEG;
    rs['lng'] = alon * RADDEG;
}
return rs;
}
//dfs_xy_conv

function xml2jsonCurrentWth(nx, ny){
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    var hours = today.getHours();
    var minutes = today.getMinutes();
    console.log("time " + minutes)
 
    if(minutes < 30){
        // 30분보다 작으면 한시간 전 값
        hours = hours - 1;
        if(hours < 0){
            // 자정 이전은 전날로 계산
            today.setDate(today.getDate() - 1);
            dd = today.getDate();
            mm = today.getMonth()+1;
            yyyy = today.getFullYear();
            hours = 23;
        }
    }
    if(hours<10) {
        hours='0'+hours
    }
    if(mm<10) {
        mm='0'+mm
    }
    if(dd<10) {
        dd='0'+dd
    } 

	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
		ctx='/pet/kotasalong';
	}else{
		ctx='/kotasalong';
	}
	var ajaxUrl = ctx + "/pxy.do?url=";
    var _nx = nx,
    _ny = ny,
    apikey = "g3wOXn7nLmuToJtF5joMIv1bVoM5szmzzXFzm5Bs1pDbUKX2cRBvnCGqvKY41ZTtHNj%2BN8qlxZ3ifVKcyruINQ%3D%3D",
    today = yyyy+""+mm+""+dd,
    basetime = hours + "00",
    fileName = "http://newsky2.kma.go.kr/service/SecndSrtpdFrcstInfoService2/ForecastGrib";
    fileName += "?ServiceKey=" + apikey;
    fileName += "&base_date=" + today;
    fileName += "&base_time=" + basetime;
    fileName += "&nx=" + _nx + "&ny=" + _ny;
    fileName += "&pageNo=1&numOfRows=6";
    fileName += "&_type=json";
 
    $.ajax({
        url: ajaxUrl+encodeURIComponent(fileName),
        type: 'GET',
        //cache: false,
        success: function(data) {
        	try{
        	var T1H, //기온  ℃
        	RN1, //1시간 강수량 mm
/*        	0.1mm 미만
        	0mm 또는 없음
        	0
        	0.1mm 이상 1mm 미만
        	1mm 미만
        	1
        	1 mm 이상 5 mm 미만
        	1~4mm
        	5
        	5 mm 이상 10 mm 미만
        	5~9mm
        	10
        	10 mm 이상 20 mm 미만
        	10~19mm
        	20
        	20 mm 이상 40 mm 미만
        	20~39mm
        	40
        	40 mm 이상 70 mm 미만
        	40~69mm
        	70
        	70 mm 이상
        	70mm 이상
        	100
*/
        	SKY, //하늘상태(SKY) 코드 : 맑음(1), 구름조금(2), 구름많음(3), 흐림(4)
        	UUU, //동서바람성분 동(+표기), 서(-표기) m/s
        	VVV, //남북바람성분 북(+표기), 남(-표기) m/s
        	REH, //습도 %
        	PTY, //강수형태(PTY) 코드 : 없음(0), 비(1), 비/눈(2), 눈(3) 여기서 비/눈은 비와 눈이 섞여 오는 것을 의미 (진눈개비)
        	LGT, //낙뢰 없음(0), 있음(1)
        	VEC, //풍향 0
        	WSD; //풍속 1
	        	for(var i = 0;i<data.response.body.items.item.length;i++){
	        		if(data.response.body.items.item[i].category=='T1H'){
	        			T1H = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='RN1'){
	        			RN1 = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='SKY'){
	        			SKY = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='UUU'){
	        			UUU = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='VVV'){
	        			VVV = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='REH'){
	        			REH = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='PTY'){
	        			PTY = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='LGT'){
	        			LGT = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='VEC'){
	        			VEC = data.response.body.items.item[i].obsrValue;
	        		}else if(data.response.body.items.item[i].category=='WSD'){
	        			WSD = data.response.body.items.item[i].obsrValue;
	        		}
	        	}
	            	innerHtmlWeather(SKY, LGT, T1H);
	            }catch(err){
	            	console.log(err);
	            	return false;
	            }
        },
        error:function(request,status,error){
            alert("다시 시도해주세요.\n" + "code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
        });
 
}
// xml2jsonCurrentWth
 
function rplLine(value){
    if (value != null && value != "") {
        return value.replace(/\n/g, "\\n");
    }else{
        return value;
    }
}
// rplLine


//getLocation();