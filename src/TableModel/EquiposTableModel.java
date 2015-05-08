package TableModel;

import Database.Equipos;
import javax.swing.table.AbstractTableModel;
import Listas.ListaEquipos;

/**
 *
 * @author Borja Andrades
 */
public class EquiposTableModel extends AbstractTableModel {

    private ListaEquipos equiposTabla = new ListaEquipos();
    
    public EquiposTableModel(ListaEquipos equipos) {
        this.equiposTabla = equipos;
    }

    //Obtener numero de filas
    @Override
    public int getRowCount() {
        return equiposTabla.getListaequipos().size();
    }

    //Obtener numero columnas
    @Override
    public int getColumnCount() {   
        //Las columnas ya estan delimitadas(Equipo,entrenador...)
        return 8;
    }

    //Obtener ambos
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipos equipo = equiposTabla.getListaequipos().get(rowIndex);
        switch(columnIndex){
            case 0: return equipo.getEquipo();
                    
            case 1: return equipo.getEntrenador();
                    
            case 2: return equipo.getPresidente();
                
            case 3: return equipo.getCiudad();            
            
            case 4: return equipo.getAño();
                
            case 5 : return equipo.getEstadio();
            
            case 6: return equipo.getAñosPrimera();
            
            case 7: return equipo.getAñosSegunda();
            
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Equipo";
           
           case 1: return "Entrenador";
               
           case 2: return "Presidente";
               
           case 3: return "Ciudad";
               
           case 4: return "AñoFundacion";
               
           case 5: return "Estadio";
               
           case 6: return "AñosPrimer.";
               
           case 7: return "AñosSegund.";
           default: return null;
       }
    }

    @Override
    //Fila de una columna se aditable
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return false;
                    
            case 1: return true;
                    
            case 2: return true;
                
            case 3: return false;            
            
            case 4: return false;
                
            case 5 : return false;
            
            case 6: return true;
            
            case 7: return true;  
        }
        return false;
    }

    @Override
    //Cambiar el valor de la columna a editar
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Equipos tablaEquipos = equiposTabla.getListaequipos().get(rowIndex);
        switch(columnIndex){
            case 1: tablaEquipos.setEntrenador(String.valueOf(aValue));
                    break;
            case 2: tablaEquipos.setPresidente(String.valueOf(aValue));
                    break;
        }
    }
   
}
