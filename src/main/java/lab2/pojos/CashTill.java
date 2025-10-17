package lab2.pojos;


public class CashTill {
    private double runningTotal = 0.0;


    public void sellItem(SaleableItem item) {
        if (item == null) return;
        System.out.println("Processing sale...");
        item.sellItem();
        double p = item.getPrice();
        runningTotal += p;
        System.out.printf("Added %.2f to till.%n", p);
        showTotal();
        System.out.println("End sale.\n");
    }


    public void showTotal() { System.out.printf("Running total: %.2f\n", runningTotal); }
}
