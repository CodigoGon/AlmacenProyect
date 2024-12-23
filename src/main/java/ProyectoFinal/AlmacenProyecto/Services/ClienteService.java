package ProyectoFinal.AlmacenProyecto.Services;



import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import ProyectoFinal.AlmacenProyecto.Repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository repoCli;

    @Override
    public void createCLiente(Cliente cli) {
        repoCli.save(cli);
    }

    @Override
    public void deleteCliente(Long id) {
        repoCli.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        Cliente clifind = repoCli.findById(id).orElse(null);
        return  clifind;
    }

    @Override
    public List<Cliente> listClientes() {
        List<Cliente> listcli = repoCli.findAll();
        return listcli;
    }

    @Override
    public void editCliente(Long idOriginal, String nombreNuevo, String apellidoNuevo, String dniNuevo) {
        Cliente cliedit = this.findCliente(idOriginal);
        cliedit.setNombre(nombreNuevo);
        cliedit.setApellido(apellidoNuevo);
        cliedit.setDni(dniNuevo);
        this.createCLiente(cliedit);
    }
}
