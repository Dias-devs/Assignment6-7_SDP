package StrategyPattern.Concretes;

import BuilderPattern.Builder.Builder;
import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Director.WeatherDirector;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

import java.util.Scanner;

public class ManualUpdate implements UpdateStrategy {
    @Override
    public Weather updateData(String city) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        double temp = sc.nextDouble();
        System.out.print("Enter humidity: ");
        double hum = sc.nextDouble();
        System.out.print("Enter wind speed: ");
        double wind = sc.nextDouble();
        System.out.print("Enter condition: ");
        String cond = sc.nextLine();

        Builder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector(builder);
        return director.construct(city, temp, hum, wind, cond);
    }
}