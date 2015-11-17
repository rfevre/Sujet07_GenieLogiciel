import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;
import javax.swing.table.* ;
import javax.swing.event.* ;

/** L'application permettant de manipuler une JTable */
public class AppliTable extends JFrame 
{    
    public static void main(String [] a) 
    {
	// pour avoir une fenetre decoree au style Swing
        JFrame.setDefaultLookAndFeelDecorated(true);
	AppliTable i = new AppliTable();
	i.setVisible(true) ;
    }

    private MyJTable table ;
    private JTable table2 ;
    private JPanel dessin ;
    
    public AppliTable() 
    {
	super("La loi des JTables") ;

	// action a effectuer lorsqu'on ferme la fenetre
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// definition du gestionnaire de placement 
	getContentPane().setLayout(new BorderLayout()) ;

	// on cree la table a partir d'un modele de table maison
	table = new MyJTable(new MyTableModel()) ;
	table2 = new JTable(new MyTableModel2()) ;

	// et on la place dans un JScrollPane
	JScrollPane scrollPane = new JScrollPane(table);
	JScrollPane scrollPane2 = new JScrollPane(table2);
	table.setPreferredScrollableViewportSize(new Dimension(600, 200));
	table2.setPreferredScrollableViewportSize(new Dimension(200,100));

	// création de la JComboBox
	String[] formations = { "DA2I", "IUT FI1", "IUT FI2", "IUT FC", "IUT AS" };
	JComboBox formationsList = new JComboBox(formations);

	// definition de l'editeur de cellule par défaut
	TableColumn column = table.getColumnModel().getColumn(2);
	column.setCellEditor(new DefaultCellEditor(formationsList));

	// pour faire apparaitre une bulle d'aide sur la colonne "Formation"
	DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	renderer.setToolTipText("Les formations disponible");
	column.setCellRenderer(renderer);	

	getContentPane().add(scrollPane, BorderLayout.NORTH) ;
	getContentPane().add(new BoutonPyramide("Calculer Pyramide"), BorderLayout.CENTER) ;
	getContentPane().add(scrollPane2, BorderLayout.SOUTH) ;
	setBounds(400,200,800,400) ;
    }

    public calculerPyramide()
    {
	Map<Integer, Integer> pyramide = new HashMap<Integer, Integer>();
	for (int i=0;i<table.getColumnCount();i++) {
	    int key = table.getValueAt(i,2);
	    if (!pyramide.containsKey(key))
		pyramide.put(key , 1);
	    else
		pyramide.put(key , pyramide.get(key)+1)
	}
    }

    class BoutonPyramide extends Button 
    {	
	/** Le constructeur cree un bouton portant le nom adequat et ajoute a l'instance
	 *  courante un auditeur pour reagir aux activations (clics) */
	public BoutonPyramide(String nom) 
	{
	    super(nom) ;
	    // L'auditeur des actions du bouton : une classe anonyme implementant
	    // l'interface ActionListener
	    this.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) 
		    {
			AppliTable.calculerPyramide() ;
		    }
		});    
	}
    } // fin de la classe interne BoutonPyramide
}
