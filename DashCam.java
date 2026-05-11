package Assignment;

public class DashCam extends StockItem {
    private String resolution;

    public DashCam(int quantity, double price, String stockCode, String resolution) {
        super(quantity, price, stockCode);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String getStockName() {
        return "Dash Camera";
    }

    @Override
    public String getStockDescription() {
        return "Records video while driving";
    }

    @Override
    public String toString() {
        return super.toString() + "\nResolution: " + resolution;
    }
}
