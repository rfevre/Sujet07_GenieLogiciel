import javax.swing.table.* ;
import javax.swing.event.*;

/** Le modele de table (TableModel) decrit la structure et le contenu des donnees,
 *  tandis que JTable ne fait que donner une representation graphique de ces
 *  donnees. */
public class MyTableModel extends AbstractTableModel 
{
    // nom des champs
    private String[]
	columnNames = {"Nom", "Prenom", "Formation", "Age", "Lillois ?"};
    // donnees brutes
    private Object[][] data = {
	{"Belorgey", "Nicolas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Biencourt", "Cyril",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Bo", "Thomas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Bouteiller", "Yannick",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Buresi", "Stephane",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Cauchy", "Matthieu",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Deloor", "Sebastien",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Descamps", "Jean-Philippe",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Dupont", "Mathieu",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Fruchart", "Remy",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Girondel", "Etienne",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Hammiche", "Tony",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Lafarge", "Thomas",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Leclercq", "Maxime",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Lenoir", "Remy",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Poirot", "Vianney",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Ramos", "Sergio",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Salerano", "Riccardo",
	 "DA2I", new Integer(20), new Boolean(false)},
	{"Sans", "Benjamin",
	 "DA2I", new Integer(20), new Boolean(false)}
    };

    public MyTableModel()
    {
	addTableModelListener(new TableModelListener() 
	{
	    public void tableChanged(TableModelEvent e) 
	    {
		int col = e.getColumn();
		int row = e.getFirstRow();
		System.out.println("La ligne " + (row+1) + " de la colonne " + getColumnName(col) + " contient maintenant : "+data[row][col]);
	    }
	});
    }

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
	if (data[row][col]!=null) {
	    data[row][col]=aValue;
	    //fireTableCellUpdated(row,col);
	    //tableChanged(new TableModelEvent(this,row,row,col));
	}
    }
 
}

