package Listas;

import Database.Jugadores;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borja Andrades
 */
public class ListaJugadores {
     List<Jugadores> listajugadores = new ArrayList();
     
     public ListaJugadores(){       
    }

    public void setListajugadores(List<Jugadores> listajugadores) {
        this.listajugadores = listajugadores;
    }

     
    public List<Jugadores> getListajugadores() {
        return listajugadores;
    }  
}
