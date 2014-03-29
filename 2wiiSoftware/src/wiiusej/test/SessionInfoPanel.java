package wiiusej.test;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class SessionInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// GUI variables
	Font fontTahoma = new Font("Tahoma", 0, 12);
	
	// declaration of variables
	private JLabel sessionNameLabel;
	private JLabel mapNameLabel;
	private JLabel mapCodeLabel;
	private JLabel locationLabel;
	private JLabel dateLabel;
	private JLabel interviewerLabel;
	private JLabel intervieweeLabel;
	private JLabel commentsLabel;
	private JTextField sessionNameTextField;
	private JTextField mapNameTextField;
	private JTextField mapCodeTextField;
	private JTextField locationTextField;
	private JTextField dateTextField;
	private JButton loadMapButton;
	private JScrollPane interviewerScrollPane;
	private JScrollPane intervieweeScrollPane;
	private JScrollPane commentsScrollPane;
	private JTextArea interviewerTextArea;
	private JTextArea intervieweeTextArea;
	private JTextArea commentsTextArea;
	private JLabel loadMapImageLabel;
	
	private int panelHeight;
	private int panelWidth;
	private Image mapImage;

	public SessionInfoPanel(int width, int height) {
		panelWidth = width;
		panelHeight = height;
		initComponents();
	}

	private void initComponents() {

		sessionNameLabel = new JLabel();
		mapNameLabel = new JLabel();
		mapCodeLabel = new JLabel();
		locationLabel = new JLabel();
		dateLabel = new JLabel();
		interviewerLabel = new JLabel();
		intervieweeLabel = new JLabel();
		commentsLabel = new JLabel();
		sessionNameTextField = new JTextField();
		mapNameTextField = new JTextField();
		mapCodeTextField = new JTextField();
		locationTextField = new JTextField();
		dateTextField = new JTextField();
		interviewerTextArea = new JTextArea();
		interviewerScrollPane = new JScrollPane();
		intervieweeTextArea = new JTextArea();
		intervieweeScrollPane = new JScrollPane();
		loadMapButton = new JButton();
		commentsScrollPane = new JScrollPane();
		commentsTextArea = new JTextArea();
		loadMapImageLabel = new JLabel();

		setBorder(BorderFactory.createEtchedBorder());

		sessionNameLabel.setFont(fontTahoma); // NOI18N
		sessionNameLabel.setText("Session Name");

		mapNameLabel.setFont(fontTahoma); // NOI18N
		mapNameLabel.setText("Map Name");

		mapCodeLabel.setFont(fontTahoma); // NOI18N
		mapCodeLabel.setText("Map Code");

		locationLabel.setFont(fontTahoma); // NOI18N
		locationLabel.setText("Location");

		dateLabel.setFont(fontTahoma); // NOI18N
		dateLabel.setText("Date");

		interviewerLabel.setFont(fontTahoma); // NOI18N
		interviewerLabel.setText("Interviewer");

		intervieweeLabel.setFont(fontTahoma); // NOI18N
		intervieweeLabel.setText("Interviewee");

		commentsLabel.setFont(fontTahoma); // NOI18N
		commentsLabel.setText("Comments");

		sessionNameTextField.setFont(fontTahoma); // NOI18N
		sessionNameTextField.setText("NewSession001");

		mapNameTextField.setFont(fontTahoma); // NOI18N

		mapCodeTextField.setFont(fontTahoma); // NOI18N

		locationTextField.setFont(fontTahoma); // NOI18N

//		dateTextField.setFormatterFactory(new DefaultFormatterFactory(
//				new DateFormatter(java.text.DateFormat
//						.getDateInstance(java.text.DateFormat.LONG))));
		dateTextField.setFont(fontTahoma); // NOI18N

		interviewerTextArea.setFont(fontTahoma); // NOI18N
		interviewerScrollPane.setViewportView(interviewerTextArea);

		intervieweeTextArea.setFont(fontTahoma); // NOI18N
		intervieweeScrollPane.setViewportView(intervieweeTextArea);

		loadMapButton.setFont(fontTahoma); // NOI18N
		loadMapButton.setText("Load Map Image");
		loadMapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				loadMapButtonActionPerformed(evt);
			}
		});

		commentsTextArea.setFont(fontTahoma); // NOI18N
		commentsScrollPane.setViewportView(commentsTextArea);

		loadMapImageLabel.setFont(fontTahoma); // NOI18N
		loadMapImageLabel.setBorder(BorderFactory.createEtchedBorder());
		loadMapImageLabel.setText("");

		GroupLayout sessionInfoPanelLayout = new GroupLayout(this);
		setLayout(sessionInfoPanelLayout);
		sessionInfoPanelLayout
				.setHorizontalGroup(sessionInfoPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								sessionInfoPanelLayout
										// Each group here represents content of each 'column'
										.createSequentialGroup()
										.addContainerGap()
										// Label name group + loadMapImageButton
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																sessionInfoPanelLayout
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING,
																				false)
																		.addComponent(
																				sessionNameLabel,
																				GroupLayout.DEFAULT_SIZE,
																				79,
																				Short.MAX_VALUE)
																		.addComponent(
																				mapNameLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				mapCodeLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				locationLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				dateLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				interviewerLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				intervieweeLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				commentsLabel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				loadMapButton))
														)
										.addGap(6, 6, 6)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																sessionNameTextField)
														.addComponent(
																mapNameTextField)
														.addComponent(
																mapCodeTextField)
														.addComponent(
																locationTextField)
														.addComponent(
																dateTextField)
														.addComponent(
																interviewerScrollPane,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																intervieweeScrollPane,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																commentsScrollPane,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																loadMapImageLabel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		sessionInfoPanelLayout
				.setVerticalGroup(sessionInfoPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								sessionInfoPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																sessionNameLabel)
														.addComponent(
																sessionNameTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																mapNameLabel)
														.addComponent(
																mapNameTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																mapCodeLabel)
														.addComponent(
																mapCodeTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																locationLabel)
														.addComponent(
																locationTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(dateLabel)
														.addComponent(
																dateTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																interviewerLabel)
														.addComponent(
																interviewerScrollPane,
																GroupLayout.PREFERRED_SIZE,
																castInt(0.1, panelHeight),
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																intervieweeLabel)
														.addComponent(
																intervieweeScrollPane,
																GroupLayout.PREFERRED_SIZE,
																castInt(0.1, panelHeight),
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																commentsLabel)
														.addComponent(
																commentsScrollPane,
																GroupLayout.PREFERRED_SIZE,
																castInt(0.2, panelHeight),
																Short.MAX_VALUE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												sessionInfoPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																loadMapButton,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																loadMapImageLabel,
																GroupLayout.PREFERRED_SIZE,
																23,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
	}
	
	/**
	 * Return an integer after rounding a multiplication of a number by another
	 * 
	 * @param num1
	 *            first number to be multiplied
	 * @param num2
	 *            second number to be multiplied
	 * @return int of the multiplication of num1*num2, after rounding
	 */
	public int castInt(double num1, double num2) {
		return (int) Math.round(num1 * num2);
	}
	
	private void loadMapButtonActionPerformed(ActionEvent evt) {
		try {
			mapImage= ImageIO.read(new File("src/wiiusej/test/testmap.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// getters for all textfields in this panel
	public String getSessionName() {
		return sessionNameTextField.getText();
	}
	
	public String getMapName() {
		return mapNameTextField.getText();
	}
	
	public String getMapCode() {
		return mapCodeTextField.getText();
	}
	
	// getLocation() is a superclass method, so naming convention here is changed
	public String getLocationText() {
		return locationTextField.getText();
	}
	
	public String getDate() {
		return dateTextField.getText();
	}
	
	public String getInterviewer() {
		return interviewerTextArea.getText();
	}
	
	public String getInterviewee() {
		return intervieweeTextArea.getText();
	}
	
	public String getComments() {
		return commentsTextArea.getText();
	}
	
	public JButton getLoadMapButton() {
		return loadMapButton;
	}
	
	//TODO: load map image real functions
	public Image getMapImage() {
		BufferedImage pic = null;
		try {
			pic = ImageIO.read(new File("src/wiiusej/test/testmap.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;
	}
}


