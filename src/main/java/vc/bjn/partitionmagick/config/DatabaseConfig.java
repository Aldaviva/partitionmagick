package vc.bjn.partitionmagick.config;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = ApplicationConfig.PACKAGE_SCAN)
public class DatabaseConfig {

	@Value("${db.host}") private String dbHost;
	@Value("${db.port}") private int dbPort;
	@Value("${db.name}") private String dbName;

	@Bean public MongoFactoryBean mongoConnection() {
		final MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();

		mongoFactoryBean.setHost(dbHost);
		mongoFactoryBean.setPort(dbPort);
		final MongoOptions mongoOptions = new MongoOptions();
		mongoOptions.autoConnectRetry = true;
		mongoOptions.j = true;
		mongoFactoryBean.setMongoOptions(mongoOptions);

		return mongoFactoryBean;
	}

	@Bean public MongoDbFactory mongoDbFactory(final Mongo mongoConnection) {
		return new SimpleMongoDbFactory(mongoConnection, dbName);
	}

	@Bean public MongoTemplate mongoTemplate(final MongoDbFactory mongoDbFactory) {
		return new MongoTemplate(mongoDbFactory);
	}
}
