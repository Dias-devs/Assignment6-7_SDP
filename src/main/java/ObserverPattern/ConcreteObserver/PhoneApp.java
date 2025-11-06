package ObserverPattern.ConcreteObserver;

import BuilderPattern.Product.Weather;
import ObserverPattern.Observer.Observer;

public class PhoneApp implements Observer {
    private final String owner;

    public PhoneApp(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(Weather weather) {
        System.out.println(owner + " received update -> " + weather);
    }
}
