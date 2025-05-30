import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnArticle extends JDialog{
	private JPanel mainPanel = new JPanel();
	private JLabel memberID = new JLabel("Member ID:");
	private JLabel DOI = new JLabel("DOI:");
	private JTextField enterMemberID = new JTextField(15);
	public static JTextField enterDOI = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public ReturnArticle(JFrame parent) {
		super(parent, "Add a New Article", true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel memberIDPanel = new JPanel();
		JPanel DOIPanel = new JPanel();
		
		memberIDPanel.add(memberID);
		memberIDPanel.add(enterMemberID);
		
		DOIPanel.add(DOI);
		DOIPanel.add(enterDOI);
		
		mainPanel.add(memberIDPanel);
		mainPanel.add(DOIPanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			
		});
		
		this.add(mainPanel);
		this.setTitle("Return a Article");
		this.setSize(300, 200);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}
