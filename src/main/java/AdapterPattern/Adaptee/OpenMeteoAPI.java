package AdapterPattern.Adaptee;

import org.json.JSONObject;
import java.net.*;
import java.io.*;

public class OpenMeteoAPI {
    public JSONObject fetchWeather(String city) {
        try {
            String urlString = "https://api.open-meteo.com/v1/forecast?latitude=43.2&longitude=76.9&current_weather=true";
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            return new JSONObject(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}