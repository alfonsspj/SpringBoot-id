package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;


    // inyeccion de dependencia mediante constructor -- no requiere @Autowired
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream()
                .map(p -> {
                    Double priceTax = p.getPrice() * 1.25d;
//                    Product newProduct = (Product)  p.clone();
//                    newProduct.setPrice(priceTax.longValue());
//                    return newProduct;

                    p.setPrice(priceTax.longValue());
                    return p;
                }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
