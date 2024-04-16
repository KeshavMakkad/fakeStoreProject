package makkad.keshav.fakestore.Controller;

import makkad.keshav.fakestore.Models.Product;
import makkad.keshav.fakestore.Service.FakeStoreProductService;
import makkad.keshav.fakestore.Service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService; // Here using product service is preferable in place of using fake store product service. Because in future if we want to use amazon prduct servie or owr own data base product service, we have to write separate code for them.
    // But using product service which is the parent is better as it is extendible to every class that implements it. SO we can use amazon or fake store or our own database product service without making any major changes to our pre-existing code.

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }
}
