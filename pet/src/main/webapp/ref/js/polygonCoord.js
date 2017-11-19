/**
 * @description 지도 측정 도구 ( OpenLayers 3.1.1 기반 )
 * @author ESR23
 */
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.MapTool = window.MapTool ? window.MapTool : {};
window.MapTool.PolygonCoord = window.MapTool.PolygonCoord ? window.MapTool.PolygonCoord : {};

//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.MapTool.PolygonCoord.CB_BEFORE = null;
window.MapTool.PolygonCoord.CB_COMPLETE = null;
window.MapTool.PolygonCoord.DIV = null;
window.MapTool.PolygonCoord.Draw = null;
window.MapTool.PolygonCoord.Layer = null;
window.MapTool.PolygonCoord.Map = null;
window.MapTool.PolygonCoord.OBJ_Drawing = null;
window.MapTool.PolygonCoord.Overlay = [];
window.MapTool.PolygonCoord.Source = null;
window.MapTool.PolygonCoord.STYLE_AREA = { fill : "rgba( 204, 102, 153, 0.3 )", line : "rgba( 204, 102, 153, 1.0 )", width : 2 };

window.MapTool.PolygonCoord.CoordArray=[];


//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * 그리기 종료 시 좌표 추출 
 * @param {Object} e
 */
window.MapTool.PolygonCoord.CB_COORD = function( coord )
{	
	//좌표를 이용하여 커스터마이징;
	console.log(coord);
	
	
}


/**
 * 그리기 종료 시
 * @param {Object} e
 */
window.MapTool.PolygonCoord.evt_drawend = function( e )
{
	var polyCoord = window.MapTool.PolygonCoord;
	if( polyCoord.CB_COMPLETE ) polyCoord.CB_COMPLETE();
		
		if( polyCoord.OBJ_Drawing )
		{
			var geom = polyCoord.OBJ_Drawing.getGeometry();
				
			if( geom instanceof ol.geom.Polygon )
			{
				var o = window.UI.Map.TopMenu;
						$(o.SELECTOR_POLYGON_LINE).attr('class','icon btn_icon14');
						$(o.SELECTOR_POLYGON_LINE).parent().attr('class',null);
			}
		}
		
		//폴리곤의 좌표;
		var polygonCoords = geom.A;
		
		if( polyCoord.CB_COORD ) polyCoord.CB_COORD(polygonCoords);
	
		polyCoord.OBJ_Drawing = null;
		polyCoord.DIV = null;
		
		window.mapObj.removeInteraction( polyCoord.Draw );
};

/**
 * 그리기 시작 시
 * @param {Object} e
 */
window.MapTool.PolygonCoord.evt_drawstart = function( e )
{
	var polyCoord = window.MapTool.PolygonCoord;
	if( polyCoord.CB_BEFORE ) polyCoord.CB_BEFORE();
	polyCoord.OBJ_Drawing = e.feature;
	
};

/**
 * 포인터 이동 시
 * @param {Object} e
 */
window.MapTool.PolygonCoord.evt_mMove_Pointer = function( e )
{
	if( e.dragging ) return;

	var polyCoord = window.MapTool.PolygonCoord;
	var coord = null;
	if( polyCoord.OBJ_Drawing )
	{
		var txt = null;
		var geom = polyCoord.OBJ_Drawing.getGeometry();
		geom.transform(window.Proj, window.Projw);
			
		if( geom instanceof ol.geom.Polygon )
		{
			geom = geom.transform(window.Projw, window.Proj);
			coord = geom.getInteriorPoint().getCoordinates();
		}
	}
};

//----------------------------------------------------------------------------------------------------;
//FUNCTION;
//----------------------------------------------------------------------------------------------------;

/**
 * 면적측정
 */
window.MapTool.PolygonCoord.area = function()
{	
	var polyCoord = window.MapTool.PolygonCoord;
//		polyCoord.initialize();
		polyCoord.Draw = new ol.interaction.Draw({
			source : polyCoord.Source
			, type : "Polygon"
			//*/
			, style : new ol.style.Style({
				fill: new ol.style.Fill({ color: polyCoord.STYLE_AREA.fill })
				, stroke : new ol.style.Stroke({ color: polyCoord.STYLE_AREA.line, width: polyCoord.STYLE_AREA.width })
				, image: new ol.style.Circle({ radius: 7, fill: new ol.style.Fill({ color: polyCoord.STYLE_AREA.line }) })
			})
			//*/
		});
		window.mapObj.addInteraction( polyCoord.Draw );

		polyCoord.Draw.on( "drawstart", polyCoord.evt_drawstart, this );
		polyCoord.Draw.on( "drawend", polyCoord.evt_drawend, this );
};

/**
 * 결과 텍스트 추가
 * @param {String} txt
 * @param {ol.Coordinate|undefined} coord
 */
window.MapTool.PolygonCoord.addText = function( txt, coord )
{
	var polyCoord = window.MapTool.PolygonCoord;

	if( polyCoord.DIV ) polyCoord.DIV.parentNode.removeChild( polyCoord.DIV );
	polyCoord.DIV = document.createElement( "div" );
	polyCoord.DIV.className = "map_polyCoord_tooltip";
	polyCoord.DIV.style.backgroundColor = "#ffffff";
	polyCoord.DIV.style.border = "solid 1px #ff0000";
	polyCoord.DIV.style.padding = "2px 2px 2px 2px";
	polyCoord.DIV.innerHTML = txt;

	var popup = new ol.Overlay({
		element : polyCoord.DIV
		, offset : [15, 0]
		, positioning : "center-left"
	});
		popup.setPosition( coord );

	window.mapObj.addOverlay( popup );
	polyCoord.Overlay.push( popup );
};

/**
 * Vector Layer 추가
 */
window.MapTool.PolygonCoord.addVectorLayer = function()
{
	var polyCoord = window.MapTool.PolygonCoord;
	if( !polyCoord.Source ) polyCoord.Source = new ol.source.Vector();
		polyCoord.Layer = new ol.layer.Vector({
			name : "MapPolygonCoord"
			, source : polyCoord.Source
		});
		window.mapObj.addLayer( polyCoord.Layer );
};

/**
 * 초기화
 */
window.MapTool.PolygonCoord.initialize = function( d )
{
	var polyCoord = window.MapTool.PolygonCoord;
//	if ( d ) 
		polyCoord.setData( d ); // 정보 설정;
	if( !polyCoord.Layer ) polyCoord.addVectorLayer(); // 벡터레이어 추가;
	window.mapObj.on( "pointermove", polyCoord.evt_mMove_Pointer);
};

/**
 * 전체 삭제
 */
window.MapTool.PolygonCoord.remove = function()
{

	window.console.log( "---------- window.MapTool.PolygonCoord.remove():void" );
	
	var polyCoord = window.MapTool.PolygonCoord;
	if( polyCoord.CB_BEFORE ) polyCoord.CB_BEFORE();
	var map = window.mapObj;
//		map.removeLayer( polyCoord.Layer );
	polyCoord.Layer.getSource().clear();
		map.un( "pointermove", polyCoord.evt_mMove_Pointer);

		/*/
	polyCoord.Source = null;
	polyCoord.Layer = null;
	//*/

	var overlay = polyCoord.Overlay;
	var i=0, iLen=overlay.length;
	for( ; i<iLen; ++i )
	{
		map.removeOverlay( overlay[i] );
	}
	overlay = [];
	if( polyCoord.CB_COMPLETE ) polyCoord.CB_COMPLETE();
	

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
window.MapTool.PolygonCoord.setData = function( d )
{
	d = d ? d : {};
	var polyCoord = window.MapTool.PolygonCoord;
	if( d.hasOwnProperty( "map" ) ) polyCoord.Map = d.map;
	if( d.hasOwnProperty( "layer" ) )
	{
		polyCoord.Layer = d.layer;
		polyCoord.Source = d.layer.getSource();
	}
	else
		polyCoord.addVectorLayer();

	if( d.hasOwnProperty( "cb" ) )
	{
		if( d.cb.hasOwnProperty( "before" ) ) polyCoord.CB_BEFORE = d.cb.before;
		if( d.cb.hasOwnProperty( "after" ) ) polyCoord.CB_COMPLETE = d.cb.after;
	}
	if( d.hasOwnProperty( "area" ) )
	{
		if( d.area.hasOwnProperty( "style" ) )
		{
			if( d.area.style.hasOwnProperty( "fill" ) ) polyCoord.STYLE_AREA.fill = d.area.style.fill;
			if( d.area.style.hasOwnProperty( "line" ) ) polyCoord.STYLE_AREA.line = d.area.style.line;
			if( d.area.style.hasOwnProperty( "width" ) ) polyCoord.STYLE_AREA.width = d.area.style.width;
		}
	}

	polyCoord.Layer.setStyle( new ol.style.Style({
		fill: new ol.style.Fill({ color: polyCoord.STYLE_AREA.fill })
		, stroke : new ol.style.Stroke({ color: polyCoord.STYLE_AREA.line, width: polyCoord.STYLE_AREA.width })
		, image: new ol.style.Circle({ radius: 7, fill: new ol.style.Fill({ color: polyCoord.STYLE_AREA.fill }) })
	}));
};

//----------------------------------------------------------------------------------------------------;

