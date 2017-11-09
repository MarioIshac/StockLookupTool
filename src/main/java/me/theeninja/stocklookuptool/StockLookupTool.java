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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class for the application; responsible for loading the stage.
 *
 * @author TheeNinja
 */
public class StockLookupTool extends Application {

    /**
     *
     */
    public static final Logger logger = Logger.getLogger(StockLookupTool.class.getSimpleName());

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

        logger.log(Level.INFO, "Starting StockLookupTool Application");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/stocklookuptool.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 250, 300);

        stage.setTitle(APPLICATION_TITLE);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();

        /* StockDataManager stockDataManager = new StockDataManager(StockExchange.NASDAQ);
        System.out.println(stockDataManager.fetch("AAON").getYearHigh()); */
    }

    /**
     * Loads previously saved configuration data.
     */
    private void loadConfigurationData() {
        userFavoriteStocks = ConfigManager.getInstance().getFavoriteStockSymbols();
    }

    private static void setUpLogger() {
        logger.setLevel(Level.ALL);
    }
}
