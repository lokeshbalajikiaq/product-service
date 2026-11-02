package in.balu.models;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 5000)
    private String name;
    @Column(length = 100000)
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt = LocalDateTime.now();

}
