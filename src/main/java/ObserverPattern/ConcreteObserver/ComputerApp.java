package ObserverPattern.ConcreteObserver;

import BuilderPattern.Product.Weather;
import ObserverPattern.Observer.Observer;

public class ComputerApp implements Observer {
    private final String owner;

    public ComputerApp(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(Weather weather) {
        System.out.println(owner + " received update -> " + weather);
    }
}
