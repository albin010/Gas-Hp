package gasagency.hpgas.controller.gasbookingcontroller;

import gasagency.hpgas.dto.gasbookingdto.GasBookingDto;
import gasagency.hpgas.server.gasbookingservice.GasBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/bookings")
    @RequiredArgsConstructor
    public class GasBookingController {

        private final GasBookingService bookingService;

        @PostMapping("/add")
        public GasBookingDto createBooking(@RequestBody GasBookingDto dto) {
            return bookingService.createBooking(dto);
        }

        @GetMapping
        public List<GasBookingDto> getAllBookings() {
            return bookingService.getAllBookings();
        }

        @GetMapping("/{bookingId}")
        public GasBookingDto getBookingById(@PathVariable Long bookingId) {
            return bookingService.getBookingById(bookingId);
        }

        @PutMapping("/{bookingId}")
        public GasBookingDto updateBooking(@PathVariable Long bookingId,
                                           @RequestBody GasBookingDto dto) {

            return bookingService.updateBooking(bookingId, dto);
        }

        @DeleteMapping("/{bookingId}")
        public void deleteBooking(@PathVariable Long bookingId) {
            bookingService.deleteBooking(bookingId);
        }
    }