/**
 * @description 지도 측정 도구 ( OpenLayers 3.1.1 기반 )
 * @author ESR23
 */
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.MapTool = window.MapTool ? window.MapTool : {};
window.MapTool.Measure = window.MapTool.Measure ? window.MapTool.Measure : {};

//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.MapTool.Measure.CB_BEFORE = null;
window.MapTool.Measure.CB_COMPLETE = null;
window.MapTool.Measure.DIV = null;
window.MapTool.Measure.Draw = null;
window.MapTool.Measure.Layer = null;
window.MapTool.Measure.Map = null;
window.MapTool.Measure.OBJ_Drawing = null;
window.MapTool.Measure.Overlay = [];
window.MapTool.Measure.Source = null;
//색상 설정 ;
window.MapTool.Measure.STYLE_AREA = { fill : "rgba( 63, 175, 220, 0.1 )", line : "rgba( 63, 175, 220, 1.0 )", width : 2 };
window.MapTool.Measure.STYLE_DIATANCE = { line : "rgba( 255, 0, 0, 0.5 )", width : 2 };

window.MapTool.Measure.CoordArray=[];


//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * 그리기 종료 시
 * @param {Object} e
 */
window.MapTool.Measure.evt_drawend = function( e )
{
	var measure = window.MapTool.Measure;
	if( measure.CB_COMPLETE ) measure.CB_COMPLETE();
		
		if( measure.OBJ_Drawing )
		{
			var geom = measure.OBJ_Drawing.getGeometry();
				
			if( geom instanceof ol.geom.Polygon )
			{
				document.getElementById("areaMeasure").className='icon btn_icon06';
				document.getElementById("areaMeasure").parentNode.className=null;
			}
			else if( geom instanceof ol.geom.LineString )
			{
				document.getElementById("lengthMeasure").className='icon btn_icon05';
				document.getElementById("lengthMeasure").parentNode.className=null;
			}
		}
	
	
		measure.OBJ_Drawing = null;
		measure.DIV = null;

		
		
		window.mapObj.removeInteraction( measure.Draw );
};

/**
 * 그리기 시작 시
 * @param {Object} e
 */
window.MapTool.Measure.evt_drawstart = function( e )
{
	var measure = window.MapTool.Measure;
	if( measure.CB_BEFORE ) measure.CB_BEFORE();
	measure.OBJ_Drawing = e.feature;
	
//	var measure = window.MapTool.Measure;
//	if( measure.OBJ_Drawing )
//	{
//		var geom = measure.OBJ_Drawing.getGeometry();
//			
//		if( geom instanceof ol.geom.Polygon )
//		{
//			document.getElementById("areaMeasure").className='icon on btn_icon06';
//			document.getElementById("areaMeasure").parentNode.className='on';
//		}
//		else if( geom instanceof ol.geom.LineString )
//		{
//			document.getElementById("lengthMeasure").className='icon on btn_icon05';
//			document.getElementById("lengthMeasure").parentNode.className='on';
//		}
//	}
};

/**
 * 포인터 이동 시
 * @param {Object} e
 */
window.MapTool.Measure.evt_mMove_Pointer = function( e )
{
	if( e.dragging ) return;

	var measure = window.MapTool.Measure;
	var coord = null;
	if( measure.OBJ_Drawing )
	{
		var txt = null;
		var geom = measure.OBJ_Drawing.getGeometry();
		geom.transform(window.Proj, window.Projw);
			
		if( geom instanceof ol.geom.Polygon )
		{
			txt = measure.setFormat_Area( geom ); //
			geom = geom.transform(window.Projw, window.Proj);
			coord = geom.getInteriorPoint().getCoordinates();
			
		}
		else if( geom instanceof ol.geom.LineString )
		{
			txt = measure.setFormat_Distance( geom );//
			geom = geom.transform(window.Projw, window.Proj);
			coord = geom.getLastCoordinate();
		}
		measure.addText( txt, coord );//
	}
};

//----------------------------------------------------------------------------------------------------;
//FUNCTION;
//----------------------------------------------------------------------------------------------------;

/**
 * 면적측정
 */
window.MapTool.Measure.area = function()
{
	var measure = window.MapTool.Measure;
		measure.initialize();
		measure.Draw = new ol.interaction.Draw({
			source : measure.Source
			, type : "Polygon"
			//*/
			, style : new ol.style.Style({
				fill: new ol.style.Fill({ color: measure.STYLE_AREA.fill })
				, stroke : new ol.style.Stroke({ color: measure.STYLE_AREA.line, width: measure.STYLE_AREA.width })
				, image: new ol.style.Circle({ radius: 7, fill: new ol.style.Fill({ color: measure.STYLE_AREA.line }) })
			})
			//*/
		});
		window.mapObj.addInteraction( measure.Draw );

		measure.Draw.on( "drawstart", measure.evt_drawstart, this );
		measure.Draw.on( "drawend", measure.evt_drawend, this );
};

/**
 * 거리측정
 */
window.MapTool.Measure.distance = function()
{
	var measure = window.MapTool.Measure;
		measure.initialize();
		measure.Draw = new ol.interaction.Draw({
			source : measure.Source
			, type : "LineString"
			//*/
			, style : new ol.style.Style({
				stroke : new ol.style.Stroke({ color: measure.STYLE_DIATANCE.line, width: measure.STYLE_DIATANCE.width })
				, image: new ol.style.Circle({ radius: 7, fill: new ol.style.Fill({ color: measure.STYLE_DIATANCE.line }) })
			})
			//*/
		});
		window.mapObj.addInteraction( measure.Draw );

		measure.Draw.on( "drawstart", measure.evt_drawstart, this );
		measure.Draw.on( "drawend", measure.evt_drawend, this );
};

/**
 * 결과 텍스트 추가
 * @param {String} txt
 * @param {ol.Coordinate|undefined} coord
 */
window.MapTool.Measure.addText = function( txt, coord )
{
	var measure = window.MapTool.Measure;

	if( measure.DIV ) measure.DIV.parentNode.removeChild( measure.DIV );
	measure.DIV = document.createElement( "div" );
	measure.DIV.className = "map_measure_tooltip";
	measure.DIV.style.backgroundColor = "#ffffff";
	measure.DIV.style.border = "solid 1px #ff0000";
	measure.DIV.style.padding = "2px 2px 2px 2px";
	measure.DIV.innerHTML = txt;

	var popup = new ol.Overlay({
		element : measure.DIV
		, offset : [15, 0]
		, positioning : "center-left"
	});
		popup.setPosition( coord );

//	measure.Map.addOverlay( popup );
	window.mapObj.addOverlay( popup );
	measure.Overlay.push( popup );
};

/**
 * Vector Layer 추가
 */
window.MapTool.Measure.addVectorLayer = function()
{
	var measure = window.MapTool.Measure;
	if( !measure.Source ) measure.Source = new ol.source.Vector();
		measure.Layer = new ol.layer.Vector({
			name : "MapMeasure"
			, source : measure.Source
		});
		window.mapObj.addLayer( measure.Layer );
};

/**
 * 초기화
 */
window.MapTool.Measure.initialize = function( d )
{
	var measure = window.MapTool.Measure;
	if( d ) measure.setData( d ); // 정보 설정;
	if( !measure.Layer ) measure.addVectorLayer(); // 벡터레이어 추가;
//	measure.Map.on( "pointermove", measure.evt_mMove_Pointer);
	window.mapObj.on( "pointermove", measure.evt_mMove_Pointer);
};

/**
 * 전체 삭제
 */
window.MapTool.Measure.remove = function()
{

	window.console.log( "---------- window.MapTool.Measure.remove():void" );
	
	var measure = window.MapTool.Measure;
	if( measure.CB_BEFORE ) measure.CB_BEFORE();
	var map = window.mapObj;
		map.removeLayer( measure.Layer );
		map.un( "pointermove", measure.evt_mMove_Pointer);

	measure.Source = null;
	measure.Layer = null;

	var overlay = measure.Overlay;
	var i=0, iLen=overlay.length;
	for( ; i<iLen; ++i )
	{
		map.removeOverlay( overlay[i] );
	}
	overlay = [];
	if( measure.CB_COMPLETE ) measure.CB_COMPLETE();
	

};

//----------------------------------------------------------------------------------------------------;
//GETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//SETTER;
//----------------------------------------------------------------------------------------------------;

/**
 * 정보 설정
 * @param {Object} d
 * <code>
 * {
 * 	"map" : object
 * 	, "cb" : { "before" : "", "after" : "" }
 *  , "area" : {
 *  	"style" : { "line" : "", "fill" : "", "width" : "" }
 *  }
 *  , "distance" : {
 *  	"style" : { "line" : "", "fill" : null, "width" : "" }
 *  }
 * }
 * </code>
 */
window.MapTool.Measure.setData = function( d )
{
	var measure = window.MapTool.Measure;
	if( d.hasOwnProperty( "map" ) ) measure.Map = d.map;
	if( d.hasOwnProperty( "layer" ) )
	{
		measure.Layer = d.layer;
		measure.Source = d.layer.getSource();
	}
	else
		measure.addVectorLayer();

	if( d.hasOwnProperty( "cb" ) )
	{
		if( d.cb.hasOwnProperty( "before" ) ) measure.CB_BEFORE = d.cb.before;
		if( d.cb.hasOwnProperty( "after" ) ) measure.CB_COMPLETE = d.cb.after;
	}
	if( d.hasOwnProperty( "area" ) )
	{
		if( d.area.hasOwnProperty( "style" ) )
		{
			if( d.area.style.hasOwnProperty( "fill" ) ) measure.STYLE_AREA.fill = d.area.style.fill;
			if( d.area.style.hasOwnProperty( "line" ) ) measure.STYLE_AREA.line = d.area.style.line;
			if( d.area.style.hasOwnProperty( "width" ) ) measure.STYLE_AREA.width = d.area.style.width;
		}
	}
	if( d.hasOwnProperty( "distance" ) )
	{
		if( d.area.hasOwnProperty( "style" ) )
		{
			if( d.area.style.hasOwnProperty( "line" ) ) measure.STYLE_DIATANCE.line = d.area.style.line;
		}
	}

	measure.Layer.setStyle( new ol.style.Style({
		fill: new ol.style.Fill({ color: measure.STYLE_AREA.fill })
		, stroke : new ol.style.Stroke({ color: measure.STYLE_AREA.line, width: measure.STYLE_AREA.width })
		, image: new ol.style.Circle({ radius: 7, fill: new ol.style.Fill({ color: measure.STYLE_AREA.fill }) })
	}));
};

/**
 * format length output
 * @param {ol.geom.Polygon} polygon
 * @return {String} result
 */
window.MapTool.Measure.setFormat_Area = function( polygon )
{
	var area =polygon.getArea();
	var result = null;
	if( area > 10000 ) result = ( Math.round( area / 1000000 * 100 ) / 100 ) + " ㎢";
	else result = ( Math.round( area * 100 ) / 100 ) + " ㎡";
	return result;
};

/**
 * format length output
 * @param {ol.geom.Polygon} polygon
 * @return {String} result
 */
window.MapTool.Measure.setFormat_Distance = function( line )
{
	var length = Math.round( line.getLength() * 100 ) / 100;
	var result = null;
	if( length > 100 ) result = ( Math.round( length / 1000 * 100 ) / 100 ) + " ㎞";
	else result = ( Math.round( length * 100 ) / 100 ) + " m";
	return result;
};

//----------------------------------------------------------------------------------------------------;

