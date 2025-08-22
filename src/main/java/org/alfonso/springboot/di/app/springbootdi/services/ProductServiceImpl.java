package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    // 1 forma, la  2 forma es pasarla por argumento
//    @Autowired
    private Environment environment;

    private ProductRepository repository;


    // inyeccion de dependencia mediante constructor -- no requiere @Autowired
//    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository, Environment environment) {
        this.repository = repository;
        this.environment = environment;// 2 forma inyectarla por constructor
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream()
                .map(p -> {
//                    Double priceTax = p.getPrice() * 1.25d;
                    Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
//                    System.out.println(environment.getProperty("config.price.tax", Double.class));

                    //inmutable
//                    Product newProduct = (Product)  p.clone();
//                    newProduct.setPrice(priceTax.longValue());

                    //mutable -- esta cambiando la instancia original que esta en memoria del objeto
                    p.setPrice(priceTax.longValue());
                    return p;

                }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
