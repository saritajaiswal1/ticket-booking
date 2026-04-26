package com.ticket.booking;

import com.ticket.booking.repository.BookingRepository;
import com.ticket.booking.repository.SeatRepository;
import com.ticket.booking.repository.ShowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BookingApplicationTests {

	/*@MockitoBean
	private SeatRepository seatRepository;

	@MockitoBean
	private ShowRepository showRepository;

	@MockitoBean
	private BookingRepository bookingRepository;
*/
//	@Test
	void contextLoads() {
	}

}
