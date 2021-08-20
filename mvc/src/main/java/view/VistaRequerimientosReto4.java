package view;

import controller.ControladorRequerimientoReto4;

//modelo 1
import model.vo.MaterialNacional;

//modelo 2
import model.vo.ProyectoRankeadoCompras;

//modelo 3
import model.vo.CargoAsignacion;

//herramientas para la ejecucion
import java.util.ArrayList;
import java.sql.SQLException;

public class VistaRequerimientosReto4 {

    //Atributo- Controlador

    //public static final ControladorProyectosContruccion controlador = new ControladorProyectosContruccion();
    public static final ControladorRequerimientoReto4 controlador = new ControladorRequerimientoReto4();

    public static void requerimiento3(){

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n",
                materialNacional.getNombreMaterial(),
                materialNacional.getImportado(),
                materialNacional.getNoCompras());
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }

    public static void requerimiento4(){

        System.out.println("-----Proyectos Mayor Compra de Granito-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");
            
            for (ProyectoRankeadoCompras proyectoRankeadoCompras : rankingProyectosGranito) {
                
                System.out.printf("%d %s %d %d %n",
                proyectoRankeadoCompras.getIdProyecto(),
                proyectoRankeadoCompras.getClasificacion(),
                proyectoRankeadoCompras.getAreaMax(),
                proyectoRankeadoCompras.getNoComprasGranito()
                );
            }

        }catch(SQLException q){
            System.err.println("Ha ocurrido un error consultando los proyectos rankeados!"+q.getMessage());
        }

    }

    public static void requerimiento5(){

        System.out.println("-----Cargos Menos Asignados-------");       

        try{

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            //Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");
            
            for (CargoAsignacion cargoAsignacion : cargosMenosAsignados) {
                System.out.printf("%s %d %n",
                cargoAsignacion.getCargo(),
                cargoAsignacion.getNumeroProyectos()
                );
            }

        }catch(SQLException r){
            System.err.println("Ha ocurrido un error consultando los cargos con menos proyectos!"+r.getMessage());
        }

    }





    
    
}
