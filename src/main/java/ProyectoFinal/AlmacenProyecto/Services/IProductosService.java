package ProyectoFinal.AlmacenProyecto.Services;


import ProyectoFinal.AlmacenProyecto.Model.Productos;

import java.util.List;

public interface IProductosService {
    public void createProducto(Productos prod);
    public void deleteProducto(Long id);
    public Productos findProducto(Long id);
    public List<Productos> listProductos();
    public void editProducto(Long idOriginal,
                            String nombreNuevo,
                            String marcaNueva,
                            Double costoNuevo,
                            Double cantidadNueva);
}
