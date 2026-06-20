package gasagency.hpgas.server.gasbookingservice;

import gasagency.hpgas.dto.gasbookingdto.GasBookingDto;
import gasagency.hpgas.entity.agententity.AgentEntity;
import gasagency.hpgas.entity.customerentity.CustomerEntity;
import gasagency.hpgas.entity.gasbookingentity.GasBookingEntity;
import gasagency.hpgas.repository.agentrepository.AgentRepository;
import gasagency.hpgas.repository.customerrepository.CustomerRepository;
import gasagency.hpgas.repository.gasbookingrepository.CylinderBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GasBookingServiceImpl implements gasagency.hpgas.server.gasbookingservice.GasBookingService {

    private final CylinderBookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final AgentRepository agentRepository;

    @Override
    public GasBookingDto createBooking(GasBookingDto dto) {

        CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        AgentEntity agent = agentRepository.findById(dto.getAgentId())
                .orElseThrow(() -> new RuntimeException("Agent not found"));

        GasBookingEntity entity = new GasBookingEntity();

        entity.setCustomer(customer);
        entity.setAgent(agent);
        entity.setBookedCylinders(dto.getBookedCylinders());
        entity.setEmptyCylinders(dto.getEmptyCylinders());
        entity.setBalanceCylinders(dto.getBalanceCylinders());
        entity.setCylinderPrice(dto.getCylinderPrice());
        entity.setDebitAmount(dto.getDebitAmount());
        entity.setCreditAmount(dto.getCreditAmount());
        entity.setBalanceAmount(dto.getBalanceAmount());
        entity.setBookingDateTime(dto.getBookingDateTime());
        entity.setDeliveryDateTime(dto.getDeliveryDateTime());

        bookingRepository.save(entity);

        dto.setBookingId(entity.getBookingId());

        return dto;
    }

    @Override
    public List<GasBookingDto> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public GasBookingDto getBookingById(Long bookingId) {

        GasBookingEntity entity = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        return convertToDto(entity);
    }

    @Override
    public GasBookingDto updateBooking(Long bookingId, GasBookingDto dto) {

        GasBookingEntity entity = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        entity.setBookedCylinders(dto.getBookedCylinders());
        entity.setEmptyCylinders(dto.getEmptyCylinders());
        entity.setBalanceCylinders(dto.getBalanceCylinders());
        entity.setCylinderPrice(dto.getCylinderPrice());
        entity.setDebitAmount(dto.getDebitAmount());
        entity.setCreditAmount(dto.getCreditAmount());
        entity.setBalanceAmount(dto.getBalanceAmount());
        entity.setDeliveryDateTime(dto.getDeliveryDateTime());

        bookingRepository.save(entity);

        return convertToDto(entity);
    }

    @Override
    public void deleteBooking(Long bookingId) {

        if (!bookingRepository.existsById(bookingId)) {
            throw new RuntimeException("Booking not found");
        }

        bookingRepository.deleteById(bookingId);
    }

    private GasBookingDto convertToDto(GasBookingEntity entity) {

        return new GasBookingDto(
                entity.getBookingId(),
                entity.getCustomer().getCustomerId(),
                entity.getAgent().getAgentId(),
                entity.getBookedCylinders(),
                entity.getEmptyCylinders(),
                entity.getBalanceCylinders(),
                entity.getCylinderPrice(),
                entity.getDebitAmount(),
                entity.getCreditAmount(),
                entity.getBalanceAmount(),
                entity.getBookingDateTime(),
                entity.getDeliveryDateTime(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}