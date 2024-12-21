package com.edutecno.springMVC.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableAutoConfiguration
@Configuration
@ComponentScan("com.edutecno.springMVC")
@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment env;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setUrl(env.getProperty("url"));
		driver.setUsername(env.getProperty("usuario"));
		driver.setPassword(env.getProperty("password"));
		driver.setDriverClassName(env.getProperty("driver"));
		return driver;
	}
}
