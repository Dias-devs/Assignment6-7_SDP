package ObserverPattern.ConcreteSubject;

import BuilderPattern.Product.Weather;
import ObserverPattern.Observer.Observer;
import ObserverPattern.Subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Weather weather) {
        for (Observer o : observers) o.update(weather);
    }
}