package wiiusej.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.EtchedBorder;

public class CalibrationPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// GUI variables
	Font fontTahoma = new Font("Tahoma", 0, 12);
	NumberFormat numberFormat = NumberFormat.getNumberInstance();

	private JLabel physicalMapSizeLabel;
	private JLabel xLabel;
	private JPanel calibrationDisplayPanel;
	private ImagePanel mapImagePanel;
	private ImagePanel wiimoteHorizontalImagePanel;
	private ImagePanel wiimoteVerticalImagePanel;
	private ImagePanel horArrowImagePanel;
	private ImagePanel verArrowImagePanel;
	private ImagePanel horMapArrowImagePanel;
	private ImagePanel verMapArrowImagePanel;
	private JLabel vertWiimoteDistanceLabel;
	private JLabel vertMapDistanceLabel;
	private JLabel horWiimoteDistanceLabel;
	private JLabel horMapDistanceLabel;
	private JLabel mapBRCoordinateLabel;
	private JLabel mapTLCoordinateLabel;
	private JLabel xLabel1;
	private JLabel xLabel2;
	private JFormattedTextField mapLengthFormattedTextField;
	private JFormattedTextField mapWidthFormattedTextField;
	private JFormattedTextField mapTLXCoordFormattedTextField;
	private JFormattedTextField mapTLYCoordFormattedTextField;
	private JFormattedTextField mapBRXCoordFormattedTextField;
	private JFormattedTextField mapBRYCoordFormattedTextField;
	private JTextArea instructionTextArea;
	private JLabel instructionLabel;
	private JButton changeLRButton;
	private JButton calibrateButton;
	private JLabel trailingCMLabel;

	private int panelHeight;
	private int panelWidth;

	public CalibrationPanel(int width, int height) {
		panelWidth = width;
		panelHeight = height;
		initComponents();
	}

	private void initComponents() {

		// load all constant, prefix images
		BufferedImage horArrow = null;
		try {
			horArrow = ImageIO.read(new File("src/wiiusej/test/horizontalarrow.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage vertArrow = null;
		try {
			vertArrow = ImageIO.read(new File("src/wiiusej/test/verticalarrow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage vertWiimote = null;
		try {
			vertWiimote = ImageIO.read(new File("src/wiiusej/test/VerticalWiiRemote.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage horWiimote = null;
		try {
			horWiimote = ImageIO.read(new File("src/wiiusej/test/HorizontalWiiRemote.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		physicalMapSizeLabel = new JLabel();
		xLabel = new JLabel();
		calibrationDisplayPanel = new JPanel();
		mapImagePanel = new ImagePanel(null);
		wiimoteHorizontalImagePanel = new ImagePanel(horWiimote);
		wiimoteVerticalImagePanel = new ImagePanel(vertWiimote);
		horArrowImagePanel = new ImagePanel(horArrow);
		verArrowImagePanel = new ImagePanel(vertArrow);
		horMapArrowImagePanel = new ImagePanel(horArrow);
		verMapArrowImagePanel = new ImagePanel(vertArrow);
		vertWiimoteDistanceLabel = new JLabel();
		horMapDistanceLabel = new JLabel();
		vertMapDistanceLabel = new JLabel();
		horWiimoteDistanceLabel = new JLabel();
		mapBRCoordinateLabel = new JLabel();
		mapTLCoordinateLabel = new JLabel();
		xLabel1 = new JLabel();
		xLabel2 = new JLabel();
		mapLengthFormattedTextField = new JFormattedTextField(numberFormat);
		mapWidthFormattedTextField = new JFormattedTextField(numberFormat);
		mapTLXCoordFormattedTextField = new JFormattedTextField(numberFormat);
		mapTLYCoordFormattedTextField = new JFormattedTextField(numberFormat);
		mapBRXCoordFormattedTextField = new JFormattedTextField(numberFormat);
		mapBRYCoordFormattedTextField = new JFormattedTextField(numberFormat);
		instructionTextArea = new JTextArea();
		instructionLabel = new JLabel();
		changeLRButton = new JButton();
		calibrateButton = new JButton();
		trailingCMLabel = new JLabel();

		physicalMapSizeLabel.setFont(fontTahoma); // NOI18N
		physicalMapSizeLabel.setText("Physical Map Size:");

		xLabel.setFont(fontTahoma); // NOI18N
		xLabel.setText("cm. x ");

		calibrationDisplayPanel.setBorder(BorderFactory
				.createEtchedBorder(EtchedBorder.RAISED));
		calibrationDisplayPanel.setFont(fontTahoma); // NOI18N
		calibrationDisplayPanel.setPreferredSize(new Dimension(200, 80));
		calibrationDisplayPanel.setBackground(new Color(255, 255, 255));

		mapImagePanel.setBackground(new Color(255, 255, 255));
		mapImagePanel.setBorder(BorderFactory.createTitledBorder("Map Image"));

		GroupLayout mapImagePanelLayout = new GroupLayout(mapImagePanel);
		mapImagePanel.setLayout(mapImagePanelLayout);
		mapImagePanelLayout.setHorizontalGroup(mapImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));
		mapImagePanelLayout.setVerticalGroup(mapImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						259, Short.MAX_VALUE));

		GroupLayout wiimoteHorizontalImagePanelLayout = new GroupLayout(
				wiimoteHorizontalImagePanel);
		wiimoteHorizontalImagePanel.setLayout(wiimoteHorizontalImagePanelLayout);
		wiimoteHorizontalImagePanelLayout
				.setHorizontalGroup(wiimoteHorizontalImagePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGap(0, 58, Short.MAX_VALUE));
		wiimoteHorizontalImagePanelLayout
				.setVerticalGroup(wiimoteHorizontalImagePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGap(0, 23, Short.MAX_VALUE));

		wiimoteVerticalImagePanel.setPreferredSize(new Dimension(25, 60));

		GroupLayout wiimoteVerticalImagePanelLayout = new GroupLayout(
				wiimoteVerticalImagePanel);
		wiimoteVerticalImagePanel.setLayout(wiimoteVerticalImagePanelLayout);
		wiimoteVerticalImagePanelLayout
				.setHorizontalGroup(wiimoteVerticalImagePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGap(0, 25, Short.MAX_VALUE));
		wiimoteVerticalImagePanelLayout.setVerticalGroup(wiimoteVerticalImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						60, Short.MAX_VALUE));

		GroupLayout horArrowImagePanelLayout = new GroupLayout(horArrowImagePanel);
		horArrowImagePanel.setLayout(horArrowImagePanelLayout);
		horArrowImagePanelLayout.setHorizontalGroup(horArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));
		horArrowImagePanelLayout.setVerticalGroup(horArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));

		GroupLayout verArrowImagePanelLayout = new GroupLayout(verArrowImagePanel);
		verArrowImagePanel.setLayout(verArrowImagePanelLayout);
		verArrowImagePanelLayout.setHorizontalGroup(verArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						25, Short.MAX_VALUE));
		verArrowImagePanelLayout.setVerticalGroup(verArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));

		GroupLayout horMapArrowImagePanelLayout = new GroupLayout(horMapArrowImagePanel);
		horMapArrowImagePanel.setLayout(horMapArrowImagePanelLayout);
		horMapArrowImagePanelLayout.setHorizontalGroup(horMapArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						174, Short.MAX_VALUE));
		horMapArrowImagePanelLayout.setVerticalGroup(horMapArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						16, Short.MAX_VALUE));

		GroupLayout verMapArrowImagePanelLayout = new GroupLayout(verMapArrowImagePanel);
		verMapArrowImagePanel.setLayout(verMapArrowImagePanelLayout);
		verMapArrowImagePanelLayout.setHorizontalGroup(verMapArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						17, Short.MAX_VALUE));
		verMapArrowImagePanelLayout.setVerticalGroup(verMapArrowImagePanelLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						0, Short.MAX_VALUE));

		vertWiimoteDistanceLabel.setText("? cm");

		horMapDistanceLabel.setText("? cm");

		vertMapDistanceLabel.setText("? cm");

		horWiimoteDistanceLabel.setText("? cm");

		GroupLayout calibrationDisplayPanelLayout = new GroupLayout(
				calibrationDisplayPanel);
		calibrationDisplayPanel.setLayout(calibrationDisplayPanelLayout);
		calibrationDisplayPanelLayout
				.setHorizontalGroup(calibrationDisplayPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								GroupLayout.Alignment.TRAILING,
								calibrationDisplayPanelLayout
										.createSequentialGroup()
										.addGroup(
												calibrationDisplayPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				calibrationDisplayPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addGap(31,
																												31,
																												31)
																										.addComponent(
																												wiimoteHorizontalImagePanel,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												horArrowImagePanel,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addContainerGap(
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												vertMapDistanceLabel)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												verMapArrowImagePanel,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				horWiimoteDistanceLabel)
																		.addGap(57,
																				57,
																				57)))
										.addGroup(
												calibrationDisplayPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																mapImagePanel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addGroup(
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				calibrationDisplayPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								wiimoteVerticalImagePanel,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addGroup(
																												calibrationDisplayPanelLayout
																														.createParallelGroup(
																																GroupLayout.Alignment.LEADING)
																														.addGroup(
																																GroupLayout.Alignment.TRAILING,
																																calibrationDisplayPanelLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				horMapDistanceLabel)
																																		.addGap(81,
																																				81,
																																				81))
																														.addComponent(
																																horMapArrowImagePanel,
																																GroupLayout.Alignment.TRAILING,
																																GroupLayout.PREFERRED_SIZE,
																																GroupLayout.DEFAULT_SIZE,
																																GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												verArrowImagePanel,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				vertWiimoteDistanceLabel)))
										.addContainerGap()));
		calibrationDisplayPanelLayout
				.setVerticalGroup(calibrationDisplayPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								calibrationDisplayPanelLayout
										.createSequentialGroup()
										.addGroup(
												calibrationDisplayPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				wiimoteVerticalImagePanel,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				calibrationDisplayPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addGap(0,
																												44,
																												Short.MAX_VALUE)
																										.addComponent(
																												horMapDistanceLabel)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												horMapArrowImagePanel,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								verArrowImagePanel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addContainerGap(
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addComponent(
																				vertWiimoteDistanceLabel)
																		.addGap(35,
																				35,
																				35)))
										.addGroup(
												calibrationDisplayPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				mapImagePanel,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																GroupLayout.Alignment.TRAILING,
																calibrationDisplayPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				calibrationDisplayPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												verMapArrowImagePanel,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED))
																						.addGroup(
																								GroupLayout.Alignment.TRAILING,
																								calibrationDisplayPanelLayout
																										.createSequentialGroup()
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												vertMapDistanceLabel)
																										.addGap(57,
																												57,
																												57)))
																		.addGroup(
																				calibrationDisplayPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								horArrowImagePanel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								wiimoteHorizontalImagePanel,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				horWiimoteDistanceLabel)
																		.addGap(119,
																				119,
																				119)))));

		mapBRCoordinateLabel.setFont(fontTahoma); // NOI18N
		mapBRCoordinateLabel
				.setText("Coordinates for the Bottom Right Hand Corner of the Map:");

		mapTLCoordinateLabel.setFont(fontTahoma); // NOI18N
		mapTLCoordinateLabel
				.setText("Coordinates for the Top Left Hand Corner of the Map:");

		xLabel1.setFont(fontTahoma); // NOI18N
		xLabel1.setText("x");

		xLabel2.setFont(fontTahoma); // NOI18N
		xLabel2.setText("x");

		mapLengthFormattedTextField.setText(" ");

		mapWidthFormattedTextField.setText(" ");

		mapTLXCoordFormattedTextField.setText(" ");
		mapTLXCoordFormattedTextField.setFont(fontTahoma); // NOI18N

		mapTLYCoordFormattedTextField.setText(" ");
		mapTLYCoordFormattedTextField.setFont(fontTahoma); // NOI18N

		mapBRXCoordFormattedTextField.setText(" ");
		mapBRXCoordFormattedTextField.setFont(fontTahoma); // NOI18N

		mapBRYCoordFormattedTextField.setText(" ");
		mapBRYCoordFormattedTextField.setFont(fontTahoma); // NOI18N

		instructionTextArea.setEditable(false);
		instructionTextArea.setColumns(20);
		instructionTextArea.setFont(fontTahoma); // NOI18N
		instructionTextArea.setLineWrap(true);
		instructionTextArea.setRows(5);
		instructionTextArea.setWrapStyleWord(true);
		instructionTextArea.setBorder(BorderFactory.createEtchedBorder());
		instructionTextArea.setPreferredSize(new Dimension(200, 80));

		instructionLabel.setFont(fontTahoma); // NOI18N
		instructionLabel.setText("Instructions:");

		changeLRButton.setFont(fontTahoma); // NOI18N
		changeLRButton.setText("Change  Orientation");
		changeLRButton.setEnabled(false);

		calibrateButton.setFont(fontTahoma); // NOI18N
		calibrateButton.setText("Calibrate");

		trailingCMLabel.setFont(fontTahoma); // NOI18N
		trailingCMLabel.setText("cm");

		GroupLayout calibrationPanelLayout = new GroupLayout(this);
		setLayout(calibrationPanelLayout);
		calibrationPanelLayout
				.setHorizontalGroup(calibrationPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								calibrationPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																calibrationPanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				physicalMapSizeLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				mapLengthFormattedTextField,
																				GroupLayout.PREFERRED_SIZE,
																				100,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				xLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				mapWidthFormattedTextField,
																				GroupLayout.PREFERRED_SIZE,
																				100,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				trailingCMLabel))
														.addGroup(
																calibrationPanelLayout
																		.createSequentialGroup()
																		.addGroup(
																				calibrationPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								mapTLCoordinateLabel,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								mapBRCoordinateLabel,
																								GroupLayout.Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				calibrationPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								mapTLXCoordFormattedTextField,
																								GroupLayout.DEFAULT_SIZE,
																								100,
																								Short.MAX_VALUE)
																						.addComponent(
																								mapBRXCoordFormattedTextField))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				calibrationPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								xLabel1,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								xLabel2,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				calibrationPanelLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								mapTLYCoordFormattedTextField,
																								GroupLayout.DEFAULT_SIZE,
																								100,
																								Short.MAX_VALUE)
																						.addComponent(
																								mapBRYCoordFormattedTextField)))
														.addComponent(
																calibrationDisplayPanel,
																GroupLayout.DEFAULT_SIZE,
																541,
																Short.MAX_VALUE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																instructionTextArea,
																GroupLayout.DEFAULT_SIZE,
																224,
																Short.MAX_VALUE)
														.addComponent(
																calibrateButton,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																changeLRButton,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																instructionLabel,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		calibrationPanelLayout
				.setVerticalGroup(calibrationPanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								calibrationPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																physicalMapSizeLabel)
														.addComponent(xLabel)
														.addComponent(
																mapLengthFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																mapWidthFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																instructionLabel)
														.addComponent(
																trailingCMLabel))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																instructionTextArea,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																calibrationDisplayPanel,
																GroupLayout.DEFAULT_SIZE,
																460,
																Short.MAX_VALUE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																mapTLCoordinateLabel)
														.addComponent(xLabel1)
														.addComponent(
																mapTLXCoordFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																mapTLYCoordFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																changeLRButton))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												calibrationPanelLayout
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(xLabel2)
														.addComponent(
																mapBRXCoordFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																mapBRYCoordFormattedTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																calibrateButton)
														.addComponent(
																mapBRCoordinateLabel))
										.addContainerGap()));
	}
	
	public double getMapLength() {
		return Double.parseDouble(mapLengthFormattedTextField.getText());
	}
	
	public double getMapWidth() {
		return Double.parseDouble(mapWidthFormattedTextField.getText());
	}
	
	public double getMapTLXCoord() {
		return Double.parseDouble(mapTLXCoordFormattedTextField.getText());
	}
	
	public double getMapTLYCoord() {
		return Double.parseDouble(mapTLYCoordFormattedTextField.getText());
	}
	
	public double getMapBRXCoord() {
		return Double.parseDouble(mapBRXCoordFormattedTextField.getText());
	}
	
	public double getMapBRYCoord() {
		return Double.parseDouble(mapBRYCoordFormattedTextField.getText());
	}
	
	public void setInstruction(String instruction) {
		instructionTextArea.setText(instruction);
	}
	
	public void setVertWiimoteDistance(Double dist) {
		vertWiimoteDistanceLabel.setText(formatNumber(dist));
	}
	
	public void setHorWiimoteDistance(Double dist) {
		horWiimoteDistanceLabel.setText(formatNumber(dist));
	}
	
	public void setVertMapDistance(Double dist) {
		vertMapDistanceLabel.setText(formatNumber(dist));
	}
	
	public void setHorMapDistance(Double dist) {
		horMapDistanceLabel.setText(formatNumber(dist));
	}
	
	public JButton getCalibrateButton() {
		return calibrateButton;
	}
	
	public ImagePanel getMapImagePanel() {
		return mapImagePanel;
	}
	
	// set the format of a double in a particular string
	public String formatNumber(Double number) {
		DecimalFormat formatter = new DecimalFormat("####.00");
		String formattedNumber = formatter.format(number.toString());
		return formattedNumber;
	}
}
