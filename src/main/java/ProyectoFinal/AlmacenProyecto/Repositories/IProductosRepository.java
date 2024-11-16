package ProyectoFinal.AlmacenProyecto.Repositories;

import ProyectoFinal.AlmacenProyecto.Model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Productos, Long> {
}
