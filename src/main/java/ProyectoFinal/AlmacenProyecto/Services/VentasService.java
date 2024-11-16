package ProyectoFinal.AlmacenProyecto.Services;

import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import ProyectoFinal.AlmacenProyecto.Model.Productos;
import ProyectoFinal.AlmacenProyecto.Model.Ventas;
import ProyectoFinal.AlmacenProyecto.Repositories.IVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentasService implements IVentasService{

    @Autowired
    private IVentasRepository repoVenta;

    @Override
    public void createVenta(Ventas vent) {
        repoVenta.save(vent);
    }

    @Override
    public void deleteVenta(Long id) {
        repoVenta.deleteById(id);
    }

    @Override
    public Ventas findVenta(Long id) {
        Ventas venti =  repoVenta.findById(id).orElse(null);
        return  venti;
    }

    @Override
    public List<Ventas> getVentas() {
        List<Ventas> lisVen = repoVenta.findAll();
        return  lisVen;
    }

    @Override
    public void editVenta(Long idOriginal, LocalDate fechaNueva, Double nuevoTotal, List<Productos> nuevaLista, Cliente nuevoCli) {
        Ventas venti = this.findVenta(idOriginal);

        venti.setFecha_venta(fechaNueva);
        venti.setTotal(nuevoTotal);
        venti.setListaProductos(nuevaLista);
        venti.setUnCliente(nuevoCli);

        this.createVenta(venti);
    }
}
