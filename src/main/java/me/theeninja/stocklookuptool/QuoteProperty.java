package me.theeninja.stocklookuptool;

/**
 * An enum holding the various parts of a quote used for
 * specifying the properties to retrieve of a quote.
 *
 * @author TheeNinja
 */
public enum QuoteProperty {
    /**
     * The QuoteProperty All, representing all quote properties
     * combined into one specification.
     */
    All(Constants.All);

    /**
     * Represents constants that are used in the production
     * of the queries of the application.
     */
    public class Constants {
        public static final String All = "*";
    }

    private String identification;

    /**
     * @param identification The constant string correlating to the quote property.
     */
    QuoteProperty(String identification) {

        this.identification = identification;
    }

    /**
     * @return The identification of the object.
     */
    public String getIdentification() {
        return this.identification;
    }
}
