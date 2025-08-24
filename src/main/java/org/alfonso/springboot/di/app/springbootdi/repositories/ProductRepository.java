package org.alfonso.springboot.di.app.springbootdi.repositories;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.List;


public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);

//    @Primary // implementacion por defecto (entre ProductRepositoryFoo y ProductServiceImpl)
    @Repository
    class ProductRepositoryFoo implements ProductRepository {

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
}
