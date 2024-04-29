package ru.netology.burakov.ReadGameCSVSpring.repository;

import org.springframework.stereotype.Repository;
import ru.netology.burakov.ReadGameCSVSpring.entity.Game;

import java.util.HashMap;
import java.util.Map;

@Repository
public class GameRepository {
    private final Map<Integer, Game> gameMap = new HashMap<>();

    public void addGameMap(int id, Game game) {
        gameMap.put(id, game);
    }
}
