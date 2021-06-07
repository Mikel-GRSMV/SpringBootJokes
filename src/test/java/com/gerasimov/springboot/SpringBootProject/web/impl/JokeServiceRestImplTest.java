package com.gerasimov.springboot.SpringBootProject.web.impl;

import com.gerasimov.springboot.SpringBootProject.web.JokeService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * тк это отдельно Java-приложение она тоже должна поднимать контекст Spring
 * --> мы обясняем как это делать аннотацией @SpringBootTest
 * аналогично с @SpringBootApplication
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = {
                InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=FALSE",
                ScriptShellApplicationRunner
                        .SPRING_SHELL_SCRIPT_ENABLED + "=FALSE"
        })
class JokeServiceRestImplTest {

    @Autowired //определили поле и чтобы оно появилось ставим аннотацию
    private JokeService jokeService;//мы должны получить бин JokeService

    @Test
    void getJoke() { //проверяем этот метод
        String jokeText = jokeService.getJoke();//сохраняем результат в переменную joke

        Assertions.assertNotNull(jokeText);//проверяем на пустоту

        assertTrue(jokeText.contains("Chuck Norris"));//проверяем на правду есть ли там имя Чака


      //  System.out.println(jokeText);//выведем что получаем от сервиса(так обычно не делают)
    }
}