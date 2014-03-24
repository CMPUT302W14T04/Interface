package wiiusej.test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

public class NLPPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel nlpInstructionLabel = new JLabel();
	private JLabel suggestedNLPLabel = new JLabel();
	private JScrollPane suggestedNLPScrollPanel = new JScrollPane();
	private JList suggestedNLPCodeList = new JList();
	private JLabel currentNLPLabel = new JLabel();
	private JScrollPane currentNLPScrollPanel = new JScrollPane();
	private JList currentNLPCodeList = new JList();
	private JLabel addNewNLPInstructionPanel = new JLabel();
	private JLabel newNLPCodeNameLabel = new JLabel();
	private JTextField newNLPCodeTextField = new JTextField();
	private JButton addNLPCodeButton = new JButton();
	private JButton addNLPtoCurrentButton = new JButton();
	private JButton removeNLPFromCurrentButton = new JButton();
	
	private int panelHeight;
	private int panelWidth;
	
	// GUI variables
	Font fontTahoma = new Font("Tahoma", 0, 12);

	public NLPPanel(int width, int height) {
		panelWidth = width;
		panelHeight = height;
		initComponents();
	}
	
	private void initComponents() {
		
		nlpInstructionLabel = new JLabel();
		suggestedNLPLabel = new JLabel();
		suggestedNLPScrollPanel = new JScrollPane();
		suggestedNLPCodeList = new JList();
		currentNLPLabel = new JLabel();
		currentNLPScrollPanel = new JScrollPane();
		currentNLPCodeList = new JList();
		addNewNLPInstructionPanel = new JLabel();
		newNLPCodeNameLabel = new JLabel();
		newNLPCodeTextField = new JTextField();
		addNLPCodeButton = new JButton();
		addNLPtoCurrentButton = new JButton();
		removeNLPFromCurrentButton = new JButton();
		
		
		nlpInstructionLabel.setFont(fontTahoma); // NOI18N
		nlpInstructionLabel
				.setText("(Instructions on how to add/use NLP here)");
		nlpInstructionLabel.setVerticalAlignment(SwingConstants.TOP);
		nlpInstructionLabel.setAutoscrolls(true);
		nlpInstructionLabel.setBorder(BorderFactory.createEtchedBorder());

		suggestedNLPLabel.setFont(fontTahoma); // NOI18N
		suggestedNLPLabel.setText("Suggested NLP Codes");

		suggestedNLPCodeList.setBorder(BorderFactory.createEtchedBorder());
		suggestedNLPCodeList.setFont(fontTahoma); // NOI18N
		suggestedNLPCodeList.setModel(new AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4",
					"Item 5" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		suggestedNLPScrollPanel.setViewportView(suggestedNLPCodeList);

		currentNLPLabel.setFont(fontTahoma); // NOI18N
		currentNLPLabel.setText("NLP Codes Utilized for Current Session");

		currentNLPCodeList.setFont(fontTahoma); // NOI18N
		currentNLPCodeList.setModel(new AbstractListModel() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4",
					"Item 5" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		currentNLPScrollPanel.setViewportView(currentNLPCodeList);

		addNewNLPInstructionPanel.setFont(fontTahoma); // NOI18N
		addNewNLPInstructionPanel
				.setText("(Instructions on how to add new NLP here)");
		addNewNLPInstructionPanel.setVerticalAlignment(SwingConstants.TOP);
		addNewNLPInstructionPanel.setBorder(BorderFactory.createEtchedBorder());

		newNLPCodeNameLabel.setFont(fontTahoma); // NOI18N
		newNLPCodeNameLabel.setText("New NLP Code Name: ");

		newNLPCodeTextField.setFont(fontTahoma); // NOI18N

		addNLPCodeButton.setFont(fontTahoma); // NOI18N
		addNLPCodeButton.setText("Add Code to Current Session");
		addNLPCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addNLPCodeButtonActionPerformed(evt);
			}
		});

		addNLPtoCurrentButton.setText(">");

		removeNLPFromCurrentButton.setText("<");

		GroupLayout nlpPanelLayout = new GroupLayout(this);
		setLayout(nlpPanelLayout);
		nlpPanelLayout
				.setHorizontalGroup(nlpPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								nlpPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												nlpPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																addNewNLPInstructionPanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																nlpInstructionLabel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																nlpPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				nlpPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								suggestedNLPLabel)
																						.addGroup(
																								nlpPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												suggestedNLPScrollPanel,
																												GroupLayout.PREFERRED_SIZE,
																												351,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18,
																												18,
																												18)
																										.addGroup(
																												nlpPanelLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addComponent(
																																addNLPtoCurrentButton)
																														.addComponent(
																																removeNLPFromCurrentButton))))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				16,
																				Short.MAX_VALUE)
																		.addGroup(
																				nlpPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								currentNLPLabel)
																						.addComponent(
																								currentNLPScrollPanel,
																								GroupLayout.PREFERRED_SIZE,
																								349,
																								GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																nlpPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				newNLPCodeNameLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				newNLPCodeTextField,
																				GroupLayout.PREFERRED_SIZE,
																				230,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				addNLPCodeButton,
																				GroupLayout.PREFERRED_SIZE,
																				200,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		nlpPanelLayout
				.setVerticalGroup(nlpPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								nlpPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(nlpInstructionLabel,
												GroupLayout.PREFERRED_SIZE, 56,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												nlpPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																suggestedNLPLabel)
														.addComponent(
																currentNLPLabel))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												nlpPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																suggestedNLPScrollPanel,
																GroupLayout.DEFAULT_SIZE,
																364,
																Short.MAX_VALUE)
														.addComponent(
																currentNLPScrollPanel,
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																nlpPanelLayout
																		.createSequentialGroup()
																		.addGap(99,
																				99,
																				99)
																		.addComponent(
																				addNLPtoCurrentButton)
																		.addGap(36,
																				36,
																				36)
																		.addComponent(
																				removeNLPFromCurrentButton)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												addNewNLPInstructionPanel,
												GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												nlpPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																newNLPCodeNameLabel)
														.addComponent(
																newNLPCodeTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																addNLPCodeButton))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

	}
	
	private void addNLPCodeButtonActionPerformed(ActionEvent evt) {
		// TODO add your handling code here:
	}

}
