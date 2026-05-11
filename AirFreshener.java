package Assignment;

public class AirFreshener extends StockItem {
    private String scent;

    public AirFreshener(int quantity, double price, String stockCode, String scent) {
        super(quantity, price, stockCode);
        this.scent = scent;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    @Override
    public String getStockName() {
        return "Air Freshener";
    }

    @Override
    public String getStockDescription() {
        return "Makes the car smell nice";
    }

    @Override
    public String toString() {
        return super.toString() + "\nScent: " + scent;
    }
}
