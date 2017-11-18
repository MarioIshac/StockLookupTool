package me.theeninja.stocklookuptool.gui.selection.settings.sections;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;

public class TechnicalAnalysisSectionController implements SingleViewController {
    @FXML
    public FlowPane technicalAnalysisGuide;

    @Override
    public FlowPane getCorrelatingView() {
        return technicalAnalysisGuide;
    }

    @FXML
    public void handleWeightSelection() {
        Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "technical_analysis/weight_section.fxml");
    }
}