<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Your page title</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/themes/redmond/jquery-ui.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.1/css/ui.jqgrid.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.14.1/jquery.jqgrid.min.js"></script>
<script>
    //<![CDATA[
    var lastsel;
    $(function () {
        "use strict";
        $("#grid").jqGrid({
			url : '${pageContext.request.contextPath}/pet/gangwon/animalClinic?listType=jqgrid',
			datatype: "json",
			jsonReader : {
          		root: "data.rows",
          		page: "data.page",
				total: "data.total",
				records: "data.records"
			},
		   	colNames:['번호','사업장명','소재지전체주소','도로명전체주소','위도','경도','전화번호','공휴일 휴진 안내','일요일 휴진 안내','기타 안내사항','월요일 영업종료시간','월요일 영업시작시간','토요일 영업종료시간','토요일 영업시작시간',''],
            colModel: [
                { name: "no", index:'no', sorttype:'int' },
                { name: "bizplcNm" , editable:true},
                { name: "locplcLotnoAddr" , editable:true},
                { name: "locplcRoadnmAddr" , editable:true},
                { name: "lat" , editable:true},
                { name: "lng" , editable:true},
                { name: "telno" , editable:true},
                { name: "noTrmtHoli" , editable:true},
                { name: "noTrmtSun" , editable:true},
                { name: "parkEtc" , editable:true},
                { name: "trmtMonEnd" , editable:true},
                { name: "trmtMonStart" , editable:true},
                { name: "trmtSatEnd" , editable:true},
                { name: "trmtSatStart" , editable:true},
                { name: "no",  editable:true, hidden:true}
            ],
		   	rowNum:40,
		   	rowList:[40,80,120,240],
		   	pager: '#list-pager',
		    autowidth:true,
		    shrinkToFit: true,
		    viewrecords: true,
		    sortname: "no",
		    sortorder: "asc",
		    loadonce:true,
			onSelectRow: function(id){
				if(id && id!==lastsel){
					jQuery('#grid').jqGrid('restoreRow',lastsel);
					jQuery('#grid').jqGrid('editRow',id,true);
					lastsel=id;
				}
			},
			editurl: "${pageContext.request.contextPath}/pet/gangwon/clinic/update"
        });

		jQuery("#list-pager").jqGrid('navGrid','#list-pager',{edit:true,add:false,del:false});
		   	
        });
    //]]>
    </script>
</head>
<body>
	<table id="grid"></table>
	<div id="list-pager"></div>
</body>
</html>