package vc.bjn.partitionmagick.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import java.util.Random;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedService
public class EventEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventEndpoint.class);
	private static final long INSTANCE_ID = new Random().nextLong();
	private static final ObjectMapper objectMapper = new ObjectMapper();

	@Ready
	public void onReady(final AtmosphereResource r) {
		LOGGER.debug("Client connected.");
		try {
			r.write(objectMapper.writeValueAsString(ImmutableMap.of("serverInstance", INSTANCE_ID)));
		} catch (final JsonProcessingException e) {
		}
	}

	@Disconnect
	public void onDisconnect(final AtmosphereResourceEvent event) {
		if (event.isCancelled()) {
			LOGGER.info("Client unexpectedly disconnected");
		} else if (event.isClosedByClient()) {
			LOGGER.info("Client closed the connection");
		}
	}

}
