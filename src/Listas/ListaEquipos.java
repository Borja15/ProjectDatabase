package Listas;

import Database.Equipos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borja Andrades
 */
public class ListaEquipos {
    private List<Equipos> listaequipos = new ArrayList();

    public ListaEquipos(){       
    }

    public void setListaequipos(List<Equipos> listaequipos) {
        this.listaequipos = listaequipos;
    }
    
    public List<Equipos> getListaequipos() {
        return listaequipos;
    }   
}
