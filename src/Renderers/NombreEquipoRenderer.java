package Renderers;


import Database.Equipos;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Borja Andrades
 */
public class NombreEquipoRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Equipos equipo = (Equipos) value;
        this.setText(equipo.getEquipo());
        return this;
    }
   
}
