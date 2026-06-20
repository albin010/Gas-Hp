//package gasagency.hpgas.repository.gasbookingrepository;
//
//import gasagency.hpgas.entity.gasbookingentity.GasBookingEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface CylinderBookingRepository
//        extends JpaRepository<GasBookingEntity, Long> {
//
//    List<GasBookingEntity> findByCustomerCustomerId(Long customerId);
//    List<GasBookingEntity> findByAgentAgentId(Long agentId);
//}
package gasagency.hpgas.repository.gasbookingrepository;

import gasagency.hpgas.entity.gasbookingentity.GasBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CylinderBookingRepository extends JpaRepository<GasBookingEntity, Long> {
}