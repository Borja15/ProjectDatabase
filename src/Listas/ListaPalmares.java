package Listas;


import Database.Palmares;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borja Andrades
 */
public class ListaPalmares {
     private List<Palmares> listapalmares = new ArrayList();
     
     public ListaPalmares(){       
    }

    public void setListapalmares(List<Palmares> listapalmares) {
        this.listapalmares = listapalmares;
    }

     
    public List<Palmares> getListapalmares() {
        return listapalmares;
    }   
}
