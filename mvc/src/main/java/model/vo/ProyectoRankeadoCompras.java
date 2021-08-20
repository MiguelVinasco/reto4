package model.vo;

//un VO es un objeto que envuelve los datos de una base de datos, para que el
//SW pueda consultarla

public class ProyectoRankeadoCompras {

    //atributos debe de tener los campos de la tabla. segun correspondan
    //a la informacion que se requiera.

    //ATRIBUTOS con envoltura
    private Integer idProyecto;
    private String clasificacion;
    private Integer areaMax;
    private Integer noComprasGranito;
    public ProyectoRankeadoCompras() {
    }
    public ProyectoRankeadoCompras(Integer idProyecto, String clasificacion, Integer areaMax,
            Integer noComprasGranito) {
        this.idProyecto = idProyecto;
        this.clasificacion = clasificacion;
        this.areaMax = areaMax;
        this.noComprasGranito = noComprasGranito;
    }
    public Integer getIdProyecto() {
        return idProyecto;
    }
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
    public Integer getAreaMax() {
        return areaMax;
    }
    public void setAreaMax(Integer areaMax) {
        this.areaMax = areaMax;
    }
    public Integer getNoComprasGranito() {
        return noComprasGranito;
    }
    public void setNoComprasGranito(Integer noComprasGranito) {
        this.noComprasGranito = noComprasGranito;
    }

    
    
    }
