package vc.bjn.partitionmagick;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@ImportResource("classpath:META-INF/spring/context-property-placeholder.xml")
@ComponentScan("vc.bjn.partitionmagick")
@EnableMongoRepositories
public class AppConfig {

	@Value("${db.host}") private String dbHost;
	@Value("${db.port}") private int dbPort;
	@Value("${db.name}") private String dbName;

	public @Bean MongoFactoryBean mongoConnection(){
		final MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();

		mongoFactoryBean.setHost(dbHost);
		mongoFactoryBean.setPort(dbPort);
		final MongoOptions mongoOptions = new MongoOptions();
		mongoOptions.autoConnectRetry = true;
		mongoOptions.j = true;
		mongoFactoryBean.setMongoOptions(mongoOptions);

		return mongoFactoryBean;
	}

	public @Bean MongoDbFactory mongoDbFactory(final Mongo mongoConnection){
		return new SimpleMongoDbFactory(mongoConnection, dbName);
	}

	public @Bean MongoTemplate mongoTemplate(final MongoDbFactory mongoDbFactory){
		return new MongoTemplate(mongoDbFactory);
	}

}
