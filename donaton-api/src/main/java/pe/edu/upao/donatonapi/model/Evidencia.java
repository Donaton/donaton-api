package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Evidencia {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String imagen;

    @Getter
    @Setter
    @Column(nullable = false)
    private String descripcion;

    @Getter
    @Setter
    @ManyToOne
    private Casos caso;



}
