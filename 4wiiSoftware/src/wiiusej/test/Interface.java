package wiiusej.test;

import java.awt.*;
import javax.swing.*;

public class Interface {
	public static void main(String[] args) {
		
		JFrame frame =  new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 400));
		frame.setTitle("INTERFACE");
		frame.setLayout(new BorderLayout());
		
		/* Handling north part */
		JButton button1 = new JButton("Session Info");
		JButton button2 = new JButton("Calibrate Map");
		JButton button3 = new JButton("Recording");
		
		JPanel north =  new JPanel(new GridLayout(1,3));
		north.add(button1);
		north.add(button2);
		north.add(button3);
		
		
		/* Handling south part */
		JLabel label1 = new JLabel("Session Name");
		JTextField field1 = new JTextField(15);
		
		JLabel label2 = new JLabel("Map Name");
		JTextField field2 = new JTextField(15);
		
		JLabel label3 = new JLabel("Date");
		JTextField field3 = new JTextField(15);
		
		JLabel label4 = new JLabel("Location");
		JTextField field4 = new JTextField(15);
		
		JLabel label5 = new JLabel("Interviewer");
		JTextField field5 = new JTextField(15);
		
		JLabel label6 = new JLabel("Interviewee");
		JTextField field6 = new JTextField(15);
		
		JLabel label7 = new JLabel("Comments");
		JTextField field7 = new JTextField(30);
		
		JButton LoadButton = new JButton("Load Map Image");
		JTextField field8 = new JTextField(15);
		
		
		JPanel south =  new JPanel(new GridLayout(8,2));
		south.add(label1);
		south.add(field1);
		south.add(label2);
		south.add(field2);
		south.add(label3);
		south.add(field3);
		south.add(label4);
		south.add(field4);
		south.add(label5);
		south.add(field5);
		south.add(label6);
		south.add(field6);
		south.add(label7);
		south.add(field7);
		south.add(LoadButton);
		south.add(field8);
		
		
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
	}
}
