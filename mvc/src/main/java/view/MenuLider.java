package view;

import controller.ControladorProyectosContruccion;
import java.util.Scanner;
import model.vo.Lider;
import java.util.ArrayList;

public class MenuLider {

    //Atributo- Controlador

    public static final ControladorProyectosContruccion controlador = new ControladorProyectosContruccion();


    public static void menuInicial(){

        boolean mainloop = true;
        Scanner lector = new Scanner(System.in);

        do {

            System.out.println("Menu Lideres");
            System.out.println("1.Listar todos los Lideres de proyectos");
            System.out.println("2.Consultar lider por ID");
            System.out.println("3. Salir");

            System.out.println("Ingrese la opcion: ");

            int opcionIngresada = lector.nextInt();

            if (opcionIngresada == 1) {

                listar();

            }else if (opcionIngresada == 2) {

                consultar();
                

            }else if (opcionIngresada ==3){

                System.out.println("Salida exitosa");
                mainloop = false;

            }else{
                System.out.println("opcion invalida");
            }

            
        } while (mainloop);

    }

    public static void listar(){

        try {

            ArrayList<Lider> Lideres = controlador.consultarTodosLideres();

            System.out.println("ID_Lider Nombre Primero_Apellido Segundo_Apellido Salario Clasificacion");

            for (Lider lider : Lideres) {
                
                System.out.printf("%d %s %s %s %d %d %n",
                lider.getIdLider(), lider.getNombre(), lider.getPrimerApellido(),lider.getSegundoApellido(), lider.getSalario(), Math.round(lider.getClasificacion())
                );
            }
            
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println("Error consultando todos los lideres" + e.getMessage());
        }

    
    }
    public static void consultar(){

        System.out.println("Consultar lider ID");
        Scanner lector = new Scanner(System.in);
        System.out.println("ingrese el id del lider");
        Integer idLider = lector.nextInt();

        try {

           Lider lider = controlador.encontrarLider(idLider);

           if (lider != null){
            System.out.println("ID_Lider Nombre Primero_Apellido Segundo_Apellido Salario Clasificacion");
            System.out.printf("%d %s %s %s %d %d %n",
            lider.getIdLider(), lider.getNombre(), lider.getPrimerApellido(),lider.getSegundoApellido(), lider.getSalario(), Math.round(lider.getClasificacion())
                );

           }else{
               System.out.println("el lider con id "+ idLider + " no fue encontrado");
           }
        
            
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println("Error consultando el lider " + e.getMessage());
        }

    }
    
}
