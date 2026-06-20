package gasagency.hpgas.entity.gasbookingentity;

import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.entity.customerentity.CustomerEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cylinder_bookings")
public class GasBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    private AgentEntity agent;

    // Number of cylinders booked in this transaction
    private Integer bookedCylinders;

    // Number of empty cylinders returned in this transaction
    private Integer emptyCylinders;

    // Running cylinder balance after this transaction
    private Integer balanceCylinders;

    // Price per cylinder
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal cylinderPrice;

    // Current transaction amount
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal debitAmount;

    // Amount received from customer
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal creditAmount;

    // Running outstanding balance after this transaction
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal balanceAmount;

    private LocalDateTime bookingDateTime;

    private LocalDateTime deliveryDateTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}