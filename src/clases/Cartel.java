
package clases;


public class Cartel implements Comparable<Cartel> {
    private Cliente cliente;
    private Tecnico tecnico;
    private boolean[][] diseno;
    private String descripcion;
    private int costo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente unCliente) {
        this.cliente = unCliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico unTecnico) {
        this.tecnico = unTecnico;
    }

    public boolean[][] getDiseno() {
        return diseno;
    }

    public void setDiseno(boolean[][] unDiseno) {
        this.diseno = unDiseno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String unDescripcion) {
        this.descripcion = unDescripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int unCosto) {
        this.costo = unCosto;
    }
    
    public Cartel(Tecnico unTecnico, Cliente unCliente,boolean[][] unDiseno ,String unDescripcion, int unCosto){
        this.tecnico = unTecnico;
        this.cliente = unCliente;
        this.diseno = unDiseno;
        this.descripcion = unDescripcion;
        this.costo = unCosto;
    } 
    @Override
    public String toString(){
       return this.cliente.toString() + " " + this.getDescripcion() + " $" + this.getCosto();
    }
    @Override
    public int compareTo(Cartel otroCartel){
      int valor;
      if (this.getCosto() == otroCartel.getCosto()) {
       valor =0;
      } else {
           if (this.getCosto() < otroCartel.getCosto()) {
              valor = -1;
           } else {
              valor = 1; 
             }
        }
      return valor;
    }
    
}
