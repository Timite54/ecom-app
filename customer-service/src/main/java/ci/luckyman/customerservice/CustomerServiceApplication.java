package ci.luckyman.customerservice;

import ci.luckyman.customerservice.entities.Customer;
import ci.luckyman.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Jean")
                            .email("jean@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                            .name("Luck")
                            .email("luck@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                            .name("Poka")
                            .email("poka@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                            .name("Ben")
                            .email("ben@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c->{
                System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

            });

        };

    }

}
