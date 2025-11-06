package StrategyPattern.Context;

import StrategyPattern.Interface.UpdateStrategy;

public class UpdateContext {
    private UpdateStrategy updateStrategy;

    public UpdateContext(UpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    public void setUpdateStrategy(UpdateStrategy updateStrategy) {
        this.updateStrategy = updateStrategy;
    }

    public void performUpdate(String city) {
        updateStrategy.updateWeather(city);
    }
}