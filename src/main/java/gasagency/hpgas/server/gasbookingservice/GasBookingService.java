package gasagency.hpgas.server.gasbookingservice;

import gasagency.hpgas.dto.gasbookingdto.GasBookingDto;

import java.util.List;

public interface GasBookingService {

    GasBookingDto createBooking(GasBookingDto dto);

    List<GasBookingDto> getAllBookings();

    GasBookingDto getBookingById(Long bookingId);

    GasBookingDto updateBooking(Long bookingId, GasBookingDto dto);

    void deleteBooking(Long bookingId);
}