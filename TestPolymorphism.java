package Assignment;

import java.util.Scanner;

public class TestPolymorphism {
    public static void itemInstance(StockItem s) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Printing item stock information:");
        System.out.println(s);
        
        System.out.print("Enter number of stock units to increase: ");
        int inc = scanner.nextInt();
        s.addStock(inc);
        
        System.out.print("Enter number of stock units to sell: ");
        int sell = scanner.nextInt();
        s.sellStock(sell);
        
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        s.setPrice(price);
        
        System.out.println("Printing item stock information:");
        System.out.println(s);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        StockItem[] s = new StockItem[3];
        s[0] = new DashCam(5, 45.0, "DC01", "1080p");
        s[1] = new CarMats(20, 15.5, "CM01", "Black");
        s[2] = new AirFreshener(50, 2.99, "AF01", "Pine");

        for (int i = 0; i < s.length; i++) {
            itemInstance(s[i]);
        }
    }
}
