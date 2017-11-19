/**
 * Define a namespace for the application.
 */
window.app = {};
var app = window.app;

//
// Define rotate to north control.
//

/**
 * @constructor
 * @extends {ol.control.Control}
 * @param {Object=}
 *            opt_options Control options.
 */

app.moveMyPosition = function(opt_options) {
	var options = opt_options || {};

	var button = document.createElement('button');
	button.innerHTML = 'ME';

	button.addEventListener('click', getLocation, false);

	var element = document.createElement('div');
	element.className = 'rotate-north ol-unselectable ol-control';
	element.appendChild(button);

	ol.control.Control.call(this, {
		element : element,
		target : options.target
	});

};
ol.inherits(app.moveMyPosition, ol.control.Control);

//
// Create map, giving it a rotate to north control.
//

//지도 Layer 추가;
var layers =
    [
	new ol.layer.Tile({
        source: new ol.source.OSM()
      })
	];

var scaleLineControl = new ol.control.ScaleLine({
target:"scale-line"
});

window.mapObj = new ol.Map({
	  controls: ol.control.defaults({
		    attributionOptions: /** @type {olx.control.AttributionOptions} */ ({
		      collapsible: false
		    })
		  }).extend([new app.moveMyPosition()
		  ]),
		  layers: [
		    new ol.layer.Tile({
		      source: new ol.source.OSM()
		    })
		  ],
		  renderer: exampleNS.getRendererFromQueryString(),
		  target: 'map',
		  view: new ol.View({
		    center: [0, 0],
		    zoom: 2,
		    rotation: 1
		  })
  });

