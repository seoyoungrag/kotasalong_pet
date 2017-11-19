<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <script type="text/javascript" src="${pageContext.request.contextPath}/ol/OpenLayers.js"></script>
    <!-- 브이월드 지도 서비스 호출 -->
    <SCRIPT language="JavaScript" type="text/javascript" src="http://map.vworld.kr/js/apis.do?type=Base&apiKey=${apiKey}"></SCRIPT>
	<script type="text/javascript" src="${pageContext.request.contextPath}/ref/js/weather.js"></script>
       
    <script type="text/javascript">
    var map;
    // 지도의 영역을 지정
    var mapBounds = new OpenLayers.Bounds(123 , 32, 132 , 43);  

    var epsg4326 =  new OpenLayers.Projection("EPSG:4326"); //WGS 1984 projection
    
    // avoid pink tiles
    OpenLayers.IMAGE_RELOAD_ATTEMPTS = 3;
    OpenLayers.Util.onImageLoadErrorColor = "transparent";

    var polygonStyle = new OpenLayers.Style({
        fillColor: "#ffcc66",
        strokeColor: "#ff9933",
        strokeWidth: 2,
        label: "\${label}",
        fontColor: "#333333",
        fontFamily: "sans-serif",
        fontWeight: "bold"
    }, {
        rules: [
            new OpenLayers.Rule({
                maxScaleDenominator: 1000000,
                symbolizer: {
                    pointRadius: 0,
                    fontSize: "0px"
                }
            }),
            new OpenLayers.Rule({
                maxScaleDenominator: 500000,
                symbolizer: {
                    pointRadius: 0,
                    fontSize: "10px"
                }
            }),
            new OpenLayers.Rule({
                maxScaleDenominator: 300000,
                symbolizer: {
                    pointRadius: 0,
                    fontSize: "14px"
                }
            })
        ]
    });/* 
    var polygonStyle = 
    OpenLayers.Util.extend({}, OpenLayers.Feature.Vector.style['default']);
    polygonStyle.label = "\${label}";
    polygonStyle.labelOutlineColor = "white";
    polygonStyle.labelOutlineWidth = 1;
    polygonStyle.rules = [
            new OpenLayers.Rule({
                minScaleDenominator: 200000000,
                symbolizer: {
                    pointRadius: 7,
                    fontSize: "0px"
                }
            }),
            new OpenLayers.Rule({
                maxScaleDenominator: 200000000,
                minScaleDenominator: 100000000,
                symbolizer: {
                    pointRadius: 10,
                    fontSize: "0px"
                }
            }),
            new OpenLayers.Rule({
                maxScaleDenominator: 100000000,
                symbolizer: {
                    pointRadius: 13,
                    fontSize: "0px"
                }
            })
        ];
 */

    var smap = new OpenLayers.StyleMap({"default": polygonStyle});
    
    function init(){
		mHeight = $("#collapseDiv").height();
    	var size = {
    			  width: window.innerWidth || document.body.clientWidth,
    			  height: window.innerHeight-50-mHeight || document.body.clientHeight-50-mHeight 
    		};
    		
   		$("#map").css(size);
   		
        var options = {
            projection: new OpenLayers.Projection("EPSG:900913"),
            displayProjection: epsg4326,
            controls : [],
            // 사용자 이벤트 등록 
            eventListeners: {
                featureover: function(e) {  // feature에 마우스오버시
                    e.feature.renderIntent = "select";
                    e.feature.layer.drawFeature(e.feature);
                    //console.log("featureover");
                },
                featureout: function(e) {   // feature에 마우스아웃시
                    e.feature.renderIntent = "default";
                    e.feature.layer.drawFeature(e.feature);
                    //console.log("featureout");
                },
                featureclick: function(e) { // feature에 마우스클릭시
                    //console.log("featureclick e.feature.id = " + e.feature.id);
                }
            }
            };
        map = new OpenLayers.Map('map', options);       // html의 'map'div 태그에 지도를 그려주도록 세팅
        
        // 배경지도 추가하기
        vBase = new vworld.Layers.Base('VBASE');
        if (vBase != null){map.addLayer(vBase);}
         
        // 지정된 바운드로 줌
        map.zoomToExtent( mapBounds.transform(map.displayProjection, map.projection ) );
        // 지도 센터 설정
        //map.setCenter(127.84058, 34.99650);
        var center = new OpenLayers.LonLat(127.78072, 36.74133);
        center.transform(epsg4326, map.getProjectionObject());
        map.setCenter(center);
        //map.setCenter(127.1141382, 35.98037);
        // 지도 초기 레벨 설정
        map.zoomTo(7);
          
        // 지도컨트롤등록
        map.addControl(new OpenLayers.Control.MousePosition());
        map.addControl(new OpenLayers.Control.Navigation());
    }

    pointMove = function( lng, lat , zoom, type )
    {
        var center = new OpenLayers.LonLat(lng, lat);
        center.transform(epsg4326, map.getProjectionObject());
        map.setCenter(center);
    	//map.zoomTo( zoom);
		
    	if(type=='mylocation'){
	        var markers = new OpenLayers.Layer.Markers( "Markers" );
	        map.addLayer(markers);
			var imgsrc = "${pageContext.request.contextPath}/ref/images/poi/poi-02.png";
	
	        var size = new OpenLayers.Size(21,25);
	        var offset = new OpenLayers.Pixel(-(size.w/2), -size.h);
	        var icon = new OpenLayers.Icon(imgsrc,size,offset);
	        markers.addMarker(new OpenLayers.Marker(center,icon));
    	}
    	
    };
    /**
     * 해수욕장 마커 로딩
     * @function
     */
    function initBeachData2()
    {
     	var ctx = window.contextPath;
     	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
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
    		    var vectorLayer = new OpenLayers.Layer.Vector("Overlay");

    			var m = {};
    			m.PoiBeachList = data.data;
    			var d = m.PoiBeachList;
    			var point = [];
    			var poiData = null;
    			var Imgfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;//128.4391216433
    				d[i].lat = d[i].mapy;//38.4788446862
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;

					var imgsrc = d[i].firstimage ? d[i].firstimage : d[i].firstimage2 ? d[i].firstimage2 : "${pageContext.request.contextPath}/ref/images/poi/poi-01.png";

    			    Imgfeatures[i] = new OpenLayers.Feature.Vector(
    			            new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()),
    			            {description: d[i].no } ,
    			            {externalGraphic: imgsrc, graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-35  }
    			        );    
    			    
    			}
    			vectorLayer.addFeatures(Imgfeatures);
			    map.addLayer(vectorLayer);
			    
    		    var textLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var Txtfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;
    				Txtfeatures[i] = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()));    
    				Txtfeatures[i].attributes = {
     		                label: d[i].title
     		            };
     			    

    			}
 			    textLayer.addFeatures(Txtfeatures);
			    map.addLayer(textLayer);
			    
			    var controls = {
			      selector: new OpenLayers.Control.SelectFeature(vectorLayer, { onSelect: createPopup, onUnselect: destroyPopup })
			    };

			    function createPopup(feature) {

			    	$("#grid").jqGrid('setSelection', feature.attributes.description);
					$("#" + $("#grid").jqGrid('getGridParam', 'selrow')).focus();			    	
			      feature.popup = new OpenLayers.Popup.FramedCloud("pop",
			          feature.geometry.getBounds().getCenterLonLat(),
			          null,
			          '<div class="markerContent" style="width:200px;height:110px;" id="markerContent_'+feature.attributes.description+'"></div>',
			          null,
			          true,
			          function() { controls['selector'].unselectAll(); }
			      );
					feature.popup.autoSize = true;
					map.addPopup(feature.popup);
				
				    $.ajax({
				    	url: "jqgridSubTable.do?no="+feature.attributes.description,
				        type: "GET",
				        success: function (html) {
				            $("#markerContent_" + feature.attributes.description).append(html);
				        }
				    });
				    
			    }

			    function destroyPopup(feature) {
			      feature.popup.destroy();
			      feature.popup = null;
			    }
			    
			    map.addControl(controls['selector']);
			    controls['selector'].activate();
			    
    		}
    	});
    };

    function initCampData()
    {
     	var ctx = window.contextPath;
     	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
     		ctx+='/kotasalong';
     	}
    	url= ctx + "/camp";
    	$.ajax({
    		type: "GET",
    		url: url,
    		data:{},
    		dataType: 'json',
    		error: function(){
    			alert('실패');
    		},
    		success: function(data){
    		    var vectorLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var m = {};
    			m.PoiBeachList = data.data;
    			var d = m.PoiBeachList;
    			var point = [];
    			var poiData = null;
    			var Imgfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;

					var imgsrc = "${pageContext.request.contextPath}/ref/images/poi/camping.png";

					Imgfeatures[i] = new OpenLayers.Feature.Vector(
    			            new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()),
    			            {description: d[i].no } ,
    			            {externalGraphic: imgsrc, graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-35  }
    			        );    
    			    
    			}
    			vectorLayer.addFeatures(Imgfeatures);
			    map.addLayer(vectorLayer);
			    
    		    var textLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var Txtfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;
    				Txtfeatures[i] = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()));    
    				Txtfeatures[i].attributes = {
     		                label: d[i].title
     		            };
     			    

    			}
 			    textLayer.addFeatures(Txtfeatures);
			    map.addLayer(textLayer);
 
    		}
    	});
    };

    function initFestivalData()
    {
     	var ctx = window.contextPath;
     	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
     		ctx+='/kotasalong';
     	}
    	url= ctx + "/festival";
    	$.ajax({
    		type: "GET",
    		url: url,
    		data:{},
    		dataType: 'json',
    		error: function(){
    			alert('실패');
    		},
    		success: function(data){
    		    var vectorLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var m = {};
    			m.PoiBeachList = data.data;
    			var d = m.PoiBeachList;
    			var point = [];
    			var poiData = null;
    			var Imgfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;

					var imgsrc = "${pageContext.request.contextPath}/ref/images/poi/screen.png";

					Imgfeatures[i] = new OpenLayers.Feature.Vector(
    			            new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()),
    			            {description: d[i].no } ,
    			            {externalGraphic: imgsrc, graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-35  }
    			        );    
    			    
    			}
    			vectorLayer.addFeatures(Imgfeatures);
			    map.addLayer(vectorLayer);
			    
    		    var textLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var Txtfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;
    				Txtfeatures[i] = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()));    
    				Txtfeatures[i].attributes = {
     		                label: d[i].title
     		            };
     			    

    			}
 			    textLayer.addFeatures(Txtfeatures);
			    map.addLayer(textLayer);
    		}
    	});
    };

    function initSportData()
    {
     	var ctx = window.contextPath;
     	if(window.uri.startsWith("http://localhost")||window.uri.startsWith("http://127.0.0.1")||window.uri.startsWith("http://10.0.2.2")){
     		ctx+='/kotasalong';
     	}
    	url= ctx + "/sport";
    	$.ajax({
    		type: "GET",
    		url: url,
    		data:{},
    		dataType: 'json',
    		error: function(){
    			alert('실패');
    		},
    		success: function(data){
    		    var vectorLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var m = {};
    			m.PoiBeachList = data.data;
    			var d = m.PoiBeachList;
    			var point = [];
    			var poiData = null;
    			var Imgfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;

					var imgsrc = "${pageContext.request.contextPath}/ref/images/poi/surfing.png";

					Imgfeatures[i] = new OpenLayers.Feature.Vector(
    			            new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()),
    			            {description: d[i].no } ,
    			            {externalGraphic: imgsrc, graphicHeight: 25, graphicWidth: 21, graphicXOffset:-12, graphicYOffset:-35  }
    			        );    
    			    
    			}
    			vectorLayer.addFeatures(Imgfeatures);
			    map.addLayer(vectorLayer);
			    
    		    var textLayer = new OpenLayers.Layer.Vector("Camp", {"styleMap": smap});

    			var Txtfeatures = new Array(d.length);
    			for (var i = 0; i<d.length; i++){
    				d[i].lng = d[i].mapx;
    				d[i].lat = d[i].mapy;
    				poiData = d[i];
    				point = [d[i].lng,d[i].lat];
    				m.PoiNm++;
    				Txtfeatures[i] = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point( d[i].lng, d[i].lat ).transform(epsg4326, map.getProjectionObject()));    
    				Txtfeatures[i].attributes = {
     		                label: d[i].title
     		            };
     			    

    			}
 			    textLayer.addFeatures(Txtfeatures);
			    map.addLayer(textLayer);
    		}
    	});
    };
    
    function innerHtmlLatAndLonAndAcc(latitude, longitude, accuracy) {
    	document.getElementById('lngAndLat').innerHTML = 'lat: ' + latitude + ', '
    	+ 'lng: ' + longitude + ', ' + 'accuracy: ' + accuracy + '<br />';
    }
    function innerHtmlWeather(sky, rainsnow, temp) {
    	if(sky=='1'){
    		sky='<p class="fa fa-sun-o"> (맑음) </p>';
    	}else if(sky=='2'){
    		sky='<p class="fa fa-cloud"> (구름조금) </p>';
    	}else if(sky=='3'){
    		sky='<p class="fa fa-cloud"> (구름많음) </p>';
    	}else if(sky=='4'){
    		sky='<p class="fa fa-umbrella"> (흐림) </p>';
    	}
    	if(rainsnow=='0'){
    		rainsnow='<p class="fa fa-bolt "> (낙뢰없음) </p>';
    	}else if(rainsnow=='1'){
    		rainsnow='<p class="fa fa-bolt "> (낙뢰있음) </p>';
    	}
    	temp+='℃';
        document.getElementById('weatherContent').innerHTML = sky + "&nbsp;&nbsp;" + rainsnow + "&nbsp;&nbsp;" + temp;
    }


    $( document ).ready(function(){

    	var getContextPath = function()
    	{
    		var offset = null;
    		var ctxPath = null;
    		if( location.host.length > 0 )
    		{
    			offset = location.href.indexOf(location.host)+location.host.length;
    			ctxPath = location.href.substring(offset+1,location.href.lastIndexOf( "/" ) );
    			ctxPath = "/"+ctxPath.split("/")[0];
    		}
    		else
    			ctxPath = ".";
    		return ctxPath;
    	};
    	var getUri = function(){
    		var windowUri = null;
    		console.log(navigator.userAgent);
    		if(navigator.userAgent.match(/Android/i)){
    			if(typeof window.location.href === 'undefined'){
    				windowUri = window.location;
    			}else{
    				windowUri = window.location.href;
    			}
    		}else{
    			windowUri = window.location.href; 
    		}
    		return windowUri;
    	}

    	//android webview에서는 startswith가 안된다.
    	if (typeof String.prototype.startsWith != 'function') {
    		  String.prototype.startsWith = function (str){
    		    return this.indexOf(str) === 0;
    		  };
    		}
    	window.uri = getUri();
    	window.contextPath = getContextPath();

    	init();
    	getLocation();
    	initBeachData2();
    	initCampData();
    	initSportData();
    	initFestivalData();
    	$('#loading').hide();
    	var mHeight = $("#collapseDiv").height();
		$("#collapseDiv").on("hide.bs.collapse", function(){
			mHeight = $("#collapseDiv").height();
			var size = {
	    			width: window.innerWidth || document.body.clientWidth,
	    			height: window.innerHeight-50 || document.body.clientHeight-50
	    		};
			$("#map").css(size);
			map.updateSize();
		});
		$("#collapseDiv").on("show.bs.collapse", function(){
			var size = {
	    			width: window.innerWidth || document.body.clientWidth,
	    			height: window.innerHeight-50-mHeight || document.body.clientHeight-50-mHeight 
	    		};
			$("#map").css(size);
			map.updateSize();
		});
		var size = {
    			width: window.innerWidth || document.body.clientWidth,
    			height: window.innerHeight-50 || document.body.clientHeight-50
    		};
		if(size.height=='0'||size.height=='-50'){
			$("#map").css('width',360);
			$("#map").css('height',document.body.clientHeight-50);
		}else{
			$("#map").css(size);
		}
		map.updateSize();
        /* 
		$('.sidebar').css('visibility','hidden').css('height','0px');
		var size = {
    			width: window.innerWidth || document.body.clientWidth,
    			height: window.innerHeight-50 || document.body.clientHeight-50
    		};
		$("#map").css(size);
		map.updateSize(); 
		*/
        var center = new OpenLayers.LonLat(127.78072, 36.74133);
        center.transform(epsg4326, map.getProjectionObject());
        map.setCenter(center);
        map.zoomTo(9);
    });
    		
    </script>
 
<div id="map"></div>
                            