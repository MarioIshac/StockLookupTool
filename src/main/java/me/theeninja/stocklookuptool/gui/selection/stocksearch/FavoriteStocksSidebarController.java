package me.theeninja.stocklookuptool.gui.selection.stocksearch;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import me.theeninja.stocklookuptool.StockLookupTool;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.config.ConfigManager;
import me.theeninja.stocklookuptool.gui.SingleViewController;
import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.Quote;

import java.util.Map;
import java.util.logging.Logger;

public class FavoriteStocksSidebarController implements SingleViewController<VBox> {

    private final Logger logger = Logger.getLogger(FavoriteStocksSidebarController.class.getSimpleName());

    // Inherited from favorite_stocks_sidebar.fxml
    @FXML public Label favoriteStocksLabel;
    @FXML public TextField addFavoriteStockInput;
    @FXML public VBox verticalStockList;
    @FXML public HBox addFavoriteStockInputContainer;

    private static FavoriteStocksSidebarController fxmlInstance;

    @FXML
    public void handleFavoriteStockInput(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {

            String stockSymbol = addFavoriteStockInput.getText().toUpperCase();

            if (StockLookupTool.userFavoriteStocks.contains(stockSymbol)) {
                return;
            }

            Quote stock = QueryManager.getQuoteOf(stockSymbol);

            System.out.println(stock.getLongName());

            Text stockIdentifier = new Text(stockSymbol);
            stockIdentifier.setFont(Font.font(18));
            stockIdentifier.getStyleClass().clear();
            stockIdentifier.getStyleClass().add("favoriteStock");

            addFavoriteStockInput.setText("");

            Map<Label, Integer[]> generatedLabelMap = StockInformationCenterController.generateLabelMap(stock);

            stockIdentifier.setOnMouseEntered(mouseEvent -> StockInformationCenterController.getInstance().updateDisplay(generatedLabelMap));
            stockIdentifier.setOnMouseExited(mouseEvent -> StockInformationCenterController.getInstance().clearDisplay());

            verticalStockList.getChildren().remove(addFavoriteStockInput);

            HBox stockIdentifierContainer = new HBox();
            stockIdentifierContainer.getChildren().add(stockIdentifier);

            Button stockIdentifierDelete = new Button("X");
            stockIdentifierDelete.getStyleClass().add("stockIdentifierDelete");

            stockIdentifierDelete.setOnAction(actionEvent -> verticalStockList.getChildren().remove(stockIdentifierDelete.getParent()));

            stockIdentifierContainer.getStyleClass().add("stockIdentifierContainer");
            stockIdentifierContainer.getChildren().add(stockIdentifierDelete);

            verticalStockList.getChildren().add(stockIdentifierContainer);
            verticalStockList.getChildren().add(addFavoriteStockInput);

            ConfigManager.getInstance().addFavoriteStockSymbol(stockSymbol);
        }
    }

    public static FavoriteStocksSidebarController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance("/fxml/stocksearch/favorite_stocks_sidebar.fxml");
        }
        return fxmlInstance;
    }

    @Override
    public VBox getCorrelatingView() {
        if (verticalStockList == null) {
            logger.warning("Variable verticalStockList is null. Contact developer.");
        }
        return verticalStockList;
    }
}
