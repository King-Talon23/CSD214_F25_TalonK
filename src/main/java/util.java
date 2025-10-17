
import com.github.javafaker.Faker;
import lab2.pojos.*;


public class util {
    private static Faker faker = new Faker();
    private static com.github.javafaker.Book fakeBook = faker.book();
    private static com.github.javafaker.Number number = faker.number();
    private static com.github.javafaker.Code code = faker.code();


    public static Book getFakeBook() {
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String author = fakeBook.author();
        String isbn = code.isbn10();
        String description = "Book: " + fakeBook.genre();
        return new Book(
                UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE,
                title,
                price,
                copies,
                isbn,
                description,
                author
        );
    }

    public static Magazine getFakeMagazine() {
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String author = fakeBook.author();
        String isbn = code.isbn10();
        String description = "Magazine: " + fakeBook.genre();
        return new Magazine(
                title,
                price,
                copies,
                isbn,
                description,
                copies,
                localDate.now()
        );
    }

    public static DiscMag getFakeDiscMag() {
        Magazine dm = getFakeMagazine();
        var random = new java.util.Random();
        return new DiscMag(
                dm,
                random.nextBoolean()
        );
    }

    public static Ticket getFakeTicket() {
        var random = new java.util.Random();
        return new Ticket(
                "This is a ticket for cool event # " + random.nextInt(),
                util.getFakeDoubleBetween(1, 100)
        );
    }


    public static int getFakeIntegerBetween(int min, int max) {
        return number.numberBetween(min, max);
    }


    public static double getFakeDoubleBetween(int min, int max) {
        return number.randomDouble(2, 10, 100);
    }
}


