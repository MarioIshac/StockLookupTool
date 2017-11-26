package me.theeninja.stocklookuptool.gui.selection.settings.sections.appearence;

import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis.TechnicalAnalysisSectionController;

public class FontAndColorSubsectionController implements SingleViewController<FlowPane> {
    private static FontAndColorSubsectionController fxmlInstance;

    public static FontAndColorSubsectionController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "appearance/font_and_color_subsection.fxml");
            System.out.println(fxmlInstance.getClass().getSimpleName() + ": " + fxmlInstance.getCorrelatingView().getChildrenUnmodifiable().size());

        }
        return fxmlInstance;
    }


    public FlowPane fontAndColorSubsectionController;

    @Override
    public FlowPane getCorrelatingView() {
        return fontAndColorSubsectionController;
    }
}
