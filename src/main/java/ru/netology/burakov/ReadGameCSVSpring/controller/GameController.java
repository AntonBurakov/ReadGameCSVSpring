package ru.netology.burakov.ReadGameCSVSpring.controller;

import org.springframework.web.bind.annotation.*;
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
}
