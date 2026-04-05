package Baiss6;

import java.util.List;

public interface ParkingService {
    TicketResponse checkIn(TicketRequest request);
    TicketResponse checkOut(Long vehicleId);
    List<TicketSummaryResponse> getTodayTickets();
}
