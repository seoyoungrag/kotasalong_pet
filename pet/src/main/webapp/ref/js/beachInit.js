/*
	var latitude, longitude, accuracy;
	function setGeolocation() {
	    var geolocation = window.navigator.geolocation.watchPosition( 
	        function ( position ) {
	            latitude = position.coords.latitude;
	            longitude = position.coords.longitude;
	            accuracy = position.coords.accuracy;
	            innerHtmlLatAndLonAndAcc(latitude, longitude, accuracy);
	        	window.Map.Marker.pointMove(longitude, latitude, 13);
	        }, function () { 
	            error 
	        }, {
	            maximumAge: 250, 
	            enableHighAccuracy: true
	        } 
	    );
	    window.setTimeout( function () {
	            window.navigator.geolocation.clearWatch( geolocation ) 
	        }, 
	        5000 //stop checking after 5 seconds
	    );
	};

	setGeolocation();
*/
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
window.Map.Marker.initBeachData();