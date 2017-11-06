package me.theeninja.stocklookuptool.stock;

/**
 * Represents a StockExchange that is supported by StockLookupTool.
 *
 * @author TheeNinja
 */
public enum StockExchange {

    NASDAQ("NASDAQ"),
    NYSE("NYSE"),
    AMEX("AMEX");

    /**
     * The String representation of the StockExchange.
     */
    private String identifier;

    /**
     * Constructs a stockexchange with a given String identifier.
     *
     * @param identifier the string representation of the stock exchange.
     */
    StockExchange(String identifier) {
        this.identifier = identifier;
    }

    /**
     * @return the identifier correlating to the stock exchange
     */
    public String getIdentifier() {
        return identifier;
    }
}
