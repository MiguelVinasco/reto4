package model.dao;

//modelo
import model.vo.ProyectoRankeadoCompras;


//clase de soporte
import util.JDBCUtilities; //clase que conecto la bd
import java.sql.Connection; //conexion
import java.sql.SQLException; //execepciones


//preparador de la consulta
import java.sql.PreparedStatement;

//conexion con iterador de la consulta
import java.sql.ResultSet;

//Arrays

import java.util.ArrayList;



//DAO - CRUD contiene todo el acceso a la BD orientado especialmente a la entidad 
// consultar todos, encontrar por id_Lider
public class ProyectoRankeadoComprasDao {


    //Requerimiento 3 reto 3
   //Obtener los 5 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> topProyectosComprasGranito() throws SQLException {

        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>();


        //prepara la conexion

        //declarar la conexion
        Connection connection = null;

        //intentar conectarnos y extraer la informacion de la BD para el requerimiento4
        //la logica la contiene la consulta sql

        try {

            //conectamos
            connection = JDBCUtilities.getConnection();

            String consulta = "SELECT p.ID_Proyecto, "+
            "p.Clasificacion,"+
            "t.Area_Max,"+
            "COUNT(mc.Nombre_Material) as No_Compras_Granito "+
        
                                    "FROM Proyecto p "+
                                    "JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto "+
                                    "JOIN MaterialConstruccion mc ON "+
                                    "mc.ID_MaterialConstruccion  = c.ID_MaterialConstruccion "+
                                    "JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo "+
                                    "WHERE mc.Nombre_Material = 'Granito'"+
                                    "GROUP BY p.ID_Proyecto "+
                                    "ORDER BY No_Compras_Granito DESC "+
                                    "LIMIT 5";

            //construir objeto que realizara la consulta.

            PreparedStatement statement = connection.prepareStatement(consulta);


            //realizar propimente la consulta
            ResultSet resultSet = statement.executeQuery();

            //recorrerlo mientras la consulta tenga posiciones o registros

            //mientras siguiente true
            while (resultSet.next()){
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyecto.setAreaMax(resultSet.getInt("Area_Max"));
                proyecto.setNoComprasGranito(resultSet.getInt("No_Compras_Granito"));

                respuesta.add(proyecto);
            }

            //se recomienda cerrar la conexion de la consulta y la ejecucion del statment
            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            System.err.println("error consultando los proyectos rankeados por compras "+e.getMessage());
            
        }finally{
            if (connection != null) {
                connection.close();
            }
        }

        //retornar la coleccion de materiales de produccion nacionales
        return respuesta;
        
    } 

    



    
}
