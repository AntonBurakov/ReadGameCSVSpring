package ru.netology.burakov.ReadGameCSVSpring.repository;

import org.springframework.stereotype.Repository;
import ru.netology.burakov.ReadGameCSVSpring.entity.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GameRepository {
    private final Map<Integer, Game> gameMap = new HashMap<>();

    public void addGameMap(int id, Game game) {
        gameMap.put(id, game);
    }

    public List<Game> getGameByPlatform(String platform) {
        List<Game> gameList = new ArrayList<>();
        String trimGame = platform.trim().toLowerCase();

        for (int i = 1; i < gameMap.size(); i++) {
            Game game = gameMap.get(i);
            String getPlatform = game.getPlatform().trim().toLowerCase();

            if (getPlatform.equals(trimGame)) {
                gameList.add(game);
            }
        }
        return gameList;
    }
}
