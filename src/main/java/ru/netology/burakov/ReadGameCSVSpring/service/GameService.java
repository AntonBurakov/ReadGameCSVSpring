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
import java.util.Scanner;

@Service
public class GameService {
    private static final String PATH = "/Игры.csv";

    GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    // данный метод потребовлся для обработки строк, где год N/A
    private int parseIntWithNA(String value) {
        return "N/A".equals(value) ? 0 : Integer.parseInt(value);
    }


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


