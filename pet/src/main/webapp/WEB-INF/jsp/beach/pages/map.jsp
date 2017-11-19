<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/ref/js/ESR23Common_debug.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ref/js/import_beach.js"></script>
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