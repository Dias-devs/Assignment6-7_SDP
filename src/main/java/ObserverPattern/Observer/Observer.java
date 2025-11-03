package ObserverPattern.Observer;

import BuilderPattern.Product.Weather;

public interface Observer {
    void update(Weather weather);
}