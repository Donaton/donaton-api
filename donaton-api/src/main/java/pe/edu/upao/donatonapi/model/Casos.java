package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Casos {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    @Column(nullable = false, length = 50)
    private String nombres;

    @Getter
    @Setter
    @Column(nullable = false, length = 300)
    private String descripcion;

    @ManyToOne
    private Damnificado damnificado;

}


