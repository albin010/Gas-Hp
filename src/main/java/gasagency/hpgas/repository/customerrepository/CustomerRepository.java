package gasagency.hpgas.repository.customerrepository;

import gasagency.hpgas.entity.customerentity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByCustomerName(String customerName);
}