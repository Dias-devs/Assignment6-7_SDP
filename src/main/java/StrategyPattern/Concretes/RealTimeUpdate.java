package StrategyPattern.Concretes;

import BuilderPattern.Builder.Builder;
import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Director.WeatherDirector;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

public class RealTimeUpdate implements UpdateStrategy {
    @Override
    public Weather updateWeather(String city)  {
        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector();

        director.constructWeather(builder, city, 18.5, 45, 10, "Rainy");
        return builder.getResult();
    }
}