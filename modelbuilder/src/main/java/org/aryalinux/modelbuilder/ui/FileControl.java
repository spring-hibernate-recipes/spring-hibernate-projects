package org.aryalinux.modelbuilder.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FileControl extends JPanel implements ActionListener {
	private JTextField location;
	private JButton browse;
	private boolean directoriesOnly;
	private Component parent;

	public FileControl(Component parent) {
		this.parent = parent;
		location = new JTextField();
		browse = new JButton("Browse");
		browse.addActionListener(this);
		setLayout(new BorderLayout());
		add(location);
		add(browse, "East");
	}

	public boolean isDirectoriesOnly() {
		return directoriesOnly;
	}

	public void setDirectoriesOnly(boolean directoriesOnly) {
		this.directoriesOnly = directoriesOnly;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		if (isDirectoriesOnly()) {
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		if (chooser.showDialog(parent, "Select") == JFileChooser.APPROVE_OPTION) {
			location.setText(chooser.getSelectedFile().getAbsolutePath());
		}
	}

	public String getPath() {
		return location.getText();
	}
}
