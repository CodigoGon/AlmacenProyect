package ProyectoFinal.AlmacenProyecto.Repositories;

import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
