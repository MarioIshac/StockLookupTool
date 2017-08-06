package me.theeninja.stocklookuptool;

import yahoofinance.Stock;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by mario on 6/15/17.
 */
public class StockSorter {
    public static List<Stock> orderBy(List<Stock> stocks, Function<Stock, BigDecimal> evaluationCriteria) {
        stocks.sort(Comparator.comparing(evaluationCriteria));
        return stocks;
    }

    public static List<Stock> filter(List<Stock> stocks, Predicate<Stock> criteria) {
        return stocks.stream().filter(criteria).collect(Collectors.toList());
    }
}
