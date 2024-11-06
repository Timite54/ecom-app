package ci.luckyman.inventoryservice;

import ci.luckyman.inventoryservice.entities.Product;
import ci.luckyman.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return ar -> {
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Paper")
							.price(2000)
							.quantity(30)
					.build());
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("clavier")
							.price(5000)
							.quantity(90)
					.build());
			productRepository.save(Product.builder()
							.id(UUID.randomUUID().toString())
							.name("Souris")
							.quantity(8)
							.price(2500)
					.build());
			productRepository.findAll().forEach(p ->{
				System.out.println(p.toString());
//				System.out.println(p.getName());
//				System.out.println(p.getPrice());
//				System.out.println(p.getQuantity());
					});
		};

	}

}
