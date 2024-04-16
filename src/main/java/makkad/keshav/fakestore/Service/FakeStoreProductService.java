package makkad.keshav.fakestore.Service;

import makkad.keshav.fakestore.DTO.FakeStoreProductDTO;
import makkad.keshav.fakestore.Models.Category;
import makkad.keshav.fakestore.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {


        // we use rest template to communicate with 3rd party api's through internet.
        // IN this get method, we give a url to call and a example class which shows what the return type of the api is. In this case, fakestore api returns us the DTO data.
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);

        // There might be some differencesn between the data we recieve from the api and our actual model. SO we convert rthe DTO data to a actual product model.
        // We use the below method to convert the DTO into actual product.

        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        Category category = new Category();
        category.setDescription(fakeStoreProductDTO.getDescription());
        product.setCategory(category);


        return product;
    }
}
