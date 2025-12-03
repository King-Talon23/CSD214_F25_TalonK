package lab3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class ComicBookEntity extends PublicationEntity {

    private String illustrator;
    private int year;
    private String publisher;

    public ComicBookEntity() {}

    public ComicBookEntity(String title, double price, int copies, String isbn, String description, String publisher, int year, String illustrator) {
        super(title, price, copies, isbn, description);
        this.illustrator = illustrator;
        this.year = year;
        this.publisher = publisher;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public void setIllustrator(String illustrator) {
        this.illustrator = illustrator;
    }


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    @Override
    public void edit() {
        System.out.println("--- Editing Comic Book "
                + (getTitle() != null ? "'" + getTitle() + "'" : "")
                + (getId() != null ? " (ID: " + getId() + ")" : "")
                + " ---");

        System.out.print("Enter new title (current: '" + (getTitle() == null ? "" : getTitle()) + "'): ");
        setTitle(super.getInput(getTitle() == null ? "" : getTitle()));

        System.out.print("Enter new illustrator (current: '" + (illustrator == null ? "" : illustrator) + "'): ");
        setIllustrator(super.getInput(illustrator == null ? "" : illustrator));

        System.out.print("Enter new publisher (current: '" + (getPublisher() == null ? "" : getPublisher()) + "'): ");
        setPublisher(super.getInput(getPublisher() == null ? "" : getPublisher()));

        System.out.print("Enter new year (current: " + getYear() + "): ");
        setYear(super.getInput(getYear()));

        System.out.print("Enter new price (current: " + getPrice() + "): ");
        setPrice(super.getInput(getPrice()));

        System.out.print("Enter new copies (current: " + getCopies() + "): ");
        setCopies(super.getInput(getCopies()));

        System.out.println("Comic Book updated.");
    }



    @Override
    public void initialize() {
        System.out.println("--- Initializing New Comic Book ---");

        System.out.print("Enter title: ");
        setTitle(super.getInput(""));

        System.out.print("Enter illustrator: ");
        setIllustrator(super.getInput(""));

        System.out.print("Enter publisher: ");
        setPublisher(super.getInput(""));

        System.out.print("Enter year: ");
        setYear(super.getInput(0));

        System.out.print("Enter price: ");
        setPrice(super.getInput(0.0));

        System.out.print("Enter copies: ");
        setCopies(super.getInput(0));

        System.out.println("Comic Book initialized.");
    }

    @Override
    public void sellItem() {
        if (getCopies() > 0) {
            setCopies(getCopies() - 1);
            System.out.println("Sold Comic Book: '" + getTitle()
                    + "' illustrated by " + illustrator
                    + ". Copies left: " + getCopies());
        } else {
            System.out.println("Comic Book '" + getTitle() + "' is out of stock.");
        }
    }
}
