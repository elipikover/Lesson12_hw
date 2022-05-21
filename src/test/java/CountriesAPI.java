import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import java.io.IOException;
import java.util.Scanner;

public class CountriesAPI {


    public static void getCountryAttributes(String cc) throws IOException {
        // use OKHttp client to create the connection and retrieve data
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://restcountries.com/v2/alpha/"+cc).build();
        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();
        if (response.code() == 404){
            System.out.println("Country is not valid please try again");
        }
//        StringBuilder sb = new StringBuilder(jsonData);
//        sb.deleteCharAt(jsonData.length() - 1);
//        sb.deleteCharAt(0);
//        jsonData = sb.toString();

        // parse JSON
        JSONObject mainJsonObject = new JSONObject(jsonData);
        // get Json object
        JSONArray resultsJsonArray = mainJsonObject.getJSONArray("borders");
        String val = mainJsonObject.getString("region");
        JSONArray resultJSONArray = mainJsonObject.getJSONArray("currencies");
        JSONObject currenciesObject = resultJSONArray.getJSONObject(0);
        String symbol = currenciesObject.getString("symbol");
//        // get value

        System.out.println("Region: " + val);
        System.out.println("Borders "+ resultsJsonArray);
        System.out.println(symbol);
        CountriesAPISolution.chooseAgain();
    }


}
