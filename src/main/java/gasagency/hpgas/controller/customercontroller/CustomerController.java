package gasagency.hpgas.controller.customercontroller;

import gasagency.hpgas.dto.customerdto.CustomerDto;
import gasagency.hpgas.entity.customerentity.CustomerEntity;
import gasagency.hpgas.server.customerservice.CustomerService;

import gasagency.hpgas.server.customerservice.CustomerSummary;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // ✅ Create Customer (Agent JWT Required)
    @PostMapping("/create")
    public CustomerEntity createCustomer(@RequestBody CustomerDto dto,
                                         HttpServletRequest request) {

        // Get agentId from JWT (set in JwtAuthFilter)
        Long agentId = (Long) request.getAttribute("userId");

        if (agentId == null) {
            throw new RuntimeException("Unauthorized: Agent not found in token");
        }

        return customerService.createCustomer(dto, agentId);
    }

    @GetMapping("/fetch")
    public List<CustomerSummary> getMyCustomers(HttpServletRequest request) {
        Long agentId = (Long) request.getAttribute("userId");
        return customerService.getCustomersForAgent(agentId);
    }

    @GetMapping("/fetch-predictive")
    public List<CustomerSummary> searchCustomers(
            @RequestParam String keyword,
            HttpServletRequest request
    ) {

        Long agentId = (Long) request.getAttribute("userId");


        if(agentId == null){
            throw new RuntimeException(
                    "Unauthorized: Agent not found"
            );
        }


        return customerService.searchCustomers(
                keyword,
                agentId
        );
    }
}