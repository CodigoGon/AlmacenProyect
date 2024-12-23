package ProyectoFinal.AlmacenProyecto.Controller;

import ProyectoFinal.AlmacenProyecto.DTO.MayorVentaDTO;
import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import ProyectoFinal.AlmacenProyecto.Model.Productos;
import ProyectoFinal.AlmacenProyecto.Model.Ventas;
import ProyectoFinal.AlmacenProyecto.Services.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class VentasController {

    @Autowired
    private IVentasService ventServi;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Ventas vent) {
        ventServi.createVenta(vent);
        return "venta creada";
    }

    @GetMapping("/ventas")
    public List<Ventas> getVentas() {
        List<Ventas> produc = ventServi.getVentas();
        return produc;
    }

    // traemos un Venta
    @GetMapping ("/ventas/{id}")
    public Ventas ventaTraer(@PathVariable Long id) {
        Ventas ventada = ventServi.findVenta(id);
        return ventada;
    }

    // eliminamos venta
    @DeleteMapping ("ventas/eliminar/{id}")
    public String borrarVenta (@PathVariable Long id) {
        ventServi.deleteVenta(id);
        return "venta borrada";
    }

    //editamos
    @PutMapping ("ventas/editar/{idOriginal}")
    public Ventas editProd(@PathVariable Long idOriginal,
                              @RequestParam(required = false, name = "fecha") LocalDate fechaNuevo,
                              @RequestParam(required = false, name = "total") Double totalNueva,
                              @RequestParam(required = false, name = "producos") List<Productos> listaNuevaa,
                              @RequestParam(required = false, name = "cliente") Cliente clienteNuevo){

        ventServi.editVenta(idOriginal,fechaNuevo,totalNueva,listaNuevaa,clienteNuevo);
        Ventas ventaEditada = ventServi.findVenta(idOriginal);
        return  ventaEditada;
    }

    //traer los productos de una venta
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public List<Productos> produVentas (@PathVariable Long codigo_venta) {
        Ventas ventaEnncontrada = ventServi.findVenta(codigo_venta);
        List<Productos> listaSelec = ventaEnncontrada.getListaProductos();

        return listaSelec;

    }

    // obtene monto total del una fecha deterrminada y tambien la cantidad de ventas que se hizo en tal dia(GET)
    @GetMapping("/ventas/dia/{fecha_venta}")
    public String ventaTotal(@PathVariable LocalDate fecha_venta) {
        List<Ventas> todasLasVentas = ventServi.getVentas();
        List<Ventas> ventasDia = new ArrayList<>();
        Double dineroVentas= 0.0;

        for (Ventas ven: todasLasVentas) {
            if (ven.getFecha_venta().isEqual(fecha_venta)) {
                ventasDia.add(ven);
            }
        }

        for (Ventas ven: ventasDia) {
            dineroVentas += ven.getTotal();
        }

        int cantidad1 = todasLasVentas.size();
        int cantidad2 = ventasDia.size();

        System.out.println(cantidad1 +" "+cantidad2);
        return "hubo "+ ventasDia.size() +" en total y se recaudo: "+ dineroVentas + " ese dia";
    }

    //traer la mayor venta
    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO laMayorVenta () {
        return ventServi.findMayorVenta();
    }
}
