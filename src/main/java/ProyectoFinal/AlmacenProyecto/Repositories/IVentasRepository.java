package ProyectoFinal.AlmacenProyecto.Repositories;

import ProyectoFinal.AlmacenProyecto.Model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentasRepository extends JpaRepository<Ventas, Long> {
}
