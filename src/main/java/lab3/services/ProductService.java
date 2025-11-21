package lab3.services;


import lab3.entities.BookEntity;
import lab3.entities.ProductEntity;
import lab3.entities.TicketEntity;
import lab3.repositories.Repository;


import java.util.List;
import java.util.Optional;


/**
 * The Service Layer for handling product-related business logic.
 * This class is completely decoupled from the data storage mechanism.
 */
public class ProductService {
    // The service depends on the repository abstraction, not a concrete implementation.

    private final Repository<ProductEntity> productRepository;

    public ProductService(Repository<ProductEntity> productRepository) {
        this.productRepository = productRepository;
    }


    public BookEntity createBook(String title, double price, int copies, String isbn, String desc, String author) {
        BookEntity newBook = new BookEntity(title, price, copies, isbn, desc, author);
        // The service's job is to orchestrate. It asks the repository to save the object.
        return (BookEntity) productRepository.save(newBook);
    }


    public TicketEntity createTicket(String description, double price) {
        TicketEntity newTicket = new TicketEntity();
        newTicket.setDescription(description);
        newTicket.setPrice(price);
        return (TicketEntity) productRepository.save(newTicket);
    }

    public ProductEntity saveProduct(ProductEntity entity) {
        return productRepository.save(entity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}