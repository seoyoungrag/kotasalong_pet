<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="common/header.jsp" flush="false" />
</head>
<body style="overflow: unset;overflow-x: hidden;overflow-y: hidden;">
    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;z-index:99;">
            <div class="navbar-header">
                <button type="button" id="navBtn" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" onclick="javascript:$('.sidebar').css('visibility','').css('height','auto');">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" id="weatherContent">가자! 해변으로(gogo beach)</a>
                <button type="button" class="mylocation" onclick="javascript:getLocation();">
                	<i class="fa fa-home"></i>
                </button>
            </div>
            <!-- /.navbar-header -->
        </nav>
            <div class="navbar-default sidebar" role="navigation">
                <div id="collapseDiv" class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="navbar-collapse">
							<jsp:include page='/kotasalong/beach/table.do' flush="false" />
						</li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        <div id="page-wrapper" class="mapDivs">
            <div class="row" class="mapDivs">
                <div class="col-lg-12 mapDivs" >
					<%-- <jsp:include page='/kotasalong/beach/map.do?type=beach' flush="true" /> --%>
						<jsp:include page='/kotasalong/beach/test.do' flush="false" />
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper --><%-- 
	<div id="loading">
		<img id="loading-image" src="${pageContext.request.contextPath}/beach_ref/icon-load.gif" alt="Loading..." />
	</div> --%>
	
<!-- The Modal -->
<div id="topModal" class="modal">

	<!-- The Close Button -->
	<span class="close" onclick="document.getElementById('topModal').style.display='none'">&times;</span>

	<!-- Modal Content (The Image) -->
	<img class="modal-content" id="img01">

	<!-- Modal Caption (Image Text) -->
	<div id="topCaption"></div>
</div>
</body>

</html>