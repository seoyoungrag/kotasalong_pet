<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/ref/css/subDetail.css">
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/ref/js/subDetail.js"></script>
	
<table>
	<tbody>
		<tr>
			<td>
			이름:&nbsp;${beachVO.title}&nbsp;&nbsp;<a href="#" onclick="javascript:$('.myImg').click();">자세히 보기</a>
			</td>
		</tr>
		<tr>
			<td>시설:&nbsp;${beachVO.facilities}</td>
		<tr>
		<tr>
			<td>
			<span class="captionWeatherContent"></span>
			</td>
		</tr>
		<tr>
			<td>주소:&nbsp;${beachVO.addr1}</td>
		</tr>
		<tr>
			<td><a target="_blank" href="http://map.daum.net/link/to/${beachVO.title},${beachVO.mapy},${beachVO.mapx}">길찾기</a></td>
		</tr>
		<tr>
			<td><img alt="${beachVO.title }" class="myImg" width="100%" height="100px" src="${beachVO.firstimage2 ? beachVO.firstimage2: beachVO.firstimage}" onerror=""></td>
		</tr>
	</tbody>
</table>	
<%-- 
<table>
	<tbody>
		<tr>
			<td>${beachVO.title}</td>
		</tr>
		<tr>
			<td><a target="_blank"
				href="http://map.daum.net/link/to/${beachVO.title},${beachVO.mapy},${beachVO.mapx}">길찾기</a></td>
		</tr>
		<tr>
			<td><img alt="${beachVO.title }" id="myImg" width="150px"
				height="100px"
				src="${beachVO.firstimage2 ? beachVO.firstimage2: beachVO.firstimage}"
				onerror=""></td>
		</tr>
	</tbody>
</table>
 --%>

<div class="modalCaption" style="display: none;">
	<table>
		<tbody>
			<tr>
				<td>${beachVO.title}</td>
			<tr>
			<tr>
				<td>시설: ${beachVO.facilities}</td>
			<tr>
				<td>
				날씨: <span class="captionWeatherContent"></span>&nbsp;&nbsp; 
				</td>
			</tr>
			<tr>
				<td>주소: ${beachVO.addr1}</td>
			</tr>
			<tr>
			<td>
				<a target="_blank" href="http://map.daum.net/link/to/${beachVO.title},${beachVO.mapy},${beachVO.mapx}">길찾기</a>
			</td>
			</tr>
		</tbody>
	</table>
</div>
