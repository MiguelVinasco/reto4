package model.dao;

import model.vo.Lider; 


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
public class LiderDao {


    //consultar todos los lideres, las consultas devuelven una coleccion

    public ArrayList<Lider> consultarTodos() throws SQLException {

        //preparar contenedor de la respuesta
        ArrayList<Lider> respuesta = new ArrayList<Lider>();

        //preparo contenedor de la conexion.

        Connection conexion = null;

        //intento la conexion para la consulta con el trycatch
        try{

            //crear la conexion
            conexion = JDBCUtilities.getConnection();

            //crear objeto apartir de la consulta SQL
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider;");
            //Ejecutar la consulta y almacenar la respuesta en estructura de datos tipo resulset
            ResultSet resultSet = statement.executeQuery(); //responde la consulta y la mantiene ahi para la iteracion y sacar los resultados

            //recorrer estilo iterador, la estructura de datos que aloja los registros
            //se detiene cuando siguiente retorna falso.
            while (resultSet.next()) {

                Lider lider = new Lider();
                lider.setIdLider(resultSet.getInt("ID_Lider"));
                lider.setNombre(resultSet.getString("Nombre"));
                lider.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                lider.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                lider.setSalario(resultSet.getInt("Salario"));
                lider.setClasificacion(resultSet.getDouble("Clasificacion"));
                respuesta.add(lider);

            }

            //realizar cierre de la consulta y la extraccion

            resultSet.close();
            statement.close();

        }catch(SQLException e){

            System.err.println("error consultando todos los lideres: "+ e.getMessage());
        }finally{

            //siempre debo cerrar la conexion con la base de datos si se logro la conexion
            if (conexion != null) {
                conexion.close();
            }
        }

        //retornar respuesta obtenida despues de interactuar con la bd
        return respuesta;

    }

    //CONSULTAR LIDER POR ID_L
    public Lider consultarLiderID(Integer idLider) throws SQLException {

        //preparar contenedor de la respuesta
        Lider respuesta = new Lider();

        //preparo contenedor de la conexion.

        Connection conexion = null;

        //intento la conexion para la consulta con el trycatch
        try{

            //crear la conexion
            conexion = JDBCUtilities.getConnection();

            //crear objeto apartir de la consulta SQL

            //opcion 1
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider WHERE ID_Lider = "+idLider);

            //opcion 2
            // PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Lider WHERE ID_Lider = ?");
            // statement.setInt(1, idLider);
            //Ejecutar la consulta y almacenar la respuesta en estructura de datos tipo resulset
            ResultSet resultSet = statement.executeQuery(); //responde la consulta y la mantiene ahi para la iteracion y sacar los resultados

            //recorrer estilo iterador, la estructura de datos que aloja los registros
            //se detiene cuando siguiente retorna falso.
            if (resultSet.next()) {

                
                respuesta.setIdLider(resultSet.getInt("ID_Lider"));
                respuesta.setNombre(resultSet.getString("Nombre"));
                respuesta.setPrimerApellido(resultSet.getString("Primer_Apellido"));
                respuesta.setSegundoApellido(resultSet.getString("Segundo_Apellido"));
                respuesta.setSalario(resultSet.getInt("Salario"));
                respuesta.setClasificacion(resultSet.getDouble("Clasificacion"));

            }else{
                respuesta = null;
            }

            //realizar cierre de la consulta y la extraccion

            resultSet.close();
            statement.close();

        }catch(SQLException e){

            System.err.println("error consultando lider por id : "+ e.getMessage());
        }finally{

            //siempre debo cerrar la conexion con la base de datos si se logro la conexion
            if (conexion != null) {
                conexion.close();
            }
        }

        //retornar respuesta obtenida despues de interactuar con la bd
        return respuesta;

    }

    //insertar o guardar un lider en la BD

    //actualizar

    //eliminar un lider

    
}
