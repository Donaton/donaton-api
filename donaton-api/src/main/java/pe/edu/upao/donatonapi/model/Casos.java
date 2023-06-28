package pe.edu.upao.donatonapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import pe.edu.upao.donatonapi.model.Damnificado;

import java.util.Date;
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

    @Getter
    @Setter
    @NotBlank(message = "El tipo de desastre natural no puede estar vacío")
    @Column(nullable = false)
    private String tipo_desastre;

    @Getter
    @Setter
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 1, message = "El nombre debe tener al menos 1 caracter")
    @Column(nullable = false)
    private String nombre;

    @Getter
    @Setter
    @NotBlank(message = "La descripción no puede estar vacía")
    @Column(nullable = false)
    private String descripcion;

    @Getter
    @Setter
    @NotBlank(message = "La ubicación no puede estar vacía")
    @Column(nullable = false)
    private String region;

    @Getter
    @Setter
    @NotBlank(message = "La provincia no puede estar vacía")
    @Column(nullable = false)
    private String provincia;

    @Getter
    @Setter
    @NotBlank(message = "El distrito no puede estar vacío")
    @Column(nullable = false)
    private String distrito;

    @Getter
    @Setter
    @NotNull(message = "La fecha no puede estar vacía")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @Getter
    @Setter
    @NotNull(message = "La meta no puede estar vacía")
    @Column(nullable = false)
    private Long meta;

    @Getter
    @Setter
    @ElementCollection
    @CollectionTable(name = "casos_imagenes", joinColumns = @JoinColumn(name = "casos_id"))
    @Column(name = "imagen")
    private List<String> imagenes;

    @Getter
    @Setter
    @OneToMany(mappedBy = "caso", cascade = CascadeType.ALL)
    private List<Damnificado> damnificados;


    @Getter
    @Setter
    @OneToMany(mappedBy = "caso", cascade = CascadeType.ALL)
    private List<Evidencia> evidencias;


    public Casos(String tipo_desastre, String nombre, String descripcion, String region, String provincia, String distrito, Date fecha, Long meta) {
        this.tipo_desastre = tipo_desastre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
        this.provincia = provincia;
        this.distrito = distrito;
        this.fecha = fecha;
        this.meta = meta;
    }

    public Casos(String tipo_desastre, String nombre, String descripcion, String region, String provincia, String distrito, Date fecha, Long meta, List<String> imagenes) {
        this.tipo_desastre = tipo_desastre;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.region = region;
        this.provincia = provincia;
        this.distrito = distrito;
        this.fecha = fecha;
        this.meta = meta;
        this.imagenes = imagenes;
    }
}


