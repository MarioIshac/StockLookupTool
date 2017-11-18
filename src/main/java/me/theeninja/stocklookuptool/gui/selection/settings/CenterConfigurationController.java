package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.DependentController;

public class CenterConfigurationController implements DependentController<FlowPane> {
    private static ControlPanelController fxmlInstance;
    public FlowPane centerConfigurationDisplay;

    public static ControlPanelController getInstance() {
        if (fxmlInstance == null) {
            Utils.getControllerInstance("/fxml/settings/sections/technical_analysis/center_configuration.fxml");
        }
        return fxmlInstance;
    }

    @Override
    public FlowPane getCorrelatingView() {
        return centerConfigurationDisplay;
    }

    @Override
    public void clearDisplay() {

    }

    @Override
    public void updateDisplay(FlowPane flowPane) {

    }
}
