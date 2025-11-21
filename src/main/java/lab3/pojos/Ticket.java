package lab3.pojos;


public class Ticket extends Product {
    private String description;
    private double price;

    public Ticket(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Ticket() {
    }

    public void setDescription(String description) {
        this.description=description;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public void sellItem() {
        System.out.println(getDescription());
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
        System.out.println("Edit ticket text");
        setDescription(getInput(getDescription()));
        System.out.println("Edit ticket price");
        setPrice(getInput(getPrice()));
    }

    @Override
    public void initialize() {
        System.out.println("Enter ticket text");
        setDescription(getInput(getDescription()));
        System.out.println("Edit ticket price");
        setPrice(getInput(getPrice()));
    }
    public String toString() {
        String format = "%-20s Description: %-250s";
        return String.format(format, this.getClass().getSimpleName(), getDescription());
    }
}