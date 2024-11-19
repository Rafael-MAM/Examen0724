
package clases;


public class Cliente {
    private String nombre;
    private String rut;
    private String telefono;
    
    public void setNombre (String unNombre){
       this.nombre = unNombre;
    }
    public void setRut (String unRut){
       this.rut = unRut;
    }
    public void setTelefono (String unTelefono){
       this.telefono = unTelefono;
    }
    public String getNombre(){
       return this.nombre;
    }
    public String getRut(){
       return this.rut; 
    }
    public String getTelefono() {
       return this.telefono;
    }
    public Cliente(String unNombre,String unTelefono,String unRut){
       this.nombre = unNombre;
       this.rut = unRut;
       this.telefono = unTelefono;
    }
    @Override
    public String toString(){
       return this.getNombre();
    }
    
}
