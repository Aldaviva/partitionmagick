(function(){
	
	var serverInstance;
	
	var request = {
		url                : window.location.protocol + '//' + window.location.host + window.contextPath + '/events',
		contentType        : 'text/plain',
		logLevel           : 'warn',
		transport          : 'websocket',
		reconnectInterval  : 5000,
		trackMessageLength : true,
		fallbackTransport  : 'long-polling',
		onOpen             : function(){
			console.info("socket connected");
		},
		onClose            : function(){
			console.error("client disconnected");
		},
		onError            : function(){
			console.error("socket disconnected");
		},
		onReconnect        : function(){
			console.warn("reconnecting...");
		},
		onMessage          : function(response){
			var message = JSON.parse(response.responseBody);
			console.log("received message", message);
			
			if(message.command){
				switch(message.command){
					case "update":
						window.location.reload();
						break;
				}
			} else if(message.serverInstance){
				if(serverInstance && (serverInstance != message.serverInstance)){
					window.location.reload(true);
				} else {
					serverInstance = message.serverInstance;
				}
			}
		}
	};
	
	var subsocket = atmosphere.subscribe(request);
	
})();