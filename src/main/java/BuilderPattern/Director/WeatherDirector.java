package BuilderPattern.Director;

import BuilderPattern.Builder.Builder;
import BuilderPattern.Product.Weather;

public class WeatherDirector {
    private final Builder builder;

    public WeatherDirector(Builder builder) {
        this.builder = builder;
    }

    public Weather construct(String city, double temp, double hum, double wind, String cond) {
        builder.setCity(city);
        builder.setTemperature(temp);
        builder.setHumidity(hum);
        builder.setWindSpeed(wind);
        builder.setCondition(cond);
        return builder.build();
    }
}