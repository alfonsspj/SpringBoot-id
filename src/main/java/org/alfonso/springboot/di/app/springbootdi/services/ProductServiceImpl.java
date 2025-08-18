package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepositoryImp;
import java.util.List;
import java.util.stream.Collectors;


public class ProductServiceImpl implements ProductService {

    // estamos simulando los datos del repositorio
    private ProductRepositoryImp repository = new ProductRepositoryImp();// capa de acceso a datos


     @Override
    public List<Product> findAll(){
        return repository.findAll().stream()
                .map(p -> {
                    Double priceTax = p.getPrice() * 1.25d;
//                    Product newProduct = new Product(p.getId(), p.getName(), priceTax.longValue());
                    Product newProduct = (Product)  p.clone();
                    newProduct.setPrice(priceTax.longValue());
                    return newProduct;
                }).collect(Collectors.toList());

        /*return repository.findAll().stream() // en una bd no sucede
                .map(p -> {
                    Double priceImp = p.getPrice() * 1.25d;
                    p.setPrice(priceImp.longValue());
                    return p;
                }).collect(Collectors.toList());*/
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
}
