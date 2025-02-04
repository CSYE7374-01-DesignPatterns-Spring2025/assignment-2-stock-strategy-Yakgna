package edu.neu.csye7374;

public class BearMarketStrategy implements StrategyAPI{
    @Override
    public double calculateStockPrice(double price) {
        return price * 1.2;
    }
}
