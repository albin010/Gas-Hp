package gasagency.hpgas.entity.customerentity;

import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String hotelName;

    private String customerName;

    private String password;

    private String phone;

    private String address;
    private String city;
    private String country;
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    private AgentEntity agent;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}