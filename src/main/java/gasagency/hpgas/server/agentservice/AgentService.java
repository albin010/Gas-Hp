package gasagency.hpgas.server.agentservice;

import gasagency.hpgas.dto.agentdto.AgentDto;
import gasagency.hpgas.dto.agentdto.AgentLoginDto;
import gasagency.hpgas.entity.agententity.AgentEntity;

public interface AgentService {

    AgentEntity createAgent(AgentDto dto);
    String loginAgent(AgentLoginDto dto);

}