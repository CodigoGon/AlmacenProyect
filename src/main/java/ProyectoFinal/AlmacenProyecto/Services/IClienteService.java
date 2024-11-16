package ProyectoFinal.AlmacenProyecto.Services;

import ProyectoFinal.AlmacenProyecto.Model.Cliente;

import java.util.List;

public interface IClienteService {
    public void createCLiente(Cliente cli);
    public void deleteCliente(Long id);
    public Cliente findCliente(Long id);
    public List<Cliente> listClientes();
    public void editCliente(Long idOriginal,
                            String nombreNuevo,
                            String apellidoNuevo,
                            Long dniNuevo);
}
