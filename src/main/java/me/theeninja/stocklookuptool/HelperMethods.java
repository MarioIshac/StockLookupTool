package me.theeninja.stocklookuptool;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * Provides helper methods that assist in the functionality of this application.
 *
 * @author TheeNinja
 */
public class HelperMethods {

    /**
     * Generates a background of the given color.
     *
     * @param color
     * @return A background of the color specified.
     */
    public static Background generateBackgroundOfColor(Color color) {
        return new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));

    }
}
