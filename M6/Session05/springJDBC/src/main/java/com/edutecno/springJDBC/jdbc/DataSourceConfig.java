package com.edutecno.springJDBC.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	DataSource getDataSource() {
		HikariConfig dataSource = new HikariConfig();
		dataSource.setJdbcUrl(System.getenv("DB_URL"));
		dataSource.setMaximumPoolSize(20);
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUsername(System.getenv("DB_USER"));
		dataSource.setPassword(System.getenv("DB_PASS"));
		return new HikariDataSource(dataSource);
	}
}
