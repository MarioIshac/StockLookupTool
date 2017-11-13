package me.theeninja.stocklookuptool.gui.selection.stocksearch;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import me.theeninja.stocklookuptool.gui.selection.Selection;

public class StockSearchSelection implements Selection {

    private static StockSearchSelection instance;

    /**
     * @return the {@link Node} to be placed in the left part of the {@link BorderPane}
     */
    @Override
    public Node getLeft() {
        System.out.println(FavoriteStocksSidebarController.getInstance() == null);
        return FavoriteStocksSidebarController.getInstance().verticalStockList;
    }

    /**
     * @return the {@link Node} to be placed in the center part of the {@link BorderPane}
     */
    @Override
    public Node getCenter() {
        return StockInformationCenterController.getInstance().stockInformationCenter;
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

    public static StockSearchSelection getInstance() {
        if (instance == null) {
            instance = new StockSearchSelection();
        }
        return instance;
    }
}