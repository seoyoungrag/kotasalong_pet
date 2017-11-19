<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
		//<![CDATA[
		$(function() {
			"use strict";
			jqgridInfo();
			setJqgridInfoByType();
			$("#grid").jqGrid({
				url : jqgridInfo.url,
				datatype : "json",
				jsonReader : {
					root : "data.rows",
					page : "data.page",
					total : "data.total",
					records : "data.records"
				},
				colModel : jqgridInfo.colModel,
				rowNum : 1000,
				pager : '#list-pager',
				autowidth : true,
				shrinkToFit : true,
				rownumbers : false, // show row numbers
				rownumWidth : 10, // the width of the row numbers columns
				viewrecords : true,
				loadonce : true,
                subGrid: true, // set the subGrid property to true to show expand buttons for each row
                subGridRowExpanded: showChildGrid // javascript function that will take care of showing the child grid
                ,onSelectRow: function(parentRowID, status, e) {  			
        		    var mapx = $("#grid").jqGrid ('getCell', parentRowID, 'mapx');
        		    var mapy = $("#grid").jqGrid ('getCell', parentRowID, 'mapy');
        			pointMove(mapx, mapy, 13);
        		    var rs = dfs_xy_conv("toXY",mapy,mapx);
        		    // 위도/경도 -> 기상청 좌표x / 좌표 y 변환
        		    xml2jsonCurrentWth(rs.nx, rs.ny);
        			innerHtmlLatAndLonAndAcc(mapy, mapx, 0);
      			}
				,loadComplete: function(){
				}
			});

			$("#grid").jqGrid('filterToolbar');
		});
		function showChildGrid(parentRowID, parentRowKey) {
			var rowIds = $("#grid").getDataIDs();
			 $.each(rowIds, function (index, rowId) {
			         $("#grid").collapseSubGridRow(rowId); 
			 });
			$("#grid").jqGrid('setSelection', parentRowKey);
		    var mapx = $("#grid").jqGrid ('getCell', parentRowKey, 'mapx');
		    var mapy = $("#grid").jqGrid ('getCell', parentRowKey, 'mapy');
			//window.Map.Marker.pointMove(mapx, mapy, 13);
			pointMove(mapx, mapy, 13);
			innerHtmlLatAndLonAndAcc(mapy, mapx, 0);
		    $.ajax({
		    	url: "jqgridSubTable.do?no="+parentRowKey,
		        type: "GET",
		        success: function (html) {
		            $("#" + parentRowID).append(html);
		        }
		    });

		}
		//]]>
	</script>
	<div id="lngAndLat" style="display: none;"></div>
	<table id="grid" class="table table-striped table-bordered table-hover"></table>
	<div id="list-pager" style="display: none;"></div>
