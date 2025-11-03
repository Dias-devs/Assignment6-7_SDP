package AdapterPattern.Adapter;

import AdapterPattern.Adaptee.OpenMeteoAPI;
import AdapterPattern.TargetInterface.ExternalWeather;
import BuilderPattern.Builder.Builder;
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

        Builder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector(builder);
        return director.construct(city, temperature, 60.0, wind, "Clear");
    }
}