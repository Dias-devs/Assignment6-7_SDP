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
        // initialize Builder and Director
        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector(builder);

        // create initial weather
        latestWeather = director.construct(
                city,
                -10 + random.nextDouble() * 45,
                30 + random.nextDouble() * 70,
                random.nextDouble() * 40,
                randomCondition()
        );

        // schedule automatic updates every 5 seconds
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
        }, 0, 1800000); // delay=0, repeat every 5 seconds

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