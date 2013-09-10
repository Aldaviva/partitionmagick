package vc.bjn.partitionmagick.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ImportResource("classpath:META-INF/spring/context-property-placeholder.xml")
@ComponentScan(ApplicationConfig.PACKAGE_SCAN)
@EnableScheduling
public class ApplicationConfig {

	public static final String PACKAGE_SCAN = "vc.bjn.partitionmagick";

}
