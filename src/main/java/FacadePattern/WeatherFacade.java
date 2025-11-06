package FacadePattern;

import BuilderPattern.Product.Weather;
import ObserverPattern.ConcreteObserver.PhoneApp;
import ObserverPattern.ConcreteSubject.WeatherStation;
import StrategyPattern.Concretes.ScheduledUpdate;
import StrategyPattern.Context.UpdateContext;
import StrategyPattern.Interface.UpdateStrategy;

public class WeatherFacade {
    private final WeatherStation station = new WeatherStation();
    private final UpdateContext context = new UpdateContext(new ScheduledUpdate());

    public void addObserver(String name) {
        station.addObserver(new PhoneApp(name));
    }

    public void changeStrategy(UpdateStrategy strategy) {
        context.setUpdateStrategy(strategy);
    }

    public void updateCity(String city) {
        Weather weather = context.performUpdate(city);
        station.notifyObservers(weather);
    }
}