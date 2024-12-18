package com.edutecno.bancoSpring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.edutecno.controlAgricola")
@PropertySource("classpath:database.properties")
public class AppConfig {
	
	@Autowired 
	Environment env;
	
    @Bean
    DataSource datasource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("driver"));
		config.setJdbcUrl(env.getProperty("url"));
		config.setUsername(env.getProperty("dbuser"));
		config.setPassword(env.getProperty("dbpassword"));
		return new HikariDataSource(config);
	}

}
