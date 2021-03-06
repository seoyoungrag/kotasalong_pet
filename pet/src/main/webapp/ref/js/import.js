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
		, contextPath + "/ref/js/map/map_marker.js"
		, contextPath + "/ref/js/initialize.js"

	], false, true );

	console.log( "document.ready ----------- END" );
});