package me.theeninja.stocklookuptool.gui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.theeninja.stocklookuptool.StockLookupTool;
import me.theeninja.stocklookuptool.config.ConfigManager;
import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.ResponseManager;
import me.theeninja.stocklookuptool.stock.StockComparisonManager;

import java.util.HashMap;
import java.util.Map;

public class SLTController {

    public static final String EMPTY_TEXT = "";

    @FXML public Label favoriteStocksLabel;
    @FXML public TextField addFavoriteStockInput;
    @FXML public Label stockSearchLabel;
    @FXML public Label newsLabel;
    @FXML public Label settings;

    @FXML public BorderPane borderPane;
    @FXML public VBox verticalStockList;
    @FXML public HBox topApplicationNavigation;
    @FXML public GridPane centerGridPane;

    @FXML
    public void handleFavoriteStockInput(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {

            String stockSymbol = addFavoriteStockInput.getText();

            if (StockLookupTool.userFavoriteStocks.contains(stockSymbol)) {
                return;
            }

            QueryManager queryManager = new QueryManager(stockSymbol);
            ResponseManager.Data queryData = queryManager.query();
            ResponseManager.Quote stock = queryData.getQuery().getResults().getJSONQuote().toQuote();

            System.out.println(stock.getName());

            Text stockIdentifier = new Text(addFavoriteStockInput.getText().toUpperCase());
            addFavoriteStockInput.setText(EMPTY_TEXT);
            stockIdentifier.setFont(new Font(18));

            Map<Label, Integer[]> labelMap = new HashMap<>();

            labelMap.put(new Label(                        StockComparisonManager.toPrint(stock.getName())),               new Integer[] {0, 0, 2, 1}); // Company Name
            labelMap.put(new Label("Ask Price: "      + StockComparisonManager.toPrint(stock.getAsk())),                new Integer[] {0, 1, 1, 1}); // Ask Price
            labelMap.put(new Label("Open: "           + StockComparisonManager.toPrint(stock.getOpen())),               new Integer[] {0, 2, 1, 1}); // Open Price
            labelMap.put(new Label("Close: "          + StockComparisonManager.toPrint(stock.getPreviousClose())),      new Integer[] {1, 2, 1, 1}); // Close Price
            labelMap.put(new Label("Percent Change: " + StockComparisonManager.toPrint(stock.getPercentChange())),      new Integer[] {1, 1, 1, 1}); // Percent Change
            labelMap.put(new Label("Day Volume: "     + StockComparisonManager.toPrint(stock.getVolume())),             new Integer[] {0, 3, 2, 1}); // Day Volume
            labelMap.put(new Label("Average Volume: " + StockComparisonManager.toPrint(stock.getAverageDailyVolume())), new Integer[] {0, 4, 2, 1}); // Average Volume

            // In order to make the UI visually pleasing
            for (Label label : labelMap.keySet()) {
                label.setPadding(new Insets(0, 0, 0, 5));
            }
            stockIdentifier.setOnMouseEntered(mouseEvent -> {
                for (Map.Entry<Label, Integer[]> entry : labelMap.entrySet()) {
                    centerGridPane.add(entry.getKey(),
                            entry.getValue()[0],  // Column Index
                            entry.getValue()[1],  // Row Index
                            entry.getValue()[2],  // Column Span
                            entry.getValue()[3]); // Row Span
                }
            });

            stockIdentifier.setOnMouseExited(mouseEvent -> {
                for (Label label : labelMap.keySet()) {
                    centerGridPane.getChildren().remove(label);
                }
            });

            verticalStockList.getChildren().remove(addFavoriteStockInput);

            verticalStockList.getChildren().add(stockIdentifier);
            verticalStockList.getChildren().add(addFavoriteStockInput);

            ConfigManager.getInstance().addFavoriteStockSymbol(stockIdentifier.getText());
        }
    }

    @FXML
    public void handleStockSearchSelection() {
        borderPane.setLeft(verticalStockList);
    }

    @FXML
    public void handleNewsSelection() {

    }

    @FXML
    public void handleSettingsSelection() {

    }
}
