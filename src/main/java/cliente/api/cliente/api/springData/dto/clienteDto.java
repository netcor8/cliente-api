package cliente.api.cliente.api.springData.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class clienteDto {


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
