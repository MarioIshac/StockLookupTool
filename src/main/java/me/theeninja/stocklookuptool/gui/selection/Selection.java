package me.theeninja.stocklookuptool.gui.selection;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * This interface defines what a selected view (Stock Search, News or Settings)
 * must provide in order to be efficiently rendered by the
 * StockLookupToolApplicationController.
 */
public interface Selection {
    /**
     * @return the {@link Node} to be placed in the left part of the {@link BorderPane}
     */
    Node getLeft();

    /**
     * @return the {@link Node} to be placed in the center part of the {@link BorderPane}
     */
    Node getCenter();

    /**
     * @return the {@link Node} to be placed in the right part of the {@link BorderPane}
     */
    Node getRight();

    /**
     * @return the {@link Node} to be placed in the bottom part of the {@link BorderPane}
     */
    Node getBottom();
}
