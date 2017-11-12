package me.theeninja.stocklookuptool.gui.selection;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
import me.theeninja.stocklookuptool.response.QueryResponse;
import me.theeninja.stocklookuptool.response.Quote;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class StockSearchSelectionController implements Selection {

    private static StockSearchSelectionController stockSearchSelectionController = new StockSearchSelectionController();

    public static StockSearchSelectionController getInstance() {
        return stockSearchSelectionController;
    }

    private Logger logger = Logger.getLogger(StockSearchSelectionController.class.getSimpleName());

    @FXML public Label favoriteStocksLabel;
    @FXML public TextField addFavoriteStockInput;
    @FXML public VBox verticalStockList;
    @FXML public HBox addFavoriteStockInputContainer;
    @FXML public GridPane stockInformationCenter;

    @FXML
    public void handleFavoriteStockInput(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {

            String stockSymbol = addFavoriteStockInput.getText();

            if (StockLookupTool.userFavoriteStocks.contains(stockSymbol)) {
                return;
            }

            QueryManager queryManager = new QueryManager(stockSymbol);
            QueryResponse queryData = queryManager.query();
            Quote stock = queryData.getQuoteResponse().getQuote().get(0);

            System.out.println(stock.getLongName());

            Text stockIdentifier = new Text(addFavoriteStockInput.getText().toUpperCase());
            stockIdentifier.setFont(Font.font(18));
            stockIdentifier.getStyleClass().clear();
            stockIdentifier.getStyleClass().add("favoriteStock");

            addFavoriteStockInput.setText("");

            Map<Label, Integer[]> labelMap = new HashMap<>();

            labelMap.put(new Label(                        stock.getLongName()),               new Integer[] {0, 0, 2, 1}); // Company Name
            labelMap.put(new Label("Ask Price: "      + stock.getAsk()),                new Integer[] {0, 1, 1, 1}); // Ask Price
            labelMap.put(new Label("Open: "           + stock.getRegularMarketOpen()),               new Integer[] {0, 2, 1, 1}); // Open Price
            labelMap.put(new Label("Close: "          + stock.getRegularMarketPreviousClose()),      new Integer[] {1, 2, 1, 1}); // Close Price
            labelMap.put(new Label("Percent Change: " + stock.getPostMarketChangePercent()),      new Integer[] {1, 1, 1, 1}); // Percent Change
            labelMap.put(new Label("Day Volume: "     + stock.getAverageDailyVolume3Month()),             new Integer[] {0, 3, 2, 1}); // Day Volume
            labelMap.put(new Label("Average Volume: " + stock.getRegularMarketVolume()), new Integer[] {0, 4, 2, 1}); // Average Volume

            for (Label label : labelMap.keySet()) {
                label.getStyleClass().clear();
                label.getStyleClass().add("favoriteStockInformationLabel");
            }

            stockIdentifier.setOnMouseEntered(mouseEvent -> {
                for (Map.Entry<Label, Integer[]> entry : labelMap.entrySet()) {
                    stockInformationCenter.add(entry.getKey(),
                            entry.getValue()[0],  // Column Index
                            entry.getValue()[1],  // Row Index
                            entry.getValue()[2],  // Column Span
                            entry.getValue()[3]); // Row Span
                }
            });

            stockIdentifier.setOnMouseExited(mouseEvent -> {
                for (Label label : labelMap.keySet()) {
                    stockInformationCenter.getChildren().remove(label);
                }
            });

            verticalStockList.getChildren().remove(addFavoriteStockInput);

            HBox stockIdentifierContainer = new HBox();
            stockIdentifierContainer.getChildren().add(stockIdentifier);

            Button stockIdentifierDelete = new Button("X");
            stockIdentifierDelete.getStyleClass().add("stockIdentifierDelete");
            stockIdentifierDelete.setOnAction(actionEvent -> {
                verticalStockList.getChildren().remove(stockIdentifierDelete.getParent());
            });

            stockIdentifierContainer.getStyleClass().add("stockIdentifierContainer");

            stockIdentifierContainer.getChildren().add(stockIdentifierDelete);

            verticalStockList.getChildren().add(stockIdentifierContainer);
            verticalStockList.getChildren().add(addFavoriteStockInput);

            ConfigManager.getInstance().addFavoriteStockSymbol(stockIdentifier.getText());
        }
    }

    /**
     * @return the {@link Node} to be placed in the left part of the {@link BorderPane}
     */
    @Override
    public Node getLeft() {
        return verticalStockList;
    }

    /**
     * @return the {@link Node} to be placed in the center part of the {@link BorderPane}
     */
    @Override
    public Node getCenter() {
        return stockInformationCenter;
    }

    /**
     * @return the {@link Node} to be placed in the right part of the {@link BorderPane}
     */
    @Override
    public Node getRight() {
        return null;
    }

    /**
     * @return the {@link Node} to be placed in the bottom part of the {@link BorderPane}
     */
    @Override
    public Node getBottom() {
        return null;
    }
}