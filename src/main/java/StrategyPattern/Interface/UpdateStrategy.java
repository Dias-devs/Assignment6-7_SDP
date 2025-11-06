package StrategyPattern.Interface;

import BuilderPattern.Product.Weather;

public interface UpdateStrategy {
    Weather updateWeather(String city);
}