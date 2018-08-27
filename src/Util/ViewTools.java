/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import static org.apache.derby.shared.common.reference.SQLState.HIDDEN_COLUMN;

/**
 *
 * @author alihaydar
 */
public class ViewTools {
       public static void hideColumn(JTable table, String columnName)
    {
        try
        {
            TableColumnModel tcm = table.getColumnModel();
            int index = tcm.getColumnIndex( columnName );
            TableColumn column = tcm.getColumn( index );
            hideColumn(table, column);
        }
        catch(IllegalArgumentException e) {}
    }
    public static void hideColumn(JTable table, TableColumn column)
    {
        table.getColumnModel().removeColumn( column );
  
        //  Save the column so it can be redisplayed
  
        ArrayList list = (ArrayList)table.getClientProperty(HIDDEN_COLUMN);
 
        if (list == null)
        {
            list = new ArrayList();
            table.putClientProperty(HIDDEN_COLUMN, list);
        }
 
        list.add(column);
    }
}
