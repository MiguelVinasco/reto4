package controller;

// tiene que interactuar con los modelos ya asignados
import model.dao.LiderDao;
import model.vo.Lider;
import java.util.ArrayList;
import java.sql.SQLException;


//los atributos del controlador van hacer instancias de los DAO no se van a modificar
public class ControladorProyectosContruccion {

    private final LiderDao liderDao;

    public ControladorProyectosContruccion(){

        this.liderDao = new LiderDao();
    }

    public ArrayList<Lider> consultarTodosLideres() throws SQLException {

        return this.liderDao.consultarTodos();


    }

    public Lider encontrarLider(Integer idLider)throws SQLException {

        return this.liderDao.consultarLiderID(idLider);

    }

    
}
