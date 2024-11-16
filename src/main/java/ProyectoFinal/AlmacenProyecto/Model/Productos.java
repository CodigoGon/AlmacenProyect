package ProyectoFinal.AlmacenProyecto.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cant_dispo;

    public Productos() {
    }

    public Productos(Long codigo_producto, String nombre, String marca, Double costo, Double cant_dispo) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cant_dispo = cant_dispo;
    }
}
