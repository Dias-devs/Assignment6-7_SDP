package BuilderPattern.ConcreteBuilder;

import BuilderPattern.Builder.Builder;
import BuilderPattern.Product.Weather;

public class ConcreteWeatherBuilder implements Builder {
    private String city;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String condition;

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public Weather build() {
        return new Weather(city, temperature, humidity, windSpeed, condition);
    }
}
