import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddArticleGUI extends JDialog {
	private JPanel mainPanel = new JPanel();
	private JLabel articleName = new JLabel("Article Name:");
	private JLabel DOI = new JLabel("DOI:");
	private JLabel publisher = new JLabel("Publisher:");
	private JTextField enterArticleName = new JTextField(15);
	private JTextField enterDOI = new JTextField(15);
	private JTextField enterPublisher = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public AddArticleGUI(JFrame parent) {
		super(parent, "Add a New Article", true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel articleNamePanel = new JPanel();
		JPanel DOIPanel = new JPanel();
		JPanel publisherPanel = new JPanel();
		
		articleNamePanel.add(articleName);
		articleNamePanel.add(enterArticleName);
		
		DOIPanel.add(DOI);
		DOIPanel.add(enterDOI);
		
		publisherPanel.add(publisher);
		publisherPanel.add(enterPublisher);
		
		mainPanel.add(articleNamePanel);
		mainPanel.add(DOIPanel);
		mainPanel.add(publisherPanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			
		});
		
		this.add(mainPanel);
		this.setTitle("Add New Article");
		this.setSize(300, 200);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}

