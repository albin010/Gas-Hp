package gasagency.hpgas.server.customerservice;

import gasagency.hpgas.entity.customerentity.CustomerEntity;
import gasagency.hpgas.dto.customerdto.CustomerDto;

public interface CustomerService {

    CustomerEntity createCustomer(CustomerDto dto, Long agentId);
}