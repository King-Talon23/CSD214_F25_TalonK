package lab2.pojos.fakes;

import lab2.pojos.Publication;

import java.time.LocalDate;


public class FakeMagazine extends Publication {
    private int orderQty;
    private LocalDate currentIssue;



    public FakeMagazine(String title, double price, int copies, LocalDate date) {
    }


    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int orderQty) { this.orderQty = orderQty; }


    public LocalDate getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(LocalDate currentIssue) { this.currentIssue = currentIssue; }


    @Override
    public void initialize() {
        setTitle(getInput("Title", getTitle()));
        setPrice(getInputDouble("Price", getPrice()));
        setCopies(getInputInt("Copies", getCopies()));
        this.orderQty = getInputInt("Order Qty", orderQty);
        this.currentIssue = getInputDate("Current Issue (dd-MM-yyyy)", currentIssue);
    }


    @Override
    public void edit() { initialize(); }


    @Override
    public void sellItem() {
        if (getCopies() > 0) { setCopies(getCopies() - 1); System.out.println("Sold magazine: " + getTitle()); }
        else System.out.println("Magazine out of stock: " + getTitle());
    }
}
