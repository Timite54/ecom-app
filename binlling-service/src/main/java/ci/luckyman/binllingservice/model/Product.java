package ci.luckyman.binllingservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private String price;
    private int quantity;
 }
