package com.prideTeam.AstonWebSchool.config;

import com.prideTeam.AstonWebSchool.Profiles;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile(Profiles.DEV_PROFILE)
public class DevDBConfig {
    @Bean
    public DataSource h2DataSource(@Value("${h2.username}") String dbUser, @Value("${h2.driver-class-name}") String dbDriver,
                                   @Value("${h2.url}") String dbUrl, @Value("${h2.password}") String dbPassword) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        dataSource.setUrl(dbUrl);
        dataSource.setDriverClassName(dbDriver);
        return dataSource;
    }
}
