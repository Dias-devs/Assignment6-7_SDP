package ObserverPattern.ConcreteObserver;

import BuilderPattern.Product.Weather;
import ObserverPattern.Observer.Observer;

public class WeatherObserver implements Observer {
    private final String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Weather weather) {
        System.out.println(name + " received update -> " + weather);
    }
}
