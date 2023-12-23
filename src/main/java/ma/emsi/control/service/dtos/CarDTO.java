package ma.emsi.control.service.dtos;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private String model;
    private String color;
    private double price;
    private String matricul;
}
