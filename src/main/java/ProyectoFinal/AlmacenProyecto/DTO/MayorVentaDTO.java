package ProyectoFinal.AlmacenProyecto.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class MayorVentaDTO {
    private Long codigo_venta;
    private int cantidad_productos;
    private Double total;
    private String nombreCliente;
    private String apellidoCliente;
}
