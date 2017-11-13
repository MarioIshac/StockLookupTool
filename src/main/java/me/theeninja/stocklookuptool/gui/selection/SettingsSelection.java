package me.theeninja.stocklookuptool.gui.selection;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class SettingsSelection implements Selection {
    /**
     * @return the {@link Node} to be placed in the left part of the {@link BorderPane}
     */
    @Override
    public Node getLeft() {
        return null;
    }

    /**
     * @return the {@link Node} to be placed in the center part of the {@link BorderPane}
     */
    @Override
    public Node getCenter() {
        return null;
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
