import util.JDBCUtilities;


//import java.sql.DriverManager;// gestionar conexiones
import java.sql.Connection; //establecer conexiones
import java.sql.SQLException; //manejador de exepciones

//importamos elemento de la vista
import view.VistaRequerimientosReto4;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //iniciar el mainlopp del menu de la aplicacion
        

        ///try (Connection conexion = JDBCUtilities.getConnection()){;
    
        //    if (JDBCUtilities.estaVacia()){

        //        System.out.println("la base de datos esta vacias");

        //    }else{
        //        System.out.println("conexion exitosa a la base de datos especifica");
        //    }
        


        //}catch (SQLException e){

        //    System.err.println("no se pudo conectar a la base de datos conexion errada "+ e.getMessage());
        //}

             //Requerimiento 3 - Reto3
            VistaRequerimientosReto4.requerimiento3();
            System.out.println();

            //Requerimiento 4 - Reto3
            VistaRequerimientosReto4.requerimiento4();
            System.out.println();

            // //Requerimiento 5 - Reto3
            // VistaRequerimientosReto4.requerimiento5();
            // System.out.println();
    }
}

