package vc.bjn.partitionmagick.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ImportResource("classpath:META-INF/spring/context-property-placeholder.xml")
@ComponentScan("vc.bjn.partitionmagick")
@EnableScheduling
public class ApplicationConfig {

}
