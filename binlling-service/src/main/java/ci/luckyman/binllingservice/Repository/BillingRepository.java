package ci.luckyman.binllingservice.Repository;

import ci.luckyman.binllingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillingRepository extends JpaRepository<Bill, Long> {

}
