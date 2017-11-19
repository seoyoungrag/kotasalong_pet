(function(){
// map marker;
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.Map = window.Map ? window.Map : {};
window.Map.Marker = window.Map.Marker ? window.Map.Marker : {};

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.Map.Marker.LAYER = null;
window.Map.Marker.STYLE = null;


window.Map.Marker.PoiHospList = null;
window.Map.Marker.PoiClinicList = null;
window.Map.Marker.PoiPensionList = null;
window.Map.Marker.PoiNm = 0;
//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * 이벤트 설정
 */
window.Map.Marker.addEvent = function()
{
	window.console.log( " window.Map.Marker.addEvent STA ********** " );
	var marker = window.Map.Marker;
		marker.addEvent_evt_mClick_Map();
		//마우스오버 툴팁 
		marker.addEvent_mOver_tooltip();
	window.console.log( " window.Map.Marker.addEvent END ********** " );
};

/**
 * 이벤트 해제
 */
window.Map.Marker.removeEvent = function()
{
	window.console.log( " window.Map.Marker.removeEvent STA ********** " );
	var marker = window.Map.Marker;
		marker.removeEvent_evt_mClick_Map();
		marker.removeEvent_mOver_tooltip();
	window.console.log( " window.Map.Marker.removeEvent END ********** " );
};


/**
 * 이벤트 설정 - 지도 클릭
 */
window.Map.Marker.addEvent_evt_mClick_Map = function()
{
	window.console.log( " window.Map.Marker.addEvent_evt_mClick_Map STA ********** " );
	var marker = window.Map.Marker;
	window.mapObj.on("click",marker.evt_mClick_Map);
	window.console.log( " window.Map.Marker.addEvent_evt_mClick_Map END ********** " );
};

/**
 * 이벤트 해제 - 지도 클릭
 */
window.Map.Marker.removeEvent_evt_mClick_Map = function()
{
	window.console.log( " window.Map.Marker.removeEvent_evt_mClick_Map STA ********** " );
	var marker = window.Map.Marker;
	window.mapObj.un("click",marker.evt_mClick_Map);
	window.console.log( " window.Map.Marker.removeEvent_evt_mClick_Map END ********** " );
};

/**
 * 이벤트 설정 - 마커 mouse over 
 */
window.Map.Marker.addEvent_mOver_tooltip = function()
{
	window.console.log( " window.Map.Marker.addEvent_mOver_tooltip STA ********** " );
	var marker = window.Map.Marker;
	window.mapObj.on("pointermove",marker.evt_mOver_tooltip);
	window.console.log( " window.Map.Marker.addEvent_mOver_tooltip END ********** " );
};

/**
 * 이벤트 해제 - 마커 mouse over 
 */
window.Map.Marker.removeEvent_mOver_tooltip = function()
{
	window.console.log( " window.Map.Marker.removeEvent_mOver_tooltip STA ********** " );
	var marker = window.Map.Marker;
	window.mapObj.un("pointermove",marker.evt_mOver_tooltip);
	window.console.log( " window.Map.Marker.removeEvent_mOver_tooltip END ********** " );
};


/**
 * 마커 mouseover 시 이벤트 
 * 툴팁을 고치기 위해선  featureData.안에 담아 커스터마이징 해야함
 * @param {ol.feature} feature
 * @param {ol.layer.Base} layer
 */
window.Map.Marker.evt_mOver_tooltip = function(e)
{
	window.console.log( " window.Map.Marker.evt_mOver_tooltip STA ********** " );
	
	var marker = window.Map.Marker;
	var map = e.target;
	var feature = map.forEachFeatureAtPixel( e.pixel, marker.evt_mOver_Map_EachFeatureAtPixel );
	
		var elementId = "tooltip_featureInfo";
		var elementClass = "tool_tip";
		if(feature){
			var left = ( e.originalEvent.clientX + 7 );
			var top = ( e.originalEvent.clientY + 10 );
			var margin = 0; // 마진값 대충 산정;
			var featureData = feature.getProperties( "data" ).data;
			if( $("#"+elementId).length > 0 )
			{
				$("#"+elementId ).html( "<span>"+featureData.nick+"</span>" );
			}
			else
			{
				var htmlText = "";
					htmlText += "<div id=\"" + elementId + "\" class=\""+elementClass+"\">";
					htmlText += 	"<span>"+featureData.nick+"</span>";
					htmlText += "</div>";
				$( "body" ).append( htmlText );
			}

			var windowXY = window.ESR23Common.getAbsoluteXY( $( "body" )[0] );
			var objXY = window.ESR23Common.getAbsoluteXY( $("#"+elementId)[0] );
			if( objXY.x + objXY.cx > windowXY.cx - margin )
			{
				left = windowXY.cx - objXY.cx - margin;
			}
			if( objXY.y + objXY.cy > windowXY.cy - margin )
			{
				top = windowXY.cy - objXY.cy - margin;
			}
			$("#"+elementId ).css( "left", left + "px" );
			$("#"+elementId ).css( "top", top + "px" );
			$("#"+elementId ).css( "position", "absolute" );
			$("#"+elementId ).css( "z-index", "100" );
			$("#"+elementId + " .tipTBL" ).attr( "featureId", feature.getId() );
			$("#"+elementId ).show();
		}
		else
		{
			$("#"+elementId).hide();
		}
		
		window.console.log( " window.Map.Marker.evt_mOver_tooltip END ********** " );
}

/**
 * 마커 mouseover 시
 * @param {ol.feature} feature
 * @param {ol.layer.Base} layer
 */
window.Map.Marker.evt_mOver_Map_EachFeatureAtPixel = function( feature, layer )
{
	window.console.log( " window.Map.Marker.evt_mClick_Map_EachFeatureAtPixel STA **********  " );
	var featureName = feature.getProperties()[ "name" ];
	var featureData = feature.getProperties()[ "data" ];
	
	if( featureData ) return feature;
	
			
	window.console.log( " window.Map.Marker.evt_mClick_Map_EachFeatureAtPixel END ********** " );
};



/**
 * 지도 클릭 시
 * @param {Object} e
 */
window.Map.Marker.evt_mClick_Map = function(e)
{
	window.console.log( " window.Map.Marker.evt_mClick_Map STA ********** " );
	var marker = window.Map.Marker;
	var map = window.mapObj;
		map.forEachFeatureAtPixel( e.pixel, marker.evt_mClick_Map_EachFeatureAtPixel );
	window.console.log( " window.Map.Marker.evt_mClick_Map END ********** " );
	
};



/**
 * 지도 클릭 시 ( 마커 클릭의 경우 )
 * @param {ol.feature} feature
 * @param {ol.layer.Base} layer
 */
window.Map.Marker.evt_mClick_Map_EachFeatureAtPixel = function( feature, layer )
{
	window.console.log( " window.Map.Marker.evt_mClick_Map_EachFeatureAtPixel STA **********  " );
	var featureName = feature.getProperties()[ "name" ];
	var featureData = feature.getProperties()[ "data" ];
	
	//여기서 커스터마이징 가능;
//	alert(featureName+" : "+JSON.stringify(featureData));

	//{"no":14,"sigunCd":"","sigunNm":"","bizplcNm":"도미약국","locplcLotnoAddr":"","locplcRoadnmAddr":"강원도 철원군 서면 와수1로 34, 1층","licensgDe":"20140630","bsnStateNm":"운영중","clsbizDe":"","suspnbizBeginDe":"","suspnbizEndDe":"","reopenbizDe":"","locplcAr":"66.0","locplcZipCd":"","totEmplyCnt":"0.0","sfrmprodProcsbizDivNm":"","stockrsDutyDivNm":"동물약국","wsg84Logt":"0.0","wsg84Lat":"0.0","xCrdnt":"0.0","yCrdnt":"0.0","dataColctDe":"20151205","etlLdadngDtm":"","lat":"38.240008823889646","lng":"127.43752268070988","insertDt":1505885309000,"updateDt":1505885309000,"pharmInfo":{"no":14,"addr":"강원도 철원군 서면 와수1로 34 (제일 의원)","hospUrl":null,"telno":"033-458-2326","yadmNm":"도미약국","ykiho":"JDQ4MTYyMiM1MSMkMSMkNCMkMDMkMzgxOTYxIzIxIyQyIyQ1IyQwMCQyNjE4MzIjNTEjJDEjJDYjJDgz","insertDt":1505885309000,"updateDt":1505885309000},"pharmDetail":null,"ktInfo":null}
	
	window.Map.Marker.pointMove(featureData.lng,featureData.lat , 13);
	if((typeof featureData.no==="undefined") || (typeof Ayapet==="undefined")){
	}else{
		Ayapet.listSelected(featureData.no)
	}
	
	
	window.console.log( " window.Map.Marker.evt_mClick_Map_EachFeatureAtPixel END ********** " );
};

/**
 * 지도 클릭 시 ( 마커 좌표 이동 )
 * @param lat, lng
 */
window.Map.Marker.pointMove = function( lat, lng , zoom )
{
	window.console.log( " window.Map.Marker.pointMove STA **********  " );
//	debugger;
	window.mapObj.getView().setCenter([lat , lng]);
	window.mapObj.getView().setZoom( zoom);
	
	window.console.log( " window.Map.Marker.pointMove END ********** " );
};


/**
 * 지도 클릭 시 (리스트 데이터)
 * @param lat, lng
 */
window.Map.Marker.listSelected = function( data )
{
	window.console.log( " window.Map.Marker.listSelected STA **********  " );
	if((typeof data.no==="undefined") || (typeof Ayapet==="undefined")){
		
	}else{
		Ayapet.listSelected(featureData.no)
	}
	
	window.console.log( " window.Map.Marker.listSelected END ********** " );
};

//----------------------------------------------------------------------------------------------------;
//FUNCTION;
//----------------------------------------------------------------------------------------------------;

/**
 * 마커 레이어 추가
 * @function
 */
window.Map.Marker.addLayer = function( map, visible )
{
	window.console.log( "---------- window.Map.Marker.addLayer():void" );
	if( !window.Map.Marker.LAYER )
	{
		var srsCode = window.mapObj.getView().getProjection().getCode(); // EPSG:3857;
		window.Map.Marker.LAYER = new ol.layer.Vector({
			map : window.mapObj
			, source : new ol.source.Vector({ features : [] })
		});
		window.Map.Marker.LAYER.setVisible( visible );
	}
};

/**
 * 마커 추가
 * @function
 * @param {Array} p
 * @param {String} id
 * @param {Number} cnt
 * <sample>
 * window.Map.Marker.add( [ 127.5, 37 ], 'marker_1',{id:'data',nick:'nickdata'})
 * </sample>
 */
window.Map.Marker.add = function( point, style, data )
{
	window.console.log( "---------- window.Map.Marker.addMarker():void" );
	var o = window.Map.Marker;
	var g = new ol.geom.Point( point );
	var feature = new ol.Feature({ geometry : g , name : "POI", data : data });
		feature.setStyle( o.STYLE[ "marker_1" ] );		
		
	o.LAYER.getSource().addFeature( feature );
};
/**
 * 마커 추가 1개
 * @function
 * @param {Array} p
 * @param {String} id
 * @param {Number} cnt
 * <sample>
 * window.Map.Marker.add( [ 127.5, 37 ], 'marker_1',{id:'data',nick:'nickdata'})
 * </sample>
 */
window.Map.Marker.addSingle = function( point, style, data,i )
{
	window.console.log( "---------- window.Map.Marker.addMarker():void" );
	var o = window.Map.Marker;
	var g = new ol.geom.Point( point );
	var feature = new ol.Feature({ geometry : g , name : "POI"+i, data : data });
	feature.setStyle( o.STYLE[ "marker_1" ] );		
	
	o.LAYER.getSource().addFeature( feature );
};
/**
 * 마커 추가 멀티 
 * @function
 * @param {int} int
 * @param {String} id
 * @param {Array} data
 * <sample>
 * window.Map.Marker.addMulti( 2000, 'marker_1',{id:'data',nick:'nickdata'})
 * </sample>
 */
window.Map.Marker.addMulti = function( int, style, data )
{
	window.console.log( "---------- window.Map.Marker.addMulti():void" );
	var o = window.Map.Marker;
	
	var pointArray = window.ESR23Common.randomPoiCoord(int ,[125,34],[129,40]);
	
	var iLen=pointArray.length;
	
	var g =null;
	var feature =null;
	
	for(var i=0; i<iLen; i++){
		 g = new ol.geom.Point(pointArray[i]);
		 feature = new ol.Feature({ geometry : g , name : "POI", data : {id:'data',nick:'nickdata'+i} });
		 feature.setStyle( o.STYLE[ "marker_1" ] );			
		 o.LAYER.getSource().addFeature( feature );

	}
};





/**
 * 마커 레이어 클리어
 * @function
 */
window.Map.Marker.clear = function()
{
	window.console.log( "---------- window.Map.Marker.clear():void" );
	if( window.Map.Marker.LAYER )
	{
		var layer = window.Map.Marker.LAYER;
		var s = layer.getSource();
			s.clear();
	}
};

/**
 * 초기화
 * @function
 */
window.Map.Marker.initialize = function()
{
	window.console.log( "---------- window.Map.Marker.initialize():void" );
	var o = window.Map.Marker;
		o.setData();
		o.addLayer( window.mapObj, true );
};

//----------------------------------------------------------------------------------------------------;
//GETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//SETTER;
//----------------------------------------------------------------------------------------------------;

/**
 * 정보설정
 * @function
 */
window.Map.Marker.setData = function()
{
	window.console.log( "---------- window.Map.Marker.setData():void" );
	var o = window.Map.Marker;
	if( !o.STYLE )
	{
		o.STYLE = {};
		var p = {};
			p.rotation = 0;
			p.anchor = [ 0.5, 1.0 ];
			p.opacity = 1.0;
			p.anchorXUnits = "fraction";
            p.anchorYUnits = "fraction";
			p.src = contextPath + "/ref/images/poi/poi-01.png";
			//add
			//p.size = [10, 10];
		    //add
		    p.scale = 0.5
		    
			o.STYLE[ "marker_1"] = new ol.style.Style({ image : new ol.style.Icon( p )});
	}
};

/**
 * id를 가지고 해당 마커를 최상단으로 이동
 * @function
 * @param {String} id
 */
window.Map.Marker.setIndex_Top_ByID = function( id )
{
	var o = window.Map.Marker;
	var feature = o.getFeature( id );
	var source = o.LAYER.getSource();
		source.addFeature( feature.clone() ); // 복사본 넣고;
		source.removeFeature( feature ); // 원본 지우기;
};

/**
 * 약국 마커 로딩
 * @function
 */
window.Map.Marker.initPharmacyData = function()
{
	window.console.log( "---------- window.Map.Marker.initData():void" );

//	url = "http://truezure.cafe24.com/pet/gangwon/animalPharmacy";
	var ctx = window.contextPath;
	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
		//if(ctx=='/pet'){
		ctx+='/pet';
	}
	url= ctx + "/gangwon/animalPharmacy";

	$.ajax({
		type: "GET",
		url: url,
		data:{},
		dataType: 'json',
		error: function(){
			alert('실패');
		},
		success: function(data){
			var m = window.Map.Marker;
			m.PoiHospList = data.data;
			var d = m.PoiHospList;
			var point = [];
			var poiData = null;
			for (var i = 0 ; i<d.length; i++){
//				console.log(d[m.PoiNm]);
				poiData = d[i];
				point = [d[i].lng,d[i].lat];
//				window.Map.Marker.addSingle( point, 'marker_1',JSON.stringify(poiData),i);
				window.Map.Marker.addSingle( point, 'marker_1',poiData,m.PoiNm);
				m.PoiNm++;
			}
			
		}
	});
	
	
};

/**
 * 해수욕장 마커 로딩
 * @function
 */
window.Map.Marker.initBeachData = function()
{
	window.console.log( "---------- window.Map.Marker.initBeachData():void" );
	var ctx = window.contextPath;
	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
	//if(ctx=='/pet'){
		ctx+='/kotasalong';
	}
	url= ctx + "/beach";
	$.ajax({
		type: "GET",
		url: url,
		data:{},
		dataType: 'json',
		error: function(){
			alert('실패');
		},
		success: function(data){
			var m = window.Map.Marker;
			m.PoiBeachList = data.data;
			var d = m.PoiBeachList;
			var point = [];
			var poiData = null;
			for (var i = 0; i<d.length; i++){
				d[i].lng = d[i].mapx;
				d[i].lat = d[i].mapy;
				poiData = d[i];
				point = [d[i].lng,d[i].lat];
				window.Map.Marker.addSingle( point, 'marker_1',poiData, m.PoiNm);
				m.PoiNm++;
			}
			
		}
	});
};
/**
 * 병원 마커 로딩
 * @function
 */
window.Map.Marker.initClinicData = function()
{
	window.console.log( "---------- window.Map.Marker.initClinicData():void" );
	var ctx = window.contextPath;
	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
		//if(ctx=='/pet'){
		ctx+='/pet';
	}
	url= ctx + "/gangwon/animalClinic";
	$.ajax({
		type: "GET",
		url: url,
		data:{},
		dataType: 'json',
		error: function(){
			alert('실패');
		},
		success: function(data){
			var m = window.Map.Marker;
			m.PoiClinicList = data.data;
			var d = m.PoiClinicList;
			var point = [];
			var poiData = null;
			for (var i = 0; i<d.length; i++){
				console.log(d[i]);
				poiData = d[i];
				point = [d[i].lng,d[i].lat];
				window.Map.Marker.addSingle( point, 'marker_1',poiData, m.PoiNm);
				m.PoiNm++;
			}
			
		}
	});
};

/**
 * 펜션 마커 로딩
 * @function
 */
window.Map.Marker.initPensionData = function()
{
	window.console.log( "---------- window.Map.Marker.initClinicData():void" );
	var ctx = window.contextPath;
	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
		//if(ctx=='/pet'){
		ctx+='/pet';
	}
	url= ctx + "/gangwon/animalPension";
	$.ajax({
		type: "GET",
		url: url,
		data:{},
		dataType: 'json',
		error: function(){
			alert('실패');
		},
		success: function(data){
			var m = window.Map.Marker;
			m.PoiPensionList = data.data;
			var d = m.PoiPensionList;
			var point = [];
			var poiData = null;
			for (var i = 0; i<d.length; i++){
				console.log(d[i]);
				poiData = d[i];
				point = [d[i].lng,d[i].lat];
				window.Map.Marker.addSingle( point, 'marker_1',poiData, m.PoiNm);
				m.PoiNm++;
			}
			
		}
	});
};


//----------------------------------------------------------------------------------------------------;

})();