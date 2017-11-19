//----------------------------------------------------------------------------------------------------;
//----------------------------------------------------------------------------------------------------;
// PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.MAP_OBJ = null;
// MIDB U3 DEV;
// 주소 변경시 url 밑으로만 변경 해주면됨;
window.URL_GISSERVER = window.contextPath + "/pxy.jsp?url="+"http://192.168.0.65:8080/MapXGeoSpatial/U3/wms";

window.MAP_CENTER = [ 127.5, 37 ];
window.MAP_EXTENT = [ -184.0, -85.582764, 180.0, 90.0 ];
// ZOOM에 따른 resolution 배열  init zoom resolution value= 0.010986328125;
window.MAP_RESOLUTIONS = [ 0.17578125 , 0.087890625, 0.0439453125 , 0.02197265625 , 0.010986328125 , 0.0054931640625 , 0.00274658203125 , 0.001373291015625 , 0.0006866455078125 , 0.00034332275390625 ];
window.MAP_MINZOOM = 0;
window.MAP_MAXZOOM = 21;
window.MAP_DEFUALT_ZOOM = 7;
window.MAP_ZOOM = 7;
window.MAP_DEFUALT_ZOOM2 = 13;


window.LAYER_VECTOR = null;
window.LAYER_SATELLITE= null;

window.TILE_GRID1 = null;
window.TILE_GRID10= null;


//----------------------------------------------------------------------------------------------------;
// EVENT ;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
// FUNCTION ;
//----------------------------------------------------------------------------------------------------;

/**
 * 지도 센터좌표 및 줌레벨 초기화
 * @function
 * @param {Object} map
 * <code>
 * {
 * 		"map" : {ol.Map}
 * 		, "layers" : {Object}
 * }
 * </code>
 */
window.initSetCenterZoom = function( map )
{
	window.console.log( "---------- window.initSetCenterZoom():void" );
	var view = map.getView();
		view.setCenter( window.MAP_CENTER );
		view.setZoom( window.MAP_ZOOM );

};

//----------------------------------------------------------------------------------------------------;
// GETTER ;
//----------------------------------------------------------------------------------------------------;

/**
 * 지도 방위 추가 및 소수점 자리 변경
 * @function
 * @param {Object} coord1
 */
window.coordConvert = function(coord1)
{
	coord1[0] = coord1[0].toFixed(7);
	coord1[1] = coord1[1].toFixed(7);
	if(coord1[0]>=0){
		coord1[0]=coord1[0]+" E";
	}else{
		coord1[0]=Math.abs(coord1[0])+" W";
	}

	if(coord1[1]>=0){
		coord1[1]=coord1[1]+" N";
	}else{
		coord1[1]=Math.abs(coord1[1])+" S";
	}
	return coord1
}
//----------------------------------------------------------------------------------------------------;
// SETTER ;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;

/**
 * initalize
 */
window.initializeLibraries = function()
{
	window.console.log( "---------- window.initializeLibraries():void" );
	
	//화면 창 변환함수
	var size = {
		  width: window.innerWidth || document.body.clientWidth,
		  height: window.innerHeight || document.body.clientHeight 
	}
	
	$("#map").css(size);
	
	
	//좌표 값 구하는 함수;
	var coordFormat = function(dgts)
	{
	  return (
	    function(coord1) {

            var latLong = LatLon( coord1[1],coord1[0]);
            var utmCoord = latLong.toUtm();
	    	var wdw = utmCoord.toMgrs().toString();

	    	window.coordConvert(coord1);
	        var wgs84_x = coord1[0];
	        var wgs84_y = coord1[1];

	       return ', Geodetic : ' + wgs84_x + ', ' + wgs84_y + ',  MGRS : ' +latLong.toUtm().toString()+', UTM : '+utmCoord.toMgrs().toString();
	  });
	}



	//마우스 이동시 좌표 값을 구함 ;
	window.mousePositionControl = new ol.control.MousePosition({
		coordinateFormat:coordFormat(7),
	    projection: 'EPSG:4326',
	    className: 'custom-mouse-position',
	    target: document.getElementById('coordVal'),
	    undefinedHTML : ''
	  });
	var scaleLineControl = new ol.control.ScaleLine({
	target:"scale-line"
	});

	//measure 시 거리나 면적을 Projection >Projection 통해 구할때 이용;
	window.Proj = new ol.proj.Projection({
		code:'EPSG:4326'
	});
	window.Projw = new ol.proj.Projection({
		code:'EPSG:3857' // EPSG:900913;
	});

	
	//지도 Layer 추가;
	var layers =
	    [
    	new ol.layer.Tile({
            source: new ol.source.OSM()
          })
    	];

	//맵객체 생성;
	window.mapObj = new ol.Map({
		//interaction : 이벤트 클릭들;
		interactions: ol.interaction.defaults({
//			altShiftDragRotate : false,
			doubleClickZoom : false,
//			mouseWheelZoom:false,
//			keyboard:false,
//			shiftDragZoom:false,
//			dragPan : false,
//			pinchRotate:false
			}),
        layers: layers,
        //controls : 인터페이스들
        controls: ol.control.defaults({
            attributionOptions: /** @type {olx.control.AttributionOptions} */ ({
            	collapsible: false
            }),
            zoom: false
        }).extend([window.mousePositionControl]).extend([scaleLineControl]),
        target: "map",
        view: new ol.View({
          center: window.MAP_CENTER,
          projection: 'EPSG:4326',
          zoom: window.MAP_ZOOM
        }),
        loadTilesWhileInteracting : true,
        loadTilesWhileAnimating : true
      });

	//전역변수로 COP 지도 저장;
	window.LAYER_VECTOR = window.mapObj.getLayers().getArray()[0];

	// Drag Zoom In
	window.customDragZoomIn = new ol.interaction.DragBox({
		condition : ol.events.condition.always
		, style : new ol.style.Style({stroke: new ol.style.Stroke({color: [0, 0, 255, 1]})})
	});

    // Drag Zoom In 박스가 그린 후 function ;
    customDragZoomIn.on( "boxend", function() {
        var map = this.getMap();
        var view = map.getView();
        var extent = this.getGeometry().getExtent();
        var center = ol.extent.getCenter(extent);
        var size = map.getSize();
        //이동시 애니메이션;
        /*/
        map.beforeRender(new ol.animation.zoom({
            resolution : map.getView().getResolution(),
            duration : 300
        }))
        //*/
        map.getView().fit( extent , map.getSize() );
    });


    // Drag Zoom Out ;
    window.customDragZoomOut = new ol.interaction.DragBox({
		condition : ol.events.condition.always
		, style : new ol.style.Style({stroke: new ol.style.Stroke({color: [0, 0, 255, 1]})})
	});

    // Drag Zoom Out 박스가 그린 후 function ;
    customDragZoomOut.on( "boxend", function(e) {
    	var map = this.getMap();
        var view = map.getView();
        var extent = this.getGeometry().getExtent();
        var center = ol.extent.getCenter( extent );
        var size = map.getSize();

        var pixSize = e.pixel;
        var pixWidth = center[0];
        var pixHeight = center[1];
        var zoomFactor = Math.min( (map.getSize()[1] / pixHeight), (map.getSize()[0] / pixWidth) );
        var mapExtents = map.getView().calculateExtent( map.getSize() );
        var center = ol.extent.getCenter( extent );

        var xmin = center[0] - (ol.extent.getWidth( mapExtents )/16) * zoomFactor;
        var xmax = center[0] + (ol.extent.getWidth( mapExtents )/16) * zoomFactor;
        var ymin = center[1] - (ol.extent.getHeight( mapExtents )/16) * zoomFactor;
        var ymax = center[1] + (ol.extent.getHeight( mapExtents )/16) * zoomFactor;

        var toExtent = [xmin, ymin, xmax, ymax];
        //이동시 애니메이션;
        /*/
        map.beforeRender(new ol.animation.zoom({
            resolution : map.getView().getResolution(),
            duration : 300
        }))
        //*/

        map.getView().fit( toExtent , map.getSize() );
    });


    //dragRotate;

//    window.customDragRotate = new ol.interaction.DragRotate ({
//		condition : ol.events.condition.always
//	});

   //dragPan;
//    window.customDragPan = new ol.interaction.DragPan ({
//		condition : ol.events.condition.always
//	});

	//기능 init;
	window.UI.MapChange.addEvent();
	window.UI.Map.Save.initialize();
//	window.UI.Map.TopMenu.initialize();
	window.Map.Marker.initialize();
	window.MapTool.Measure.initialize();

	window.MapTool.PolygonCoord.initialize(
//	{"style" : { fill : "rgba( 204, 102, 153, 0.3 )", line : "rgba( 204, 102, 153, 1.0 )", width : 2 }}
	);


	//interaction add  회전 이동 주석처리;
//  window.mapObj.addInteraction( customDragRotate );
//  window.mapObj.addInteraction( customDragPan );
    window.mapObj.addInteraction( customDragZoomIn );
    window.mapObj.addInteraction( customDragZoomOut );

    // interaction active 회전 이동 주석처리;
//    customDragRotate.setActive( false );
//  customDragPan.setActive( false );
    customDragZoomOut.setActive( false );
    customDragZoomIn.setActive( false );

    //우측 줌바 활성화 ;
    var zoombar = window.ol3_15_1.MapTool.Zoombar.Custom({
		map : window.mapObj
		, minZoom : window.MAP_MINZOOM
		, maxZoom : window.MAP_MAXZOOM
		, ui : {
			zoomin : "zoomin"
			, zoomout : "zoomout"
			, bodycontroller : "bodycontroller"
			, controller : "btncontroller"
		}
	});

    //브라우저창 resize시 중심선 이동 function;
    window.addEventListener('resize', function(event){
    	//중심선 유무;
        if($(".width_line").length>0){
        	//중심선을 구하기 위한 계산 식 ;
        	var centerLen= $("body").outerHeight()-$(".coordinate").outerHeight()-$(".top_map").outerHeight();
        	$(".width_line").css("top",centerLen/2);
        }
      });


    //스케일 측정 function 확대 축소할시에 변경;
    window.mapObj.getView().on('change:resolution', function(evt) {
        window.getMapScale_changeResolution();
      });
    //스케일 측정 function
    window.getMapScale_changeResolution();

    window.bLoadCompleted = true;
    
    
    //poi data 가져오기 
//    window.Map.Marker.initPharmacyData();
//    window.Map.Marker.initClinicData();
//  window.Map.Marker.initPensionData();
    //poi 클릭 addEvent
    window.Map.Marker.addEvent();
    window.UI.Map.TopMenu.addEvent();
};



/**
 * 축척으로부터 맵 레졸루션 설정
 * @param {ol.Map} map
 * @param {Number} scale
 * <sample>
 * window.setMapResolution_fromMapScale(window.mapObj,5000000)
 * </sample>
 */
window.setMapResolution_fromMapScale = function( map, scale )
{
	var resolution = null;
	var units = map.getView().getProjection().getUnits();
	var mpu = ol.proj.METERS_PER_UNIT[units];
	var dpi = 25.4 / 0.28;
	resolution = ( ( scale / mpu ) / 39.37 ) / dpi;
	if( resolution != NaN ) map.getView().setResolution( resolution );
};

/**
 * 맵 레졸루션으로부터 축척 반환
 * @param {evt} event
 * <sample>
 * </sample>
 */
window.getMapScale_fromMapResolution = function( resolution )
{
	var scale = null;
	var units = window.mapObj.getView().getProjection().getUnits();
	var dpi = 25.4 / 0.28;
	var mpu = ol.proj.METERS_PER_UNIT[units];
	var scale = resolution * mpu * 39.37 * dpi;
	return scale;
};


/**
 * Resolution 변경 시  축척 반환
 * @param {Number} resolution
 * <sample>
 * </sample>
 */
window.getMapScale_changeResolution = function(  )
{
    var resolution = window.mapObj.getView().getResolution();
    var units = window.mapObj.getView().getProjection().getUnits();
    var dpi = 25.4 / 0.28;
    var mpu = ol.proj.METERS_PER_UNIT[units];
    var scale = resolution * mpu * 39.37 * dpi;
    $("#scaleVal").text( "Scale : " + parseInt(scale));
};
//----------------------------------------------------------------------------------------------------;

window.initializeLibraries();