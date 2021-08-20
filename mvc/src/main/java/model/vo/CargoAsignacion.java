package model.vo;

//un VO es un objeto que envuelve los datos de una base de datos, para que el
//SW pueda consultarla

public class CargoAsignacion {

    //atributos debe de tener los campos de la tabla. segun correspondan
    //a la informacion que se requiera.

    //ATRIBUTOS con envoltura
    private String cargo;
    private Integer numeroProyectos;
    
    //constructor vacio
    public CargoAsignacion() {

    }

    //constructor con los paramentros igualados a los atributos de clase
    public CargoAsignacion(String cargo, Integer numeroProyectos) {
        this.cargo = cargo;
        this.numeroProyectos = numeroProyectos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getNumeroProyectos() {
        return numeroProyectos;
    }

    public void setNumeroProyectos(Integer numeroProyectos) {
        this.numeroProyectos = numeroProyectos;
    }

    
    

    
    
    }
