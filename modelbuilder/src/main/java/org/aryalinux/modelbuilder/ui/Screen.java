package org.aryalinux.modelbuilder.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class Screen {
	private JPanel panel;
	private String name;
	private List<Boolean> buttonStates;

	public Screen(JPanel panel, String name, Boolean... states) {
		this.panel = panel;
		this.name = name;
		this.buttonStates = new ArrayList<Boolean>();
		Collections.addAll(buttonStates, states);
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Boolean> getButtonStates() {
		return buttonStates;
	}

	public void setButtonStates(List<Boolean> buttonStates) {
		this.buttonStates = buttonStates;
	}

}
