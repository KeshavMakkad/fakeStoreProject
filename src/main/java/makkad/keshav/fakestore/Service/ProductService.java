package makkad.keshav.fakestore.Service;

import makkad.keshav.fakestore.Models.Product;

import java.util.List;


//We don't want to use just one provider fo rdata ex. fakestore. In the future, fakestore might close, we might add multiple vendors or have our own data base.
// If something happens to out current provider, it mihgt be hard to convert. SO we use interfaces.
// In interface, we describe all the methods like get, post and others. THen we create separate Services for each provider, so that changing between can be easy and future problem scan be avoided.
public interface ProductService{
        Product getProductById(Long id);
        List<Product> getAllProducts();
}
