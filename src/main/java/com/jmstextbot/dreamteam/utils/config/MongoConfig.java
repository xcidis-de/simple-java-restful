package com.jmstextbot.dreamteam.utils.config;

import com.jmstextbot.dreamteam.repositories.CustomerDriverRepo;
import com.jmstextbot.dreamteam.repositories.implementations.CustomerDriverRepoImpl;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

@Configuration
public class MongoConfig {
    private final String database = "test";
    private final String host = "localhost";
    private final String password = "simple"; // TODO: security, load off disk
    private final Integer port = 27017;
    private final String username = "Xcidis";
    @Bean

    public MongoDbFactory mongoDbFactory() {
        MongoCredential userCredentials = MongoCredential.createCredential(username, "admin", password.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), userCredentials, MongoClientOptions.builder().build());
        SimpleMongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, database);
        return mongoDbFactory;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
