package gasagency.hpgas.server.customerservice;

import gasagency.hpgas.entity.customerentity.CustomerEntity;
import gasagency.hpgas.dto.customerdto.CustomerDto;
import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.repository.agentrepository.AgentRepository;
import gasagency.hpgas.repository.customerrepository.CustomerRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AgentRepository agentRepository;
    private final BCryptPasswordEncoder encoder; // ✅ FIX

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               AgentRepository agentRepository,
                               BCryptPasswordEncoder encoder) { // ✅ FIX
        this.customerRepository = customerRepository;
        this.agentRepository = agentRepository;
        this.encoder = encoder;
    }

    @Override
    public CustomerEntity createCustomer(CustomerDto dto, Long agentId) {

        CustomerEntity customer = new CustomerEntity();

        customer.setHotelName(dto.getHotelName());
        customer.setCustomerName(dto.getCustomerName());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());
        customer.setCity(dto.getCity());
        customer.setCountry(dto.getCountry());
        customer.setZipCode(dto.getZipCode());

        // ✅ Encrypt password
        customer.setPassword(encoder.encode(dto.getPassword()));

        // ✅ Fetch agent using ID
        AgentEntity agent = agentRepository.findById(agentId)
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        customer.setAgent(agent);

        // ✅ Audit fields
        customer.setCreatedAt(LocalDateTime.now());

        return customerRepository.save(customer); // ✅ FIX
    }
}