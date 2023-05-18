package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Donante {

    @Getter @Setter
    //@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(length = 50, nullable = false)
    private String email;

    @Getter @Setter
    @Column(name = "edad", nullable = false, length = 10)
    private String edad;

}