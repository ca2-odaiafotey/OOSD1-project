package Assignment;

/**
 * StockItem class for the shop.
 * Written by a student for the OO Systems Development assignment.
 */
public class StockItem {
    private String stockCode;
    private int quantity;
    private double price;

    public StockItem(int quantity, double price, String stockCode) {
        this.quantity = quantity;
        this.price = price;
        this.stockCode = stockCode;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStockName() {
        return "Unknown Stock Name";
    }

    public String getStockDescription() {
        return "Unknown Stock Description";
    }

    public void addStock(int amount) {
        if (amount < 1) {
            System.out.println("The error was: Increased item must be greater than or equal to one");
        } else if (this.quantity + amount > 100) {
            System.out.println("The error was: Stock cannot exceed 100");
        } else {
            this.quantity += amount;
        }
    }

    public boolean sellStock(int amount) {
        if (amount < 1) {
            System.out.println("The error was: amount to sell must be at least 1");
            return false;
        }
        if (amount <= this.quantity) {
            this.quantity -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getVAT() {
        return 17.5;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceWithoutVAT() {
        return this.price;
    }

    public double getPriceWithVAT() {
        return this.price + (this.price * getVAT() / 100.0);
    }

    public String toString() {
        return "Stock Type: " + getStockName() + "\n" +
               "Description: " + getStockDescription() + "\n" +
               "Stock Code: " + stockCode + "\n" +
               "Price Without VAT: " + getPriceWithoutVAT() + "\n" +
               "Price With VAT: " + getPriceWithVAT() + "\n" +
               "Total unit in stock: " + quantity;
    }
}
