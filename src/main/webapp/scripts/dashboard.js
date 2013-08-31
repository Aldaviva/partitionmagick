(function(){
	
	var eventSource;
	eventSource;
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
	}
	
})();