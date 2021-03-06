var categorySubArr = '<%=categorySubArr.toString()%>';
var param = "category=<%=searchVO.getCategory()%>&categorySub=<%=searchVO.getCategorySub()%>&startDate=<%=searchVO.getStartDate()%>&endDate=<%=searchVO.getEndDate()%>&searchType=<%=searchVO.getSearchType()%>&searchWord=<%=searchVO.getSearchWord()%>"
		+ categorySubArr;
$(function() {
	$("#noticeList")
			.jqGrid(
					{
						// ajax 호출할 페이지
						url : '<%=contextPath%>/getNoticeList.do?' + param,

						// 로딩중일때 출력시킬 로딩내용
						loadtext : '로딩중..',
						// 응답값
						datatype : "json",
						styleUI : 'Bootstrap',
						multiselect : false,
						colNames : [ '시스템명', '업무구분', '긴급', '제목', '등록자', 'id',
								'등록일', '등록자 아이디', '부모아이디' ],
						colModel : [ {
							name : 'category',
							index : 'CheckResult',
							align : "center",
							width : "100",
							hidden : true
						}, {
							name : 'categorySub',
							align : "center",
							width : "100",
							formatter : subFormatter,
							sortable : true
						}, {
							name : 'emer',
							align : "center",
							width : "100",
							hidden : true
						}, {
							name : 'title',
							align : "left",
							width : "400",
							formatter : emer,
							sortable : true
						}, {
							name : 'writer',
							align : "left",
							width : "100",
							sortable : true
						}, {
							name : 'noticeId',
							align : "center",
							width : "100",
							hidden : true
						}, {
							name : 'regDate',
							align : "center",
							width : "100",
							sortable : true
						}, {
							name : 'userId',
							align : "center",
							width : "100",
							hidden : true
						}, {
							name : 'parentId',
							align : "center",
							width : "100",
							hidden : true
						} ],
						viewrecords : true,
						pager : "#jqGridPager",
						rowNum : 20,
						rowList : [ 20, 50, 100 ],
						height : 'auto',
						autowidth : true,
						shrinkToFit : true,
						rownumbers : true,
						onCellSelect : function(rowid, index, contents, event) {
							var cm = $(this).jqGrid('getGridParam', 'colModel');
							if (cm[index].name == 'title') {
								var id = $(this).jqGrid('getRowData', rowid).noticeId; // 선택된
								// row의
								// id를
								// 가져온다.
								document.location.href = "<%=contextPath%>/notice/view.do?bbsPostId="
										+ id;
							}
						}
					});
});


function noticeSearch() {
	$("#noticeSearchForm").submit();
}

function subFormatter(value, options, rowObject) {
	var returnVal = '';

	if (value == 'normal') {
		returnVal = '일반';
	} else if (value == 'data') {
		returnVal = '데이터';
	} else if (value == 'work') {
		returnVal = '작업';
	}

	return returnVal;
}

function emer(value, options, rowObject) {
	/* 12.15 댓글 개수 표시 */
	var commentCnt = '';
	if (value.length > 3) {
		commentCnt = value.substr(value.length - 3, value.length);
		if (commentCnt[0] == '[' && commentCnt[2] == ']') {
			value = value.replace(commentCnt, '');
		} else {
			commentCnt = '';
		}
	}

	var emerYN = rowObject.emer;
	var radioHtml = "&nbsp;&nbsp;&nbsp;";
	if (emerYN == 'Y') {
		radioHtml = '<p class="label label-danger" style="width:100px; margin-top:15px; margin-left:15px; text-align:left">긴급</p>&nbsp;&nbsp;&nbsp;'
	}

	var replyContent = rowObject.parentId;
	if (replyContent != "") {
		radioHtml = '<p class="label label-success" style="width:100px; margin-top:15px; margin-left:50px; text-align:left">답변</p>&nbsp;&nbsp;&nbsp;'
	}

	/* 12.15 댓글 개수 표시 */
	/* radioHtml += '<span style="cursor:pointer;"">'+value+'</span>' ; */
	radioHtml += '<span style="cursor:pointer">' + value
			+ '&nbsp;<font style="font-style:oblique;font-weight:bold;">'
			+ commentCnt + '</></span>';
	return radioHtml;
}

function question(value, options, rowObject) {
	var radioHtml = '<p class="label label-success" style="width:100px; margin-top:15px; margin-left:0px; background-color:#5cb85c; text-align:left">질문</p>&nbsp;&nbsp;&nbsp;'
			+ value;
	return radioHtml;
}