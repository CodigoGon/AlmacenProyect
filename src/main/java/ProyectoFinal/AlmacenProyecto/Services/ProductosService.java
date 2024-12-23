package ProyectoFinal.AlmacenProyecto.Services;

import ProyectoFinal.AlmacenProyecto.Model.Productos;
import ProyectoFinal.AlmacenProyecto.Repositories.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductosService implements IProductosService{
    @Autowired
    private IProductosRepository repoProd;

    @Override
    public void createProducto(Productos prod) {
        repoProd.save(prod);
    }

    @Override
    public void deleteProducto(Long id) {
        repoProd.deleteById(id);
    }

    @Override
    public Productos findProducto(Long id) {
        Productos prod = repoProd.findById(id).orElse(null);
        return prod;
    }

    @Override
    public List<Productos> listProductos() {
        List<Productos> listProd = repoProd.findAll();
        return  listProd;
    }


    @Override
    public void editProducto(Long idOriginal,
                             String nombreNuevo,
                             String marcaNueva,
                             Double costoNuevo,
                             Double cantidadNueva) {

        Productos prod = this.findProducto(idOriginal);
        prod.setNombre(nombreNuevo);
        prod.setMarca(marcaNueva);
        prod.setCosto(costoNuevo);
        prod.setCant_dispo(cantidadNueva);
        this.createProducto(prod);
    }

    @Override
    public List<Productos> faltaStock() {
        List<Productos> prov = this.listProductos();
        List<Productos> prodfinal = new ArrayList<>();
        for (Productos produ : prov) {
            if (produ.getCant_dispo() <=5){
                prodfinal.add(produ);
            }
        }

        return  prodfinal;
    }
}
