package gasagency.hpgas.controller.agentcontroller;

import gasagency.hpgas.dto.agentdto.AgentDto;
import gasagency.hpgas.dto.agentdto.AgentLoginDto;
import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.server.agentservice.AgentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/create-agent")
    public AgentEntity createAgent(@RequestBody AgentDto dto){
        return agentService.createAgent(dto);
    }
    @PostMapping("/login")
    public String loginAgent(@RequestBody AgentLoginDto dto){
        return agentService.loginAgent(dto);
    }
}