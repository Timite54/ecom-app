package ci.luckyman.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Product.class)
public interface ProductProjection {
    public String getName();
    public double getPrice();
    public int getQuantity();
    public String getId();
}
