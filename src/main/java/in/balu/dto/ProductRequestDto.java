package in.balu.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;

}
