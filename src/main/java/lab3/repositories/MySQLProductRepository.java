package lab3.repositories;


import lab3.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.List;
import java.util.Optional;



public class MySQLProductRepository implements Repository<ProductEntity> {


    private final EntityManagerFactory emf;


    public MySQLProductRepository() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }


    @Override
    public Optional<ProductEntity> findById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            ProductEntity entity = em.find(ProductEntity.class, id);
            return Optional.ofNullable(entity);
        }
    }


    @Override
    public List<ProductEntity> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class)
                    .getResultList();
        }
    }


    @Override
    public ProductEntity save(ProductEntity entity) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProductEntity savedEntity = em.merge(entity);
            em.getTransaction().commit();
            return savedEntity;
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }


    @Override
    public void deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            ProductEntity entityToRemove = em.find(ProductEntity.class, id);
            if (entityToRemove != null) {
                em.remove(entityToRemove);
            }
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
    @Override
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}