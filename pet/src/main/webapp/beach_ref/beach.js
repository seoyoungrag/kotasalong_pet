$.extend($.jgrid.defaults,{
	emptyrecords: "Nothing to display",
	responsive : true,
	styleUI : 'Bootstrap',
	recordtext: "{0} - {1} / {2}",
    emptyrecords: "No records to view",
    loadtext: "Loading...",
    pgtext : ""
	});
function jqgridInfo() {
	this.url;
	this.colNames;
	this.colModel;
	this.editurl;
}

function setJqgridInfoByType() {
	jqgridInfo.url = ctx + '/kotasalong/beach?listType=jqgrid';
	jqgridInfo.colModel = [ {
		label : "번호",
		name : "no",
		key: true,
		hidden : true,
		editable : true,
		editoptions : {
			defaultValue : '0'
		}
	}, {
		label : "해수욕장",
		name : "title",
		hidden : false
	}, {
		label : "longtitude",
		name : "mapx",
		hidden : true
	}, {
		label : "latitude",
		name : "mapy",
		hidden : true
	}, {
		label : "주소",
		name : "addr1",
		hidden : false
	}, {
		label : "지역2",
		name : "addr2",
		hidden : true
	}, {
		label : "firstimage",
		name : "firstimage",
		hidden : true
	}, {
		label : "firstimage2",
		name : "firstimage2",
		hidden : true
	}, {
		label : "readcount",
		name : "readcount",
		hidden : true
	}, {
		label : "sigungucode",
		name : "sigungucode",
		hidden : true
	}, {
		label : "zipcode",
		name : "zipcode",
		hidden : true
	}];
	/*jqgridInfo.caption = "해수욕장 리스트";*/
}