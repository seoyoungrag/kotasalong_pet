// mapTool zoombar;
//----------------------------------------------------------------------------------------------------;
window.ol3_15_1 = window.ol3_15_1 ? window.ol3_15_1 : {};
window.ol3_15_1.MapTool = window.ol3_15_1.MapTool ? window.ol3_15_1.MapTool : {};
window.ol3_15_1.MapTool.Zoombar = window.ol3_15_1.MapTool.Zoombar ? window.ol3_15_1.MapTool.Zoombar : {};

//----------------------------------------------------------------------------------------------------;

window.ol3_15_1.MapTool.Zoombar.Custom = function( d )
{
	var _packageName = this.packageName = "window.ol3_15_1.MapTool.Zoombar.Custom";

	window.console.log( "----- " + _packageName + " STA" );

	var _map = null;
	var _minZoom = null;
	var _maxZoom = null;
	var _ui_zoomin = null;
	var _ui_zoomout = null;
	var _ui_bodycontroller = null;

	//----------------------------------------------------------------------------------------------------;
	//DEFINE;
	//----------------------------------------------------------------------------------------------------;

	//----------------------------------------------------------------------------------------------------;
	//PROPERTY-CONST;
	//----------------------------------------------------------------------------------------------------;

	//----------------------------------------------------------------------------------------------------;
	//EVENT;
	//----------------------------------------------------------------------------------------------------;

	this.addEvent = function()
	{
		window.console.log( "------ " + _packageName + ".addEvent():void" );
		this.addEvent_mClick_ZoomIn();
		this.addEvent_mClick_ZoomOut();

		var zoom = _map.getView().getZoom();

		$( "#" + _ui_bodycontroller ).noUiSlider({
			range : [ _minZoom, _maxZoom ]
			, start : zoom
			, step : 1
			, connect : true
			, handles : 1
			, orientation : "vertical"
			, slide : this.evt_Slide_Zoombar
		});

		$( "#" + _ui_bodycontroller ).addClass( "zoombar" );
		$( "#" + _ui_bodycontroller + " div").addClass( "zoombar_controller" );

		// 지도 줌엔드 이벤트 설정 ( 줌바 동기화 )
		this.addEvent_Map_Zoomend();
	};

	//--------------------------------------------------;

	this.removeEvent = function()
	{
		window.console.log( "------ " + _packageName + ".addEvent():void" );
		this.removeEvent_mClick_ZoomIn();
		this.removeEvent_mClick_ZoomOut();
		this.removeEvent_Map_Zoomend();
	};

	this.addEvent_mClick_ZoomIn = function()
	{
		window.console.log( "------ " + _packageName + ".addEvent_mClick_ZoomIn():void" );
		$( "#" + _ui_zoomin ).bind( "click", this.evt_mClick_ZoomIn );
	};

	this.removeEvent_mClick_ZoomIn = function()
	{
		window.console.log( "------ " + _packageName + ".removeEvent_mClick_ZoomIn():void" );
		$( "#" + _ui_zoomin ).unbind( "click", this.evt_mClick_ZoomIn );
	};

	this.evt_mClick_ZoomIn = function( e )
	{
		window.console.log( "------ " + _packageName + ".evt_mClick_ZoomIn():void" );
		var zoom = _map.getView().getZoom();
		_map.getView().setZoom( zoom+1 );
	};

	//--------------------------------------------------;

	this.addEvent_mClick_ZoomOut = function()
	{
		window.console.log( "------ " + _packageName + ".addEvent_mClick_ZoomOut():void" );
		$( "#" + _ui_zoomout ).bind( "click", this.evt_mClick_ZoomOut );
	};

	this.removeEvent_mClick_ZoomOut = function()
	{
		window.console.log( "------ " + _packageName + ".removeEvent_mClick_ZoomOut():void" );
		$( "#" + _ui_zoomout ).unbind( "click", this.evt_mClick_ZoomOut );
	};

	this.evt_mClick_ZoomOut = function( e )
	{
		window.console.log( "------ " + _packageName + ".evt_mClick_ZoomOut():void" );
		var zoom = _map.getView().getZoom();
		 _map.getView().setZoom( zoom-1 );
	};

	//--------------------------------------------------;

	this.addEvent_Map_Zoomend = function()
	{
		window.console.log( "------ " + _packageName + ".addEvent_Map_Zoomend():void" );
		_map.getView().on( "change:resolution", this.evt_Map_Zoomend );
	};

	this.removeEvent_Map_Zoomend = function()
	{
		window.console.log( "------ " + _packageName + ".removeEvent_Map_Zoomend():void" );
		_map.getView().un( "change:resolution", this.evt_Map_Zoomend );
	};

	this.evt_Map_Zoomend = function( e )
	{
		window.console.log( "------ " + _packageName + ".evt_Map_Zoomend():void" );
		$( "#" + _ui_bodycontroller ).val( e.target.getZoom() );
	};

	//--------------------------------------------------;

	this.evt_mClick_MapControl = function( e )
	{
		window.console.log( "------ " + _packageName + ".evt_mClick_MapControl():void" );
		var id = $( e.currentTarget ).attr( "id" );
		if( id == _ui_btncontroller ) return;
		else
		{
			var zoom = this.map.getView().getZoom();

			if( id == _ui_zoomin ) zoom = zoom + 1;
			else if( id == _ui_zoomout ) zoom = zoom - 1;

			_map.getView().setZoom( zoom );
			$( "#" + _ui_bodycontroller ).val( zoom );
		}
	};

	this.evt_Slide_Zoombar = function( e )
	{
		window.console.log( "------ " + _packageName + ".evt_Slide_Zoombar():void" );
		var val = this.val();

		var zoom = _map.getView().getZoom();
		if( zoom != val ) _map.getView().setZoom( val );
	};

	//----------------------------------------------------------------------------------------------------;
	//FUNCTION;
	//----------------------------------------------------------------------------------------------------;

	this.initialize = function( d )
	{
		window.console.log( "------ " + _packageName + ".initialize():void" );
		this.setData( d );
		this.removeEvent();
		this.addEvent();
	};

	//----------------------------------------------------------------------------------------------------;
	//GETTER;
	//----------------------------------------------------------------------------------------------------;

	//----------------------------------------------------------------------------------------------------;
	//SETTER;
	//----------------------------------------------------------------------------------------------------;

	/**
	 *
	 * @function
	 * @param {Object} d
	 * <code>
	 * {
	 * 		"map" : {ol.Map}
	 * 		, minZoom : 0
	 * 		, maxZoom : 0
	 * 		, "ui" : {
	 * 			"zoomin" : "" // element ID;
	 * 			, "zoomout" : "" // element ID;
	 * 			, "bodycontroller" : "" // element ID;
	 * 			, "controller" : "" // element ID;
	 * 		}
	 * }
	 * </code>
	 */
	this.setData = function( d )
	{
		window.console.log( "------ " + _packageName + ".setData():void" );
		if( d.hasOwnProperty( "map" ) ) _map = d.map;
		if( d.hasOwnProperty( "minZoom" ) ) _minZoom = d.minZoom;
		if( d.hasOwnProperty( "maxZoom" ) ) _maxZoom = d.maxZoom;
		if( d.hasOwnProperty( "ui" ) )
		{
			if( d.ui.hasOwnProperty( "zoomin" ) ) _ui_zoomin = d.ui.zoomin;
			if( d.ui.hasOwnProperty( "zoomout" ) ) _ui_zoomout = d.ui.zoomout;
			if( d.ui.hasOwnProperty( "bodycontroller" ) ) _ui_bodycontroller = d.ui.bodycontroller;
			if( d.ui.hasOwnProperty( "controller" ) ) _ui_btncontroller = d.ui.controller;
		}
	};

	//----------------------------------------------------------------------------------------------------;

	this.initialize( d );

	window.console.log( "----- " + _packageName + " END" );
	return this;
};

/*/
var zoombar = window.ol3_15_1.MapTool.Zoombar.Custom({
	map : window.mapObj.map1.map
	, minZoom : 7
	, maxZoom : 19
	, ui : {
		zoomin : "btnzoomin"
		, zoomout : "btnzoomout"
		, bodycontroller : "bodycontroller"
		, controller : "btncontroller"
	}
});
//*/