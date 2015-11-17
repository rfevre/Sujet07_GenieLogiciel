import javax.swing.table.*;

public class MyTableModel2 extends AbstractTableModel
{
    private String[]
	columnNames = {"Tranche d'age", "effectif"};

    private Object[][] data = {
	{"20 ans", new Integer(5)},
	{"21 ans", new Integer(8)}
    };

        // Redefinition de quelques methodes de AbstractTableModel 

    /** Nombre de colonnes dans la table */
    public int getColumnCount() 
    { 
	return columnNames.length ; 
    }

    /** Nombre de lignes dans la table */
    public int getRowCount() 
    { 
	return data.length ; 
    }
    
    /** Nom du champ correspondant a la colonne specifiee */
    public String getColumnName(int col) 
    { 
	return columnNames[col] ; 
    }
    
    /** Valeur du champ de la colonne col pour la ligne specifiee */
    public Object getValueAt(int row, int col) 
    { 
	return data[row][col] ; 
    }

    /** Renvoie la class du premier objet de la colonne spécifié */
    public Class<?> getColumnClass(int col)
    {
	return data[0][col].getClass();
    }
    
    /** Modifier les valeur dans une cellule */
    public void setValueAt(Object aValue, int row, int col)
    {
	data[row][col]=aValue;
    }
}
