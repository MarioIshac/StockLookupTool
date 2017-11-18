package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import me.theeninja.stocklookuptool.gui.SingleViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(ControlPanelController.class.getResource("/fxml/settings/settings_control_panel.fxml"));
            try {
                fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fxmlInstance = fxmlLoader.getController();
        }
        return fxmlInstance;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TreeItem<String> technicalAnalysis = new TreeItem<>("Technical Analysis");

        TreeItem<String> weight = new TreeItem<>("Weight");
        technicalAnalysis.getChildren().add(weight);

        TreeItem<String> appearence = new TreeItem<>("Appearance");
        TreeItem<String> query = new TreeItem<>("Query");

        dummyRoot.getChildren().addAll(technicalAnalysis, appearence, query);

        settingsControlPanelTreeView.setShowRoot(false);
        settingsControlPanelTreeView.setEditable(true);

        settingsControlPanelTreeView.setCellFactory(stringTreeView -> {
            ControlPanelTreeCell controlPanelTreeCell = new ControlPanelTreeCell();
            controlPanelTreeCell.setOnMouseClicked(mouseEvent -> {
                TreeItem<String> treeItem = controlPanelTreeCell.getTreeItem();
                String settingsSectionName = controlPanelTreeCell.getText();


            });
            return controlPanelTreeCell;
        });
    }

    @Override
    public VBox getCorrelatingView() {
        return settingsControlPanel;
    }

    public class ControlPanelTreeCell extends TreeCell<String> {

    }
}
