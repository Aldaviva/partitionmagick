package vc.bjn.partitionmagick.api.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Path("events")
public class EventSource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventSource.class);

	@Autowired private SseBroadcaster sseBroadcaster;

	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput subscribe(){
		LOGGER.debug("new client registering for events.");
		final EventOutput eventOutput = new EventOutput();
		sseBroadcaster.add(eventOutput);
		return eventOutput;
	}
}
