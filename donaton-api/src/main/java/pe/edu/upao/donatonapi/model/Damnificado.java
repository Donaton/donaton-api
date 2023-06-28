package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import lombok.*;
import pe.edu.upao.donatonapi.model.Casos;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Damnificado {

    @Getter
    @Setter
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(nullable = false, length = 8)
    private int dni;

    @Getter
    @Setter
    @Column(nullable = false)
    private int edad;

    @Getter
    @Setter
    @Column(nullable = false)
    private String genero;

    @Getter
    @Setter
    @Column(nullable = false)
    private String region;

    @Getter
    @Setter
    @Column(nullable = false)
    private String provincia;

    @Getter
    @Setter
    @Column(nullable = false)
    private String distrito;

    @Getter
    @Setter
    @Column(nullable = false)
    private String direccion;

    @Getter
    @Setter
    @Column(length = 50)
    private String email;

    @Getter
    @Setter
    @Column(length = 50)
    private String contraseña;

    @Getter
    @Setter
    @Column(nullable = false)
    private String telefono;

    @Getter
    @Setter
    @ManyToOne
    private Casos caso;



}
