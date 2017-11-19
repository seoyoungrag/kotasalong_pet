$( document ).ready(function()
{
	console.log( "document.ready ----------- STA" );

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

	window.ESR23Common.import_JS_Async( [
		contextPath + "/ref/js/common.js"

		, contextPath + "/ref/js/lib/jquery-ui.js"
		, contextPath + "/ref/js/lib/vector3d.js"
		, contextPath + "/ref/js/lib/dms.js"
		, contextPath + "/ref/js/lib/latlon-ellipsoidal.js"
		, contextPath + "/ref/js/lib/utm.js"
		, contextPath + "/ref/js/lib/mgrs.js"

		, contextPath + "/ref/js/converter.js"
		, contextPath + "/ref/js/lib/jquery.nouislider.js"
		, contextPath + "/ref/js/lib/html2canvas.min.js"
		, contextPath + "/ref/js/map/ol3.15.1_jquery_nouislider_MapTool_Zoombar_Custom.js"
		, contextPath + "/ref/js/map/ui_map_change.js"
		, contextPath + "/ref/js/map/ui_map_save.js"
		, contextPath + "/ref/js/map/ui_map_topMenu.js"
		, contextPath + "/ref/js/measure.js"

		, contextPath + "/ref/js/polygonCoord.js"

		, contextPath + "/ref/js/lib/ol.js"
		, contextPath + "/ref/js/map/map_marker_beach.js"
		, contextPath + "/ref/js/initialize.js"
		, contextPath + "/ref/js/beachInit.js"
		, contextPath + "/ref/js/weather.js"
		//, contextPath + "/ref/js/custom_controls.js"

	], false, true );

    $('#loading').hide();
	console.log( "document.ready ----------- END" );
});