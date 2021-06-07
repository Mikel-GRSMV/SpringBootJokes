package com.gerasimov.springboot.SpringBootProject.web.impl;

import com.gerasimov.springboot.SpringBootProject.dto.JokeDTO;
import com.gerasimov.springboot.SpringBootProject.web.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeServiceRestImpl implements JokeService {

    private static Logger logger = LoggerFactory.getLogger(JokeServiceRestImpl.class);

    private final RestTemplate restTemplate;
    private static String URL = "http://api.icndb.com/jokes/random";

    public JokeServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getJoke() {
        logger.debug("getJoke - started!"); //сделали небольшую трасировку запиши в дебаг сообщение

        ResponseEntity<JokeDTO> stringResponseEntity =
                restTemplate.getForEntity(URL, JokeDTO.class);

        logger.info(stringResponseEntity.getBody().getValue().getJoke());
        logger.debug("getJoke - finished!"); //сделали небольшую трасировку запиши в дебаг сообщение


        return stringResponseEntity.getBody().getValue().getJoke();
    }
}
