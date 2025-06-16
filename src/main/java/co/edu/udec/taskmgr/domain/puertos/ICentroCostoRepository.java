package co.edu.udec.taskmgr.domain.puertos;

import cotizacionesycomprasaplication.base.CentroCosto;
import java.util.List;

public interface ICentroCostoRepository {

    void save(CentroCosto centro);         // Crear
    CentroCosto findById(int id);          // Leer
    List<CentroCosto> findAll();           // Leer todos
    void update(CentroCosto centro);       // Actualizar
    void deleteById(int id);               // Eliminar
}