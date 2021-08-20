package model.vo;

//un VO es un objeto que envuelve los datos de una base de datos, para que el
//SW pueda consultarla

public class MaterialNacional {

    //atributos debe de tener los campos de la tabla. segun correspondan
    //a la informacion que se requiera.

    //ATRIBUTOS con envoltura
    private String nombreMaterial;
    private String importado;
    private Integer noCompras;
    
    public MaterialNacional() {
    }

    public MaterialNacional(String nombreMaterial, String importado, Integer noCompras) {
        this.nombreMaterial = nombreMaterial;
        this.importado = importado;
        this.noCompras = noCompras;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public Integer getNoCompras() {
        return noCompras;
    }

    public void setNoCompras(Integer noCompras) {
        this.noCompras = noCompras;
    }

    
    
    
}
