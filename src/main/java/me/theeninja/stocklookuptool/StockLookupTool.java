package me.theeninja.stocklookuptool;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class StockLookupTool extends Application {

    List<String> userFavoriteStocks = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Stock Lookup Tool");

        BorderPane pane = new BorderPane();
        VBox vBox = new VBox();
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox top = new HBox();
        GridPane centerPane = new GridPane();
        pane.setLeft(vBox);
        pane.setCenter(centerPane);

        Label favoriteStocksLabel = new Label("Favorite Stocks");
        favoriteStocksLabel.setFont(new Font(24));
        vBox.getChildren().add(favoriteStocksLabel);

        for (String stockSymbol : userFavoriteStocks) {
            Text stockIdentifier = new Text(stockSymbol);
            stockIdentifier.setFont(new Font(18));
            vBox.getChildren().add(stockIdentifier);
        }

        TextField addFavoriteStock = new TextField();
        addFavoriteStock.setPromptText("Add Stock");
        addFavoriteStock.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                String stockSymbol = addFavoriteStock.getText();
                try {
                    if (userFavoriteStocks.contains(stockSymbol)) {
                        return;
                    }

                    userFavoriteStocks.add(stockSymbol);

                    Stock stock = YahooFinance.get(stockSymbol);

                    Text stockIdentifier = new Text(addFavoriteStock.getText().toUpperCase());
                    addFavoriteStock.setText("");
                    stockIdentifier.setFont(new Font(18));

                    Label companyName = new Label(stock.getName());
                    companyName.setFont(new Font(16));
                    companyName.setPadding(new Insets(0, 0, 0, 5));

                    Label openPrice = new Label("Open: " + stock.getQuote().getOpen().setScale(2, RoundingMode.HALF_UP).toPlainString());
                    openPrice.setPadding(new Insets(0, 0, 0, 5));

                    Label closePrice = new Label("Close: " + stock.getQuote().getPreviousClose().setScale(2, RoundingMode.HALF_UP).toPlainString());
                    closePrice.setPadding(new Insets(0, 0, 0, 5));

                    Label dayVolume = new Label("Day Volume: " + stock.getQuote().getVolume());
                    dayVolume.setPadding(new Insets(0, 0, 0, 5));

                    Label avgVolume = new Label("Avg Volume: " + stock.getQuote().getAvgVolume());
                    avgVolume.setPadding(new Insets(0, 0, 0, 5));

                    stockIdentifier.setOnMouseEntered(mouseEvent -> {
                        centerPane.add(companyName, 0, 0, 2, 1);
                        centerPane.add(openPrice, 0, 1);
                        centerPane.add(closePrice, 1, 1);
                        centerPane.add(dayVolume, 0, 2, 2, 1);
                        centerPane.add(avgVolume, 0, 3, 2, 1);
                    });

                    stockIdentifier.setOnMouseExited(mouseEvent -> {
                        centerPane.getChildren().remove(companyName);
                        centerPane.getChildren().remove(openPrice);
                        centerPane.getChildren().remove(closePrice);
                        centerPane.getChildren().remove(dayVolume);
                        centerPane.getChildren().remove(avgVolume);
                    });

                    vBox.getChildren().remove(addFavoriteStock);
                    vBox.getChildren().add(stockIdentifier);
                    vBox.getChildren().add(addFavoriteStock);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        vBox.getChildren().add(addFavoriteStock);

        vBox.setPadding(new Insets(15, 15, 15, 15));

        stage.setScene(new Scene(pane, 250, 300));
        stage.setFullScreen(true);
        stage.show();
    }
}