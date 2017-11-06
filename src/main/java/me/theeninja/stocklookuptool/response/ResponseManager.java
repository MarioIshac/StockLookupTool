package me.theeninja.stocklookuptool.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Currency;
import java.util.Date;
import java.util.Optional;

public class ResponseManager {

    public static class Data {

        @SerializedName("query")
        @Expose
        private Query query;

        public Query getQuery() {
            return query;
        }
    }

    public static class Query {

        @SerializedName("count")
        @Expose
        private Integer count;

        @SerializedName("created")
        @Expose
        private String created;

        @SerializedName("lang")
        @Expose
        private String lang;

        @SerializedName("results")
        @Expose
        private Results results;

        public int getCount() {
            return count;
        }

        public String getCreated() {
            return created;
        }

        public String getLang() {
            return lang;
        }

        public Results getResults() {
            return results;
        }
    }

    public static class Results {

        @SerializedName("quote")
        @Expose
        private JSONQuote jsonQuote;

        public JSONQuote getJSONQuote() {
            return jsonQuote;
        }
    }

    public static class JSONQuote {

        @SerializedName("Ask")
        @Expose
        private String ask;
        @SerializedName("AverageDailyVolume")
        @Expose
        private String averageDailyVolume;
        @SerializedName("Bid")
        @Expose
        private String bid;
        @SerializedName("AskRealtime")
        @Expose
        private String askRealtime;
        @SerializedName("BidRealtime")
        @Expose
        private String bidRealtime;
        @SerializedName("BookValue")
        @Expose
        private String bookValue;
        @SerializedName("Change_PercentChange")
        @Expose
        private String changePercentChange;
        @SerializedName("Change")
        @Expose
        private String change;
        @SerializedName("Commission")
        @Expose
        private String commission;
        @SerializedName("Currency")
        @Expose
        private String currency;
        @SerializedName("ChangeRealtime")
        @Expose
        private String changeRealtime;
        @SerializedName("AfterHoursChangeRealtime")
        @Expose
        private String afterHoursChangeRealtime;
        @SerializedName("DividendShare")
        @Expose
        private String dividendShare;
        @SerializedName("LastTradeDate")
        @Expose
        private String lastTradeDate;
        @SerializedName("TradeDate")
        @Expose
        private String tradeDate;
        @SerializedName("EarningsShare")
        @Expose
        private String earningsShare;
        @SerializedName("ErrorIndicationreturnedforsymbolchangedinvalid")
        @Expose
        private String errorIndicationreturnedforsymbolchangedinvalid;
        @SerializedName("EPSEstimateCurrentYear")
        @Expose
        private String ePSEstimateCurrentYear;
        @SerializedName("EPSEstimateNextYear")
        @Expose
        private String ePSEstimateNextYear;
        @SerializedName("EPSEstimateNextQuarter")
        @Expose
        private String ePSEstimateNextQuarter;
        @SerializedName("DaysLow")
        @Expose
        private String daysLow;
        @SerializedName("DaysHigh")
        @Expose
        private String daysHigh;
        @SerializedName("YearLow")
        @Expose
        private String yearLow;
        @SerializedName("YearHigh")
        @Expose
        private String yearHigh;
        @SerializedName("HoldingsGainPercent")
        @Expose
        private String holdingsGainPercent;
        @SerializedName("AnnualizedGain")
        @Expose
        private String annualizedGain;
        @SerializedName("HoldingsGain")
        @Expose
        private String holdingsGain;
        @SerializedName("HoldingsGainPercentRealtime")
        @Expose
        private String holdingsGainPercentRealtime;
        @SerializedName("HoldingsGainRealtime")
        @Expose
        private String holdingsGainRealtime;
        @SerializedName("MoreInfo")
        @Expose
        private String moreInfo;
        @SerializedName("OrderBookRealtime")
        @Expose
        private String orderBookRealtime;
        @SerializedName("MarketCapitalization")
        @Expose
        private String marketCapitalization;
        @SerializedName("MarketCapRealtime")
        @Expose
        private String marketCapRealtime;
        @SerializedName("EBITDA")
        @Expose
        private String eBITDA;
        @SerializedName("ChangeFromYearLow")
        @Expose
        private String changeFromYearLow;
        @SerializedName("PercentChangeFromYearLow")
        @Expose
        private String percentChangeFromYearLow;
        @SerializedName("LastTradeRealtimeWithTime")
        @Expose
        private String lastTradeRealtimeWithTime;
        @SerializedName("ChangePercentRealtime")
        @Expose
        private String changePercentRealtime;
        @SerializedName("ChangeFromYearHigh")
        @Expose
        private String changeFromYearHigh;
        @SerializedName("PercebtChangeFromYearHigh")
        @Expose
        private String percebtChangeFromYearHigh;
        @SerializedName("LastTradeWithTime")
        @Expose
        private String lastTradeWithTime;
        @SerializedName("LastTradePriceOnly")
        @Expose
        private String lastTradePriceOnly;
        @SerializedName("HighLimit")
        @Expose
        private String highLimit;
        @SerializedName("LowLimit")
        @Expose
        private String lowLimit;
        @SerializedName("DaysRange")
        @Expose
        private String daysRange;
        @SerializedName("DaysRangeRealtime")
        @Expose
        private String daysRangeRealtime;
        @SerializedName("FiftydayMovingAverage")
        @Expose
        private String fiftydayMovingAverage;
        @SerializedName("TwoHundreddayMovingAverage")
        @Expose
        private String twoHundreddayMovingAverage;
        @SerializedName("ChangeFromTwoHundreddayMovingAverage")
        @Expose
        private String changeFromTwoHundreddayMovingAverage;
        @SerializedName("PercentChangeFromTwoHundreddayMovingAverage")
        @Expose
        private String percentChangeFromTwoHundreddayMovingAverage;
        @SerializedName("ChangeFromFiftydayMovingAverage")
        @Expose
        private String changeFromFiftydayMovingAverage;
        @SerializedName("PercentChangeFromFiftydayMovingAverage")
        @Expose
        private String percentChangeFromFiftydayMovingAverage;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Notes")
        @Expose
        private String notes;
        @SerializedName("Open")
        @Expose
        private String open;
        @SerializedName("PreviousClose")
        @Expose
        private String previousClose;
        @SerializedName("PricePaid")
        @Expose
        private String pricePaid;
        @SerializedName("ChangeinPercent")
        @Expose
        private String changeinPercent;
        @SerializedName("PriceSales")
        @Expose
        private String priceSales;
        @SerializedName("PriceBook")
        @Expose
        private String priceBook;
        @SerializedName("ExDividendDate")
        @Expose
        private String exDividendDate;
        @SerializedName("PERatio")
        @Expose
        private String pERatio;
        @SerializedName("DividendPayDate")
        @Expose
        private String dividendPayDate;
        @SerializedName("PERatioRealtime")
        @Expose
        private String pERatioRealtime;
        @SerializedName("PEGRatio")
        @Expose
        private String pEGRatio;
        @SerializedName("PriceEPSEstimateCurrentYear")
        @Expose
        private String priceEPSEstimateCurrentYear;
        @SerializedName("PriceEPSEstimateNextYear")
        @Expose
        private String priceEPSEstimateNextYear;
        @SerializedName("Symbol")
        @Expose
        private String symbol;
        @SerializedName("SharesOwned")
        @Expose
        private String sharesOwned;
        @SerializedName("ShortRatio")
        @Expose
        private String shortRatio;
        @SerializedName("LastTradeTime")
        @Expose
        private String lastTradeTime;
        @SerializedName("TickerTrend")
        @Expose
        private String tickerTrend;
        @SerializedName("OneyrTargetPrice")
        @Expose
        private String oneyrTargetPrice;
        @SerializedName("Volume")
        @Expose
        private String volume;
        @SerializedName("HoldingsValue")
        @Expose
        private String holdingsValue;
        @SerializedName("HoldingsValueRealtime")
        @Expose
        private String holdingsValueRealtime;
        @SerializedName("YearRange")
        @Expose
        private String yearRange;
        @SerializedName("DaysValueChange")
        @Expose
        private String daysValueChange;
        @SerializedName("DaysValueChangeRealtime")
        @Expose
        private String daysValueChangeRealtime;
        @SerializedName("StockExchange")
        @Expose
        private String stockExchange;
        @SerializedName("DividendYield")
        @Expose
        private String dividendYield;
        @SerializedName("PercentChange")
        @Expose
        private String percentChange;

        public Quote toQuote() {
            return new Quote(this);
        }
    }

    public static class Quote {

        private float ask;
        private float averageDailyVolume;
        private Optional<Float> bid;
        private float askRealtime;
        private Optional<Float> bidRealtime;
        private float bookValue;
        private String changePercentChange;
        private float change;
        private String commission;
        private Currency currency;
        private String changeRealtime;
        private String afterHoursChangeRealtime;
        private float dividendShare;
        private String tradeDate;
        private float earningsShare;
        private String errorIndicationreturnedforsymbolchangedinvalid;
        private float ePSEstimateCurrentYear;
        private float ePSEstimateNextYear;
        private float ePSEstimateNextQuarter;
        private float daysLow;
        private float daysHigh;
        private float yearLow;
        private float yearHigh;
        private String holdingsGainPercent;
        private String annualizedGain;
        private String holdingsGain;
        private String holdingsGainPercentRealtime;
        private String holdingsGainRealtime;
        private String moreInfo;
        private String orderBookRealtime;
        private float marketCapitalization;
        private String marketCapRealtime;
        private float eBITDA;
        private Date lastTradeDate;
        private float changeFromYearLow;
        private float percentChangeFromYearLow;
        private String lastTradeRealtimeWithTime;
        private String changePercentRealtime;
        private float changeFromYearHigh;
        private float percentChangeFromYearHigh;
        private String lastTradeWithTime;
        private float lastTradePriceOnly;
        private String highLimit;
        private String lowLimit;
        private float[] daysRange;
        private String daysRangeRealtime;
        private float fiftydayMovingAverage;
        private float twoHundreddayMovingAverage;
        private float changeFromTwoHundreddayMovingAverage;
        private float percentChangeFromTwoHundreddayMovingAverage;
        private float changeFromFiftydayMovingAverage;
        private float percentChangeFromFiftydayMovingAverage;
        private String name;
        private String notes;
        private float open;
        private float previousClose;
        private String pricePaid;
        private float changeinPercent;
        private float priceSales;
        private float priceBook;
        private Date exDividendDate;
        private float pERatio;
        private Date dividendPayDate;
        private String pERatioRealtime;
        private float pEGRatio;
        private float priceEPSEstimateCurrentYear;
        private float priceEPSEstimateNextYear;
        private String symbol;
        private String sharesOwned;
        private float shortRatio;
        private String lastTradeTime;
        private String tickerTrend;
        private float oneyrTargetPrice;
        private int volume;
        private String holdingsValue;
        private String holdingsValueRealtime;
        private float[] yearRange;
        private String daysValueChange;
        private String daysValueChangeRealtime;
        private String stockExchange;
        private float dividendYield;
        private float[] percentChange;

        public float getAsk() {
            return ask;
        }

        public float getAverageDailyVolume() {
            return averageDailyVolume;
        }

        public Optional<Float> getBid() {
            return bid;
        }

        public float getAskRealtime() {
            return askRealtime;
        }

        public Optional<Float> getBidRealtime() {
            return bidRealtime;
        }

        public float getBookValue() {
            return bookValue;
        }

        public String getChangePercentChange() {
            return changePercentChange;
        }

        public float getChange() {
            return change;
        }

        public String getCommission() {
            return commission;
        }

        public Currency getCurrency() {
            return currency;
        }

        public String getChangeRealtime() {
            return changeRealtime;
        }

        public String getAfterHoursChangeRealtime() {
            return afterHoursChangeRealtime;
        }

        public float getDividendShare() {
            return dividendShare;
        }

        public Date getLastTradeDate() {
            return lastTradeDate;
        }

        public String getTradeDate() {
            return tradeDate;
        }

        public float getEarningsShare() {
            return earningsShare;
        }

        public String getErrorIndicationreturnedforsymbolchangedinvalid() {
            return errorIndicationreturnedforsymbolchangedinvalid;
        }

        public float getePSEstimateCurrentYear() {
            return ePSEstimateCurrentYear;
        }

        public float getePSEstimateNextYear() {
            return ePSEstimateNextYear;
        }

        public float getePSEstimateNextQuarter() {
            return ePSEstimateNextQuarter;
        }

        public float getDaysLow() {
            return daysLow;
        }

        public float getDaysHigh() {
            return daysHigh;
        }

        public float getYearLow() {
            return yearLow;
        }

        public float getYearHigh() {
            return yearHigh;
        }

        public String getHoldingsGainPercent() {
            return holdingsGainPercent;
        }

        public String getAnnualizedGain() {
            return annualizedGain;
        }

        public String getHoldingsGain() {
            return holdingsGain;
        }

        public String getHoldingsGainPercentRealtime() {
            return holdingsGainPercentRealtime;
        }

        public String getHoldingsGainRealtime() {
            return holdingsGainRealtime;
        }

        public String getMoreInfo() {
            return moreInfo;
        }

        public String getOrderBookRealtime() {
            return orderBookRealtime;
        }

        public float getMarketCapitalization() {
            return marketCapitalization;
        }

        public String getMarketCapRealtime() {
            return marketCapRealtime;
        }

        public float geteBITDA() {
            return eBITDA;
        }

        public float getChangeFromYearLow() {
            return changeFromYearLow;
        }

        public float getPercentChangeFromYearLow() {
            return percentChangeFromYearLow;
        }

        public String getLastTradeRealtimeWithTime() {
            return lastTradeRealtimeWithTime;
        }

        public String getChangePercentRealtime() {
            return changePercentRealtime;
        }

        public float getChangeFromYearHigh() {
            return changeFromYearHigh;
        }

        public float getPercebtChangeFromYearHigh() {
            return percentChangeFromYearHigh;
        }

        public String getLastTradeWithTime() {
            return lastTradeWithTime;
        }

        public float getLastTradePriceOnly() {
            return lastTradePriceOnly;
        }

        public String getHighLimit() {
            return highLimit;
        }

        public String getLowLimit() {
            return lowLimit;
        }

        public float[] getDaysRange() {
            return daysRange;
        }

        public String getDaysRangeRealtime() {
            return daysRangeRealtime;
        }

        public float getFiftydayMovingAverage() {
            return fiftydayMovingAverage;
        }

        public float getTwoHundreddayMovingAverage() {
            return twoHundreddayMovingAverage;
        }

        public float getChangeFromTwoHundreddayMovingAverage() {
            return changeFromTwoHundreddayMovingAverage;
        }

        public float getPercentChangeFromTwoHundreddayMovingAverage() {
            return percentChangeFromTwoHundreddayMovingAverage;
        }

        public float getChangeFromFiftydayMovingAverage() {
            return changeFromFiftydayMovingAverage;
        }

        public float getPercentChangeFromFiftydayMovingAverage() {
            return percentChangeFromFiftydayMovingAverage;
        }

        public String getName() {
            return name;
        }

        public String getNotes() {
            return notes;
        }

        public float getOpen() {
            return open;
        }

        public float getPreviousClose() {
            return previousClose;
        }

        public String getPricePaid() {
            return pricePaid;
        }

        public float getChangeinPercent() {
            return changeinPercent;
        }

        public float getPriceSales() {
            return priceSales;
        }

        public float getPriceBook() {
            return priceBook;
        }

        public Date getExDividendDate() {
            return exDividendDate;
        }

        public float getpERatio() {
            return pERatio;
        }

        public Date getDividendPayDate() {
            return dividendPayDate;
        }

        public String getpERatioRealtime() {
            return pERatioRealtime;
        }

        public float getpEGRatio() {
            return pEGRatio;
        }

        public float getPriceEPSEstimateCurrentYear() {
            return priceEPSEstimateCurrentYear;
        }

        public float getPriceEPSEstimateNextYear() {
            return priceEPSEstimateNextYear;
        }

        public String getSymbol() {
            return symbol;
        }

        public String getSharesOwned() {
            return sharesOwned;
        }

        public float getShortRatio() {
            return shortRatio;
        }

        public String getLastTradeTime() {
            return lastTradeTime;
        }

        public String getTickerTrend() {
            return tickerTrend;
        }

        public float getOneyrTargetPrice() {
            return oneyrTargetPrice;
        }

        public int getVolume() {
            return volume;
        }

        public String getHoldingsValue() {
            return holdingsValue;
        }

        public String getHoldingsValueRealtime() {
            return holdingsValueRealtime;
        }

        public float[] getYearRange() {
            return yearRange;
        }

        public String getDaysValueChange() {
            return daysValueChange;
        }

        public String getDaysValueChangeRealtime() {
            return daysValueChangeRealtime;
        }

        public String getStockExchange() {
            return stockExchange;
        }

        public float getDividendYield() {
            return dividendYield;
        }

        public float[] getPercentChange() {
            return percentChange;
        }

        private Quote(JSONQuote j) {
            this.ask = Float.parseFloat(Optional.ofNullable(j.ask).orElse("0"));
            this.askRealtime = Float.parseFloat(Optional.ofNullable(j.askRealtime).orElse("0"));
            this.averageDailyVolume = Float.parseFloat(Optional.ofNullable(j.averageDailyVolume).orElse("0"));
        }
    }
}

