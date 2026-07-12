// CustomerService.java
package gasagency.hpgas.server.customerservice;

import gasagency.hpgas.dto.customerdto.CustomerDto;
import gasagency.hpgas.entity.customerentity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity createCustomer(CustomerDto dto, Long agentId);
    //fetch cust id and name all
    List<CustomerSummary> getCustomersForAgent(Long agentId);
    //fetch predictive search bar
    List<CustomerSummary> searchCustomers(
            String keyword,
            Long agentId
    );
}