package Baiss6;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleResponse
{
    private int id;
    private String licensePlate;
    private String color;
    private CarType vehicleType;
}
