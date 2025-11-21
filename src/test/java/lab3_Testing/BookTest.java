package lab3_Testing;


import lab3.entities.BookEntity.*;
import lab3.entities.BookEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Book Entity Unit Tests")
class BookTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayOutputStream testOutput;

    @BeforeEach
    void setUp() {
        testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    @DisplayName("Should set and get author correctly")
    void testGetAndSetAuthor() {
        BookEntity book = new BookEntity();
        String expectedAuthor = "J.R.R. Tolkien";
        book.setAuthor(expectedAuthor);
        assertEquals(expectedAuthor, book.getAuthor(), "The author should be correctly set and retrieved.");
    }

    @Test
    @DisplayName("initialize() should correctly populate a BookEntity from user input")
    void testInitialize() {
        String simulatedInput = "The Hobbit\n"
                + "J.R.R. Tolkien\n"
                + "978-0345339683\n"
                + "A classic fantasy.\n"
                + "14.99\n"
                + "10\n";

        BookEntity book = new BookEntity();
        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        book.setSystemInput(testIn);

        book.initialize();

        assertEquals("The Hobbit", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());
        assertEquals("978-0345339683", book.getIsbn_10());
        assertEquals("A classic fantasy.", book.getDescription());
        assertEquals(14.99, book.getPrice());
        assertEquals(10, book.getCopies());
    }

    @Test
    @DisplayName("edit() should correctly update fields and respect empty input")
    void testEdit() {
        BookEntity book = new BookEntity("Dune", 17.99, 8, "978-0441013593", "Sci-fi classic.", "Frank Herbert");
        book.setId(1L);

        String simulatedInput = "Dune Messiah\n"
                + "\n"
                + "20.50\n"
                + "\n";

        ByteArrayInputStream testIn = new ByteArrayInputStream(simulatedInput.getBytes());
        book.setSystemInput(testIn);

        book.edit();

        assertEquals("Dune Messiah", book.getTitle(), "Title should be updated.");
        assertEquals("Frank Herbert", book.getAuthor(), "Author should remain unchanged.");
        assertEquals(20.50, book.getPrice(), "Price should be updated.");
        assertEquals(8, book.getCopies(), "Copies should remain unchanged.");

        String output = testOutput.toString();
        assertTrue(output.contains("--- Editing Book 'Dune' (ID: 1) ---"));
        assertTrue(output.contains("Enter new title (current: 'Dune'):"));
        assertTrue(output.contains("Enter new author (current: 'Frank Herbert'):"));
    }

    @Test
    @DisplayName("sellItem() should decrement copies when stock is available")
    void testSellItemWithStock() {
        BookEntity book = new BookEntity();
        book.setCopies(5);
        book.setTitle("1984");

        book.sellItem();

        assertEquals(4, book.getCopies(), "Copies should be decremented by 1.");
        assertTrue(testOutput.toString().contains("Sold Book: '1984'"));
    }

    @Test
    @DisplayName("sellItem() should not decrement copies when out of stock")
    void testSellItemOutOfStock() {
        BookEntity book = new BookEntity();
        book.setCopies(0);
        book.setTitle("Animal Farm");

        book.sellItem();

        assertEquals(0, book.getCopies(), "Copies should remain 0 when out of stock.");
        assertTrue(testOutput.toString().contains("Book 'Animal Farm' is out of stock."));
    }

    @Test
    @DisplayName("equals() and hashCode() should be consistent")
    void testEqualsAndHashCode() {
        BookEntity book1 = new BookEntity("Title", 10.0, 5, "123", "Desc", "Author");
        BookEntity book2 = new BookEntity("Title", 10.0, 5, "123", "Desc", "Author");
        BookEntity book3 = new BookEntity("Different Title", 10.0, 5, "123", "Desc", "Author");

        // Test for identicals
        assertEquals(book1, book2, "Two books with identical properties should be equal.");
        assertEquals(book1.hashCode(), book2.hashCode(), "Hash codes should be equal for equal objects.");

        // Test for differentials
        assertNotEquals(book1, book3, "Two books with different properties should not be equal.");
        assertNotEquals(book1.hashCode(), book3.hashCode(), "Hash codes should ideally be different for non-equal objects.");
    }
}
