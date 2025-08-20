package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired // inyeccion mediante atributo
//    @Qualifier("productList") // si es por atributo va Autowired junto con @Qualifier
    private ProductRepository repository;

    //  inyeccion mediante metodo setter
//    @Autowired
//    public void setRepository(ProductRepository repository) {
//        this.repository = repository;
//    }


    // inyeccion de dependencia mediante constructor -- no requiere @Autowired
//    public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository repository) {
    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream()
                .map(p -> {
                    Double priceTax = p.getPrice() * 1.25d;
                    Product newProduct = (Product)  p.clone();
                    newProduct.setPrice(priceTax.longValue());
                    return newProduct;
                }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
