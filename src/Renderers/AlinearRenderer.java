package Renderers;




import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Borja Andrades
 */
public class AlinearRenderer extends DefaultTableCellRenderer{

   @Override
   protected void setValue(Object value) {
       setText((String) value);
       setHorizontalAlignment(CENTER);
    }
}
