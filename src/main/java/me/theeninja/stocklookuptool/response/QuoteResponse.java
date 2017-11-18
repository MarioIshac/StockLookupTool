package me.theeninja.stocklookuptool.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteResponse {

    @SerializedName("result")
    @Expose
    private List<Quote> quote;

    @SerializedName("error")
    @Expose
    private Object error;

    public List<Quote> getQuote() {
        return quote;
    }

    public Quote getSingleQuote() {
        return this.getQuote().get(0);
    }

    public Object getError() {
        return error;
    }
}