package StrategyPattern.Concretes;

import BuilderPattern.Builder.Builder;
import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Director.WeatherDirector;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

public class RealTimeUpdate implements UpdateStrategy {
    @Override
    public Weather updateData(String city)  {
        Builder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector(builder);
        return director.construct(city, 18.5, 45, 10, "Rainy");
    }
}