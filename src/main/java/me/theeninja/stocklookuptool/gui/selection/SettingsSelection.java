package me.theeninja.stocklookuptool.gui.selection;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import me.theeninja.stocklookuptool.gui.selection.settings.ControlPanelController;

public class SettingsSelection implements Selection {

    private static SettingsSelection instance;

    /**
     * @return the {@link Node} to be placed in the left part of the {@link BorderPane}
     */
    @Override
    public Node getLeft() {
        return ControlPanelController.getInstance().getCorrelatingView();
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

    public static SettingsSelection getInstance() {
        if (instance == null) {
            instance = new SettingsSelection();
        }
        return instance;
    }
}
