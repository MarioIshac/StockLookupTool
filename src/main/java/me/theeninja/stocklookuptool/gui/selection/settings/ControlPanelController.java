package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlPanelController implements Initializable, SingleViewController<VBox> {
    @FXML public VBox settingsControlPanel;
    @FXML public TreeView<String> settingsControlPanelTreeView;

    private static ControlPanelController fxmlInstance;

    Logger logger = Logger.getLogger(ControlPanelController.class.getSimpleName());

    @FXML
    public TreeItem<String> dummyRoot;

    public static ControlPanelController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance("/fxml/settings/settings_control_panel.fxml");
        }
        return fxmlInstance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        logger.info("Initializing control panel with sections and subsections.");

        TreeItem<String> technicalAnalysis = new TreeItem<>("Technical Analysis");

        TreeItem<String> weight = new TreeItem<>("Weight");
        technicalAnalysis.getChildren().add(weight);

        TreeItem<String> appearence = new TreeItem<>("Appearance");
        TreeItem<String> query = new TreeItem<>("Query");

        dummyRoot.getChildren().addAll(technicalAnalysis, appearence, query);

        settingsControlPanelTreeView.setShowRoot(false);
        settingsControlPanelTreeView.setEditable(true);

        CenterConfigurationController.getInstance().clearDisplay();

        settingsControlPanelTreeView.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            logger.log(Level.INFO,
                    "Switching center configuration display to {0} configuration", newValue.getValue());

            SettingSection previousSettingSection;
            if (oldValue != null) {
                previousSettingSection = SettingSection.getEnum(oldValue.getValue());
            }

            SettingSection selectedSettingSection = SettingSection.getEnum(newValue.getValue());
            if (selectedSettingSection != null) {
                selectedSettingSection.present();
            }
        }));
    }

    @Override
    public VBox getCorrelatingView() {
        return settingsControlPanel;
    }
}
