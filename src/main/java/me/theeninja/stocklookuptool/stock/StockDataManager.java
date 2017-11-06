package me.theeninja.stocklookuptool.stock;

import me.theeninja.stocklookuptool.query.QueryManager;
import me.theeninja.stocklookuptool.response.ResponseManager;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<String                /* Symbol */,
        ResponseManager.Quote /* Associated Quote */> data = new HashMap<>();

    public void refreshAll() {
        for (String symbol : data.keySet()) {
            this.refresh(symbol);
        }
    }

    /**
     * @param symbol The symbol associated with the quote to be refreshed.
     */
    public void refresh(String symbol) {
        ResponseManager.Quote updatedQuote = QueryManager.query(symbol).getQuery().getResults().getJSONQuote().toQuote();
        data.put(symbol, updatedQuote);
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
