package org.coding.sorting;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Result {

    private static String holdingStartUrl = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/holding_start";
    private static String pricingStartUrl = "https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/paging/pricing_start";

    /*
     * Complete the 'calculateNAV' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts STRING date as parameter.
     */

    public static double calculateNAV(String date) {

        List<Holding>holdingData =getHoldingData(date);
        List<Pricing> pricingData = getPricingData(date);

        double totalValue = 0;



        for(Holding holding : holdingData)
        {
            List<Pricing> pricings = pricingData.stream().filter(pricing1 -> pricing1.security.equals(holding.security)).collect(Collectors.toList());
            if(!pricings.isEmpty())
            {
                totalValue+= (holding.quantity * pricings.get(0).price);
            }
        }
        return totalValue;
    }

    private static List<Pricing> getPricingData(String date) {

        List<Pricing> pricingListMain = new ArrayList<>();
        boolean nextPagePresent = true;
        try {

            URL url = new URL(pricingStartUrl);


            while (nextPagePresent)
            {
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                JsonElement jsonElement = new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
                JsonElement text = jsonElement.getAsJsonObject().get("data");
                JsonElement nextPage = jsonElement.getAsJsonObject().get("nextPage");
                if (nextPage!=null) {
                    nextPagePresent = true;
                    url = new URL(nextPage.getAsString());
                }
                else
                {
                    nextPagePresent = false;
                    url = null;
                }
                Type listType = new TypeToken<List<Pricing>>() {
                }.getType();
                List<Pricing> yourList = new Gson().fromJson(text, listType);
                if (yourList.size() > 0) {
                    pricingListMain.addAll(yourList);
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pricingListMain.stream().filter(x->x.date.equals(date)).collect(Collectors.toList());
    }

    private static List<Holding> getHoldingData(String date) {

        List<Holding> mainList = new ArrayList<>();
        boolean nextPagePresent = true;
        try {

            URL url = new URL(holdingStartUrl);


            while (nextPagePresent)
            {
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                JsonElement jsonElement = new JsonParser().parse(new InputStreamReader((InputStream) request.getContent()));
                JsonElement text = jsonElement.getAsJsonObject().get("data");
                JsonElement nextPage = jsonElement.getAsJsonObject().get("nextPage");
                if (nextPage!=null) {
                    nextPagePresent = true;
                    url = new URL(nextPage.getAsString());
                }
                else
                {
                    nextPagePresent = false;
                    url = null;
                }
                Type listType = new TypeToken<List<Holding>>() {
                }.getType();
                List<Holding> yourList = new Gson().fromJson(text, listType);
                if (yourList.size() > 0) {
                    mainList.addAll(yourList);
                }
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mainList.stream().filter(x->x.date.equals(date)).collect(Collectors.toList());

    }






//    private String getPricingData(String data) {
//
//    }


}

public class PortFolioManagement {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String date = bufferedReader.readLine();

        double result = Result.calculateNAV("20190305");

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
