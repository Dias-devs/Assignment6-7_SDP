package AdapterPattern.TargetInterface;

import BuilderPattern.Product.Weather;

public interface ExternalWeather {
    Weather getWeatherData(String city);
}