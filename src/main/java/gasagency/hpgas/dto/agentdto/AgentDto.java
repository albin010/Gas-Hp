package gasagency.hpgas.dto.agentdto;

import lombok.Data;

@Data
public class AgentDto {

    private String name;
    private String email;
    private String phone;
    private String address;
    private String vehicleNumber;
    private String password;
}