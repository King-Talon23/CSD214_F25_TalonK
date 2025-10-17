package lab2.pojos;

import java.io.Serializable;
import java.util.Objects;


public abstract class Publication extends Editable implements SaleableItem, Serializable {
    private String title;
    private double price;
    private int copies;


    public Publication() {}
    public Publication(String title, double price, int copies) {
        this.title = title; this.price = price; this.copies = copies;
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }


    @Override
    public String toString() {
        return String.format("Publication[id=%d,title=%s,price=%.2f,copies=%d]", id, title, price, copies);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publication)) return false;
        Publication p = (Publication) o;
        return Double.compare(p.price, price) == 0 && copies == p.copies && Objects.equals(title, p.title);
    }


    @Override
    public int hashCode() { return Objects.hash(title, price, copies); }
}