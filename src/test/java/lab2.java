import lab2.pojos.SaleableItem;
import static org.junit.jupiter.api.Assertions.*;
import lab2.pojos.*;
import lab2.pojos.fakes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import lab2.App;

class lab2 {
        private List<SaleableItem> inventory;

        @BeforeEach
        void setUp() {
            inventory = new ArrayList<>();
        }

        @Test
        void testAddFakeBook() {
            FakeBook book = utility.getFakeBook();
            inventory.add(book);

            assertFalse(inventory.isEmpty(), "Inventory should not be empty after adding a book");
            assertTrue(inventory.get(0) instanceof FakeBook, "First item should be a Book");
            assertNotNull(book.getTitle(), "Book title should not be null");
            assertTrue(book.getPrice() > 0, "Book price should be positive");
        }

        @Test
        void testAddFakeMagazine() {
            FakeMagazine mag = utility.getFakeMagazine();
            inventory.add(mag);

            assertEquals(1, inventory.size());
            assertTrue(mag.getOrderQty() > 0, "Order quantity should be > 0");
            assertNotNull(mag.getCurrentIssue(), "Current issue date should not be null");
        }

        @Test
        void testAddFakeDiscMag() {
            FakeDiscMag discMag = utility.getFakeDiscMag();
            inventory.add(discMag);

            assertEquals(1, inventory.size());
            assertTrue(inventory.get(0) instanceof FakeDiscMag);
        }

        @Test
        void testAddFakeTicket() {
            Ticket ticket = utility.getFakeTicket();
            inventory.add(ticket);

            assertEquals(1, inventory.size());
            assertTrue(ticket.getPrice() > 0);
            assertTrue(ticket.getDescription().contains("ticket"), "Ticket description should mention ticket");
        }

        @Test
        void testEditBook() {
            FakeBook book = utility.getFakeBook();
            String oldTitle = book.getTitle();
            double oldPrice = book.getPrice();


            book.setTitle("Edited Title");
            book.setPrice(oldPrice + 10);

            assertNotEquals(oldTitle, book.getTitle(), "Book title should be updated");
            assertEquals(oldPrice + 10, book.getPrice(), 0.001, "Book price should increase by 10");
        }



        @Test
        void testSellTicket() {
            Ticket ticket = utility.getFakeTicket();
            double price = ticket.getPrice();

            assertDoesNotThrow(ticket::sellItem, "Selling a ticket should not throw exceptions");
            assertTrue(price > 0, "Ticket price should be positive");
        }

    @Test
    void testDeleteItem() {
        List<SaleableItem> inventory = new ArrayList<>();
        FakeBook book = utility.getFakeBook();
        FakeMagazine mag = utility.getFakeMagazine();
        inventory.add(book);
        inventory.add(mag);

        int initialSize = inventory.size();
        SaleableItem removed = inventory.get(0);
        App.deleteItem(inventory, true);


        assertEquals(initialSize - 1, inventory.size(), "Inventory size should decrease by 1 after deletion");
        assertFalse(inventory.contains(removed), "Deleted item should no longer be in inventory");
        assertEquals(mag, inventory.get(0), "Remaining item should be the second one originally added");
    }

}
