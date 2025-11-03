package ObserverPattern.Subject;

import BuilderPattern.Product.Weather;
import ObserverPattern.Observer.Observer;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Weather weather);
}