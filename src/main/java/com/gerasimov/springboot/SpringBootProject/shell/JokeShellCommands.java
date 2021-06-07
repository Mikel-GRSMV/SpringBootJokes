package com.gerasimov.springboot.SpringBootProject.shell;

import com.gerasimov.springboot.SpringBootProject.data.JokeDataService;
import com.gerasimov.springboot.SpringBootProject.web.JokeService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
public class JokeShellCommands {

    private final JokeService jokeService; //добавили сервис с шутками
    private final JokeDataService jokeDataService; //добавили сервис с работай данными

//    public JokeShellCommands(JokeService jokeService) { //инициализируем(активируем) через конструктор
//        this.jokeService = jokeService;
//    }

    public JokeShellCommands(JokeService jokeService, JokeDataService jokeDataService) { //инициализируем(активируем) через конструктор
        this.jokeService = jokeService;
        this.jokeDataService = jokeDataService;
    }

    private String lastJoke; //будем писать в это поле

    @ShellMethod("Get joke about Chuck Norris.")
    public String joke() {
        lastJoke = jokeService.getJoke(); //определим переменную joke куда мы будем класть нашу переменную
        return lastJoke;
    }

    @ShellMethod("Save joke in database.")
    public String saveJoke() {
        if (lastJoke == null) {
            return "Сначала загрузите шутку";
        } else {
            jokeDataService.save(lastJoke);
            return "Шутка сохранена.";
        }
    }

    @ShellMethod("List of all saved Joke")
    public String showSavedJoke() {
        return jokeDataService.findAll().stream()
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
