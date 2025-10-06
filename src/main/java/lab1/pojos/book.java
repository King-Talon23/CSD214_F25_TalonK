package lab1.pojos;

public class book extends publication {
    private String author;


    public book() { super(); }
    public book(String title, double price, int copies, String author) {
        super(title, price, copies);
        this.author = author;
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