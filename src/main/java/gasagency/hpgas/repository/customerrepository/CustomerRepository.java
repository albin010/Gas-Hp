// CustomerRepository.java
package gasagency.hpgas.repository.customerrepository;

import gasagency.hpgas.entity.customerentity.CustomerEntity;
import gasagency.hpgas.server.customerservice.CustomerSummary;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByCustomerName(String customerName);


//fetch predictive search bar

    @Query("""
        select c.customerId as customerId,
               c.customerName as customerName,
               c.phone as phone
        from CustomerEntity c
        where c.agent.agentId = :agentId
        and (
            lower(c.customerName) like lower(concat('%', :keyword, '%'))
            or 
            c.phone like concat('%', :keyword, '%')
        )
        """)
    List<CustomerSummary> searchCustomers(
            @Param("agentId") Long agentId,
            @Param("keyword") String keyword
    );


    //    fetch customer id and name
    @Query("""
        select c.customerId as customerId,
               c.customerName as customerName
        from CustomerEntity c
        where c.agent.agentId = :agentId
        """)
    List<CustomerSummary> findSummariesByAgentId(@Param("agentId") Long agentId);
}