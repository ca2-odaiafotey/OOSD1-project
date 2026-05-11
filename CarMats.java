package Assignment;

public class CarMats extends StockItem {
    private String color;

    public CarMats(int quantity, double price, String stockCode, String color) {
        super(quantity, price, stockCode);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getStockName() {
        return "Car Mats";
    }

    @Override
    public String getStockDescription() {
        return "Floor mats for the car";
    }

    @Override
    public String toString() {
        return super.toString() + "\nColor: " + color;
    }
}
