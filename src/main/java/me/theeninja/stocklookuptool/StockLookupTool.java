package me.theeninja.stocklookuptool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.theeninja.stocklookuptool.config.ConfigManager;
import me.theeninja.stocklookuptool.stock.StockDataManager;
import me.theeninja.stocklookuptool.stock.StockExchange;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class for the application; responsible for loading the stage.
 *
 * @author TheeNinja
 */
public class StockLookupTool extends Application {

    /**
     * Represents application-wide name and tital.
     */
    public static final String APPLICATION_TITLE = "Stock Lookup Tool";

    /**
     * Represents the list of stocks that the user has determined to be their favorite.
     */
    public static List<String> userFavoriteStocks = new ArrayList<>();

    /**
     * @param stage
     * @throws Exception when there is an error in loading the scene/stage.
     */
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/stocklookuptool.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 250, 300);

        stage.setTitle(APPLICATION_TITLE);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

        StockDataManager stockDataManager = new StockDataManager(StockExchange.NASDAQ);
        System.out.println(stockDataManager.fetch("AAON").getYearHigh());
    }

    /**
     * Loads previously saved configuration data.
     */
    private void loadConfigurationData() {
        userFavoriteStocks = ConfigManager.getInstance().getFavoriteStockSymbols();
    }
}