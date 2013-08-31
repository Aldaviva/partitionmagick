(function(){
	
	var socket = new WebSocket("ws://"+window.location.host+"/partitionmagick/events"); //TODO parameterize
	
	socket.onopen = function(event){
		console.info("socket connected");
	};
	
	socket.onerror = function(err){
		console.error(err);
	};
	
	socket.onmessage = function(event){
		console.log(event.data);
	};
	
	/*var eventSource;
	connect();
	
	function connect(){
		window.es = eventSource = new EventSource('api/events');
		
		eventSource.onmessage = function(event){
			console.log("received event", event.data);
		};
		
		eventSource.onerror = function(err){
			console.error("received error", err);
			setTimeout(connect, 2000);
		};
		
		eventSource.onopen = function(){
			console.info("event source opened");
		};
	}*/
	
})();