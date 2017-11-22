package me.theeninja.stocklookuptool.gui;

import javafx.scene.Node;

/**
 * An controller that supports external-management of its associated display.
 * This includes clearing the display contents and updating them based on a parameter
 * that is unique for each state of the display.
 *
 * @param <ViewType> The type of the correlating view to be managed.
 * @param <UpdateParameterType> The type of the parameter that gives uniqueness to
 *                             each state of the display.
 */
public interface DependentController<ViewType, UpdateParameterType> extends SingleViewController<ViewType> {
    /**
     * Clears the associated display/{@link Node} affiliated with the controller.
     * This is typically done by clearing the children of the affiliated display/{@link Node}
     */
    void clearDisplay();

    /**
     * Updates the contents of the associated display.
     *
     * @param updateParameterType The parameter that gives uniqueness to each state of the display.
     */
    void updateDisplay(UpdateParameterType updateParameterType);
}
