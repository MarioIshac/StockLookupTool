package me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;

public class WeightSubsectionController implements SingleViewController<FlowPane> {
    private static WeightSubsectionController fxmlInstance;

    public static WeightSubsectionController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "technical_analysis/weight_subsection.fxml");
            System.out.println(fxmlInstance.getClass().getSimpleName() + ": " + fxmlInstance.getCorrelatingView().getChildrenUnmodifiable().size());
        }
        return fxmlInstance;
    }

    @FXML
    public FlowPane weightSubsectionContainer;

    @Override
    public FlowPane getCorrelatingView() {
        return weightSubsectionContainer;
    }
}
