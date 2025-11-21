package lab3.pojos;

public class CashTill {

    private double runningTotal;

    public void sellItem(SaleableItem saleableItem) {
        runningTotal = runningTotal + saleableItem.getPrice();
        saleableItem.sellItem();
        System.out.println("Sold " + saleableItem + " @ "
                + saleableItem.getPrice() + "\nSubtotal = "
                + runningTotal);
    }

    public void showTotal() {
        System.out.println("Till Total: " + runningTotal);
    }
}
