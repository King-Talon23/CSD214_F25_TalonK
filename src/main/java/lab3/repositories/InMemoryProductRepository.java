package lab3.repositories;


import lab3.entities.ProductEntity;

import java.util.*;


public class InMemoryProductRepository implements Repository<ProductEntity> {

    private final Map<Long, ProductEntity> products = new HashMap<>();
    private Long nextId = 1L;


    @Override
    public Optional<ProductEntity> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<ProductEntity> findAll() {
        return new ArrayList<>(products.values());
    }


    @Override
    public ProductEntity save(ProductEntity entity) {
        if (entity.getId() == null || entity.getId() == 0L) {
            entity.setId(nextId++);
        }

        products.put(entity.getId(), entity);
        return entity;
    }


    @Override
    public void deleteById(Long id) {
        products.remove(id);
    }

    public void clear() {
        products.clear();
        nextId = 1L;
    }
}