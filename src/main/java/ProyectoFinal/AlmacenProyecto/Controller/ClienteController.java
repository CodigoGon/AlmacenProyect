package ProyectoFinal.AlmacenProyecto.Controller;



import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import ProyectoFinal.AlmacenProyecto.Services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService clidServ;

    // creamos producto
    @PostMapping("/cliente/crear")
    public String crearCliente(@RequestBody Cliente cli) {
        clidServ.createCLiente(cli);
        return "cliente creado";
    }

    // tramemos todos los productos
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        List<Cliente> clientela = clidServ.listClientes();
        return clientela;
    }

    // traemos un producto
    @GetMapping ("/cliente/{id}")
    public Cliente traerCli(@PathVariable Long id) {
        Cliente elCli = clidServ.findCliente(id);
        return elCli;
    }

    // eliminamos producto
    @DeleteMapping ("cliente/eliminar/{id}")
    public String borrarProd (@PathVariable Long id) {
        clidServ.deleteCliente(id);
        return "producto borrado";
    }

    //editamos
    @PutMapping ("cliente/editar/{idOriginal}")
    public Cliente editProd(@PathVariable Long idOriginal,
                              @RequestParam(required = false, name = "nombre") String nombreNuevo,
                              @RequestParam(required = false, name = "apellido") String apellidoNuevo,
                              @RequestParam(required = false, name = "dni") String dniNuevo){
        clidServ.editCliente(idOriginal,nombreNuevo,apellidoNuevo,dniNuevo);
        Cliente editadoProd = clidServ.findCliente(idOriginal);
        return  editadoProd;
    }
}
