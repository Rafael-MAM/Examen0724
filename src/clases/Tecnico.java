
package clases;


public class Tecnico {
    private String nombre;
    private String direccion;
    
    public void setNombre (String unNombre){
      this.nombre = unNombre;
    }
    public void setDireccion (String unDireccion){
      this.direccion = unDireccion;
    }
    public String getNombre(){
      return this.nombre;
    }
    public String getDireccion(){
      return this.direccion;
    }
    public Tecnico(String unNombre, String unDireccion){
      this.nombre = unNombre;
      this.direccion = unDireccion;
    }
    
}
