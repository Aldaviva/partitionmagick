package vc.bjn.partitionmagick.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class ApiConfig extends ResourceConfig {

	public ApiConfig(){
		super(JacksonFeature.class);
		register(RequestContextFilter.class);

		packages("vc.bjn.partitionmagick.api.resource");
	}

}
