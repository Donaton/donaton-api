package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Donacion {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDonacion;

    @NotNull(message = "La entidad Nombre no puede estar vacio")
    @Column(nullable = false)
    private String monto;


    @ManyToOne
    @JoinColumn(name = "ID_donante")
    private Donante donante;

    @ManyToOne
    @JoinColumn(name = "idCasos")
    private Casos casos;

}
