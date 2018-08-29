var demoVideoButton = document.getElementById('demoVideoButton');
var demoVideoModal = document.getElementById('demoVideoModal');
var closeDemoModal = document.getElementsByClassName("close")[0];
var captionText = document.getElementById('caption');
var player;
demoVideoButton.onclick = function() {
	$(demoVideo)
			.attr(
					'src',
					'https://www.youtube-nocookie.com/embed/g4Hbz2jLxvQ?enablejsapi=1&version=3&playerapiid=ytplayer&autoplay=1&origin=http://example.com&controls=1&cc_load_policy=1&color=white&hl=fr&iv_load_policy=3&modestbranding=1&rel=0&showinfo=0&autohide=1&theme=light');
	demoVideoModal.style.display = 'block';
	captionText.innerHTML = "Vidéo de démo";
	var screenWidth = window.matchMedia("(max-width: 700px)")
	resizeVideo(screenWidth) // Call listener function at run time
	screenWidth.addListener(resizeVideo) // Attach listener function on state changes
	//This code loads the IFrame Player API code asynchronously.
	$.getScript("https://www.youtube.com/iframe_api");
}
function resizeVideo(screenWidth) {
	if (screenWidth.matches) {
		$(demoVideo).attr('height', 140);
		$(demoVideo).attr('width', 320);
	} else {
		$(demoVideo).attr('height', 300);
		$(demoVideo).attr('width', 640);
	}
}

window.onYouTubeIframeAPIReady = function() {
	//This function creates a YouTube player after the API code downloads.
	player = new YT.Player('demoVideo', {
		events : {
			/*'onReady': onPlayerReady,
			'onStateChange': onPlayerStateChange*/
			'onReady' : function() {
				console.log('ready');
			},
			'onStateChange' : function() {
				doStateChange();
				console.log('state change', arguments)
			}
		}
	});
}

closeDemoModal.onclick = function() {
	demoVideoModal.style.display = "none";
	$(demoVideo).attr('src', '');

}

function onPlayerReady(event) {
	event.target.playVideo();
}

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.
var done = false;
function onPlayerStateChange(event) {
	if (event.data == YT.PlayerState.PLAYING && !done) {
		setTimeout(stopVideo, 6000);
		done = true;
	}
}
function stopVideo() {
	player.stopVideo();
}