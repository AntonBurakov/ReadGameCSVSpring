package ru.netology.burakov.ReadGameCSVSpring.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.netology.burakov.ReadGameCSVSpring.entity.Game;
import ru.netology.burakov.ReadGameCSVSpring.repository.GameRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class GameService {
    private static final String PATH = "/Игры.csv";

    GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public String getNameOfMostPopularGame(String platform){
        List<Game> gameList = gameRepository.getGameByPlatform(platform);

        String name = null;
        float maxPurchase = 0;
        for (Game game: gameList){
            if(game.getGlobalSales() > maxPurchase){
                maxPurchase = game.getGlobalSales();
                name = game.getName();
            }
        }
        return name;
    }

    public List<Game> getGamesForPeriod(String genre, int fromYear, int toYear){
        return gameRepository.getGameByGenre(genre, fromYear, toYear);
    }

    public List<Game> getGamesByPublisherAndGenre(String publisher, String genre){
        return gameRepository.getGamesByPublisherAndGenre(publisher, genre);
    }

    public String editGame(int id, float naSales, float euSales, float jpSales, float otherSales, float globalSales){
        Game game = gameRepository.getGameById(id);
        float previousNaSales = game.getNaSales();
        float previousEuSales = game.getEuSales();
        float previousJpSales = game.getJpSales();
        float previousOtherSales = game.getOtherSales();
        float previousGlobalSales = game.getGlobalSales();

        game.setNaSales(naSales);
        game.setEuSales(euSales);
        game.setJpSales(jpSales);
        game.setOtherSales(otherSales);
        game.setGlobalSales(globalSales);
        gameRepository.addGameMap(id, game);

        return "Продажи в Америке были: " + String.valueOf(previousNaSales) + ". Стали: " + game.getNaSales() + "\n" +
        "Продажи в Европе были: " + String.valueOf(previousEuSales) + ". Стали: " + game.getEuSales() + "\n" +
        "Продажи в Японии были: " + String.valueOf(previousJpSales) + ". Стали: " + game.getJpSales() + "\n" +
        "Продажи в Остально мире были: " + String.valueOf(previousOtherSales) + ". Стали: " + game.getOtherSales() + "\n" +
        "Продажи во всем мире были: " + String.valueOf(previousGlobalSales) + ". Стали: " + game.getGlobalSales();
    }

    public void deleteGame(int id){
        gameRepository.deleteFromMap(id);
    }
    // данный метод потребовлся для обработки строк, где год NA
    private int parseIntWithNA(String value) {
        return "N/A".equals(value) ? 0 : Integer.parseInt(value);
    }


    // код для получения данных из файла в мапу
    @PostConstruct
    private void readCSV() throws IOException {
        URL resource = GameService.class.getResource(PATH);
        try {
            File file = Paths.get(resource.toURI()).toFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",11);
                if (i >= 1) {
                    int rank = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    String platform = fields[2];
                    int year = parseIntWithNA(fields[3]);
                    String genre = fields[4];
                    String publisher = fields[5];
                    float naSales = Float.parseFloat(fields[6]);
                    float euSales = Float.parseFloat(fields[7]);
                    float jpSales = Float.parseFloat(fields[8]);
                    float otherSales = Float.parseFloat(fields[9]);
                    float globalSales = Float.parseFloat(fields[10]);
                    Game game = new Game(rank, name, platform, year, genre, publisher, naSales, euSales, jpSales, otherSales, globalSales);
                    gameRepository.addGameMap(i, game);
                }
                System.out.println(i + " : " + Arrays.toString(fields));
                i++;
            }
            reader.close();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}


