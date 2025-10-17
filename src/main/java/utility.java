
import com.github.javafaker.Faker;
import lab2.pojos.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class utility {
    private static Faker faker = new Faker();
    private static com.github.javafaker.Book fakeBook = faker.book();
    private static com.github.javafaker.Number number = faker.number();
    private static com.github.javafaker.Code code = faker.code();


    public static Book getFakeBook() {
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String author = fakeBook.author();
        return new Book(
                title,
                price,
                copies,
                author
        );
    }

    public static Magazine getFakeMagazine() {
        String title = fakeBook.title();
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        LocalDate date = LocalDate.now();
        return new Magazine(
                title,
                price,
                copies,
                date
        );
    }

    public static DiscMag getFakeDiscMag() {
        Magazine dm = getFakeMagazine();
        return new DiscMag(
                dm,
                true
        );
    }

    public static Ticket getFakeTicket() {
        var random = new java.util.Random();
        return new Ticket(
                "This is a ticket for cool event # " + random.nextInt(),
                utility.getFakeDoubleBetween(1, 100)
        );
    }


    public static int getFakeIntegerBetween(int min, int max) {
        return number.numberBetween(min, max);
    }


    public static double getFakeDoubleBetween(int min, int max) {
        return number.randomDouble(2, 10, 100);
    }
}


