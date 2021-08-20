package controller;

// tiene que interactuar con los modelos ya asignados
import model.dao.MaterialNacionalDao;
import model.vo.MaterialNacional;

//segundo modelo
import model.dao.ProyectoRankeadoComprasDao;
import model.vo.ProyectoRankeadoCompras;


import java.util.ArrayList;
import java.sql.SQLException;


//los atributos del controlador van hacer instancias de los DAO no se van a modificar
public class ControladorRequerimientoReto4 {

    private final MaterialNacionalDao MaterialNacionalDao;

    private final ProyectoRankeadoComprasDao ProyectoRankeadoComprasDao;

    public ControladorRequerimientoReto4(){

        this.MaterialNacionalDao = new MaterialNacionalDao();

        this.ProyectoRankeadoComprasDao = new ProyectoRankeadoComprasDao();

        
    }

    public ArrayList<MaterialNacional> consultarMaterialesNacionalesComprados() throws SQLException {
    
        return this.MaterialNacionalDao.topMaterialesNacionales();
    }

    public ArrayList<ProyectoRankeadoCompras> consultarProyectosComprasGranito() throws SQLException {
        return this.ProyectoRankeadoComprasDao.topProyectosComprasGranito();
    }

    // public ArrayList<CargoAsignacion> consultarCargosMenosAsignados() throws SQLException {
    //     //.
    //     //.
    //     //.
    // }
}
