package Assignment;

public class NavSys extends StockItem {
    public NavSys(int quantity, double price, String stockCode) {
        super(quantity, price, stockCode);
    }

    @Override
    public String getStockName() {
        return "Navigation system";
    }

    @Override
    public String getStockDescription() {
        return "Geo Vision Sat Nav";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
