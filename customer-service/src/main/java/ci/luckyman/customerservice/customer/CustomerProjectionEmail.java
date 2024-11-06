package ci.luckyman.customerservice.customer;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
    public String getEmail();
}
