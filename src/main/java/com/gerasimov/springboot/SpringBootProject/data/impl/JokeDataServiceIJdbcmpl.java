package com.gerasimov.springboot.SpringBootProject.data.impl;

import com.gerasimov.springboot.SpringBootProject.data.JokeDataService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //добавили сервис контекс
public class JokeDataServiceIJdbcmpl implements JokeDataService {

    private final JdbcTemplate jdbcTemplate; //Воспользовались классом JdbcTemplate

    public JokeDataServiceIJdbcmpl(JdbcTemplate jdbcTemplate) { //инициализируем поле через конструктор
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String joke) { //Сохранение
        jdbcTemplate.update("INSERT INTO jokes (joke) VALUES (?)", joke); //Куда вставить, параметр который добавляет jdbcTemplate
    }

    @Override
    public List<String> findAll() { //вывод

        return jdbcTemplate.query("SELECT * FROM jokes",
                (rs, rowNum) -> rs.getString("joke"));//просим пременную rs получить строку из поля joke
    }
}
