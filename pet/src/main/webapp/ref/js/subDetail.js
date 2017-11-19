// Get the modal
var topModal = document.getElementById('topModal');
// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementsByClassName('myImg')[0];
var modalImg = document.getElementById("img01");
var captionText = document.getElementsByClassName("modalCaption")[0];
var topCaptionText = document.getElementById("topCaption");
var captionWeatherContent = document.getElementsByClassName("captionWeatherContent");
var tmpWidth;
img.onclick = function() {
	//tmpWidth = document.getElementById("pop").style.width;
	//document.getElementById("pop").style.width = "0";
	topModal.style.display = "block";
	modalImg.src = this.src;
	for(var i=0;i<captionWeatherContent.length;i++){
		captionWeatherContent[i].innerHTML = "날씨: "+document.getElementById('weatherContent').innerHTML;
	}
	topCaptionText.innerHTML = captionText.innerHTML;
	// captionText.innerHTML = this.alt;
}
