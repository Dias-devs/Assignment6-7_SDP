package BuilderPattern.Director;

import BuilderPattern.ConcreteBuilder.ConcreteWeatherBuilder;
import BuilderPattern.Product.Weather;

public class WeatherDirector {

    public Weather constructWeather(ConcreteWeatherBuilder builder, String city, double temp,
                                    double hum, double wind, String cond) {
        builder.setCity(city);
        builder.setTemperature(temp);
        builder.setHumidity(hum);
        builder.setWindSpeed(wind);
        builder.setCondition(cond);

        return builder.getResult();
    }
}