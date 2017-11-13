package me.theeninja.stocklookuptool.gui.selection.stocksearch;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.theeninja.stocklookuptool.StockLookupTool;
import me.theeninja.stocklookuptool.config.ConfigManager;
import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.QueryResponse;
import me.theeninja.stocklookuptool.response.Quote;

import java.io.IOException;

public class FavoriteStocksSidebarController {

    // Inherited from favorite_stocks_sidebar.fxml
    @FXML
    public Label favoriteStocksLabel;
    @FXML
    public TextField addFavoriteStockInput;
    @FXML
    public VBox verticalStockList;
    @FXML
    public HBox addFavoriteStockInputContainer;

    private static FavoriteStocksSidebarController fxmlInstance;

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

            stockIdentifier.setOnMouseEntered(mouseEvent -> {
                StockInformationCenterController.getInstance().setDisplay(stock);
            });

            stockIdentifier.setOnMouseExited(mouseEvent -> {
                StockInformationCenterController.getInstance().clearDisplay();
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

    public static FavoriteStocksSidebarController getInstance() {
        if (fxmlInstance == null) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(FavoriteStocksSidebarController.class.getResource("/fxml/stocksearch/favorite_stocks_sidebar.fxml"));
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
