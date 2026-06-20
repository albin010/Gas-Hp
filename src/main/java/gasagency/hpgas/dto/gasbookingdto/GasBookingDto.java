package gasagency.hpgas.dto.gasbookingdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GasBookingDto {

    private Long bookingId;

    private Long customerId;

    private Long agentId;

    // Number of cylinders booked in this transaction
    private Integer bookedCylinders;

    // Number of empty cylinders returned in this transaction
    private Integer emptyCylinders;

    // Running cylinder balance after this transaction
    private Integer balanceCylinders;

    // Price per cylinder
    private BigDecimal cylinderPrice;

    // Current transaction amount
    private BigDecimal debitAmount;

    // Amount received from customer
    private BigDecimal creditAmount;

    // Running outstanding balance after this transaction
    private BigDecimal balanceAmount;

    private LocalDateTime bookingDateTime;

    private LocalDateTime deliveryDateTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}