package lab2.pojos.fakes;

import lab2.pojos.Publication;

public class FakeBook extends Publication {
    private String author;


    public FakeBook(String title, double price, int copies, String author) {
    }


    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }


    @Override
    public void initialize() {
        setTitle(getInput("Title", getTitle()));
        setPrice(getInputDouble("Price", getPrice()));
        setCopies(getInputInt("Copies", getCopies()));
        this.author = getInput("Author", author);
    }


    @Override
    public void edit() { initialize(); }


    @Override
    public void sellItem() {
        if (getCopies() > 0) { setCopies(getCopies() - 1); System.out.println("Sold book: " + getTitle()); }
        else System.out.println("Book out of stock: " + getTitle());
    }


    @Override
    public String toString() { return "Book: " + super.toString() + ", author=" + author; }
}