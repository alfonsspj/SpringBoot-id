package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;


public class ProductService {

    // estamos simulando los datos del repositorio
    private ProductRepository repository = new ProductRepository();// capa de acceso a datos

    public List<Product> findAll(){
        return repository.findAll().stream()
                .map(p -> {
                    Double priceImp = p.getPrice() * 1.25d;
                    p.setPrice(priceImp.longValue());
                    return p;
                }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }
}
