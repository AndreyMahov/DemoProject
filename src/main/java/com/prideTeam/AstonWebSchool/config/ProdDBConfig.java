package com.prideTeam.AstonWebSchool.config;

import com.prideTeam.AstonWebSchool.Profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile(Profiles.PROD_PROFILE)
public class ProdDBConfig {
    @Bean
    public DataSource h2DataSource(@Value("${postgres.username}") String dbUser, @Value("${postgres.driver-class-name}") String dbDriver,
                                   @Value("${postgres.url}") String dbUrl, @Value("${postgres.password}") String dbPassword) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(dbDriver);
        return dataSource;
    }
}