package me.theeninja.stocklookuptool.query;

import com.google.gson.Gson;
import me.theeninja.stocklookuptool.response.ResponseManager;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.utils.URIBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryManager {

    // Quandl API Key = sweUCDwhgKDxco9dp_xJ
    // Alpha Vantage API Key =  T2ALTQ2SGQIWBT3E
    // Tradier
    // Maximize B2 B Niches App
    // Access token: FNbyAebHEKHISI2arduyLSXsZV89

    private String symbol;

    private final static Logger logger = Logger.getLogger(QueryManager.class.getSimpleName());
    private final static String BASE_URL = "https://query.yahooapis.com/v1/public/yql";

    public QueryManager(String symbol) {
        this.symbol = symbol;
    }

    public ResponseManager.Data query() {
        try {
            String queryString = this.generateQueryString();

            URIBuilder uriBuilder = new URIBuilder(BASE_URL);
            uriBuilder.addParameter("q", queryString);
            uriBuilder.addParameter("format", "json");
            uriBuilder.addParameter("env", "store://datatables.org/alltableswithkeys");

            String fullUrlString = uriBuilder.toString();
            URL fullUrl = new URL(fullUrlString);

            logger.log(Level.INFO, "Generted URL for query: {0}", fullUrlString);

            InputStream is = fullUrl.openStream();

            Gson gson = new Gson();
            String jsonString = IOUtils.toString(is, "UTF-8");
            ResponseManager.Data data = gson.fromJson(jsonString, ResponseManager.Data.class);

            IOUtils.closeQuietly(is);

            return data;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String generateQueryString() {

        return "select * from yahoo.finance.quotes where symbol = \"" + symbol + "\"";
    }

    public static List<String> getAllSymbols(String stockExchange) {
        try {
            URL url = new URL(URLEncoder.encode("http://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=" + stockExchange + "&render=download", "UTF-8"));

            try (InputStream is = url.openStream()) {

                String csvString = IOUtils.toString(is, "UTF-8");
                return getSymbolsFromCSV(csvString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException | UnsupportedEncodingException malformedURLException) {
            malformedURLException.printStackTrace();
        }
        return null;
    }

    private static List<String> getSymbolsFromCSV(String csvFileContents) {

        List<String> symbols = new ArrayList<>();

        InputStream is = IOUtils.toInputStream(csvFileContents, Charset.defaultCharset());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        try {
            br.readLine(); // disregards first line

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