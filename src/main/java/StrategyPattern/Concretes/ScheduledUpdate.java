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

    @Override
    public Weather updateWeather(String city) {
        ConcreteWeatherBuilder builder = new ConcreteWeatherBuilder();
        WeatherDirector director = new WeatherDirector();

        director.constructWeather(
                builder,
                city,
                -(random.nextDouble() * 50) + random.nextDouble() * 45,
                random.nextDouble() * 100,
                random.nextDouble() * 90,
                randomCondition()
        );

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                director.constructWeather(
                        builder,
                        city,
                        -(random.nextDouble() * 40) + random.nextDouble() * 40,
                        random.nextDouble() * 100,
                        random.nextDouble() * 90,
                        randomCondition()
                );
                System.out.println("[Scheduled Update] Weather refreshed for: " + city);
                System.out.println(builder.getResult());
            }
        }, 0, 3600000);

        return builder.getResult();
    }

    private String randomCondition() {
        String[] conditions = {"Sunny", "Partially-Cloudy", "Cloudy", "Rainy", "Stormy", "Snowy"};
        int condLength = conditions.length;
        return conditions[random.nextInt(condLength)];
    }

    public void stop() {
        timer.cancel();
    }
}