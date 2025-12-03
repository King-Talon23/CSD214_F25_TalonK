
import com.github.javafaker.Faker;
import lab2.pojos.*;
import lab2.pojos.fakes.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class utility {
    private static Faker faker = new Faker();
    private static com.github.javafaker.Book fakeBook = faker.book();
    private static com.github.javafaker.Number number = faker.number();
    private static com.github.javafaker.Code code = faker.code();


    public static FakeBook getFakeBook() {
        String title = "im a fake book";
        double price = number.randomDouble(2, 10, 100);
        int copies = number.numberBetween(1, 20);
        String author = fakeBook.author();
        return new FakeBook(
                title,
                price,
                copies,
                author
        );
    }

    public static FakeMagazine getFakeMagazine() {
        int copies = number.numberBetween(1, 20);
        LocalDate date = LocalDate.now();
        return new FakeMagazine(
                copies,
                date
        );
    }

    public static FakeDiscMag getFakeDiscMag() {
        FakeMagazine dm = getFakeMagazine();
        return new FakeDiscMag(
                dm,
                true
        );
    }

    public static Ticket getFakeTicket() {
        var random = new java.util.Random();
        return new Ticket(utility.getFakeIntBetween(1, 100),
                "This is a ticket for cool event # " + random.nextInt(),
                utility.getFakedoubleBetween(1,100)
        );
    }


    public static int getFakeIntBetween(int min, int max) {
        return number.numberBetween(min, max);
    }
    public static double getFakedoubleBetween(int min, int max) {
        return number.numberBetween(min, max);
    }
}
