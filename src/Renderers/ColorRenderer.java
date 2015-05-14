
package Renderers;

import java.awt.Color;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author Borja Andrades
 */
public class ColorRenderer extends DefaultTableCellRenderer {
    @Override
   protected void setValue(Object value) {
       super.setValue(value);
       switch((String)value){
           case "Athletic Club":this.setBackground(Color.red);
                                this.setForeground(Color.black);
               break;
           case "Real Madrid":this.setBackground(Color.magenta);
                                this.setForeground(Color.black);
               break;
           case "Racing de Santander":this.setBackground(Color.green);
                                    this.setForeground(Color.black);
               break;        
       }
    }
}


