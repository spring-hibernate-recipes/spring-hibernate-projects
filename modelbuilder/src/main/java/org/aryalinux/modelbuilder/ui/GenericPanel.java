package org.aryalinux.modelbuilder.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GenericPanel extends JPanel {
	protected GridBagConstraints gbc;
	private GridBagLayout gbl;

	public GenericPanel() {
		gbl = new GridBagLayout();
		gbc = new GridBagConstraints();
		setLayout(gbl);
	}

	public Component add(Component c, int x, int y, int w, int h) {
		if (c instanceof JLabel) {
			gbc.anchor = GridBagConstraints.EAST;
		} else {
			gbc.anchor = GridBagConstraints.WEST;
		}
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		add(c, gbc);
		return c;
	}
}
