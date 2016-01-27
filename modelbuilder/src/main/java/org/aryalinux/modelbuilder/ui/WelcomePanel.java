package org.aryalinux.modelbuilder.ui;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WelcomePanel extends GenericPanel {

	public WelcomePanel() {
		add(new JLabel(
				"<html>Welcome to Model Builder.<br>In the screens that follow we would collect some information about the database for which you intend to build model classes.<br>Click `Next` to Proceed</html>"));
	}
}
