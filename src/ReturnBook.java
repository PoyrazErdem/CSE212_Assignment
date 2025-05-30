import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnBook extends JDialog	{
	private JPanel mainPanel = new JPanel();
	private JLabel memberID = new JLabel("Member ID:");
	private JLabel ISBN = new JLabel("ISBN:");
	private JTextField enterMemberID = new JTextField(15);
	public static JTextField enterISBN = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public ReturnBook(JFrame parent) {
		super(parent, "Add a New Article", true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel memberIDPanel = new JPanel();
		JPanel ISBNPanel = new JPanel();
		
		memberIDPanel.add(memberID);
		memberIDPanel.add(enterMemberID);
		
		ISBNPanel.add(ISBN);
		ISBNPanel.add(enterISBN);
		
		mainPanel.add(memberIDPanel);
		mainPanel.add(ISBNPanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			
		});
		
		this.add(mainPanel);
		this.setTitle("Return a Book");
		this.setSize(300, 200);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}
