package ProyectoFinal.AlmacenProyecto.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    @ManyToMany
    @JoinTable (name = "idProductos")
    private List<Productos> listaProductos;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente unCliente;
}
