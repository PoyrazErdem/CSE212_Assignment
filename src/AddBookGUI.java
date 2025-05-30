import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookGUI extends JDialog{
	private JPanel mainPanel = new JPanel();
	private JLabel bookName = new JLabel("Book Name:");
	private JLabel ISBN = new JLabel("ISBN:");
	private JLabel price = new JLabel("Price:");
	public static JTextField enterBookName = new JTextField(15);
	public static JTextField enterISBN = new JTextField(15);
	private JTextField enterPrice = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public AddBookGUI(JFrame parent) {
		super(parent, "Add a New Book", true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel bookNamePanel = new JPanel();
		JPanel ISBNPanel = new JPanel();
		JPanel pricePanel = new JPanel();
		
		bookNamePanel.add(bookName);
		bookNamePanel.add(enterBookName);
		
		ISBNPanel.add(ISBN);
		ISBNPanel.add(enterISBN);
		
		pricePanel.add(price);
		pricePanel.add(enterPrice);
		
		mainPanel.add(bookNamePanel);
		mainPanel.add(ISBNPanel);
		mainPanel.add(pricePanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			
		});
		
		this.add(mainPanel);
		this.setTitle("Add New Book");
		this.setSize(300, 200);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}
