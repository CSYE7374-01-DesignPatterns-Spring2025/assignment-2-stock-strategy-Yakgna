package edu.neu.csye7374;

public class StockMarket {
    private static StockMarket stockMarketInstance;

//    private List<StockAPI> stocks = new ArrayList<>();

    private StrategyAPI strategyAPI;

    private StockAPI stock;

    public void setStrategy(StrategyAPI strategyAPI) {
        this.strategyAPI = strategyAPI;
    }

    public double calculateStockPrice() {
        return strategyAPI.calculateStockPrice(this.stock.getPrice());
    }

    public void setStock(StockAPI stock) { this.stock = stock; }

    private StockMarket(){

    }

//    public void add(StockAPI stock) {stocks.add(stock);}
//
//    public void remove(StockAPI stk) {
//        boolean isRemoved = this.stocks.remove(stk);
//
//        if(!isRemoved) {
//            System.out.println("stock was not found to be traded");
//        }
//    }
    public static StockMarket getInstance(){
        if(stockMarketInstance == null){
            stockMarketInstance = new StockMarket();
        }
        return stockMarketInstance;
    }

    public void tradeStock(String bid) {
        stock.setBid(bid);
        System.out.println("Traded: " + stock.toString());
    }

    public String getMetric() {
        return stock.getMetric();
    }

    public static void demo(){
        StockMarket stockMarket = getInstance();

        //IBM Stock
        //Strategy Pattern
        stockMarket.setStock(new IBM());
        System.out.println("<-----------------IBM Stock {Price: " + stockMarket.stock.getPrice() + "}" + "----------------->");
        String[] bids = new String[]{"132.89", "130.98", "135.00", "134.02", "136.00", "139.02"};
        for (String bid : bids) {
            stockMarket.tradeStock(bid);
        }
        System.out.println(stockMarket.getMetric());
        stockMarket.setStrategy(new BullMarketStrategy());
        System.out.println("<------Bull Market Strategy (Price * 1.5): " + stockMarket.calculateStockPrice() + "------>");
        stockMarket.setStrategy(new BearMarketStrategy());
        System.out.println("<------Bear Market Strategy (Price * 1.2): " + stockMarket.calculateStockPrice() + "------>");
        System.out.println();

        //Tech Stock
        //Strategy Pattern
        stockMarket.setStock(new TechStock());
        System.out.println("<-----------------Tech Stock {Price: " + stockMarket.stock.getPrice() + "}" + "----------------->");
        bids = new String[]{"132", "133", "135", "134", "136", "139"};
        for (String bid : bids) {
            stockMarket.tradeStock(bid);
        }
        System.out.println(stockMarket.getMetric());
        stockMarket.setStrategy(new BullMarketStrategy());
        System.out.println("<------Bull Market Strategy (Price * 1.5): " + stockMarket.calculateStockPrice() + "------>");
        stockMarket.setStrategy(new BearMarketStrategy());
        System.out.println("<------Bear Market Strategy (Price * 1.2): " + stockMarket.calculateStockPrice() + "------>");
        System.out.println();
        
    }
}
