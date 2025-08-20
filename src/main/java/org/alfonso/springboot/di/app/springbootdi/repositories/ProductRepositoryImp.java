package org.alfonso.springboot.di.app.springbootdi.repositories;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Primary
@Repository // capa de datos --- especializacion de @Component -- esta clase es un  repositorio encargada de acceder a la bd
public class ProductRepositoryImp implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImp(){
        this.data = Arrays.asList(
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "Cpu Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboar Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    public Product findById(Long id){
        return data.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
