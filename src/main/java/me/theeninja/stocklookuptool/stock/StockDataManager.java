package me.theeninja.stocklookuptool.stock;

import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.ResponseManager;

import javax.xml.ws.Response;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    Map<String                /* Symbol */,
        ResponseManager.Quote /* Associated Quote */> data = new HashMap<>();

    public void refreshAll() {
        logger.log(Level.INFO, "Refreshing all symbol <-> stock entries.");
        for (String symbol : data.keySet()) {
            this.refresh(symbol);
        }
    }

    /**
     * @param symbol The symbol associated with the quote to be refreshed.
     */
    public void refresh(String symbol) {
        logger.log(Level.INFO, "Refreshing symbol: {0} <-> stock entry.", symbol);

        QueryManager queryManager = new QueryManager(symbol);
        ResponseManager.Data dataResponse = queryManager.query();

        if (dataResponse != null) {
            logger.log(Level.FINEST, "Applying successfully received response for symbol: {0} to symbol: {0}", symbol);
            data.put(symbol, dataResponse.getQuery().getResults().getJSONQuote().toQuote());
        }
        else {
            logger.log(Level.WARNING, "Response received for symbol: {0} is null. Aborting refresh operation.");
        }

    }

    /**
     * @param symbol The symbol associated with the quote to be fetched.
     * @return The quote associated with the provided symbol.
     */
    public ResponseManager.Quote fetch(String symbol) {
        return data.get(symbol);
    }

    /**
     * @param symbols The list of symbols to be accounted for in the data.
     */
    public StockDataManager(List<String> symbols) {
        System.out.println(symbols);
        for (String symbol : symbols) {
            this.refresh(symbol);
        }
    }

    public StockDataManager(StockExchange stockExchange) {
        this(QueryManager.getAllSymbols(stockExchange.getIdentifier()));
    }
}
