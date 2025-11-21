package lab3.entities;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.Objects;

public class MagazineEntity extends PublicationEntity {

    @Column(name = "order_qty")
    private int orderQty;

    @Column(name = "current_issue")
    private LocalDate currIssue;

    public void MagazineEntity() {
    }

    public MagazineEntity(String title, double price, int copies, String isbn_10, String description,
                          int orderQty, LocalDate currIssue) {
        super(title, price, copies, isbn_10, description);
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }


    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public LocalDate getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(LocalDate currIssue) {
        this.currIssue = currIssue;
    }

    @Override
    public void edit() {
        System.out.println("--- Editing Magazine "
                + (getTitle() != null ? "'" + getTitle() + "'" : "")
                + (getId() != null ? " (ID: " + getId() + ")" : "")
                + " ---");

        System.out.print("Enter new title (current: '" + (getTitle() == null ? "" : getTitle()) + "'): ");
        setTitle(super.getInput(getTitle() == null ? "" : getTitle()));

        System.out.print("Enter new copies (current: " + getCopies() + "): ");
        setCopies(super.getInput(getCopies()));

        System.out.print("Enter new price (current: " + getPrice() + "): ");
        setPrice(super.getInput(getPrice()));

        System.out.print("Enter new order quantity (current: " + getOrderQty() + "): ");
        setOrderQty(super.getInput(getOrderQty()));

        System.out.print("Enter new current issue (current: " + getCurrIssue() + " in dd-MMM-yyyy format): ");
        setCurrIssue(super.getInput(getCurrIssue()));

        System.out.println("Magazine updated.");
    }

    @Override
    public void initialize() {
        System.out.println("--- Initializing New Magazine ---");

        System.out.print("Enter title: ");
        setTitle(super.getInput(""));

        System.out.print("Enter copies: ");
        setCopies(super.getInput(0));

        System.out.print("Enter price: ");
        setPrice(super.getInput(0.0));

        System.out.print("Enter order quantity: ");
        setOrderQty(super.getInput(0));

        System.out.print("Enter current issue (dd-MMM-yyyy): ");
        setCurrIssue(super.getInput(java.time.LocalDate.now()));

        System.out.println("Magazine initialized.");
    }


    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Sold Magazine: '" + getTitle() + "'. Copies left: " + getCopies());
        } else {
            System.out.println("Magazine '" + getTitle() + "' is out of stock.");
        }
    }

    @Override
    public String toString() {
        String format = "Order Qty: %-10s Current Issue: %-15s";
        return super.toString() + " " + String.format(format, getOrderQty(), getCurrIssue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MagazineEntity that)) return false;
        if (!super.equals(o)) return false;
        return orderQty == that.orderQty && Objects.equals(currIssue, that.currIssue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), orderQty, currIssue);
    }
}


