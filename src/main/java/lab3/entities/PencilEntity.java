package lab3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pencils")
public class PencilEntity extends ProductEntity {

    private String name;
    private String color;
    private double price;

    public PencilEntity() {}

    public PencilEntity(String productId, String name, double price, String color) {
        super(productId);
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public void edit() {
        System.out.println("--- Editing Pencil "
                + (getName() != null ? "'" + getName() + "'" : "")
                + (getId() != null ? " (ID: " + getId() + ")" : "")
                + " ---");

        System.out.print("Enter new name (current: '" + (name == null ? "" : name) + "'): ");
        setName(super.getInput(name == null ? "" : name));

        System.out.print("Enter new color (current: '" + (color == null ? "" : color) + "'): ");
        setColor(super.getInput(color == null ? "" : color));

        System.out.print("Enter new price (current: " + price + "): ");
        setPrice(super.getInput(price));

        System.out.print("Enter new product ID (current: '" + (getProductId() == null ? "" : getProductId()) + "'): ");
        setProductId(super.getInput(getProductId() == null ? "" : getProductId()));

        System.out.println("Pencil updated.");
    }

    @Override
    public void initialize() {
        System.out.println("--- Initializing New Pencil ---");

        System.out.print("Enter product ID: ");
        setProductId(super.getInput(""));

        System.out.print("Enter name: ");
        setName(super.getInput(""));

        System.out.print("Enter color: ");
        setColor(super.getInput(""));

        System.out.print("Enter price: ");
        setPrice(super.getInput(0.0));

        System.out.println("Pencil initialized.");
    }


    @Override
    public void sellItem() {
        System.out.println("Sold Pencil: '" + name + "' (Color: " + color + ")");
    }
}
