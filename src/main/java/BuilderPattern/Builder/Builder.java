package BuilderPattern.Builder;

import BuilderPattern.Product.Weather;

public interface Builder {
    void setCity(String city);
    void setTemperature(double temperature);
    void setHumidity(double humidity);
    void setWindSpeed(double windSpeed);
    void setCondition(String condition);
    Weather build();
}
