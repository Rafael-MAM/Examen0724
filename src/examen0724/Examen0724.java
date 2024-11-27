package examen0724;

import clases.Cartel;
import clases.Cliente;
import clases.Sistema;
import clases.Tecnico;
import interfaces.ConsultaDeCostos;
import java.util.ArrayList;

public class Examen0724 {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Jorge","099111111","2111111");
        Cliente cliente2 = new Cliente("Eduardo","099222222","2222222");
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        Tecnico tecnico1 = new Tecnico("Jose","Ejido");
        Tecnico tecnico2 = new Tecnico("Pedro","Minas");
        ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);
        boolean[][] diseno1 = {{false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},
                               {false,true,true,true,false,true,false},
                               {false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},
                              };
        boolean[][] diseno2 = {{true,false,true,false,false,false,false},
                               {true,false,true,false,false,false,false},
                              };
        boolean[][] diseno3 = {{false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},
                               {false,true,false,true,false,true,false},                      
                              };
        Cartel cartel1 = new Cartel(tecnico1,cliente1,diseno1,"Cartel 1",1000);
        Cartel cartel2 = new Cartel(tecnico2,cliente2,diseno2,"Cartel 2",500);
        Cartel cartel3 = new Cartel(tecnico1,cliente2,diseno3,"Cartel 3",1500);
        Cartel cartel4 = new Cartel(tecnico1,cliente1,diseno1,"Cartel 4",1600);
        Cartel cartel5 = new Cartel(tecnico2,cliente2,diseno2,"Cartel 5",3500);
        Cartel cartel6 = new Cartel(tecnico1,cliente2,diseno3,"Cartel 6",400);
        Cartel cartel7 = new Cartel(tecnico1,cliente2,diseno3,"Cartel 7",1500);
        Cartel cartel8 = new Cartel(tecnico1,cliente1,diseno1,"Cartel 8",16200);
        Cartel cartel9 = new Cartel(tecnico2,cliente2,diseno2,"Cartel 9",3600);
        Cartel cartel10 = new Cartel(tecnico1,cliente2,diseno3,"Cartel 10",1400);
        ArrayList<Cartel> carteles = new ArrayList<Cartel>();
        carteles.add(cartel1);
        carteles.add(cartel2);
        carteles.add(cartel3);
        carteles.add(cartel4);
        carteles.add(cartel5);
        carteles.add(cartel6);
        carteles.add(cartel7);
        carteles.add(cartel8);
        carteles.add(cartel9);
        carteles.add(cartel10);
        Sistema modelo = new Sistema(clientes,tecnicos,carteles);
        ConsultaDeCostos ventana = new ConsultaDeCostos(modelo);
        
        //System.out.println(modelo.getListaCarteles().toString());
        //modelo.cartelOrdenado(carteles);
        //System.out.println(modelo.getListaCarteles().toString());
        //int res = modelo.analisisLuces();
        //System.out.println(res);
        boolean [][] aux = new boolean[modelo.getListaCarteles().get(2).getDiseno().length][modelo.getListaCarteles().get(2).getDiseno()[0].length];
        aux = modelo.simular(modelo.getListaCarteles().get(1).getDiseno(),7);
        modelo.imprimirDisenioCartel(aux);
    }
    
}
