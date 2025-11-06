package StrategyPattern.Concretes;

import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Director.WeatherDirector;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

import java.util.Scanner;

public class ManualUpdate implements UpdateStrategy {
    @Override
    public Weather updateWeather(String city) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- Manual Weather Update for " + city);
        System.out.print("Enter temperature (°C): ");
        double temp = sc.nextDouble();
        System.out.print("Enter humidity (%): ");
        double hum = sc.nextDouble();
        System.out.print("Enter wind speed (km/h): ");
        double wind = sc.nextDouble();
        System.out.print("Enter condition (Ex. Sunny): ");
        String cond = sc.nextLine();

        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector();

        director.constructWeather(builder, city, temp, hum, wind, cond);
        return builder.getResult();
    }
}