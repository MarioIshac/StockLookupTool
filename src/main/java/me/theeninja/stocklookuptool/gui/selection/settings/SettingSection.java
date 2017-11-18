package me.theeninja.stocklookuptool.gui.selection.settings;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TreeCell;
import javafx.scene.layout.FlowPane;
import me.theeninja.stocklookuptool.Utils;
import me.theeninja.stocklookuptool.gui.SingleViewController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum SettingSection {

    WEIGHT(
            "Weight",
            "",
            Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "technical_analysis_weight_subsection.fxml"
    ),

    TECHNICAL_ANALYSIS(
            "Technical Analysis",
            "",
            Arrays.<SettingSection>asList(WEIGHT)
    ),


    FONT(
            "Font",
            "",
            Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "appearance_font_subsection.fxml"
    ),

    COLOR(
            "Color",
            "",
            Utils.FXML_SETTINGS_SECTIONS_DIRECTORY + "appearance_color_subsection.fxml"
    ),

    APPEARANCE(
            "Appearance",
            "",
            Arrays.asList(FONT, COLOR)
    ),

    QUERY(
            "Query",
            "",
            Collections.emptyList()
    );

    private static final String BASE_SECTIONS_DIRECTORY = "/fxml/settings/sections/";

    private final String representation;
    private final String description;
    private final String correlatedFxmlFile;
    private final List<SettingSection> subSections;

    SettingSection(String representation, String description, List<SettingSection> subSections) {
        this.representation = representation;
        this.description = description;
        this.subSections = subSections;
        this.correlatedFxmlFile = null;
    }

    SettingSection(String representation, String description, String correlatedFxmlFile) {
        this.representation = representation;
        this.description = description;
        this.subSections = Collections.emptyList();
        this.correlatedFxmlFile = correlatedFxmlFile;
}

    public List<SettingSection> getSubSections() {
        return subSections;
    }

    public String getRepresentation() {
        return representation;
    }

    public String getDescription() {
        return description;
    }

    public void handle(TreeCell<String> treeCell) {
        SettingSection settingSection = valueOf(treeCell.getText());

        // Two scenarios here

        /* 1) the setting section provided an option for expansion, yet was clicked directly.
        In this case, we present a layout inside the right GridPane, similar to the expansion */
        if (settingSection.hasSubSections()) {
            List<SettingSection> subSections = settingSection.getSubSections();
            FlowPane flowPane = new FlowPane();

            // Construct a list of hyper links that each redirect to their associated configuration
            for (SettingSection subSection : subSections) {
                Hyperlink subSectionLink = new Hyperlink(subSection.getRepresentation());

                subSectionLink.setOnAction(actionEvent -> {
                    SingleViewController singleViewController = Utils.getControllerInstance(subSection.getCorrelatedFxmlFile());
                    singleViewController.getCorrelatingView();
                });

                flowPane.getChildren().add(subSectionLink);
            }

            flowPane.setVgap(10);
        }

        /* 2) the setting section provided is a leaf of the TreeView, and thus, should open
        a configuration menu correlating to the section */
        else {

        }
    }

    public boolean hasSubSections() {
        return getSubSections().isEmpty();
    }

    public String getCorrelatedFxmlFile() {
        return correlatedFxmlFile;
    }
}
