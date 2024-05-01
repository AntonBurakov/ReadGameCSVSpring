package ru.netology.burakov.ReadGameCSVSpring.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.burakov.ReadGameCSVSpring.entity.Game;
import ru.netology.burakov.ReadGameCSVSpring.service.GameService;

import java.util.List;

@RestController
@RequestMapping
public class GameController {

    GameService service;

    public GameController(GameService service) {
        this.service = service;
    }
    @GetMapping("/get/{platform}")
    public String getMostPopularGame(@PathVariable String platform) {
        return service.getNameOfMostPopularGame(platform);
    }

    @GetMapping("/get/{genre}/{fromYear}/{toYear}")
    public List<Game> getGamesForPeriod(@PathVariable String genre, @PathVariable int fromYear, @PathVariable int toYear) {
        return service.getGamesForPeriod(genre, fromYear, toYear);
    }

    // метод используется для поиска игр опредленного жанра опредленного издателя, может быть использован для фильтрации
    @GetMapping("/get/{publisher}/{genre}")
    public List<Game> getGamesByPublisherAndGenre(@PathVariable String publisher, @PathVariable String genre) {
        return service.getGamesByPublisherAndGenre(publisher, genre);
    }

    @PutMapping("/put/{id}/{naSales}/{euSales}/{jpSales}/{otherSales}/{globalSales}")
    public String editGame(@PathVariable int id, @PathVariable float naSales, @PathVariable float euSales, @PathVariable float jpSales, @PathVariable float otherSales, @PathVariable float globalSales) {
        return service.editGame(id, naSales, euSales, jpSales, otherSales, globalSales);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGame(@PathVariable int id) {
        service.deleteGame(id);
    }
}
