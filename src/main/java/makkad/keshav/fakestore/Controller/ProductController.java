package makkad.keshav.fakestore.Controller;

import makkad.keshav.fakestore.DTO.ExceptionDTO;
import makkad.keshav.fakestore.Models.Product;
import makkad.keshav.fakestore.Service.FakeStoreProductService;
import makkad.keshav.fakestore.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService; // Here using product service is preferable in place of using fake store product service. Because in future if we want to use amazon prduct servie or owr own data base product service, we have to write separate code for them.
    // But using product service which is the parent is better as it is extendible to every class that implements it. SO we can use amazon or fake store or our own database product service without making any major changes to our pre-existing code.

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id) {

        ResponseEntity<Product> productResponseEntity = null;
        Product product = null;
        try {
            product = productService.getProductById(id);
            productResponseEntity = new ResponseEntity<>(product, HttpStatus.OK);
            System.out.println("Product found");
        }
        catch (RuntimeException exception) {
            ExceptionDTO exceptionDTO = new ExceptionDTO();
            exceptionDTO.setErrorMessage("Unable to access the given product ID");
            exceptionDTO.setErrorResolution("Verify the product ID and please try again");
            ResponseEntity<ExceptionDTO> exceptionDTOResponseEntity = new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
            return exceptionDTOResponseEntity;
        }
        return productResponseEntity;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
}
