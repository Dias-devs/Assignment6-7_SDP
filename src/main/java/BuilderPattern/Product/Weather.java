package BuilderPattern.Product;

public class Weather {
    private final String city;
    private final double temperature;
    private final double humidity;
    private final double windSpeed;
    private final String condition;

    public Weather(String city, double temperature, double humidity,
                    double windSpeed, String condition) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.condition = condition;
    }

    @Override
    public String toString() {
        return String.format("City: %s | Temp: %.1f°C | Humidity: %.1f%% | Wind: %.1f km/h | Condition: %s",
                city, temperature, humidity, windSpeed, condition);
    }

    public String getCity() {
        return city;
    }
    public double getTemperature() {
        return temperature;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public String getCondition() {
        return condition;
    }
}