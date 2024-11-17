package ci.luckyman.binllingservice;

import ci.luckyman.binllingservice.Repository.BillingRepository;
import ci.luckyman.binllingservice.Repository.ProductItemRepository;
import ci.luckyman.binllingservice.entities.Bill;
import ci.luckyman.binllingservice.entities.ProductItem;
import ci.luckyman.binllingservice.feign.CustomerRestClient;
import ci.luckyman.binllingservice.feign.ProductRestClient;
import ci.luckyman.binllingservice.model.Customer;
import ci.luckyman.binllingservice.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillingRepository billingRepository,
										ProductItemRepository productItemRepository,
										ProductRestClient productRestClient,
										CustomerRestClient customerRestClient) {
		return args -> {
			Collection<Customer> customers = customerRestClient.getCustomerById().getContent();
			Collection<Product> products = productRestClient.getProductById().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder()
						.customerId(customer.getId())
						.billingDate(new Date())
						.build();
				billingRepository.save(bill);

				products.forEach(product-> {
					ProductItem productItems = ProductItem.builder()
							.productId(product.getId())
							.bill(bill)
							.quantity(1+new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItems);
				});
			});
		};
	}
}
