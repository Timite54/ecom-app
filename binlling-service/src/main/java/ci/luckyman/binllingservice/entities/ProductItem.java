package ci.luckyman.binllingservice.entities;

import ci.luckyman.binllingservice.model.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    private Bill bill;
    private int quantity;
    private double unitPrice;
    @Transient
    private Product product;
}
