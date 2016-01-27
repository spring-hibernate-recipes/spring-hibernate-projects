package org.aryalinux.modelbuilder.ui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SettingsDialog extends JDialog {
	private FileControl sampleProjectLocation;
	private FileControl mavenExecutable;
	private GenericPanel panel;
	private ButtonPanel buttonPanel;
	private Map<String, String> settings;

	public SettingsDialog(Window parent) {
		super(parent);
		setTitle("Model Builder Settings");
		setModal(true);
		panel = new GenericPanel();
		panel.gbc.anchor = GridBagConstraints.WEST;
		panel.gbc.weightx = 1.0;
		panel.gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.gbc.insets = new Insets(0, 5, 0, 5);
		panel.add(new JLabel("Scaffolding Project Location"), 0, 0, 1, 1);
		panel.add(sampleProjectLocation = new FileControl(panel), 0, 1, 1, 1);
		sampleProjectLocation.setDirectoriesOnly(true);
		panel.add(new JLabel("Maven Executable"), 0, 2, 1, 1);
		panel.add(mavenExecutable = new FileControl(panel), 0, 3, 1, 1);
		add(buttonPanel = new ButtonPanel(), "South");
		add(panel);
		buttonPanel.addButton("Ok", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				settings = new LinkedHashMap<String, String>();
				settings.put("sample.project.location", sampleProjectLocation.getPath());
				settings.put("maven.executable", mavenExecutable.getPath());
				dispose();
			}
		});
		buttonPanel.addButton("Cancel", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				settings = new LinkedHashMap<String, String>();
				System.exit(0);
			}
		});
	}

	public void showDialog() {
		pack();
		setSize(getHeight() * 2 + 150, getHeight());
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
		setVisible(true);
	}

	public Map<String, String> getSettings() {
		return settings;
	}

}
