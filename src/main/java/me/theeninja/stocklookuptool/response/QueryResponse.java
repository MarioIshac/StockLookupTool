package me.theeninja.stocklookuptool.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryResponse {

    @SerializedName("quoteResponse")
    @Expose
    private QuoteResponse quoteResponse;

    public QuoteResponse getQuoteResponse() {
        return quoteResponse;
    }

    public void setQuoteResponse(QuoteResponse quoteResponse) {
        this.quoteResponse = quoteResponse;
    }

}