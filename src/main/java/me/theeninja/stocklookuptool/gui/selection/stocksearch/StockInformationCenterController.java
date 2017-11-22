package me.theeninja.stocklookuptool.gui.selection.stocksearch;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.DependentController;
import me.theeninja.stocklookuptool.response.Quote;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author TheeNinja
 */
public class StockInformationCenterController implements DependentController<GridPane, Map<Label, Integer[]>> {

    /**
     * The logger for {@link StockInformationCenterController}. Used for logging information regarding
     * management of the stock information display.
     */
    private static Logger logger = Logger.getLogger(StockInformationCenterController.class.getSimpleName());

    /**
     * The container of the stock information that is to be presented to the user.
     */
    @FXML public GridPane stockInformationCenter;

    private static StockInformationCenterController fxmlInstance;

    @Override
    public void clearDisplay() {
        logger.info("Clearing display.");
        stockInformationCenter.getChildren().clear();
    }

    @Override
    public void updateDisplay(Map<Label, Integer[]> labelMap) {
        clearDisplay();
        logger.info("Updating display with received labels and their respective placements.");
        for (Map.Entry<Label, Integer[]> entry : labelMap.entrySet()) {
            stockInformationCenter.add(entry.getKey(),
                    entry.getValue()[0],  // Column Index
                    entry.getValue()[1],  // Row Index
                    entry.getValue()[2],  // Column Span
                    entry.getValue()[3]); // Row Span
        }
    }

    static Map<Label, Integer[]> generateLabelMap(Quote stock) {
        logger.info("Generating label map of stock " + stock);

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

        return labelMap;
    }

    public static StockInformationCenterController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance("/fxml/stocksearch/stock_information_center.fxml");
        }
        return fxmlInstance;
    }

    @Override
    public GridPane getCorrelatingView() {
        return stockInformationCenter;
    }
}
