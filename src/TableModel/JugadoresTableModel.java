package TableModel;

import Database.Jugadores;
import javax.swing.table.AbstractTableModel;
import Listas.ListaJugadores;

/**
 *
 * @author Borja Andrades
 */
public class JugadoresTableModel extends AbstractTableModel{

    private ListaJugadores jugadoresTabla;
    
    public JugadoresTableModel(ListaJugadores jugadores) {
        this.jugadoresTabla = jugadores;
    }

    //Obtener numero de filas
    @Override
    public int getRowCount() {
        return jugadoresTabla.getListajugadores().size();
    }

    //Obtener numero columnas
    @Override
    public int getColumnCount() {   
        //Las columnas ya estan delimitadas(Nombre,apellidos..)
        return 7;
    }
    
    //Obtener ambos
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Jugadores jugador = jugadoresTabla.getListajugadores().get(rowIndex);
        switch(columnIndex){
            case 0: return jugador.getNombre();
            
            case 1: return jugador.getApellidos();
            
            case 2: return jugador.getApodo();
            
            case 3: return jugador.getEdad();
            
            case 4: return jugador.getGoles();
            
            case 5: return jugador.getIdEquipo().getEquipo();
            
            case 6: return jugador.getSancionado();
                
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
       switch(column){
           case 0: return "Nombre";
           
           case 1: return "Apellido";
               
           case 2: return "Apodo";
               
           case 3: return "Edad";
               
           case 4: return "Goles";
               
           case 5: return "Equipo";
               
           case 6: return "¿Sancionado?";
               
           default: return null;
       }
    }
    
      @Override
    //Terminar para que al editar se actualize 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:                  
            case 1:
            case 5:
                return false;  
            case 2:             
            case 3:                      
            case 4:          
            case 6:
                return true;
        }
        return false;
    }
    
    @Override
    //Cambiar el valor de la columna a editar
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       Jugadores tablaJugadores = jugadoresTabla.getListajugadores().get(rowIndex);
        switch(columnIndex){
            case 2: tablaJugadores.setApodo(String.valueOf(aValue));
                   break;
            case 3: tablaJugadores.setEdad(Short.valueOf((String)aValue));
                    break;
            case 4: tablaJugadores.setGoles(Short.valueOf((String)aValue));
                    break;
            case 6: tablaJugadores.setSancionado(Boolean.valueOf((String)aValue));
        }
    }
}
