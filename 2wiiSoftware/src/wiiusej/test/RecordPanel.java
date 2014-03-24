package wiiusej.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.EtchedBorder;

import wiiusej.utils.IRCombined;

public class RecordPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JLabel irCombinedLabel;
	private JLabel videoCameraViewLabel;
	private JLabel systemStatusLabel;
	private JTextArea systemStatusTextArea;
	private JButton recordingButton;
	private JButton saveButton;
	private IRCombined irCombinedPanel;
	private JPanel videoCameraPanel;
	
	private int panelHeight;
	private int panelWidth;
	
	public BufferedImage mapImage;
	
	// GUI variables
	Font fontTahoma = new Font("Tahoma", 0, 12);

	public RecordPanel(int height, int width) {
		panelHeight = height;
		panelWidth = width;
		initComponents();
	}
	
	private void initComponents() {
		
		mapImage = null;
		
		irCombinedLabel = new JLabel();
		videoCameraViewLabel = new JLabel();
		systemStatusLabel = new JLabel();
		systemStatusTextArea = new JTextArea();
		recordingButton = new JButton();
		saveButton = new JButton();
		irCombinedPanel = new IRCombined();
		videoCameraPanel = new JPanel();
		
		irCombinedLabel.setFont(fontTahoma); // NOI18N
		irCombinedLabel.setText("IR Map Recording");

		videoCameraViewLabel.setFont(fontTahoma); // NOI18N
		videoCameraViewLabel.setText("Video Camera View");

		systemStatusLabel.setFont(fontTahoma); // NOI18N
		systemStatusLabel.setText("System Status:");

		systemStatusTextArea.setEditable(false);
		systemStatusTextArea.setColumns(20);
		systemStatusTextArea.setFont(fontTahoma); // NOI18N
		systemStatusTextArea.setLineWrap(true);
		systemStatusTextArea.setRows(5);
		systemStatusTextArea.setWrapStyleWord(true);
		systemStatusTextArea.setBorder(BorderFactory.createEtchedBorder());

		recordingButton.setFont(fontTahoma); // NOI18N
		recordingButton.setText("Start Recording Session");

		saveButton.setFont(fontTahoma); // NOI18N
		saveButton.setText("Save Session");

		irCombinedPanel.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		irCombinedPanel.setFont(fontTahoma); // NOI18N

		GroupLayout irCombinedPanelLayout = new GroupLayout(
				irCombinedPanel);
		irCombinedPanel.setLayout(irCombinedPanelLayout);
		irCombinedPanelLayout.setHorizontalGroup(irCombinedPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						603, Short.MAX_VALUE));
		irCombinedPanelLayout.setVerticalGroup(irCombinedPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));

		videoCameraPanel.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		videoCameraPanel.setFont(fontTahoma); // NOI18N

		GroupLayout videoCameraPanelLayout = new GroupLayout(videoCameraPanel);
		videoCameraPanel.setLayout(videoCameraPanelLayout);
		videoCameraPanelLayout.setHorizontalGroup(videoCameraPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						151, Short.MAX_VALUE));
		videoCameraPanelLayout.setVerticalGroup(videoCameraPanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						177, Short.MAX_VALUE));

		GroupLayout recordPanelLayout = new GroupLayout(this);
		setLayout(recordPanelLayout);
		recordPanelLayout
				.setHorizontalGroup(recordPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								recordPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recordPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																recordPanelLayout
																		.createSequentialGroup()
																		.addGap(1,
																				1,
																				1)
																		.addComponent(
																				irCombinedPanel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																irCombinedLabel))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recordPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																saveButton,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																recordingButton,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																systemStatusTextArea,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE,
																0,
																Short.MAX_VALUE)
														.addGroup(
																recordPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				recordPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								videoCameraViewLabel)
																						.addComponent(
																								videoCameraPanel,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								systemStatusLabel))
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		recordPanelLayout
				.setVerticalGroup(recordPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								recordPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												recordPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																irCombinedLabel)
														.addComponent(
																videoCameraViewLabel))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												recordPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																recordPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				videoCameraPanel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				systemStatusLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				systemStatusTextArea,
																				GroupLayout.DEFAULT_SIZE,
																				250,
																				Short.MAX_VALUE)
																		.addGap(13,
																				13,
																				13)
																		.addComponent(
																				recordingButton)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				saveButton))
														.addComponent(
																irCombinedPanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
	}
	
	public void setSystemStatus(String status) {
		systemStatusTextArea.setText(status);
	}
	
	public JButton getRecordingButton() {
		return recordingButton;
	}
	
	public JButton getSaveButton() {
		return saveButton;
	}
	
	public IRCombined getIRCombinedPanel() {
		return irCombinedPanel;
	}

}
