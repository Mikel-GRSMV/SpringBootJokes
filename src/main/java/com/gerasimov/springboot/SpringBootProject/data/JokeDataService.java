package com.gerasimov.springboot.SpringBootProject.data;

import java.util.List;

public interface JokeDataService {
    void save(String joke);

    List<String> findAll();
}
