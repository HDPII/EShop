package lk.example.eshop.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String productId;
    private String tittle;
    private String description;
    private double price;
    private String categoryId;
    private List<String> images;
    private int stockCount;
    private boolean status;
    private float rating;


}
