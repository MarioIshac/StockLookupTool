package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.appearence.AppearanceSectionController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.appearence.FontAndColorSubsectionController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.query.QuerySectionController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis.TechnicalAnalysisSectionController;
import me.theeninja.stocklookuptool.gui.selection.settings.sections.technicalanalysis.WeightSubsectionController;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Optional;
import java.util.logging.Logger;

public enum SettingSection {

    WEIGHT(
            "Weight",
            WeightSubsectionController.getInstance()
    ),

    TECHNICAL_ANALYSIS(
            "Technical Analysis",
            TechnicalAnalysisSectionController.getInstance()
    ),


    FONT_AND_COLOR(
            "Font and Color",
            FontAndColorSubsectionController.getInstance()
    ),

    APPEARANCE(
            "Appearance",
            AppearanceSectionController.getInstance()
    ),

    QUERY(
            "Query",
            QuerySectionController.getInstance()
            // Utils.get(...)
    );

    static Logger logger = Logger.getLogger(SettingSection.class.getSimpleName());

    private final String representation;
    private final SingleViewController<FlowPane> correlatedFXMLController;

    SettingSection(String representation, SingleViewController<FlowPane> correlatedFXMLController) {
        this.representation = representation;
        this.correlatedFXMLController = correlatedFXMLController;
    }

    public String getRepresentation() {
        return representation;
    }

    public SingleViewController<FlowPane> getCorrelatedFXMLController() {
        return correlatedFXMLController;
    }

    public void present() {
        CenterConfigurationController.getInstance().updateDisplay(this);
    }

    public static SettingSection getEnum(String representation) {
        for (SettingSection settingSection : values()) {
            if (settingSection.getRepresentation().equals(representation)) {
                return settingSection;
            }
        }
        return null;
    }
}
