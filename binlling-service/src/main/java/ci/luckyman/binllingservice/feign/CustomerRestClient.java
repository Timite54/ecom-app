package ci.luckyman.binllingservice.feign;

import ci.luckyman.binllingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customer/{id}")
    Customer getCustomerById(@PathVariable String id);

    @GetMapping("/customer")
    PagedModel<Customer> getCustomerById();


}
