package StrategyPattern.Concretes;

import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;
import BuilderPattern.Director.WeatherDirector;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class ScheduledUpdate implements UpdateStrategy {

    private final Timer timer = new Timer();
    private final Random random = new Random();
    private Weather latestWeather;

    @Override
    public Weather updateData(String city) {
        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector(builder);

        latestWeather = director.construct(
                city,
                -10 + random.nextDouble() * 45,
                30 + random.nextDouble() * 70,
                random.nextDouble() * 40,
                randomCondition()
        );

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                latestWeather = director.construct(
                        city,
                        -10 + random.nextDouble() * 45,
                        30 + random.nextDouble() * 70,
                        random.nextDouble() * 40,
                        randomCondition()
                );
                System.out.println("[Scheduled Update] Weather refreshed for: " + city);
                System.out.println(latestWeather);
            }
        }, 0, 1800000);

        return latestWeather;
    }

    private String randomCondition() {
        String[] conditions = {"Sunny", "Cloudy", "Rainy", "Stormy", "Snowy"};
        return conditions[random.nextInt(conditions.length)];
    }

    public void stop() {
        timer.cancel();
    }
}