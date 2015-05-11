import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by boyd on 5/9/15.
 */
public class MusicDataTable extends AbstractTableModel {
    private ResultSet resultSet;

    MusicDataTable(ResultSet rs){
        this.resultSet = rs;
    }



    @Override
    public int getRowCount(){
        int count = 0;
        try {
            if(this.resultSet==null){
                return 0;
            }else {
                this.resultSet.beforeFirst();
                while (this.resultSet.next()) {
                    count++;
                }
            }
        }catch(SQLException sqle){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
        }
        return count;

    }

    @Override
    public Object getValueAt(int row, int col){
        try{
            this.resultSet.absolute(row+1);
            Object o = this.resultSet.getObject(col+1);
            return o.toString();

        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
            return "Not right.";
        }

    }

    @Override
    public int getColumnCount(){
        try{
            if(this.resultSet==null){
                return 1;
            }else {
                return this.resultSet.getMetaData().getColumnCount();
            }
        }catch(SQLException se){
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"There was a database problem.");
            return 1;
        }
    }



}
