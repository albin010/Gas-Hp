package gasagency.hpgas.repository.agentrepository;

import gasagency.hpgas.entity.agententity.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<AgentEntity, Long> {
    AgentEntity findByEmail(String email);
}