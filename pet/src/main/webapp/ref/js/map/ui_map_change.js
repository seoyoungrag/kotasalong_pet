// map change button control;
//----------------------------------------------------------------------------------------------------;
//DEFINE;
//----------------------------------------------------------------------------------------------------;

window.UI = window.UI ? window.UI : {};
window.UI.MapChange = window.UI.MapChange ? window.UI.MapChange : {};

//----------------------------------------------------------------------------------------------------;
//PROPERTY - CONST;
//----------------------------------------------------------------------------------------------------;

window.UI.MapChange.SELECTOR_VECTOR = ".iconBox #vector";
window.UI.MapChange.SELECTOR_SATELLITE = ".iconBox #satellite";

//----------------------------------------------------------------------------------------------------;
//EVENT;
//----------------------------------------------------------------------------------------------------;

/**
 * event 설정
 * @function
 */
window.UI.MapChange.addEvent = function()
{
	window.console.log( "---------- window.UI.MapChange.addEvent():void" );
	var o = window.UI.MapChange;
		o.removeEvent_mClick_Vector();
		o.removeEvent_mClick_Satellite();

		o.addEvent_mClick_Vector();
		o.addEvent_mClick_Satellite();
};

//--------------------------------------------------;

/**
 * 벡터 지도 버튼 click event 설정
 * @function
 */
window.UI.MapChange.addEvent_mClick_Vector = function()
{
	window.console.log( "---------- window.UI.MapChange.addEvent_mClick_Vector():void" );
	$( window.UI.MapChange.SELECTOR_VECTOR ).bind( "click", window.UI.MapChange.evt_mClick_Vector );
};

/**
 * 벡터 지도 버튼 click event 해제
 * @function
 */
window.UI.MapChange.removeEvent_mClick_Vector = function()
{
	window.console.log( "---------- window.UI.MapChange.removeEvent_mClick_Vector():void" );
	$( window.UI.MapChange.SELECTOR_VECTOR ).unbind( "click", window.UI.MapChange.evt_mClick_Vector );
};

/**
 * 벡터 지도 버튼 click event 발생 시
 * @function
 * @param {MouseEvent} e
 */
window.UI.MapChange.evt_mClick_Vector = function( e )
{
	window.console.log( "---------- window.UI.MapChange.evt_mClick_Vector():void" );

	var o = window.UI.MapChange;

	if(document.getElementById("vector").className=='icon btn_icon09'){			
		if( window.mapObj )
		{				
			window.LAYER_SATELLITE.setVisible(false);
			window.LAYER_VECTOR.setVisible(true);
		}
		document.getElementById("vector").className='icon_on btn_icon09';
		document.getElementById("vector").parentNode.className='on';
		document.getElementById("satellite").className='icon btn_icon10';
		document.getElementById("satellite").parentNode.className=null;
	}
//	else{
//		if( window.mapObj )
//		{
//			window.LAYER_SATELLITE.setVisible(true);
//			window.LAYER_VECTOR.setVisible(false);
//		}
//		document.getElementById("vector").className='icon btn_icon09';
//		document.getElementById("vector").parentNode.className=null;
//		document.getElementById("satellite").className='icon_on btn_icon10';
//		document.getElementById("satellite").parentNode.className='on';
//	}
	
};

//--------------------------------------------------;

/**
 * 위성 지도 버튼 click event 설정
 * @function
 */
window.UI.MapChange.addEvent_mClick_Satellite = function()
{
	window.console.log( "---------- window.UI.MapChange.addEvent_mClick_Satellite():void" );
	$( window.UI.MapChange.SELECTOR_SATELLITE ).bind( "click", window.UI.MapChange.evt_mClick_Satellite );
};

/**
 * 위성 지도 버튼 click event 해제
 * @function
 */
window.UI.MapChange.removeEvent_mClick_Satellite = function()
{
	window.console.log( "---------- window.UI.MapChange.removeEvent_mClick_Satellite():void" );
	$( window.UI.MapChange.SELECTOR_SATELLITE ).unbind( "click", window.UI.MapChange.evt_mClick_Satellite );
};

/**
 * 위성 지도 버튼 click event 발생 시
 * @function
 * @param {MouseEvent} e
 */
window.UI.MapChange.evt_mClick_Satellite = function( e )
{
	window.console.log( "---------- window.UI.MapChange.evt_mClick_Satellite():void" );

	var o = window.UI.MapChange;
	
	if(document.getElementById("satellite").className=='icon btn_icon10'){		
		if( window.mapObj )
		{
			window.LAYER_SATELLITE.setVisible(true);
			window.LAYER_VECTOR.setVisible(false);
		}
		document.getElementById("satellite").className='icon_on btn_icon10';
		document.getElementById("satellite").parentNode.className='on';
		document.getElementById("vector").className='icon btn_icon09';
		document.getElementById("vector").parentNode.className=null;
	}
//	else{
//		if( window.mapObj )
//		{
//			window.LAYER_SATELLITE.setVisible(false);
//			window.LAYER_VECTOR.setVisible(true);
//		}
//		document.getElementById("satellite").className='icon btn_icon10';
//		document.getElementById("satellite").parentNode.className=null;
//		document.getElementById("vector").className='icon_on btn_icon09';
//		document.getElementById("vector").parentNode.className='on';
//	}
	
};

//--------------------------------------------------;


//----------------------------------------------------------------------------------------------------;
//FUNCTION;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//GETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;
//SETTER;
//----------------------------------------------------------------------------------------------------;

//----------------------------------------------------------------------------------------------------;