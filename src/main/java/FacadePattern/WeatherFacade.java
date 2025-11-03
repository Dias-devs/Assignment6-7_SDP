package FacadePattern;

import BuilderPattern.Product.Weather;
import ObserverPattern.ConcreteObserver.WeatherObserver;
import ObserverPattern.ConcreteSubject.WeatherStation;
import StrategyPattern.Context.UpdateContext;
import StrategyPattern.Interface.UpdateStrategy;

public class WeatherFacade {
    private final WeatherStation station = new WeatherStation();
    private final UpdateContext context = new UpdateContext();

    public void addObserver(String name) {
        station.registerObserver(new WeatherObserver(name));
    }

    public void changeStrategy(UpdateStrategy strategy) {
        context.setStrategy(strategy);
    }

    public void updateCity(String city) {
        Weather weather = context.executeStrategy(city);
        station.notifyObservers(weather);
    }
}