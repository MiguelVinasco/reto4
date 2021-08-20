package controller;

// tiene que interactuar con los modelos ya asignados
import model.dao.MaterialNacionalDao;
import model.vo.MaterialNacional;
import java.util.ArrayList;
import java.sql.SQLException;


//los atributos del controlador van hacer instancias de los DAO no se van a modificar
public class ControladorRequerimientoReto4 {

    private final MaterialNacionalDao MaterialNacionalDao;

    public ControladorRequerimientoReto4(){

        this.MaterialNacionalDao = new MaterialNacionalDao();
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
    
        return this.MaterialNacionalDao.topMaterialesNacionales();
    }

    // public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
    //     //.
    //     //.
    //     //.
    // }

    // public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
    //     //.
    //     //.
    //     //.
    // }
}
