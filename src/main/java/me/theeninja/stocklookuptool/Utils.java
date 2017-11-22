package me.theeninja.stocklookuptool;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import me.theeninja.stocklookuptool.gui.SingleViewController;

import java.io.IOException;

/**
 * Provides helper methods that assist in the functionality of this application.
 *
 * @author TheeNinja
 */
public final class Utils {

    /**
     * Generates a background of the given color.
     *
     * @param color
     * @return A background of the color specified.
     */
    public static Background generateBackgroundOfColor(Color color) {
        return new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));

    }

    public static <T extends SingleViewController> T getControllerInstance(String fxmlFile) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Utils.class.getResource(fxmlFile));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fxmlLoader.getController();
    }


    public static void setView() {

    }

    public static final String BASE_CSS_DIRECTORY = "/css/";
    public static final String BASE_FXML_DIRECTORY = "/fxml/";
    public static final String FXML_SETTINGS_DIRECTORY = BASE_FXML_DIRECTORY + "settings/";
    public static final String FXML_STOCKSEARCH_DIRECTORY = BASE_FXML_DIRECTORY + "stocksearch/";
    public static final String FXML_SETTINGS_SECTIONS_DIRECTORY = FXML_SETTINGS_DIRECTORY + "sections/";
}
