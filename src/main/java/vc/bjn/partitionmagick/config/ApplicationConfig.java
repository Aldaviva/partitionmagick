package vc.bjn.partitionmagick.config;

import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@ImportResource("classpath:META-INF/spring/context-property-placeholder.xml")
@ComponentScan("vc.bjn.partitionmagick")
@EnableScheduling
public class ApplicationConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationConfig.class);
	private int eventId = 0;

	@Bean(name="eventBroadcaster")
	public SseBroadcaster sseBroadcaster(){
		return new SseBroadcaster();
	}

	@Scheduled(fixedRate=2000)
	public void broadcastEvent(){
		final OutboundEvent event = new OutboundEvent.Builder()
			.data(String.class, "update"+(eventId++))
			.build();
		sseBroadcaster().broadcast(event);
		LOGGER.debug("broadcast event");
	}

}
