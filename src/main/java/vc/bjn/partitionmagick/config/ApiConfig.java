package vc.bjn.partitionmagick.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class ApiConfig extends ResourceConfig {

	public ApiConfig(){
//		register(RequestContextFilter.class);
		super(SseFeature.class, JacksonFeature.class);

		packages("vc.bjn.partitionmagick.api.resource");
	}

}
