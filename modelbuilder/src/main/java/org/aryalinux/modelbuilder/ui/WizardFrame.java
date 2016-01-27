package org.aryalinux.modelbuilder.ui;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WizardFrame extends ExtendedFrame {
	private CardLayout cardLayout;
	private JPanel mainPanel;
	private ButtonPanel buttonPanel;
	private List<Screen> screens;
	private String current;

	public WizardFrame(String title) {
		super(title);
		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		buttonPanel = new ButtonPanel();
		screens = new ArrayList<Screen>();

		getContentPane().add(mainPanel, "Center");
		getContentPane().add(buttonPanel, "South");
	}

	protected void addScreen(Screen screen) {
		screens.add(screen);
		mainPanel.add(screen.getPanel(), screen.getName());
		current = screen.getName();
		show(current);
	}

	protected JButton addButton(String str, ActionListener al) {
		return buttonPanel.addButton(str, al);
	}

	protected void show(String screenName) {
		current = screenName;
		for (Screen screen : screens) {
			if (screen.getName().equals(screenName)) {
				cardLayout.show(mainPanel, screenName);
				buttonPanel.setStates(screen.getButtonStates());
				setTitle(screen.getTitle());
			}
		}
	}

	protected String nextScreen() {
		int currentIndex = -1;
		for (int i = 0; i < screens.size(); i++) {
			if (screens.get(i).getName().equals(current)) {
				currentIndex = i;
			}
		}
		if (currentIndex < screens.size() - 1) {
			show(screens.get(currentIndex + 1).getName());
		}
		return screens.get(currentIndex + 1).getName();
	}

	protected String previousScreen() {
		int currentIndex = -1;
		for (int i = 0; i < screens.size(); i++) {
			if (screens.get(i).getName().equals(current)) {
				currentIndex = i;
			}
		}
		if (currentIndex > 0) {
			show(screens.get(currentIndex - 1).getName());
		}
		return screens.get(currentIndex - 1).getName();
	}

	protected ButtonPanel getButtonPanel() {
		return buttonPanel;
	}
	
}
