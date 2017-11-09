package me.theeninja.stocklookuptool.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import me.theeninja.stocklookuptool.stock.StockExchange;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        private float bookValue;
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
        private String percentChangeFromYearHigh;
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
        private float changeinPercent;
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
        private float[] percentChange;

        public Quote toQuote() {
            return new Quote(this);
        }
    }

    static OptionalInt convertStringToInteger(String intString) {
        if (intString == null) {
            return OptionalInt.empty();
        }
        else {
            return OptionalInt.of(Integer.parseInt(intString));
        }
    }

    static OptionalDouble convertStringToDouble(String doubleString) {
        if (doubleString == null) {
            return OptionalDouble.empty();
        }
        else {
            return OptionalDouble.of(Double.parseDouble(doubleString));
        }
    }

    public static class Quote {

        private OptionalDouble ask;
        private OptionalInt averageDailyVolume;
        private OptionalDouble bid;
        private OptionalDouble askRealtime;
        private OptionalDouble bidRealtime;
        private float bookValue;
        private String changePercentChange;
        private OptionalDouble change;
        private String commission;
        private String currency;
        private String changeRealtime;
        private String afterHoursChangeRealtime;
        private OptionalDouble dividendShare;
        private Date tradeDate;
        private OptionalDouble earningsShare;
        private String errorIndicationreturnedforsymbolchangedinvalid;
        private OptionalDouble ePSEstimateCurrentYear;
        private OptionalDouble ePSEstimateNextYear;
        private OptionalDouble ePSEstimateNextQuarter;
        private OptionalDouble daysLow;
        private OptionalDouble daysHigh;
        private OptionalDouble yearLow;
        private OptionalDouble yearHigh;
        private String holdingsGainPercent;
        private String annualizedGain;
        private String holdingsGain;
        private String holdingsGainPercentRealtime;
        private String holdingsGainRealtime;
        private String moreInfo;
        private String orderBookRealtime;
        private OptionalDouble marketCapitalization;
        private OptionalDouble marketCapRealtime;
        private OptionalDouble eBITDA;
        private Date lastTradeDate;
        private OptionalDouble changeFromYearLow;
        private OptionalDouble percentChangeFromYearLow;
        private String lastTradeRealtimeWithTime;
        private String changePercentRealtime;
        private OptionalDouble changeFromYearHigh;
        private OptionalDouble percentChangeFromYearHigh;
        private String lastTradeWithTime;
        private OptionalDouble lastTradePriceOnly;
        private OptionalDouble highLimit;
        private OptionalDouble lowLimit;
        private OptionalDouble[] daysRange;
        private String daysRangeRealtime;
        private OptionalDouble fiftydayMovingAverage;
        private OptionalDouble twoHundreddayMovingAverage;
        private OptionalDouble changeFromTwoHundreddayMovingAverage;
        private OptionalDouble percentChangeFromTwoHundreddayMovingAverage;
        private OptionalDouble changeFromFiftydayMovingAverage;
        private OptionalDouble percentChangeFromFiftydayMovingAverage;
        private String name;
        private String notes;
        private OptionalDouble open;
        private OptionalDouble previousClose;
        private String pricePaid;
        private float changeinPercent;
        private OptionalDouble priceSales;
        private OptionalDouble priceBook;
        private Date exDividendDate;
        private OptionalDouble pERatio;
        private Date dividendPayDate;
        private OptionalDouble pERatioRealtime;
        private OptionalDouble pEGRatio;
        private OptionalDouble priceEPSEstimateCurrentYear;
        private OptionalDouble priceEPSEstimateNextYear;
        private String symbol;
        private OptionalInt sharesOwned;
        private OptionalDouble shortRatio;
        private String lastTradeTime;
        private String tickerTrend;
        private OptionalDouble oneyrTargetPrice;
        private OptionalInt volume;
        private String holdingsValue;
        private String holdingsValueRealtime;
        private OptionalDouble[] yearRange;
        private String daysValueChange;
        private String daysValueChangeRealtime;
        private StockExchange stockExchange;
        private OptionalDouble dividendYield;
        private float[] percentChange;

        public OptionalDouble getAsk() {
            return ask;
        }

        public OptionalInt getAverageDailyVolume() {
            return averageDailyVolume;
        }

        public OptionalDouble getBid() {
            return bid;
        }

        public OptionalDouble getAskRealtime() {
            return askRealtime;
        }

        public OptionalDouble getBidRealtime() {
            return bidRealtime;
        }

        public float getBookValue() {
            return bookValue;
        }

        public String getChangePercentChange() {
            return changePercentChange;
        }

        public OptionalDouble getChange() {
            return change;
        }

        public String getCommission() {
            return commission;
        }

        public String getCurrency() {
            return currency;
        }

        public String getChangeRealtime() {
            return changeRealtime;
        }

        public String getAfterHoursChangeRealtime() {
            return afterHoursChangeRealtime;
        }

        public OptionalDouble getDividendShare() {
            return dividendShare;
        }

        public Date getLastTradeDate() {
            return lastTradeDate;
        }

        public Date getTradeDate() {
            return tradeDate;
        }

        public OptionalDouble getEarningsShare() {
            return earningsShare;
        }

        public String getErrorIndicationreturnedforsymbolchangedinvalid() {
            return errorIndicationreturnedforsymbolchangedinvalid;
        }

        public OptionalDouble getePSEstimateCurrentYear() {
            return ePSEstimateCurrentYear;
        }

        public OptionalDouble getePSEstimateNextYear() {
            return ePSEstimateNextYear;
        }

        public OptionalDouble getePSEstimateNextQuarter() {
            return ePSEstimateNextQuarter;
        }

        public OptionalDouble getDaysLow() {
            return daysLow;
        }

        public OptionalDouble getDaysHigh() {
            return daysHigh;
        }

        public OptionalDouble getYearLow() {
            return yearLow;
        }

        public OptionalDouble getYearHigh() {
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

        public OptionalDouble getMarketCapitalization() {
            return marketCapitalization;
        }

        public OptionalDouble getMarketCapRealtime() {
            return marketCapRealtime;
        }

        public OptionalDouble geteBITDA() {
            return eBITDA;
        }

        public OptionalDouble getChangeFromYearLow() {
            return changeFromYearLow;
        }

        public OptionalDouble getPercentChangeFromYearLow() {
            return percentChangeFromYearLow;
        }

        public String getLastTradeRealtimeWithTime() {
            return lastTradeRealtimeWithTime;
        }

        public String getChangePercentRealtime() {
            return changePercentRealtime;
        }

        public OptionalDouble getChangeFromYearHigh() {
            return changeFromYearHigh;
        }

        public OptionalDouble getPercebtChangeFromYearHigh() {
            return percentChangeFromYearHigh;
        }

        public String getLastTradeWithTime() {
            return lastTradeWithTime;
        }

        public OptionalDouble getLastTradePriceOnly() {
            return lastTradePriceOnly;
        }

        public OptionalDouble getHighLimit() {
            return highLimit;
        }

        public OptionalDouble getLowLimit() {
            return lowLimit;
        }

        public OptionalDouble[] getDaysRange() {
            return daysRange;
        }

        public String getDaysRangeRealtime() {
            return daysRangeRealtime;
        }

        public OptionalDouble getFiftydayMovingAverage() {
            return fiftydayMovingAverage;
        }

        public OptionalDouble getTwoHundreddayMovingAverage() {
            return twoHundreddayMovingAverage;
        }

        public OptionalDouble getChangeFromTwoHundreddayMovingAverage() {
            return changeFromTwoHundreddayMovingAverage;
        }

        public OptionalDouble getPercentChangeFromTwoHundreddayMovingAverage() {
            return percentChangeFromTwoHundreddayMovingAverage;
        }

        public OptionalDouble getChangeFromFiftydayMovingAverage() {
            return changeFromFiftydayMovingAverage;
        }

        public OptionalDouble getPercentChangeFromFiftydayMovingAverage() {
            return percentChangeFromFiftydayMovingAverage;
        }

        public String getName() {
            return name;
        }

        public String getNotes() {
            return notes;
        }

        public OptionalDouble getOpen() {
            return open;
        }

        public OptionalDouble getPreviousClose() {
            return previousClose;
        }

        public String getPricePaid() {
            return pricePaid;
        }

        public float getChangeinPercent() {
            return changeinPercent;
        }

        public OptionalDouble getPriceSales() {
            return priceSales;
        }

        public OptionalDouble getPriceBook() {
            return priceBook;
        }

        public Date getExDividendDate() {
            return exDividendDate;
        }

        public OptionalDouble getpERatio() {
            return pERatio;
        }

        public Date getDividendPayDate() {
            return dividendPayDate;
        }

        public OptionalDouble getpERatioRealtime() {
            return pERatioRealtime;
        }

        public OptionalDouble getpEGRatio() {
            return pEGRatio;
        }

        public OptionalDouble getPriceEPSEstimateCurrentYear() {
            return priceEPSEstimateCurrentYear;
        }

        public OptionalDouble getPriceEPSEstimateNextYear() {
            return priceEPSEstimateNextYear;
        }

        public String getSymbol() {
            return symbol;
        }

        public OptionalInt getSharesOwned() {
            return sharesOwned;
        }

        public OptionalDouble getShortRatio() {
            return shortRatio;
        }

        public String getLastTradeTime() {
            return lastTradeTime;
        }

        public String getTickerTrend() {
            return tickerTrend;
        }

        public OptionalDouble getOneyrTargetPrice() {
            return oneyrTargetPrice;
        }

        public OptionalInt getVolume() {
            return volume;
        }

        public String getHoldingsValue() {
            return holdingsValue;
        }

        public String getHoldingsValueRealtime() {
            return holdingsValueRealtime;
        }

        public OptionalDouble[] getYearRange() {
            return yearRange;
        }

        public String getDaysValueChange() {
            return daysValueChange;
        }

        public String getDaysValueChangeRealtime() {
            return daysValueChangeRealtime;
        }

        public StockExchange getStockExchange() {
            return stockExchange;
        }

        public OptionalDouble getDividendYield() {
            return dividendYield;
        }

        public float[] getPercentChange() {
            return percentChange;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/YYYY");

        private Quote(JSONQuote t) {
            this.afterHoursChangeRealtime = t.afterHoursChangeRealtime;
            this.annualizedGain = t.annualizedGain;
            this.ask = convertStringToDouble(t.ask);
            this.askRealtime = convertStringToDouble(t.askRealtime);
            this.averageDailyVolume = convertStringToInteger(t.averageDailyVolume);
            this.bid = convertStringToDouble(t.bid);
            this.bidRealtime = convertStringToDouble(t.bidRealtime);
            this.bookValue = t.bookValue;
            this.change = convertStringToDouble(t.change);
            this.changeFromFiftydayMovingAverage = convertStringToDouble(t.changeFromFiftydayMovingAverage);
            this.changeFromTwoHundreddayMovingAverage = convertStringToDouble(t.changeFromTwoHundreddayMovingAverage);
            this.changeFromYearHigh = convertStringToDouble(t.changeFromYearHigh);
            this.changeFromYearLow = convertStringToDouble(t.changeFromYearLow);
            this.changeinPercent = t.changeinPercent;
            this.changePercentChange = t.changePercentChange;
            this.changePercentRealtime = t.changePercentRealtime;
            this.changeRealtime = t.changeRealtime;
            this.commission = t.commission;
            this.currency = t.currency;
            this.daysHigh = convertStringToDouble(t.daysHigh);
            this.daysLow = convertStringToDouble(t.daysLow);
            this.daysRange = new OptionalDouble[] {this.daysLow, this.daysHigh};
            this.daysRangeRealtime = t.daysRangeRealtime;
            this.daysValueChange = t.daysValueChange;
            this.daysValueChangeRealtime = t.daysValueChangeRealtime;
            this.dividendShare = convertStringToDouble(t.dividendShare);
            try {
                this.dividendPayDate = simpleDateFormat.parse(t.dividendPayDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.dividendYield = convertStringToDouble(t.dividendYield);
            this.earningsShare = convertStringToDouble(t.earningsShare);
            this.eBITDA = convertStringToDouble(t.eBITDA);
            this.ePSEstimateCurrentYear = convertStringToDouble(t.ePSEstimateCurrentYear);
            this.ePSEstimateNextQuarter = convertStringToDouble(t.ePSEstimateNextQuarter);
            this.ePSEstimateNextYear = convertStringToDouble(t.ePSEstimateNextYear);
            try {
                this.exDividendDate = simpleDateFormat.parse(t.exDividendDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.errorIndicationreturnedforsymbolchangedinvalid = t.errorIndicationreturnedforsymbolchangedinvalid;
            this.fiftydayMovingAverage = convertStringToDouble(t.fiftydayMovingAverage);
            this.highLimit = convertStringToDouble(t.highLimit);
            this.holdingsGain = t.holdingsGain;
            this.holdingsGainRealtime = t.holdingsGainRealtime;
            this.holdingsGainPercent = t.holdingsGainPercent;
            this.holdingsGainPercentRealtime = t.holdingsGainPercentRealtime;
            this.holdingsValue = t.holdingsValue;
            this.holdingsValueRealtime = t.holdingsValueRealtime;
            try {
                this.lastTradeDate = simpleDateFormat.parse(t.lastTradeDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.lastTradePriceOnly = convertStringToDouble(t.lastTradePriceOnly);
            this.lastTradeRealtimeWithTime = t.lastTradeRealtimeWithTime;
            this.lastTradeTime = t.lastTradeTime;
            this.lastTradeWithTime = t.lastTradeWithTime;
            this.lowLimit = convertStringToDouble(t.lowLimit);
            this.marketCapitalization = convertStringToDouble(t.marketCapitalization);
            this.marketCapRealtime = convertStringToDouble(t.marketCapRealtime);
            this.moreInfo = t.moreInfo;
            this.name = t.name;
            this.notes = t.notes;
            this.oneyrTargetPrice = convertStringToDouble(t.oneyrTargetPrice);
            this.open = convertStringToDouble(t.open);
            this.orderBookRealtime = t.orderBookRealtime;
            this.pEGRatio = convertStringToDouble(t.pEGRatio);
            this.pERatio = convertStringToDouble(t.pERatio);
            this.pERatioRealtime = convertStringToDouble(t.pERatioRealtime);
            this.percentChange = t.percentChange;
            this.percentChangeFromFiftydayMovingAverage = convertStringToDouble(t.percentChangeFromFiftydayMovingAverage);
            this.percentChangeFromTwoHundreddayMovingAverage = convertStringToDouble(t.percentChangeFromTwoHundreddayMovingAverage);
            this.percentChangeFromYearHigh = convertStringToDouble(t.percentChangeFromYearHigh);
            this.percentChangeFromYearLow = convertStringToDouble(t.percentChangeFromYearLow);
            this.priceSales = convertStringToDouble(t.priceSales);
            this.priceBook = convertStringToDouble(t.priceBook);
            this.previousClose = convertStringToDouble(t.previousClose);
            this.pricePaid = t.pricePaid;
            this.priceEPSEstimateCurrentYear = convertStringToDouble(t.priceEPSEstimateCurrentYear);
            this.priceEPSEstimateNextYear = convertStringToDouble(t.priceEPSEstimateNextYear);
            this.sharesOwned = convertStringToInteger(t.sharesOwned);
            this.shortRatio = convertStringToDouble(t.shortRatio);
            this.stockExchange = StockExchange.valueOf(t.stockExchange);
            this.symbol = t.symbol;
            this.tickerTrend = t.tickerTrend;
            try {
                this.tradeDate = simpleDateFormat.parse(t.tradeDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.twoHundreddayMovingAverage = convertStringToDouble(t.twoHundreddayMovingAverage);
            this.volume = convertStringToInteger(t.volume);
            this.yearHigh = convertStringToDouble(t.yearHigh);
            this.yearLow = convertStringToDouble(t.yearLow);
            this.yearRange = new OptionalDouble[] {this.yearLow, this.yearHigh};
        }
    }
}

