package ProyectoFinal.AlmacenProyecto.Controller;

import ProyectoFinal.AlmacenProyecto.Model.Productos;
import ProyectoFinal.AlmacenProyecto.Services.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductosController {

    @Autowired
    private IProductosService prodServ;

    // creamos producto
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Productos prod) {
        prodServ.createProducto(prod);
        return "producto creado";
    }

    // tramemos todos los productos
    @GetMapping ("/productos")
    public List<Productos> getProductos() {
        List<Productos> produc = prodServ.listProductos();
        return produc;
    }

    // traemos un producto
    @GetMapping ("/productos/{id}")
    public Productos prodtraer(@PathVariable Long id) {
        Productos prod = prodServ.findProducto(id);
        return prod;
    }

    // eliminamos producto
    @DeleteMapping ("productos/eliminar/{id}")
    public String borrarProd (@PathVariable Long id) {
        prodServ.deleteProducto(id);
        return "producto borrado";
    }

    //editamos
    @PutMapping ("productos/editar/{idOriginal}")
    public Productos editProd(@PathVariable Long idOriginal,
                              @RequestParam(required = false, name = "nombre") String nombreNuevo,
                              @RequestParam(required = false, name = "marca") String marcaNueva,
                              @RequestParam(required = false, name = "costo") Double costoNuevo,
                              @RequestParam(required = false, name = "cantidad") Double cantidadNueva){

        prodServ.editProducto(idOriginal,nombreNuevo,marcaNueva,costoNuevo,cantidadNueva);
        Productos editadoProd = prodServ.findProducto(idOriginal);
        return  editadoProd;
    }

    //falta stock
    @GetMapping("/productos/falta_stock")
    public List<Productos> lefaltan() {
        return prodServ.faltaStock();
    }
}
