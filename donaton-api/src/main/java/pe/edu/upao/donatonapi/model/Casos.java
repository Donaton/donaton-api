package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


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
    private long idCasos;


    @NotNull(message = "La entidad Nombre no puede estar vacio")
    @Size(min = 4, message = "La entidad Nombre debe tener como minimo 4 caracteres")
    @Size(max = 40, message = "Ha superado el maximo de caracteres")
    @Column(nullable = false)
    private String nombres;


    @NotNull(message = "El campo Descripcion no puede estar vacio")
    @Size(min = 4, message = "El campo Descripcion debe tener como minimo 300 caracteres")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(name = "monto_limite")
    private Integer montoLimite;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    private Damnificado damnificado;

    // Varios Casos pueden pertenecer a la misma Ciudad

    // Un caso puede tener varias forma de pago

    @OneToMany(mappedBy = "casos")
    private List<Donacion> donaciones;


    //Registra la fecha actual del sistema cuando el caso es creado
    @PrePersist
    public void prePersist() {
        fecha = LocalDate.now();
    }

}


