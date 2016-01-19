package org.aryalinux.projectbuilder;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class GenericDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private GridBagLayout gbl;

	public GenericDialog(Window parent, String title) {
		super(parent);
		setTitle(title);
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
