package me.theeninja.stocklookuptool.query;

import com.google.gson.Gson;
import me.theeninja.stocklookuptool.response.ResponseManager;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryManager {

    public static ResponseManager.Data query(String symbol) {
        try {
            String queryString = generateQueryString(symbol);

            String baseUrl = "https://query.yahooapis.com/v1/public/yql?q=";
            String endUrl = "&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";

            String fullUrlStr = null;

            fullUrlStr = baseUrl + URLEncoder.encode(queryString, "UTF-8") + endUrl;

            URL fullUrl = null;

            fullUrl = new URL(fullUrlStr);

            ResponseManager.Data data;

            InputStream is = fullUrl.openStream();

            Gson gson = new Gson();
            String jsonString = IOUtils.toString(is, "UTF-8");
            data = gson.fromJson(jsonString, ResponseManager.Data.class);

            IOUtils.closeQuietly(is);

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateQueryString(String symbol) {

        return "select * from yahoo.finance.quotes where symbol = " + "\"" + symbol + "\"";
    }

    public static List<String> getAllSymbols(String stockExchange) {
        try {
            URL url = new URL("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=" + stockExchange + "&render=download");

            try (InputStream is = url.openStream()) {

                String csvString = IOUtils.toString(is, "UTF-8");
                return getSymbolsFromCSV(csvString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        return null;
    }

    private static List<String> getSymbolsFromCSV(String csvFileContents) {

        List<String> symbols = new ArrayList<>();

        InputStream is = IOUtils.toInputStream(csvFileContents, Charset.defaultCharset());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            String disregardFirstLine = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineParts = line.split(",");
                symbols.add(lineParts[0].replace("\"", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return symbols;
    }
}