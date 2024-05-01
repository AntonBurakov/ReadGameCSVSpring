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
        String trimPlatform = platform.trim().toLowerCase();

        for (int i = 1; i < gameMap.size(); i++) {
            Game game = gameMap.get(i);
            String getPlatform = game.getPlatform().trim().toLowerCase();

            if (getPlatform.equals(trimPlatform)) {
                gameList.add(game);
            }
        }
        return gameList;
    }

    public List<Game> getGameByGenre(String genre, int fromYear, int toYear) {
        List<Game> gameList = new ArrayList<>();
        String trimGenre = genre.trim().toLowerCase();

        for (int i = 1; i < gameMap.size(); i++) {
            Game game = gameMap.get(i);
            String getGenre = game.getGenre().trim().toLowerCase();
            int getYear = game.getYear();

            if (getGenre.equals(trimGenre) && getYear >= fromYear && getYear <= toYear) {
                gameList.add(game);
            }
        }
        return gameList;
    }

    public List<Game> getGamesByPublisherAndGenre(String publisher, String genre) {
        List<Game> gameList = new ArrayList<>();
        String trimPublisher = publisher.trim().toLowerCase();
        String trimGenre = genre.trim().toLowerCase();

        for (int i = 1; i < gameMap.size(); i++) {
            Game game = gameMap.get(i);
            String getPublisher = game.getPublisher().trim().toLowerCase();
            String getGenre = game.getGenre().trim().toLowerCase();

            if (getPublisher.equals(trimPublisher) && getGenre.equals(trimGenre)) {
                gameList.add(game);
            }
        }
        return gameList;
    }

    public Game getGameById(int id) {
        return gameMap.get(id);
    }

    public void deleteFromMap(int id){
        gameMap.remove(id);
    }
}
