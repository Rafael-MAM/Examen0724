
package clases;

import java.util.ArrayList;
import java.util.Collections;


public class Sistema {
    private ArrayList<Tecnico> listaTecnicos;
    private ArrayList<Cartel> listacarteles;
    private ArrayList<Cliente> listaClientes;

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<Cartel> getListaCarteles() {
        return listacarteles;
    }

    public void setListacarteles(ArrayList<Cartel> listacarteles) {
        this.listacarteles = listacarteles;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public Sistema(ArrayList<Cliente> unlistaClientes, ArrayList<Tecnico> unlistaTecnicos,ArrayList<Cartel> unlistaCarteles){
        this.listaClientes = unlistaClientes;
        this.listaTecnicos = unlistaTecnicos;
        this.listacarteles = unlistaCarteles;
    }
    public ArrayList<Cartel> cartelMontoFranja(int unMinimo, int unMaximo,ArrayList<Cartel> unListaCartel ){
        ArrayList<Cartel> aux = new  ArrayList<Cartel>();
        for(int i = 0; i < unListaCartel.size(); i++) {
            if ((unMinimo <= unListaCartel.get(i).getCosto()) && (unListaCartel.get(i).getCosto()<= unMaximo)) {
                aux.add(unListaCartel.get(i));
            }
            
        }
        return aux;
    }
    
    public ArrayList<Cartel> cartelOrdenado(ArrayList<Cartel> unListaCartel){
        ArrayList<Cartel> aux = unListaCartel;
        Collections.sort(aux);
        return aux;
    }
    public boolean[][] simular(boolean[][] mat, int segundos){
        boolean[][] aux = new boolean[mat.length][mat[0].length];
        for (int l = 0; l < mat.length; l++){
          for(int m = 0; m < mat[0].length; m++){
             aux[l][m] = mat[l][m];
          }
        }
        if (segundos > 0) {
            for (int k = 0; k < segundos; k++){
              for(int i = 0; i < aux.length; i++){
                 boolean sig = aux[i][0];
                 for(int j = 0; j < aux[0].length - 1; j++) { 
                        if (j == aux[i].length - 2){
                             aux[i][0] = aux[i][j+1];
                             aux[i][j+1] = sig;
                        } else {
                             boolean auxSig = aux[i][j+1];
                             aux[i][j+1] = sig;
                             sig = auxSig;
                          }
                 }
              }
            }
        }
        return aux;
    }
    public int analisisLuces(){
        ArchivoLectura arch = new ArchivoLectura("src/resources/Cartel.txt");
        arch.hayMasLineas();
        String[] aux = arch.linea().split("#");
        int fila = Integer.parseInt(aux[0]);
        int colum = Integer.parseInt(aux[1]);
        boolean[][] cartel = new boolean[fila][colum];
        int filaAux = 0;
        while (arch.hayMasLineas()){
            String linea = arch.linea();
           for(int i = 0; i < linea.length(); i++){
               char letra = linea.charAt(i);
               if (letra == 'P'){
                  cartel[filaAux][i] = true;
               }
           }
           filaAux ++;
        }
        arch.cerrar();
        ArchivoLectura arch2 = new ArchivoLectura("src/resources/Roturas.txt");
        ArrayList<String[]> roturasfilcol = new ArrayList<String[]>();
        while(arch2.hayMasLineas()){
            String[] aux2 = arch2.linea().split("#");
            roturasfilcol.add(aux2);
        }
        arch2.cerrar();
        boolean roto = false;
        int segundos = 0;
        for(int j = 0; j < roturasfilcol.size() && !roto; j++){
             int fil = Integer.parseInt(roturasfilcol.get(j)[0])-1;
             int col = Integer.parseInt(roturasfilcol.get(j)[1])-1;
             if (cartel[fil][col] == true){
                 roto = true;
             }
        }
        for (int i = 0; i< cartel.length; i++){  //imprime
          for (int j = 0; j< cartel[0].length; j++){
             System.out.print(cartel[i][j]+ " ");
          }
           System.out.println("");
        }
        System.out.println(""); //  termina imprime
        boolean[][] matAux = this.simular(cartel,1);
        for(int k = 1; k < cartel[0].length && !roto; k++){
            for (int i = 0; i< matAux.length; i++){   //imprime
                for (int j = 0; j< matAux[0].length; j++){
                System.out.print(matAux[i][j]+" ");
                }
                System.out.println("");
            }
            System.out.println(""); //  termina imprime
            for(int j = 0; j < roturasfilcol.size() && !roto; j++){
                 int fil = Integer.parseInt(roturasfilcol.get(j)[0])-1;
                 int col = Integer.parseInt(roturasfilcol.get(j)[1])-1;
                 if (matAux[fil][col] == true){
                    roto = true;
                 }
            }
            segundos++;
             matAux = this.simular(matAux,1);
        }
        if (roto == false){
          segundos = -1;
        }
        return segundos;
    }
    
    //agrego imprimir disenio cartel para probar simular
    public void imprimirDisenioCartel(boolean[][] unDisenio){
        for(int i=0; i<unDisenio.length; i++){
           for(int j=0; j<unDisenio[0].length; j++){
                System.out.print(unDisenio[i][j] + " ");
           }
           System.out.println("");
        }
    }
    
}
