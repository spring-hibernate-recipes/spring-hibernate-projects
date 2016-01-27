package org.aryalinux.modelbuilder.ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WizardFrame extends JFrame implements ActionListener {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private ButtonPanel buttonPanel;
	private List<Screen> screens;

	public WizardFrame(String title) {
		super(title);
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		buttonPanel = new ButtonPanel();
		screens = new ArrayList<Screen>();

		add(mainPanel);
		getContentPane().add(buttonPanel, "South");

		buttonPanel.addButton("Previous", this);
		buttonPanel.addButton("Next", this);
		buttonPanel.addButton("Finish", this);
		buttonPanel.addButton("Cancel", this);
	}

	public void actionPerformed(ActionEvent arg0) {

	}

	public static void main(String[] args) {
		new WizardFrame("Wizard").setVisible(true);
	}
}
