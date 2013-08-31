package vc.bjn.partitionmagick.api.resource;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint("/events")
public class EventEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventEndpoint.class);
	private static final Set<EventEndpoint> INSTANCES = new CopyOnWriteArraySet<>(); //should probably not be static

	private Session session;

	public EventEndpoint(){
		LOGGER.debug("connection starting...");
	}

	@OnOpen
	public void onOpen(final Session session) {
		this.session = session;
		INSTANCES.add(this);
		LOGGER.debug("client connected");
	}

	@OnClose
	public void onClose(){
		INSTANCES.remove(this);
		LOGGER.debug("client disconnected");
	}

	@OnError
	public void onError(final Throwable err){
		LOGGER.error("client error", err);
	}

	public static void broadcast(final String message){
		for(final EventEndpoint eventEndpoint : INSTANCES){
			try {
				eventEndpoint.session.getBasicRemote().sendText(message);
			} catch (final IOException e){
				INSTANCES.remove(eventEndpoint);
				try {
					eventEndpoint.session.close();
				} catch (final IOException e2){
				}
				LOGGER.debug("cleaning up disconnected client");
			}
		}
		LOGGER.debug("broadcast {}", message);
	}


}
