<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="common/header.jsp" flush="true" />
</head>
<body>
	<!-- Begin menu -->
	<header> 
	<!-- 로고를 상단 가운데에 따로 띄우려면 topbar 주석 -->
	<div class="container-fluid">
		<div class="topbar">
			<jsp:include page="common/topmenu.jsp" flush="true" />
		</div>
	</div>
	</header>
	<!-- menu End --> 
	
	<!-- Body -->
	<div class="wrapper">
		<div class="container-fluid" id="wrapper-content-container">
			<jsp:include page='${pageContext.request.contextPath}/gangwon/admin/facility/edit?type=clinic' flush="true" />
		</div>
	</div>
	<!-- end body -->
	
	<!-- Footer -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">아야펫 관리자 - 코타살롱</div>
			</div>
		</div>
	</footer>
	<!-- End Footer -->
	
</body>
</html>
