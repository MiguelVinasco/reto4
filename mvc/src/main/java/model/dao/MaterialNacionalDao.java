package model.dao;

//modelo
import model.vo.MaterialNacional; 


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



//DAO - CRUD contiene todo el acceso a la BD orientado especialmente a la entidad en especifico Lider
// consultar todos, encontrar por id_Lider
public class MaterialNacionalDao {


    //Requerimiento 3 reto 3
    //Materiales de producción nacional más comprados
    public ArrayList<MaterialNacional> topMaterialesNacionales() throws SQLException {

        //prepara la coleccion que tendra la respuesta

        ArrayList<MaterialNacional> respuesta = new ArrayList<MaterialNacional>();


        //prepara la conexion

        //declarar la conexion
        Connection connection = null;

        //intentar conectarnos y extraer la informacion de la BD para el requerimiento4
        //la logica la contiene la consulta sql

        try {

            //conectamos
            connection = JDBCUtilities.getConnection();

            String consulta = "SELECT mc.Nombre_Material, mc.Importado, COUNT(c.Cantidad) as No_Compras "+

                                "FROM MaterialConstruccion mc "+
                                "Join Compra c ON mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion "+
                                "WHERE mc.Importado = 'No' "+
                                "GROUP BY mc.ID_MaterialConstruccion "+
                                "ORDER BY No_Compras DESC,"+
                                        "mc.Nombre_Material ASC";

            //construir objeto que realizara la consulta.

            PreparedStatement statement = connection.prepareStatement(consulta);


            //realizar propimente la consulta
            ResultSet resultSet = statement.executeQuery();

            //recorrerlo mientras la consulta tenga posiciones o registros

            //mientras siguiente true
            while (resultSet.next()){
                MaterialNacional material = new MaterialNacional();
                material.setNombreMaterial(resultSet.getString("Nombre_Material"));
                material.setImportado(resultSet.getString("Importado"));
                material.setNoCompras(resultSet.getInt("No_Compras"));

                respuesta.add(material);
            }

            //se recomienda cerrar la conexion de la consulta y la ejecucion del statment
            resultSet.close();
            statement.close();

        } catch (SQLException e) {

            System.err.println("error consultando materiales nacionales "+e.getMessage());
            
        }finally{
            if (connection != null) {
                connection.close();
            }
        }

        //retornar la coleccion de materiales de produccion nacionales
        return respuesta;
        
    } 

    



    
}
