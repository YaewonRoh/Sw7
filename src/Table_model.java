import javax.swing.table.AbstractTableModel;

public class Table_model extends AbstractTableModel {

	String[] columNames =
		{"�̸�","����","��ȿ�Ⱓ"};
	
	Object[][] data = {{" "," "," "}};
       
    public Table_model(){
          
    }
 
    // ������
    public Table_model(Object[][] data) {
           this.data = data;
    }
    
    @Override
    public int getColumnCount() {
    	return columNames.length;
    }
 
    @Override
    public int getRowCount() {
    	return data.length;           
    }
 
    @Override
    public Object getValueAt(int arg0, int arg1) {
        return data[arg0][arg1];
    }
 
    @Override
    public String getColumnName(int arg0) {
    	return columNames[arg0];
    }

}
