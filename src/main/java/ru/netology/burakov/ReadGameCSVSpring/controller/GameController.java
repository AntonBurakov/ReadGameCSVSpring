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

    @GetMapping("/get/{country}")
    public String getYang(@PathVariable String country) {
        return service.getNameYang(country);
    }

    @GetMapping("/company/{country}/{industry}")
    public List<Forbes> getCompany(@PathVariable String country, @PathVariable String industry) {
        return service.getCompanyFromCountry(country, industry);
    }

    @GetMapping("/range/{fromIndex}/{toIndex}")
    public List<Forbes> getRange(@PathVariable int fromIndex, @PathVariable int toIndex) {
        return service.getRange(fromIndex, toIndex);
    }

    @PostMapping("/post/{id}/{rank}")
    public String editForbes(@PathVariable int id, @PathVariable int rank) {
        return service.editForbes(id, rank);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteForbes(@PathVariable int id) {
        service.deleteForbes(id);
    }
}
