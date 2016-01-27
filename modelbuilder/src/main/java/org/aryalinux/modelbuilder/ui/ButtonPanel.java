package org.aryalinux.modelbuilder.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
	private List<JButton> buttons;
	private JPanel thePanel;

	public ButtonPanel() {
		super(new FlowLayout(FlowLayout.RIGHT));
		thePanel = new JPanel(new GridLayout(1, 0, 5, 5));
		buttons = new ArrayList<JButton>();
		add(thePanel);
	}

	public JButton addButton(String label, ActionListener listener) {
		buttons.add((JButton) thePanel.add(new JButton(label)));
		buttons.get(buttons.size() - 1).addActionListener(listener);
		return buttons.get(buttons.size() - 1);
	}

	public void setStates(List<Boolean> states) {
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setEnabled(states.get(i));
		}
	}
}
