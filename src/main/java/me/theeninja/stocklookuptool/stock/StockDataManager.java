package me.theeninja.stocklookuptool.stock;

import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.QueryResponse;
import me.theeninja.stocklookuptool.response.Quote;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A platform for managing the quotes correlating to certain stocks.
 * Caching is utilized in order to satisfy the query limit imposed by the Yahoo
 * Query Console.
 *
 * This data manager is newly instaiated every instance of the entire application.
 * That is, it is not preserved over the course of multiple application launches and
 * must be recontructed on every launch.
 */
public class StockDataManager {
    public static final Logger logger = Logger.getLogger(StockDataManager.class.getSimpleName());

    private Map<String                /* Symbol */,
            Quote /* Associated Quote */> data = new HashMap<>();

    public void refreshAll() {
        logger.log(Level.INFO, "Refreshing all symbol <-> stock entries.");
        data.keySet().forEach(this::refresh);
    }

    /**
     * @param symbol The symbol associated with the quote to be refreshed.
     */
    public void refresh(String symbol) {
        logger.log(Level.INFO, "Refreshing symbol: {0} <-> stock entry.", symbol);
        data.put(symbol, QueryManager.getQuoteOf(symbol));
    }

    /**
     * @param symbol The symbol associated with the quote to be fetched.
     * @return The quote associated with the provided symbol.
     */
    public Quote fetch(String symbol) {
        return data.get(symbol);
    }

    /**
     * @param symbols The list of symbols to be accounted for in the data.
     */
    public StockDataManager(List<String> symbols) {
        symbols.forEach(this::refresh);
    }

    public StockDataManager(StockExchange stockExchange) {
        this(QueryManager.getAllSymbols(stockExchange.getIdentifier()));
    }
}
