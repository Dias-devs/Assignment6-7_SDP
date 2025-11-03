package StrategyPattern.Context;

import BuilderPattern.Product.Weather;
import StrategyPattern.Interface.UpdateStrategy;

public class UpdateContext {
    private UpdateStrategy strategy;
    private String city;

    public UpdateContext() {
    }

    public UpdateContext(UpdateStrategy strategy, String city) {
        this.strategy = strategy;
        this.city = city;
    }

    public void setStrategy(UpdateStrategy strategy) { this.strategy = strategy; }
    public void setCity(String city) { this.city = city; }

    public Weather executeStrategy(String city) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy set!");
        }
        return strategy.updateData(city);
    }
}