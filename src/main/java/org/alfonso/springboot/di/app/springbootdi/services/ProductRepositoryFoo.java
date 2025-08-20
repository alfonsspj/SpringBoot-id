package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;


@Primary // implementacion por defecto (entre ProductRepositoryFoo y ProductServiceImpl)
@Repository
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        // una unica lista
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27", 600L);
    }
}
