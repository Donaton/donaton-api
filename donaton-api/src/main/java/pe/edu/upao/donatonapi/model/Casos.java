package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull(message = "La entidad Nombre no puede estar vacio")
    @NotBlank(message = "La entidad Nombre no debe quedar en blanco")
    @Size(min = 4, message = "La entidad Nombre debe tener como minimo 4 caracteres")
    @Column(nullable = false)
    private String nombres;

    @Getter
    @Setter
    @Column(nullable = false)
    private String descripcion;

    @ManyToOne
    private Damnificado damnificado;

}


