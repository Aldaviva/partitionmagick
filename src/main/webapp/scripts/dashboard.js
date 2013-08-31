(function(){
	
	var socket = new WebSocket("ws://"+window.location.host+"/partitionmagick/events"); //TODO parameterize
	
	socket.onopen = function(event){
		console.info("socket connected");
	};
	
	socket.onerror = function(err){
		console.error(err);
	};
	
	socket.onmessage = function(event){
		if(event.data == 'update'){
			window.location.reload();
		}
	};
	
})();