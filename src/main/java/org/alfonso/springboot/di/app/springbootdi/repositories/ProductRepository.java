package org.alfonso.springboot.di.app.springbootdi.repositories;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository(){
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "Cpu Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboar Gigabyte", 490L)
        );
    }

    public List<Product> findAll(){
        return data;
    }
}
