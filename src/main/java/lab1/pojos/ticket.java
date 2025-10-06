package lab1.pojos;

import java.io.Serializable;


public class ticket implements saleableItem, Serializable {
    private int id;
    private String description;
    private double price;


    public ticket() {}
    public ticket(int id, String description, double price) { this.id = id; this.description = description; this.price = price; }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }


    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    @Override
    public void sellItem() { System.out.println("Ticket sold: " + description + " ("+price+")"); }


    @Override
    public String toString() { return "Ticket[id="+id+",desc="+description+",price="+price+"]"; }
}