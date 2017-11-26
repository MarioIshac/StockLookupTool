package me.theeninja.stocklookuptool.gui.selection.settings.sections.query;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;

public class QuerySectionController implements SingleViewController<FlowPane> {
    private static QuerySectionController fxmlInstance;

    public static QuerySectionController getInstance() {
        if (fxmlInstance == null) {
            fxmlInstance = Utils.getControllerInstance(Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "query/query_section.fxml");
            System.out.println(fxmlInstance.getClass().getSimpleName() + ": " + fxmlInstance.getCorrelatingView().getChildrenUnmodifiable().size());

        }
        return fxmlInstance;
    }

    @FXML
    public FlowPane queryRerouter;

    @Override
    public FlowPane getCorrelatingView() {
        return queryRerouter;
    }
}
