package com.gerasimov.springboot.SpringBootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
    }

    @Bean
    public RestTemplate getResTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void createJokesTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS jokes (joke text)");

    }
}
