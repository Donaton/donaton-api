package pe.edu.upao.donatonapi.model;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Damnificado {

    @Getter @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(name = "dni", nullable = false, length = 8)
    private int dni;

    @Getter @Setter
    @Column(name = "edad", nullable = false, length = 10)
    private int edad;

    @Getter @Setter
    @Column(name = "genero", nullable = false, length = 10)
    private String genero;

    @Getter @Setter
    @Column(name = "region", nullable = false, length = 30)
    private String region;

    @Getter @Setter
    @Column(name = "provincia", nullable = false, length = 30)
    private String provincia;

    @Getter @Setter
    @Column(name = "distrito", nullable = false, length = 30)
    private String distrito;

    @Getter @Setter
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Getter @Setter
    @Column(name = "email",length = 50, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "contraseña",length = 50, nullable = false)
    private String contraseña;


    @Getter @Setter
    @Column(name = "telefono", nullable = false, length = 9)
    private int telefono;

}
