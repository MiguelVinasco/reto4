package model.vo;

//un VO es un objeto que envuelve los datos de una base de datos, para que el
//SW pueda consultarla

public class Lider {

    //atributos debe de tener los campos de la tabla. segun correspondan
    //a la informacion que se requiera.

    //ATRIBUTOS con envoltura
    private Integer idLider;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Integer salario;
    private Double clasificacion; 
    

    public Lider(){


    }

    public Lider(Integer idLider, String nombre){

        this.idLider = idLider;
        this.nombre = nombre;
    }

    public Integer getIdLider() {
        return idLider;
    }

    public void setIdLider(Integer idLider) {
        this.idLider = idLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Double getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Double clasificacion) {
        this.clasificacion = clasificacion;
    }

    


    
}
