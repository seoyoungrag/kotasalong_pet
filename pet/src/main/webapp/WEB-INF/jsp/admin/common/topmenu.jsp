<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script src="${pageContext.request.contextPath}/ref/js/topmenu.js"></script>

<div class="topbar-left">
	<div class="text-center">
		<!-- <a class="logo" id="logo" href="#" onclick="javascript:bodyLoad('${pageContext.request.contextPath}/admin/main.do');">
			<span class="logo-small"><i class="mdi mdi-radar"></i>아야펫 관리자 시스템</span>
			<span class="logo-large"><i class="mdi mdi-radar"></i></span>
		</a> -->
	</div>
</div>

<div class="navbar navbar-default" role="navigation" >
	<div class="container">
		<div>
			<ul class="nav navbar-nav hidden-xs">
				<!-- <li><a class="waves-effect" href="#">Files</a></li> -->
				<li class="dropdown">
				<a class="dropdown-toggle waves-effect waves-primary forscreensize" role="button" aria-expanded="false" aria-haspopup="false" href="#" onclick="javascript:bodyLoad('${pageContext.request.contextPath}/pet/gangwon/admin/facility/edit?type=clinic');"
					data-toggle="dropdown">동물 병원</span>
				</a>
				</li>
				<li class="dropdown">
				<a
					class="dropdown-toggle waves-effect waves-primary forscreensize"
					role="button" aria-expanded="false" aria-haspopup="false" href="#" onclick="javascript:bodyLoad('${pageContext.request.contextPath}/pet/gangwon/admin/facility/edit?type=pharmacy');"
					data-toggle="dropdown">동물 약국</span>
				</a>
				</li>
				<li class="dropdown">
				<a
					class="dropdown-toggle waves-effect waves-primary forscreensize"
					role="button" aria-expanded="false" aria-haspopup="false" href="#" onclick="javascript:bodyLoad('${pageContext.request.contextPath}/pet/gangwon/admin/facility/edit?type=pension');"
					data-toggle="dropdown">애견 펜션</span>
				</a>
				</li>
			</ul>

			<ul class="nav navbar-nav navbar-right pull-right">

				<!-- <li class="dropdown hidden-xs"><a
					class="dropdown-toggle waves-effect waves-light forscreensize"
					aria-expanded="true" href="#" data-toggle="dropdown"
					data-target="#"> 관리자 </a></li>
				<li class="hidden-xs"><a class="waves-effect waves-light"
					href="javascript:logout();"
					style="margin-top: 25px; line-height: 20px;"><i
						class="zmdi zmdi-square-right"></i></a></li> -->


			</ul>

		</div>
	</div>
</div>


