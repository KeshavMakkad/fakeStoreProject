package makkad.keshav.fakestore.DTO;

import lombok.Getter;
import lombok.Setter;
import makkad.keshav.fakestore.Models.Category;



// Each API provider might have a different return tyep. and we also dont want to reveal all of otu data to the proividers. SO we use DTO's ( Data transfer objects) to communicate with the api's are the same as the return type.
@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
