package org.alfonso.springboot.di.app.springbootdi.repositories;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import java.util.List;


public interface ProductRepository {

    List<Product> findAll();
    Product findById(Long id);
}
