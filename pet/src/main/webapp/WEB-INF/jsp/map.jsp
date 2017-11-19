<%--
	Description : JSP
	Modification Information

			수정일         수정자                   수정내용
		-------    --------    ---------------------------
							         최초 생성

		author   : 
		since    : 
--%>
<%@page import="java.io.OutputStream"%>
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="content-language" content="ko" />
<title>ayapet</title>

<!-- StyleSheet -->
<link rel="stylesheet" type="text/css" href="<c:url value='/ref/css/3.16.0.css'/>" />
<link rel='stylesheet' type="text/css" href="<c:url value='/ref/css/jquery-ui.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/ref/css/nouislider.fox.css'/>" />
</head>
<body>
<div class="wrap_map">
<!-- 탑 start -->
  <div class="top_map">
<!--     <p class="logo"><img src="./images/logo.png" alt="" /></p> -->
		<ul style="display:none;" >
			<li><a href="#" id="btnAll" class="icon btn_icon01" style="display:none;" title="전체">전체</a></li>
          <li><a href="#" id="btnClinic" class="icon btn_icon02" style="display:none;"  title="병원">병원</a></li>
          <li><a href="#" id="btnPhar" class="icon btn_icon03" style="display:none;" title="약국">약국</a></li>
          <li><a href="#" id="btnPension" class="icon btn_icon04" style="display:none;"  title="펜션">펜션</a></li>
         </ul>
  </div>
  <!-- 탑 end -->
  <!-- 본문 start -->
  <div class="container_map">
     <!-- 지도영역 start -->
     <div class="content_map">
     <div id="map" style="width:80%; height:80%;">	
     <div id="marker"></div>
     </div>
     </div>
    <!-- 지도영역 end -->
 </div>
 <!-- 본문 end -->
</div>
<!-- 전체 Wrap_map end -->

<!-- JavaScript lib -->
<script type="text/javascript" src="<c:url value='/ref/js/lib/jquery-2.2.4.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/ref/js/ESR23Common_debug.js'/>"></script>
<script type="text/javascript" src="<c:url value='/ref/js/import.js'/>"></script>

<script type="text/javascript">
window.onload=function(){
	var latitude, longitude, accuracy;
	function setGeolocation() {
	    var geolocation = window.navigator.geolocation.watchPosition( 
	        function ( position ) {
	            latitude = position.coords.latitude;
	            longitude = position.coords.longitude;
	            accuracy = position.coords.accuracy;
	            innerHtmlLatAndLonAndAcc(latitude, longitude, accuracy);
	        	window.Map.Marker.pointMove(longitude, latitude, 13);
	        }, function () { 
	            /*error*/ 
	        }, {
	            maximumAge: 250, 
	            enableHighAccuracy: true
	        } 
	    );
	    window.setTimeout( function () {
	            window.navigator.geolocation.clearWatch( geolocation ) 
	        }, 
	        5000 //stop checking after 5 seconds
	    );
	};

	setGeolocation();

	if('${type}'=='clinic'){
		window.Map.Marker.initClinicData();
	}else if('${type}'=='pharmacy'){
		window.Map.Marker.initPharmacyData();
	}else if('${type}'=='pension'){
		window.Map.Marker.initPensionData();
	}else if('${type}'=='all'){
		window.Map.Marker.initClinicData();
		window.Map.Marker.initPharmacyData();
		window.Map.Marker.initPensionData();
	}else if('${type}'=='beach'){
		window.Map.Marker.initBeachData();
	}
};
</script>
</body>
</html>