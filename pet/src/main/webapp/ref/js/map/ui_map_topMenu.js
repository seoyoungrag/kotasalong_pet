// map split control;
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.UI = window.UI ? window.UI : {};
window.UI.Map = window.UI.Map ? window.UI.Map : {};
window.UI.Map.TopMenu = window.UI.Map.TopMenu ? window.UI.Map.TopMenu : {};

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.UI.Map.TopMenu.SELECTOR_ALL = "#btnAll";
window.UI.Map.TopMenu.SELECTOR_CLINIC = "#btnClinic";
window.UI.Map.TopMenu.SELECTOR_PENSION = "#btnPension";
window.UI.Map.TopMenu.SELECTOR_PHAR = "#btnPhar";
window.UI.Map.TopMenu.SELECTOR_BEACH = "#btnBeach";

//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * 이벤트 설정
 * @function
 */
window.UI.Map.TopMenu.addEvent = function()
{
	window.console.log( "---------- window.UI.Map.TopMenu.addEvent():void" );
	var o = window.UI.Map.TopMenu;
		$( o.SELECTOR_ALL ).bind( "click", o.evt_mClick_All );
		$( o.SELECTOR_CLINIC ).bind( "click", o.evt_mClick_Clinic );
		$( o.SELECTOR_PENSION ).bind( "click", o.evt_mClick_Pension );
		$( o.SELECTOR_PHAR ).bind( "click", o.evt_mClick_Phar );
		$( o.SELECTOR_BEACH ).bind( "click", o.evt_mClick_Beach );
};

/**
 * 지도 all버튼 이벤트 발생 시
 * @function
 * @param {EventObject} e
 */
window.UI.Map.TopMenu.evt_mClick_All = function( e )
{
	window.console.log( "---------- window.UI.Map.TopMenu.evt_mClick_All():void" );
	var o = window.UI.Map.TopMenu;
		window.Map.Marker.PoiNm = 0;
		window.Map.Marker.clear();
		
		window.Map.Marker.initPharmacyData();
		window.Map.Marker.initClinicData();
		window.Map.Marker.initPensionData();
		window.Map.Marker.initBeachData();
};
/**
 * evt_mClick_Beach
 * @function
 * @param {EventObject} e
 */
window.UI.Map.TopMenu.evt_mClick_Beach = function( e )
{
	window.console.log( "---------- window.UI.Map.TopMenu.evt_mClick_Beach():void" );
	var o = window.UI.Map.TopMenu;
		window.Map.Marker.PoiNm = 0;
		window.Map.Marker.clear();
		window.Map.Marker.initBeachData();
};
/**
 * evt_mClick_Clinic
 * @function
 * @param {EventObject} e
 */
window.UI.Map.TopMenu.evt_mClick_Clinic = function( e )
{
	window.console.log( "---------- window.UI.Map.TopMenu.evt_mClick_Clinic():void" );
	var o = window.UI.Map.TopMenu;
		window.Map.Marker.PoiNm = 0;
		window.Map.Marker.clear();
		window.Map.Marker.initClinicData();
};
/**
 * evt_mClick_Phar
 * @function
 * @param {EventObject} e
 */
window.UI.Map.TopMenu.evt_mClick_Phar = function( e )
{
	window.console.log( "---------- window.UI.Map.TopMenu.evt_mClick_Phar():void" );
	var o = window.UI.Map.TopMenu;
		window.Map.Marker.PoiNm = 0;
		window.Map.Marker.clear();
		window.Map.Marker.initPharmacyData();
};
/**
 * evt_mClick_Pension
 * @function
 * @param {EventObject} e
 */
window.UI.Map.TopMenu.evt_mClick_Pension = function( e )
{
	window.console.log( "---------- window.UI.Map.TopMenu.evt_mClick_Pension():void" );
	var o = window.UI.Map.TopMenu;
		window.Map.Marker.PoiNm = 0;
		window.Map.Marker.clear();
		window.Map.Marker.initPensionData();
};

