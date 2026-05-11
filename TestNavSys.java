package Assignment;

public class TestNavSys {
    public static void main(String[] args) {
        System.out.println("Task 1. Creating a stock with 10 units Navigation system, price 99.99, and item code NS101");
        System.out.println("Printing stock item information");
        NavSys nav = new NavSys(10, 99.99, "NS101");
        System.out.println(nav);
        System.out.println();

        System.out.println("Task 2. Increasing 10 more units");
        System.out.println("Printing stock item information");
        nav.addStock(10);
        System.out.println(nav);
        System.out.println();

        System.out.println("Task 3. Sold 2 units");
        System.out.println("Printing stock item information");
        nav.sellStock(2);
        System.out.println(nav);
        System.out.println();

        System.out.println("Task 4. Set new price 100.99 per unit");
        System.out.println("Printing stock item information");
        nav.setPrice(100.99);
        System.out.println(nav);
        System.out.println();

        System.out.println("Task 5. Increasing 0 more units");
        nav.addStock(0);
    }
}
