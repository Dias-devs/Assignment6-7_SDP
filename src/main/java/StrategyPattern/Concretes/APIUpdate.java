package StrategyPattern.Concretes;

import AdapterPattern.Adapter.WeatherAPIAdapter;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

public class APIUpdate implements UpdateStrategy {
    private final WeatherAPIAdapter adapter = new WeatherAPIAdapter();

    @Override
    public Weather updateData(String city) {
        return adapter.getWeatherData(city);
    }
}