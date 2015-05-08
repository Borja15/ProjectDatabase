package TableModel;

import Database.Palmares;
import javax.swing.table.AbstractTableModel;
import Listas.ListaPalmares;

/**
 *
 * @author Borja Andrades
 */
public class PalmaresTableModel extends AbstractTableModel {

    private ListaPalmares palmaresTabla = new ListaPalmares();
    
    public PalmaresTableModel(ListaPalmares palmares) {
        this.palmaresTabla = palmares;
    }

    //Obtener numero de filas
    @Override
    public int getRowCount() {
        return palmaresTabla.getListapalmares().size();
    }

    //Obtener numero columnas
    @Override
    public int getColumnCount() {   
        //Las columnas ya estan delimitadas(Equipo,liga,copa..)
        return 7;
    }
    
    //Obtener ambos
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Palmares palmare = palmaresTabla.getListapalmares().get(rowIndex);
        switch(columnIndex){
            case 0: return palmare.getEquipo();
                    
            case 1: return palmare.getLiga();
                
            case 2: return palmare.getCopaRey();
                
            case 3: return palmare.getChampions();
                
            case 4: return palmare.getSupEspaña();
                
            case 5: return palmare.getSupEuropa();
                
            case 6: return palmare.getEuropaLiga();
            
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Equipo";
           
           case 1: return "Ligas";
               
           case 2: return "Copas SM Rey";
               
           case 3: return "Liga de Campeones";
               
           case 4: return "Sup.España";
               
           case 5: return "Sup.Europa";
               
           case 6: return "EuropaLeague";
               
           default: return null;
       }
    }
    
      @Override
    //Terminar para que al editar se actualize 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return false;                   
            case 1:                    
            case 2:                
            case 3:                        
            case 4:                
            case 5:           
            case 6:
                return true;
        }
        return false;
    }
    
    @Override
    //Cambiar el valor de la columna a editar
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Palmares tablaPalmares = palmaresTabla.getListapalmares().get(rowIndex);
        switch(columnIndex){
            case 1: tablaPalmares.setLiga(Short.valueOf((String)aValue));
                   break;
            case 2: tablaPalmares.setCopaRey(Short.valueOf((String)aValue));
                   break;
            case 3: tablaPalmares.setChampions(Short.valueOf((String)aValue));
                    break;
            case 4: tablaPalmares.setSupEspaña(Short.valueOf((String)aValue));
                    break;
            case 5: tablaPalmares.setSupEuropa(Short.valueOf((String)aValue));
                    break;
            case 6: tablaPalmares.setEuropaLiga(Short.valueOf((String)aValue));
                    break;
        }
    }
    
}
