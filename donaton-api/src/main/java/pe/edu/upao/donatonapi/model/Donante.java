package pe.edu.upao.donatonapi.model;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Donante {

    @Getter @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_donante;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Getter @Setter
    @Column(name = "ciudad", nullable = false, length = 30)
    private String ciudad;

    @OneToMany(mappedBy = "donante")
    private List<Donacion> donacion;

}
