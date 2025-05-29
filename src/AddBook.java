import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBook extends JOptionPane{
	private JPanel mainPanel = new JPanel();
	private JLabel bookName = new JLabel("Book Name:");
	private JLabel ISBN = new JLabel("ISBN:");
	private JLabel price = new JLabel("Price:");
	private JTextField enterBookName = new JTextField();
	private JTextField enterISBN = new JTextField();
	private JTextField enterPrice = new JTextField();
	private JButton submitButton = new JButton("Submit");
	
	public AddBook() {
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
		
		this.add(mainPanel);
	}
}
