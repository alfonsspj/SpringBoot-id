package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import java.util.List;


public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
