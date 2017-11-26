package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.DependentController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis.TechnicalAnalysisSectionController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * JavaFX Controller for the configuration located in the center of the settings view selection.
 * This center configuration houses different configuration options depending on the {@link SettingSection} selected.
 * Hence, there is a distinct state of the center configuration for each section and subsection of the
 * {@link TreeView}.
 *
 * @author TheeNinja
 */
public class CenterConfigurationController implements DependentController<AnchorPane, SettingSection> {

    private Logger logger = Logger.getLogger(CenterConfigurationController.class.getSimpleName());
    /**
     * Represents the instance associated with the class. Used for communicating with the center
     * configuration's display that this class controls.
     */
    private static CenterConfigurationController fxmlInstance;

    /**
     * Represents the display that houses all the nodes used to communicate configuration options
     * to the application user.
     */
    @FXML public AnchorPane centerConfigurationDisplay;

    /**
     *
     * @return An instance of this controller correlating to its fxml file.
     */
    public static CenterConfigurationController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_DIRECTORY + "center_configuration.fxml");
        }
        return fxmlInstance;
    }

    @Override
    public AnchorPane getCorrelatingView() {
        return centerConfigurationDisplay;
    }

    @Override
    public void clearDisplay() {
        this.getCorrelatingView().getChildren().clear();
    }

    @Override
    public void updateDisplay(SettingSection settingSection) {
        this.clearDisplay();
        this.getCorrelatingView().getChildren().add(settingSection.getCorrelatedFXMLController().getCorrelatingView());
    }
}