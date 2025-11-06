package AdapterPattern.Adapter;

import AdapterPattern.Adaptee.OpenMeteoAPI;
import AdapterPattern.TargetInterface.ExternalWeather;
import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Director.WeatherDirector;
import BuilderPattern.Product.Weather;
import org.json.JSONObject;

public class WeatherAPIAdapter implements ExternalWeather {
    private final OpenMeteoAPI api = new OpenMeteoAPI();

    @Override
    public Weather getWeatherData(String city) {
        JSONObject data = api.fetchWeather(city);
        if (data == null) return null;

        JSONObject current = data.getJSONObject("current_weather");
        double temperature = current.getDouble("temperature");
        double wind = current.getDouble("windspeed");
        int weatherCode = current.getInt("weathercode");
        String cond = getWeatherCondition(weatherCode);


        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector();

        director.constructWeather(builder, city, temperature, 70, wind, cond);
        return builder.getResult();
    }

    private static String getWeatherCondition(int code) {
        if (code == 0) return "Clear";
        if (code <= 3) return "Partly cloudy";
        if (code <= 48) return "Fog";
        if (code <= 57) return "Drizzle";
        if (code <= 67) return "Rain";
        if (code <= 77) return "Snow";
        if (code <= 82) return "Rain showers";
        if (code <= 86) return "Snow showers";
        if (code <= 99) return "Thunderstorm";
        return "Unknown";
    }
}