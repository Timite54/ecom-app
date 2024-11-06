package ci.luckyman.customerservice.customer;

import lombok.Getter;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    public String getName();
    public String getEmail();
}
