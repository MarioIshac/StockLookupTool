package me.theeninja.stocklookuptool.config;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ConfigManager {
    private static ConfigManager instance = new ConfigManager();
    private final String FILE_NAME = "favorite-stocks.sltconfig";

    public void addFavoriteStockSymbol(String favoriteStockSymbol) {

        Path path = Paths.get(FILE_NAME);

        System.out.println(path);

        if (path.getParent() != null && !Files.isDirectory(path.getParent())) {
            System.out.println("Directory Does not exist");
            try {
                Files.createDirectory(path.getParent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (Files.notExists(path)) {
            System.out.println("Does not exist");
            try {
                Files.createFile(path);
                System.out.println("File created");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            bufferedWriter.write(favoriteStockSymbol);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getFavoriteStockSymbols() {
        try {
            return Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ConfigManager getInstance() {
        return instance;
    }
}
