package gasagency.hpgas.server.agentservice;

import gasagency.hpgas.dto.agentdto.AgentDto;
import gasagency.hpgas.dto.agentdto.AgentLoginDto;
import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.entity.adminentity.AdminEntity;
import gasagency.hpgas.repository.agentrepository.AgentRepository;
import gasagency.hpgas.repository.adminrepository.AdminRepository;

import gasagency.hpgas.security.JwtUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;
    private final AdminRepository adminRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder;

    public AgentServiceImpl(AgentRepository agentRepository,
                            AdminRepository adminRepository,
                            JwtUtil jwtUtil,
                            BCryptPasswordEncoder encoder) {
        this.agentRepository = agentRepository;
        this.adminRepository = adminRepository;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @Override
    public AgentEntity createAgent(AgentDto dto){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        AgentEntity agent = new AgentEntity();

        agent.setName(dto.getName());
        agent.setEmail(dto.getEmail());
        agent.setPhone(dto.getPhone());
        agent.setAddress(dto.getAddress());
        agent.setVehicleNumber(dto.getVehicleNumber());

        // Encrypt password
        agent.setPassword(encoder.encode(dto.getPassword()));

        // Get logged-in admin email from SecurityContext
        String adminEmail =
                SecurityContextHolder.getContext().getAuthentication().getName();

        // Find admin from database
        AdminEntity admin = adminRepository.findByEmail(adminEmail);

        if(admin == null){
            throw new RuntimeException("Admin not found");
        }

        // Set admin reference
        agent.setAdmin(admin);

        // Audit fields
        agent.setCreatedAt(LocalDateTime.now());

        return agentRepository.save(agent);
    }


    @Override
    public String loginAgent(AgentLoginDto dto) {

        AgentEntity agent = agentRepository.findByEmail(dto.getEmail());

        if (agent == null) {
            throw new RuntimeException("Agent not found");
        }

        if (!encoder.matches(dto.getPassword(), agent.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // ✅ Generate JWT with email + agentId
        return jwtUtil.generateToken(agent.getEmail(), agent.getAgentId());
    }

}