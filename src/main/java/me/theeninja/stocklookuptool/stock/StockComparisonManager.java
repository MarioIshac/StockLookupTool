package me.theeninja.stocklookuptool.stock;

import me.theeninja.stocklookuptool.response.Quote;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Manages the functions used for manipulating stock data.
 */
public class StockComparisonManager {
    /**
     * Represents the string displayed when the requested value is null.
     */
    public static final String NOT_AVAILABLE = "/";

    /**
     * Represents the cached stocks used throughout the application for data retrieval.
     */
    public List<Quote> stocks;

    /**
     * Orders the provided stocks by assigning them a value based on the
     * evaluation criteria and then using the value for ranking.
     *
     * @param evaluationCriteria The criteria used to sort the stocks.
     * @return
     */
    public List<Quote> orderBy(Function<Quote, BigDecimal> evaluationCriteria) {
        stocks.sort(Comparator.comparing(evaluationCriteria));
        return stocks;
    }

    public List<Quote> filter(Predicate<Quote> criteria) {
        return stocks.stream().filter(criteria).collect(Collectors.toList());
    }

    public StockComparisonManager(List<Quote> stocks) {
        this.stocks = stocks;
    }
}
