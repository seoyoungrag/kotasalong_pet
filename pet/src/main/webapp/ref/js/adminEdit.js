$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

function startEdit() {
    var grid = $("#grid");
    var ids = grid.jqGrid('getDataIDs');

    for (var i = 0; i < ids.length; i++) {
        grid.jqGrid('editRow',ids[i]);
    }
};

function saveRows() {
    var grid = $("#grid");
    var ids = grid.jqGrid('getDataIDs');

    for (var i = 0; i < ids.length; i++) {
        grid.jqGrid('saveRow', ids[i]);
    }
}
function jqgridInfo() {
	this.url;
	this.colNames;
	this.colModel;
	this.editurl;
}
function setJqgridInfoByType(type) {
	if (type == 'clinic') {
		jqgridInfo.url = ctx+'/pet/gangwon/animalClinic?listType=jqgrid';
		jqgridInfo.colModel = [ {
			label : "번호",
			name : "no",
			hidden : true,
			editable : true,
			editoptions: { defaultValue: '0'}
		}, {
			label : "사업장명",
			name : "bizplcNm",
			editable : true
		}, {
			label : "소재지전체주소",
			name : "locplcLotnoAddr",
			editable : true
		}, {
			label : "도로명전체주소",
			name : "locplcRoadnmAddr",
			editable : true
		}, {
			label : "위도",
			name : "lat",
			editable : true
		}, {
			label : "경도",
			name : "lng",
			editable : true
		}, {
			label : "전화번호",
			name : "telno",
			editable : true
		}, {
			label : "공휴일 휴진 안내",
			name : "noTrmtHoli",
			editable : true
		}, {
			label : "일요일 휴진 안내",
			name : "noTrmtSun",
			editable : true
		}, {
			label : "기타 안내사항",
			name : "parkEtc",
			editable : true
		}, {
			label : "월요일 영업시작시간",
			name : "trmtMonStart",
			editable : true
		}, {
			label : "월요일 영업종료시간",
			name : "trmtMonEnd",
			editable : true
		}, {
			label : "토요일 영업시작시간",
			name : "trmtSatStart",
			editable : true
		}, {
			label : "토요일 영업종료시간",
			name : "trmtSatEnd",
			editable : true
		} ];
		jqgridInfo.editurl = ctx+"/pet/gangwon/clinic/update";
		jqgridInfo.caption = "병원 리스트";
	} else if (type == 'pharmacy') {
		jqgridInfo.url = ctx+'/pet/gangwon/animalPharmacy?listType=jqgrid';
		jqgridInfo.colModel = [ {
			label : "번호",
			name : "no",
			hidden : true,
			editable : true,
			editoptions: { defaultValue: '0'}
		}, {
			label : "사업장명",
			name : "bizplcNm",
			editable : true
		}, {
			label : "소재지전체주소",
			name : "locplcLotnoAddr",
			editable : true
		}, {
			label : "도로명전체주소",
			name : "locplcRoadnmAddr",
			editable : true
		}, {
			label : "위도",
			name : "lat",
			editable : true
		}, {
			label : "경도",
			name : "lng",
			editable : true
		}, {
			label : "전화번호",
			name : "telno",
			editable : true
		}, {
			label : "공휴일 휴진 안내",
			name : "noTrmtHoli",
			editable : true
		}, {
			label : "일요일 휴진 안내",
			name : "noTrmtSun",
			editable : true
		}, {
			label : "기타 안내사항",
			name : "parkEtc",
			editable : true
		}, {
			label : "월요일 영업시작시간",
			name : "trmtMonStart",
			editable : true
		}, {
			label : "월요일 영업종료시간",
			name : "trmtMonEnd",
			editable : true
		}, {
			label : "토요일 영업시작시간",
			name : "trmtSatStart",
			editable : true
		}, {
			label : "토요일 영업종료시간",
			name : "trmtSatEnd",
			editable : true
		} ];
		jqgridInfo.editurl = ctx+"/pet/gangwon/pharmacy/update";
		jqgridInfo.caption = "약국 리스트";
	} else if (type == 'pension') {
		jqgridInfo.url = ctx+'/pet/gangwon/animalPension?listType=jqgrid';
		jqgridInfo.colModel = [ {
			label : "번호",
			name : "no",
			hidden : true,
			editable : true,
			editoptions: { defaultValue: '0'}
		}, {
			label : "사업장명",
			name : "bizplcNm",
			editable : true
		}, {
			label : "소재지전체주소",
			name : "locplcLotnoAddr",
			editable : true
		}, {
			label : "도로명전체주소",
			name : "locplcRoadnmAddr",
			editable : true
		}, {
			label : "위도",
			name : "lat",
			editable : true
		}, {
			label : "경도",
			name : "lng",
			editable : true
		}, {
			label : "전화번호",
			name : "telno",
			editable : true
		}, {
			label : "입실시간",
			name : "checkIn",
			editable : true
		}, {
			label : "퇴실시간",
			name : "checkOut",
			editable : true
		}, {
			label : "기타 안내사항",
			name : "etcInfo",
			editable : true
		}, {
			name : "distance",
			editable : true,
			hidden : true,
			editoptions: { defaultValue: '0.0'}
		} ];
		jqgridInfo.editurl = ctx+"/pet/gangwon/pension/update";
		jqgridInfo.caption = "펜션 리스트";
	}else if (type == 'beach') {
		jqgridInfo.url = ctx+'/pet/gangwon/animalClinic?listType=jqgrid';
		jqgridInfo.colModel = [ {
			label : "번호",
			name : "no",
			hidden : true,
			editable : true,
			editoptions: { defaultValue: '0'}
		}, {
			label : "사업장명",
			name : "bizplcNm",
			editable : true
		}, {
			label : "소재지전체주소",
			name : "locplcLotnoAddr",
			editable : true
		}, {
			label : "도로명전체주소",
			name : "locplcRoadnmAddr",
			editable : true
		}, {
			label : "위도",
			name : "lat",
			editable : true
		}, {
			label : "경도",
			name : "lng",
			editable : true
		}, {
			label : "전화번호",
			name : "telno",
			editable : true
		}, {
			label : "공휴일 휴진 안내",
			name : "noTrmtHoli",
			editable : true
		}, {
			label : "일요일 휴진 안내",
			name : "noTrmtSun",
			editable : true
		}, {
			label : "기타 안내사항",
			name : "parkEtc",
			editable : true
		}, {
			label : "월요일 영업시작시간",
			name : "trmtMonStart",
			editable : true
		}, {
			label : "월요일 영업종료시간",
			name : "trmtMonEnd",
			editable : true
		}, {
			label : "토요일 영업시작시간",
			name : "trmtSatStart",
			editable : true
		}, {
			label : "토요일 영업종료시간",
			name : "trmtSatEnd",
			editable : true
		} ];
		jqgridInfo.editurl = ctx+"/pet/gangwon/clinic/update";
		jqgridInfo.caption = "병원 리스트";
	}
}