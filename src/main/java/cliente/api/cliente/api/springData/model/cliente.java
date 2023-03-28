package cliente.api.cliente.api.springData.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int identificacion;

    private String nombres;

    private String apellidos;
    private String paisResidencia;

    private String paisNacimiento;
    private String direccion;
    private String telefono;

    private Boolean estado;

}
