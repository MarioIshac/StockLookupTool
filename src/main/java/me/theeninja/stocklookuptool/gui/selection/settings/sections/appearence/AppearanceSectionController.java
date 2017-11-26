package me.theeninja.stocklookuptool.gui.selection.settings.sections.appearence;

import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis.TechnicalAnalysisSectionController;

public class AppearanceSectionController implements SingleViewController<FlowPane> {
    private static AppearanceSectionController fxmlInstance;

    public static AppearanceSectionController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "appearance/appearance_section.fxml");
            System.out.println(fxmlInstance.getClass().getSimpleName() + ": " + fxmlInstance.getCorrelatingView().getChildrenUnmodifiable().size());
        }
        return fxmlInstance;
    }


    public FlowPane appearanceSectionGuide;

    @Override
    public FlowPane getCorrelatingView() {
        return appearanceSectionGuide;
    }
}
