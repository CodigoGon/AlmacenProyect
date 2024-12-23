package ProyectoFinal.AlmacenProyecto.Services;


import ProyectoFinal.AlmacenProyecto.DTO.MayorVentaDTO;
import ProyectoFinal.AlmacenProyecto.Model.Cliente;
import ProyectoFinal.AlmacenProyecto.Model.Productos;
import ProyectoFinal.AlmacenProyecto.Model.Ventas;

import java.time.LocalDate;
import java.util.List;

public interface IVentasService {
    public void createVenta(Ventas vent);
    public void deleteVenta(Long id);
    public Ventas findVenta(Long id);
    public List<Ventas> getVentas();
    public void editVenta(Long idOriginal,
                          LocalDate fechaNueva,
                          Double nuevoTotal,
                          List<Productos> nuevaLista,
                          Cliente nuevoCli);
    public MayorVentaDTO findMayorVenta();
}
