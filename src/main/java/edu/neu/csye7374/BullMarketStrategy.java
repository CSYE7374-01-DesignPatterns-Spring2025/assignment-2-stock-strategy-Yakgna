package edu.neu.csye7374;

public class BullMarketStrategy implements StrategyAPI {
    @Override
    public double calculateStockPrice(double price) {
        return price * 1.5;
    }
}
