package me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis;

import javafx.fxml.FXML;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;
import me.theeninja.stocklookuptool.gui.selection.Selection;
import me.theeninja.stocklookuptool.gui.selection.settings.CenterConfigurationController;
import me.theeninja.stocklookuptool.gui.selection.settings.SettingSection;

public class TechnicalAnalysisSectionController implements SingleViewController<FlowPane> {
    private static TechnicalAnalysisSectionController fxmlInstance;

    public static TechnicalAnalysisSectionController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "technical_analysis/technical_analysis_section.fxml");
        }
        return fxmlInstance;
    }

    @FXML
    public FlowPane technicalAnalysisRerouter;

    @Override
    public FlowPane getCorrelatingView() {
        return technicalAnalysisRerouter;
    }

    @FXML
    public void handleWeightSelection() {
        CenterConfigurationController.getInstance().updateDisplay(SettingSection.WEIGHT);
    }
}