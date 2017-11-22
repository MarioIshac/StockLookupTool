package me.theeninja.stocklookuptool.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import me.theeninja.stocklookuptool.gui.selection.Selection;
import me.theeninja.stocklookuptool.gui.selection.SettingsSelection;
import me.theeninja.stocklookuptool.gui.selection.StockSearchSelection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StockLookupToolApplicationController {

    private static StockLookupToolApplicationController stockLookupToolApplicationController = new StockLookupToolApplicationController();

    private Logger logger = Logger.getLogger(StockLookupToolApplicationController.class.getSimpleName());

    @FXML public Label stockSearchLabel;
    @FXML public Label newsLabel;
    @FXML public Label settings;

    @FXML public BorderPane borderPane;
    @FXML public HBox topApplicationNavigation;

    @FXML
    public void handleSettingsSelection() {
        logger.info("Setting GUI View to Settings");;
        setView(SettingsSelection.getInstance());
    }

    @FXML
    public void handleStockSearchSelection() {
        logger.info("Setting GUI View to Stock Search");
        setView(StockSearchSelection.getInstance());
    }

    private void setView(Selection selection) {
        borderPane.setLeft(selection.getLeft());
        borderPane.setCenter(selection.getCenter());
        borderPane.setRight(selection.getRight());
        borderPane.setBottom(selection.getBottom());
    }

    public static StockLookupToolApplicationController getInstance() {
        return stockLookupToolApplicationController;
    }
}
