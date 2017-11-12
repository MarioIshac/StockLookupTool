package me.theeninja.stocklookuptool.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quote {

    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("quoteType")
    @Expose
    private String quoteType;
    @SerializedName("quoteSourceName")
    @Expose
    private String quoteSourceName;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("tradeable")
    @Expose
    private boolean tradeable;
    @SerializedName("shortName")
    @Expose
    private String shortName;
    @SerializedName("financialCurrency")
    @Expose
    private String financialCurrency;
    @SerializedName("averageDailyVolume3Month")
    @Expose
    private long averageDailyVolume3Month;
    @SerializedName("averageDailyVolume10Day")
    @Expose
    private long averageDailyVolume10Day;
    @SerializedName("fiftyTwoWeekLowChange")
    @Expose
    private double fiftyTwoWeekLowChange;
    @SerializedName("fiftyTwoWeekLowChangePercent")
    @Expose
    private double fiftyTwoWeekLowChangePercent;
    @SerializedName("fiftyTwoWeekHighChange")
    @Expose
    private double fiftyTwoWeekHighChange;
    @SerializedName("fiftyTwoWeekHighChangePercent")
    @Expose
    private double fiftyTwoWeekHighChangePercent;
    @SerializedName("fiftyTwoWeekLow")
    @Expose
    private double fiftyTwoWeekLow;
    @SerializedName("fiftyTwoWeekHigh")
    @Expose
    private double fiftyTwoWeekHigh;
    @SerializedName("dividendDate")
    @Expose
    private long dividendDate;
    @SerializedName("earningsTimestamp")
    @Expose
    private long earningsTimestamp;
    @SerializedName("earningsTimestampStart")
    @Expose
    private long earningsTimestampStart;
    @SerializedName("earningsTimestampEnd")
    @Expose
    private long earningsTimestampEnd;
    @SerializedName("trailingAnnualDividendRate")
    @Expose
    private double trailingAnnualDividendRate;
    @SerializedName("trailingPE")
    @Expose
    private double trailingPE;
    @SerializedName("trailingAnnualDividendYield")
    @Expose
    private double trailingAnnualDividendYield;
    @SerializedName("priceHint")
    @Expose
    private long priceHint;
    @SerializedName("postMarketChangePercent")
    @Expose
    private double postMarketChangePercent;
    @SerializedName("postMarketTime")
    @Expose
    private long postMarketTime;
    @SerializedName("postMarketChange")
    @Expose
    private double postMarketChange;
    @SerializedName("regularMarketChangePercent")
    @Expose
    private double regularMarketChangePercent;
    @SerializedName("regularMarketPreviousClose")
    @Expose
    private double regularMarketPreviousClose;
    @SerializedName("bid")
    @Expose
    private double bid;
    @SerializedName("ask")
    @Expose
    private double ask;
    @SerializedName("bidSize")
    @Expose
    private long bidSize;
    @SerializedName("askSize")
    @Expose
    private long askSize;
    @SerializedName("messageBoardId")
    @Expose
    private String messageBoardId;
    @SerializedName("fullExchangeName")
    @Expose
    private String fullExchangeName;
    @SerializedName("longName")
    @Expose
    private String longName;
    @SerializedName("postMarketPrice")
    @Expose
    private double postMarketPrice;
    @SerializedName("regularMarketPrice")
    @Expose
    private double regularMarketPrice;
    @SerializedName("regularMarketTime")
    @Expose
    private long regularMarketTime;
    @SerializedName("regularMarketChange")
    @Expose
    private double regularMarketChange;
    @SerializedName("regularMarketOpen")
    @Expose
    private double regularMarketOpen;
    @SerializedName("regularMarketDayHigh")
    @Expose
    private double regularMarketDayHigh;
    @SerializedName("regularMarketDayLow")
    @Expose
    private double regularMarketDayLow;
    @SerializedName("regularMarketVolume")
    @Expose
    private long regularMarketVolume;
    @SerializedName("market")
    @Expose
    private String market;
    @SerializedName("sharesOutstanding")
    @Expose
    private long sharesOutstanding;
    @SerializedName("bookValue")
    @Expose
    private double bookValue;
    @SerializedName("fiftyDayAverage")
    @Expose
    private double fiftyDayAverage;
    @SerializedName("fiftyDayAverageChange")
    @Expose
    private double fiftyDayAverageChange;
    @SerializedName("fiftyDayAverageChangePercent")
    @Expose
    private double fiftyDayAverageChangePercent;
    @SerializedName("twoHundredDayAverage")
    @Expose
    private double twoHundredDayAverage;
    @SerializedName("twoHundredDayAverageChange")
    @Expose
    private double twoHundredDayAverageChange;
    @SerializedName("twoHundredDayAverageChangePercent")
    @Expose
    private double twoHundredDayAverageChangePercent;
    @SerializedName("priceToBook")
    @Expose
    private double priceToBook;
    @SerializedName("sourceInterval")
    @Expose
    private long sourceInterval;
    @SerializedName("exchangeTimezoneName")
    @Expose
    private String exchangeTimezoneName;
    @SerializedName("exchangeTimezoneShortName")
    @Expose
    private String exchangeTimezoneShortName;
    @SerializedName("gmtOffSetMilliseconds")
    @Expose
    private long gmtOffSetMilliseconds;
    @SerializedName("epsTrailingTwelveMonths")
    @Expose
    private double epsTrailingTwelveMonths;
    @SerializedName("epsForward")
    @Expose
    private double epsForward;
    @SerializedName("exchange")
    @Expose
    private String exchange;
    @SerializedName("marketCap")
    @Expose
    private long marketCap;
    @SerializedName("forwardPE")
    @Expose
    private double forwardPE;
    @SerializedName("exchangeDataDelayedBy")
    @Expose
    private long exchangeDataDelayedBy;
    @SerializedName("marketState")
    @Expose
    private String marketState;
    @SerializedName("symbol")
    @Expose
    private String symbol;

    public String getLanguage() {
        return language;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public String getQuoteSourceName() {
        return quoteSourceName;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFinancialCurrency() {
        return financialCurrency;
    }

    public long getAverageDailyVolume3Month() {
        return averageDailyVolume3Month;
    }

    public long getAverageDailyVolume10Day() {
        return averageDailyVolume10Day;
    }

    public double getFiftyTwoWeekLowChange() {
        return fiftyTwoWeekLowChange;
    }

    public double getFiftyTwoWeekLowChangePercent() {
        return fiftyTwoWeekLowChangePercent;
    }

    public double getFiftyTwoWeekHighChange() {
        return fiftyTwoWeekHighChange;
    }

    public double getFiftyTwoWeekHighChangePercent() {
        return fiftyTwoWeekHighChangePercent;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public long getDividendDate() {
        return dividendDate;
    }

    public long getEarningsTimestamp() {
        return earningsTimestamp;
    }

    public long getEarningsTimestampStart() {
        return earningsTimestampStart;
    }

    public long getEarningsTimestampEnd() {
        return earningsTimestampEnd;
    }

    public double getTrailingAnnualDividendRate() {
        return trailingAnnualDividendRate;
    }

    public double getTrailingPE() {
        return trailingPE;
    }

    public double getTrailingAnnualDividendYield() {
        return trailingAnnualDividendYield;
    }

    public long getPriceHint() {
        return priceHint;
    }

    public double getPostMarketChangePercent() {
        return postMarketChangePercent;
    }

    public long getPostMarketTime() {
        return postMarketTime;
    }

    public double getPostMarketChange() {
        return postMarketChange;
    }

    public double getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public double getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public long getBidSize() {
        return bidSize;
    }

    public long getAskSize() {
        return askSize;
    }

    public String getMessageBoardId() {
        return messageBoardId;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public String getLongName() {
        return longName;
    }

    public double getPostMarketPrice() {
        return postMarketPrice;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public long getRegularMarketTime() {
        return regularMarketTime;
    }

    public double getRegularMarketChange() {
        return regularMarketChange;
    }

    public double getRegularMarketOpen() {
        return regularMarketOpen;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public long getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public String getMarket() {
        return market;
    }

    public long getSharesOutstanding() {
        return sharesOutstanding;
    }

    public double getBookValue() {
        return bookValue;
    }

    public double getFiftyDayAverage() {
        return fiftyDayAverage;
    }

    public double getFiftyDayAverageChange() {
        return fiftyDayAverageChange;
    }

    public double getFiftyDayAverageChangePercent() {
        return fiftyDayAverageChangePercent;
    }

    public double getTwoHundredDayAverage() {
        return twoHundredDayAverage;
    }

    public double getTwoHundredDayAverageChange() {
        return twoHundredDayAverageChange;
    }

    public double getTwoHundredDayAverageChangePercent() {
        return twoHundredDayAverageChangePercent;
    }

    public double getPriceToBook() {
        return priceToBook;
    }

    public long getSourceInterval() {
        return sourceInterval;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public String getExchangeTimezoneShortName() {
        return exchangeTimezoneShortName;
    }

    public long getGmtOffSetMilliseconds() {
        return gmtOffSetMilliseconds;
    }

    public double getEpsTrailingTwelveMonths() {
        return epsTrailingTwelveMonths;
    }

    public double getEpsForward() {
        return epsForward;
    }

    public String getExchange() {
        return exchange;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public double getForwardPE() {
        return forwardPE;
    }

    public long getExchangeDataDelayedBy() {
        return exchangeDataDelayedBy;
    }

    public String getMarketState() {
        return marketState;
    }

    public String getSymbol() {
        return symbol;
    }
}
