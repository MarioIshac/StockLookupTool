package me.theeninja.stocklookuptool.gui.selection.stocksearch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import me.theeninja.stocklookuptool.response.Quote;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StockInformationCenterController {

    @FXML public GridPane stockInformationCenter;

    private static StockInformationCenterController fxmlInstance;

    public void clearDisplay() {
        stockInformationCenter.getChildren().clear();
    }

    public void setDisplay(Quote displayedStock) {
        Map<Label, Integer[]> labelMap = new HashMap<>();

        labelMap.put(new Label(                        displayedStock.getLongName()),               new Integer[] {0, 0, 2, 1}); // Company Name
        labelMap.put(new Label("Ask Price: "      + displayedStock.getAsk()),                new Integer[] {0, 1, 1, 1}); // Ask Price
        labelMap.put(new Label("Open: "           + displayedStock.getRegularMarketOpen()),               new Integer[] {0, 2, 1, 1}); // Open Price
        labelMap.put(new Label("Close: "          + displayedStock.getRegularMarketPreviousClose()),      new Integer[] {1, 2, 1, 1}); // Close Price
        labelMap.put(new Label("Percent Change: " + displayedStock.getPostMarketChangePercent()),      new Integer[] {1, 1, 1, 1}); // Percent Change
        labelMap.put(new Label("Day Volume: "     + displayedStock.getAverageDailyVolume3Month()),             new Integer[] {0, 3, 2, 1}); // Day Volume
        labelMap.put(new Label("Average Volume: " + displayedStock.getRegularMarketVolume()), new Integer[] {0, 4, 2, 1}); // Average Volume

        for (Label label : labelMap.keySet()) {
            label.getStyleClass().clear();
            label.getStyleClass().add("favoriteStockInformationLabel");
        }

        for (Map.Entry<Label, Integer[]> entry : labelMap.entrySet()) {
            stockInformationCenter.add(entry.getKey(),
                    entry.getValue()[0],  // Column Index
                    entry.getValue()[1],  // Row Index
                    entry.getValue()[2],  // Column Span
                    entry.getValue()[3]); // Row Span
        }
    }

    public static StockInformationCenterController getInstance() {
        if (fxmlInstance == null) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(StockInformationCenterController.class.getResource("/fxml/stocksearch/stock_information_center.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fxmlInstance = fxmlLoader.getController();
        }
        return fxmlInstance;
    }
}
