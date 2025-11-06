package AdapterPattern.Adaptee;

import org.json.JSONObject;
import java.net.*;
import java.io.*;

public class OpenMeteoAPI {
    public JSONObject fetchWeather(String city) {
        String urlString;

        switch (city) {
            case "Almaty" ->
                    urlString = "https://api.open-meteo.com/v1/forecast?latitude=43.2220&longitude=76.8512&current_weather=true&hourly=relativehumidity_2m";
            case "Astana" ->
                    urlString = "https://api.open-meteo.com/v1/forecast?latitude=51.1694&longitude=71.4491&current_weather=true&hourly=relativehumidity_2m";
            case "Shymkent" ->
                    urlString = "https://api.open-meteo.com/v1/forecast?latitude=42.3417&longitude=69.5901&current_weather=true&hourly=relativehumidity_2m";
            default -> {
                return null;
            }
        }

        try {
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