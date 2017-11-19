// map split control;
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.UI = window.UI ? window.UI : {};
window.UI.Map = window.UI.Map ? window.UI.Map : {};
window.UI.Map.Save = window.UI.Map.Save ? window.UI.Map.Save : {};

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.UI.Map.Save.SELECTOR_DIV_TARGET = "#map";
window.UI.Map.Save.SELECTOR_BTN_SAVE = "#btnSave";

window.UI.Map.Save.CS = null;
window.UI.Map.Save.URL = window.contextPath + "/MapImageDownload.do";

//이미지 저장 클래스;
window.UI.Map.Save.CLASS_CanvasSaver = function( url )
{
	this.url = url;
	this.savePNG = function( cnvs, fname )
	{
		if(!cnvs || !url) return;
		fname = fname || "picture";

		var data = cnvs.toDataURL("image/png");
			data = data.substr(data.indexOf(",") + 1).toString();

		if( $( "iframe[name='iframeDown']" ).length == 0 )
		{
			var iframe = "<iframe name=\"iframeDown\" style=\"display:none;\"></iframe>";
			$( iframe ).appendTo( "body" );
		}
		else
			$( "iframe[name='iframeDown']" ).empty();

		var strForm = "";
			strForm += "<form name=\"sForm\" id=\"sForm\" target=\"iframeDown\" action=\""+ url +"\" method=\"post\">";
			strForm += 		"<input type=\"hidden\" name=\"fileName\" value=\""+ fname +".png\" />";
			strForm += 		"<input type=\"hidden\" name=\"imgdata\" value=\""+ data +"\" />";
			strForm += "</form>";
		$( strForm ).appendTo( "body" ).submit().remove();
	};
};

//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * 이벤트 설정
 */
window.UI.Map.Save.addEvent = function()
{
	window.console.log( "---------- window.UI.Map.Save.addEvent():void" );
	var o = window.UI.Map.Save;
		o.addEvent_mClick_Save();
};

/**
 * 이벤트 해제
 */
window.UI.Map.Save.removeEvent = function()
{
	window.console.log( "---------- window.UI.Map.Save.removeEvent():void" );
	var o = window.UI.Map.Save;
		o.removeEvent_mClick_Save();
};


//--------------------------------------------------;

/**
 * 저장 버튼 클릭 이벤트 설정
 */
window.UI.Map.Save.addEvent_mClick_Save = function()
{
	window.console.log( "---------- window.UI.Map.Save.addEvent_mClick_Save():void" );
	var o = window.UI.Map.Save;
	$( o.SELECTOR_BTN_SAVE ).bind( "click", o.evt_mClick_Save );
};

/**
 * 저장 버튼 클릭 이벤트 해제
 */
window.UI.Map.Save.removeEvent_mClick_Save = function()
{
	window.console.log( "---------- window.UI.Map.Save.removeEvent_mClick_Save():void" );
	var o = window.UI.Map.Save;
	$( o.SELECTOR_BTN_SAVE ).unbind( "click", o.evt_mClick_Save );
};

/**
 * 저장 버튼 클릭 이벤트 발생 시
 */
window.UI.Map.Save.evt_mClick_Save = function( e )
{
	window.console.log( "---------- window.UI.Map.Save.evt_mClick_Save():void" );
	var o = window.UI.Map.Save;
		o.renderSync();
	html2canvas(document.getElementById("map")).then(function(canvas) {
		if( !o.CS ) o.CS = new o.CLASS_CanvasSaver( o.URL );
		o.CS.savePNG( canvas, "map_" + window.ESR23Common.getTimeStamp( "YYYYMMDDhhmmss" ) );
	});
};

//----------------------------------------------------------------------------------------------------;
//FUNCTION;
//----------------------------------------------------------------------------------------------------;

/**
 * 초기화
 * @function
 */
window.UI.Map.Save.initialize = function()
{
	window.console.log( "---------- window.UI.Map.Save.initialize():void" );
	var o = window.UI.Map.Save;
		o.removeEvent();
		o.addEvent();
};

/**
 * map render sync
 * @function
 */
window.UI.Map.Save.renderSync = function()
{
	window.console.log( "---------- window.UI.Map.Save.renderSync():void" );
	window.mapObj.renderSync();
};

//----------------------------------------------------------------------------------------------------;
//GETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//SETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
