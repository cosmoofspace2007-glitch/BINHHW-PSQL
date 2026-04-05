package Baiss6;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final ParkingService parkingService;

    // CHECK-IN
    @PostMapping("/check-in")
    public ApiResponse<TicketResponse> checkIn(@RequestBody TicketRequest request) {
        return ApiResponse.<TicketResponse>builder()
                .code(1000)
                .message("Check-in success")
                .result(parkingService.checkIn(request))
                .build();
    }

    // CHECK-OUT
    @PutMapping("/check-out/{vehicleId}")
    public ApiResponse<TicketResponse> checkOut(@PathVariable Long vehicleId) {
        return ApiResponse.<TicketResponse>builder()
                .code(1000)
                .message("Check-out success")
                .result(parkingService.checkOut(vehicleId))
                .build();
    }

    @GetMapping("/summary")
    public ApiResponse<List<TicketSummaryResponse>> getSummary() {

        return ApiResponse.<List<TicketSummaryResponsebuilder()
                .code(1000)
                .message("Get ticket summary successfully")
                .result(parkingService.getTodayTickets())
                .build();
    }
}
