<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="common/header.jsp" flush="true" />
</head>
<body>
<script type="text/javascript">
var ctx = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/ref/js/adminEdit.js"></script>
<script>
//<![CDATA[
var lastsel;
$(function () {
  "use strict";
	jqgridInfo();
	setJqgridInfoByType('${type}');
  $.jgrid.styleUI.Bootstrap.base.rowTable = "table table-bordered table-striped";
  $("#grid").jqGrid({
		url : jqgridInfo.url,
		datatype: "json",
		jsonReader : {
    		root: "data.rows",
    		page: "data.page",
			total: "data.total",
			records: "data.records"
		},
		colModel: jqgridInfo.colModel,
	   	rowNum: 40,
	   	pager: '#list-pager',
	   	autowidth: true,
	    shrinkToFit: true,
		rownumbers: true, // show row numbers
		rownumWidth: 35, // the width of the row numbers columns
		viewrecords: true,
		sortname: "bizplcNm",
	    loadonce:true,
		/* onSelectRow: function(id){
			if(id && id!==lastsel){
				jQuery('#grid').jqGrid('restoreRow',lastsel);
				jQuery('#grid').jqGrid('editRow',id,true);
				lastsel=id;
			}
		}*/
		editurl: jqgridInfo.editurl,
		caption: jqgridInfo.caption,
		beforeSubmit: function () {
		    $("#grid").jqGrid("setGridParam", {datatype: 'json'});
		    return [true];
		},
		reloadAfterSubmit: true
      });

	$("#grid").jqGrid('filterToolbar');
  $("#grid").jqGrid('bindKeys');
	jQuery("#grid").jqGrid('navGrid',"#list-pager",
  {   //navbar options
      edit: true,
      add: true,
      del: false,
      search: true,
      refresh: true,
      view: true,
      position: "left",
      cloneToTop: false,
      fromServer: true
  },{   //edit record form
      recreateForm: true,
		checkOnUpdate : true,
		checkOnSubmit : true,
      closeAfterEdit: true,
      errorTextFormat: function (data) {
          return 'Error: ' + data.responseText
      }
  },{   //new record form
      closeAfterAdd: true,
      recreateForm: true,
      errorTextFormat: function (data) {
          return 'Error: ' + data.responseText
      }
  },{   //delete record form
      errorTextFormat: function (data) {
          return 'Error: ' + data.responseText
      }
  }
	);
  $('#grid').navButtonAdd('#list-pager',
      {
          buttonicon: "ui-icon-trash",
          position: "right",
          title: "",
          caption: "삭제",
          onClickButton: deleteButtonClicked
      });
	function deleteButtonClicked(){
		var grid = $("#grid");
		var rowid = grid.jqGrid('getGridParam', 'selrow');
		var no = $('#grid').jqGrid('getCell',rowid,'no');
		$.ajax({
		     type:"POST",
		     url: jqgridInfo.editurl,
		     data: {
		            'no': no,
		            'oper': 'del'
		            },
		     success: function(data){
		             if(data.responseCode==1){
		            	 alert('성공');
		            	 $('#grid').jqGrid('delRowData',rowid);
		             }else{
		            	 alert('실패');
		             }
		     }
		});
	}
	var winHeight = window.innerHeight;
	var wHeight = winHeight - 350;
	$("#grid").jqGrid('setGridHeight',wHeight);
  if(wHeight < 110){  //Height of five rows in grid is 110 pixels.
      wHeight = 110;
      $('#grid').jqGrid('setGridHeight',wHeight);
  }
  else {
      $('#grid').jqGrid('setGridHeight',wHeight);
  }
});
//]]>
</script>

	<div id="jqGrid_container" style="margin-left:20px">
	    <input class="btn btn-default" type="button" value="Edit in Batch Mode" onclick="startEdit()" />
	    <input class="btn btn-default" type="button" value="Save All Rows" onclick="saveRows()" />
	
	    <br /><br />
		<table id="grid"></table>
		<div id="list-pager"></div>
	</div>
	<div class="contextMenu row" id="contextMenu" style="display: none;">
		<ul>
			<li id="add"><span class="glyphicon glyphicon-plus"
				style="float: left"></span> <span
				style="font-size: 100%; font-family: Verdana; margin-left: 10px;">Add
					Row</span></li>
			<li id="edit"><span class="glyphicon glyphicon-pencil"
				style="float: left"></span> <span
				style="font-size: 100%; font-family: Verdana; margin-left: 10px;">Edit
					Row</span></li>
			<li id="del"><span class="glyphicon glyphicon-trash"
				style="float: left"></span> <span
				style="font-size: 100%; font-family: Verdana; margin-left: 10px;">Delete
					Row</span></li>
		</ul>
	</div>
