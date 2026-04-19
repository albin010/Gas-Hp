package gasagency.hpgas.entity.agententity;

import gasagency.hpgas.entity.adminentity.AdminEntity;
import gasagency.hpgas.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agents")
public class AgentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    private String address;

    private String vehicleNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;

    // ✅ Admin who created this agent
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private AdminEntity admin;

    // Audit fields
    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}