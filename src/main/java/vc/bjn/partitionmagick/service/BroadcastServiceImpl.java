package vc.bjn.partitionmagick.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BroadcastServiceImpl implements BroadcastService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BroadcastServiceImpl.class);

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void broadcast(final String message) {
		final BroadcasterFactory broadcasterFactory = BroadcasterFactory.getDefault();
		if(broadcasterFactory != null){
			final Broadcaster rootBroadcaster = broadcasterFactory.lookup("/");
			try {
				rootBroadcaster.broadcast(objectMapper.writeValueAsString(ImmutableMap.of("command", message)));
				LOGGER.debug("broadcast {} to all clients", message);
			} catch (final JsonProcessingException e) {
			}
		}
	}

}
