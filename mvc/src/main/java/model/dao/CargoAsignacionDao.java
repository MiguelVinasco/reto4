package model.dao;

//modelo
import model.vo.CargoAsignacion;


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
public class CargoAsignacionDao {


    //Requerimiento 3 reto 3
   //Obtener los 5 proyectos rankeados según las compras
    public ArrayList<CargoAsignacion> cargosMenosAsignados() throws SQLException {

        ArrayList<CargoAsignacion> respuesta = new ArrayList<CargoAsignacion>();


        //prepara la conexion

        //declarar la conexion
        Connection connection = null;

        //intentar conectarnos y extraer la informacion de la BD para el requerimiento4
        //la logica la contiene la consulta sql

        try {

            //conectamos
            connection = JDBCUtilities.getConnection();

            String consulta = "SELECT l.Cargo, "+
                            "COUNT(*) as Numero_Proyectos "+
        
        
                        "FROM Proyecto p "+
                        "JOIN Lider l "+
                        "ON l.ID_Lider = p.ID_Lider "+
                        "GROUP BY l.Cargo "+
                        "ORDER BY Numero_Proyectos ASC "+
                        "LIMIT 2";

            //construir objeto que realizara la consulta.

            PreparedStatement statement = connection.prepareStatement(consulta);


            //realizar propimente la consulta
            ResultSet resultSet = statement.executeQuery();

            //recorrerlo mientras la consulta tenga posiciones o registros

            //mientras siguiente true
            while (resultSet.next()){
                CargoAsignacion cargo = new CargoAsignacion();
                cargo.setCargo(resultSet.getString("Cargo"));
                cargo.setNumeroProyectos(resultSet.getInt("Numero_Proyectos"));


                respuesta.add(cargo);
            }

            //se recomienda cerrar la conexion de la consulta y la ejecucion del statment
            resultSet.close();
            statement.close();

        } catch (SQLException r) {

            System.err.println("error consultando los cargos con menos proyectos "+r.getMessage());
            
        }finally{
            if (connection != null) {
                connection.close();
            }
        }

        //retornar la coleccion de materiales de produccion nacionales
        return respuesta;
        
    } 

    



    
}
