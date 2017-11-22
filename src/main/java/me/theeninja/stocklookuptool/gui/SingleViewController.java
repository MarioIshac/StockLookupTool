package me.theeninja.stocklookuptool.gui;

import javafx.scene.Node;

/**
 * A provider of a single view that is the only responsibility of the controller.
 * @param <ViewType> The type of the correlating view to be managed.
 */
public interface SingleViewController<ViewType> {
    /**
     * @return The display/{@link Node} associated with the controller.
     */
    ViewType getCorrelatingView();

}

// Dirty heads remix