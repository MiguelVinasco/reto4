import util.JDBCUtilities;


//import java.sql.DriverManager;// gestionar conexiones
import java.sql.Connection; //establecer conexiones
import java.sql.SQLException; //manejador de exepciones

//importamos elemento de la vista
import view.MenuLider;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //iniciar el mainlopp del menu de la aplicacion
        MenuLider.menuInicial();
        ///try (Connection conexion = JDBCUtilities.getConnection()){;
    
        //    if (JDBCUtilities.estaVacia()){

        //        System.out.println("la base de datos esta vacias");

        //    }else{
        //        System.out.println("conexion exitosa a la base de datos especifica");
        //    }
        


        //}catch (SQLException e){

        //    System.err.println("no se pudo conectar a la base de datos conexion errada "+ e.getMessage());
        //}

    }
}

