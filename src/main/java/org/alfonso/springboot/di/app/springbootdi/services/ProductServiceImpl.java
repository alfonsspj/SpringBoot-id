package org.alfonso.springboot.di.app.springbootdi.services;

import org.alfonso.springboot.di.app.springbootdi.models.Product;
import org.alfonso.springboot.di.app.springbootdi.repositories.ProductRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductServiceImpl implements ProductService {

    // estamos simulando los datos del repositorio
//    private ProductRepositoryImp repository = new ProductRepositoryImp();// capa de acceso a datos -- intanciamos, llamamos al objeto

    @Autowired  // estamos inyectando al producto service una instancia singleton del productoRepositoryImpl --
    // no llames a la instancia, no cree el objeto sino que nosotros te vamos a proveer el objeto a ti -- Principio Hollywood
    private ProductRepositoryImp repository;// el contenedor nos llama a nosotros y nos provee el objeto


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
