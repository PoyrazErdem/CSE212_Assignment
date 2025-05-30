import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CheckOutArticle extends JDialog{
	private JPanel mainPanel = new JPanel();
	private JLabel memberID = new JLabel("Member ID:");
	private JLabel articleDOI = new JLabel("Article DOI:");
	private JLabel dueYear = new JLabel("Due Year(YYYY):");
	private JLabel dueMonth = new JLabel("Due Month(MM):");
	private JLabel dueDay = new JLabel("Due Day(DD):");
	private JTextField enterMemberID = new JTextField(15);
	private JTextField enterArticleDOI = new JTextField(15);
	private JTextField enterDueYear = new JTextField(15);
	private JTextField enterDueMonth = new JTextField(15);
	private JTextField enterDueDay = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public CheckOutArticle(JFrame parent) {
		super(parent, "Add a New Article", true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel memberIdPanel = new JPanel();
		JPanel bookISBNPanel = new JPanel();
		JPanel dueYearPanel = new JPanel();
		JPanel dueMonthPanel = new JPanel();
		JPanel dueDayPanel = new JPanel();
		
		memberIdPanel.add(memberID);
		memberIdPanel.add(enterMemberID);
		
		bookISBNPanel.add(articleDOI);
		bookISBNPanel.add(enterArticleDOI);
		
		dueYearPanel.add(dueYear);
		dueYearPanel.add(enterDueYear);
		
		dueMonthPanel.add(dueMonth);
		dueMonthPanel.add(enterDueMonth);
		
		dueDayPanel.add(dueDay);
		dueDayPanel.add(enterDueDay);
		
		mainPanel.add(memberIdPanel);
		mainPanel.add(bookISBNPanel);
		mainPanel.add(dueYearPanel);
		mainPanel.add(dueMonthPanel);
		mainPanel.add(dueDayPanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			JOptionPane.showMessageDialog(this, "Article '" + AddBookGUI.enterBookName.getText().trim() + "' (DOI: " + enterArticleDOI.getText().trim() + ") checked out by " + AddMemberGUI.enterMemberName.getText().trim());
		});
		
		this.add(mainPanel);
		this.setTitle("Check Out an Article");
		this.setSize(300, 250);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}
