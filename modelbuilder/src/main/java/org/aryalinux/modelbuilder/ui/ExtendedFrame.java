package org.aryalinux.modelbuilder.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ExtendedFrame extends JFrame {
	public ExtendedFrame(String title) {
		super(title);
	}

	public void center(int w, int h) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		setBounds((dimension.width - w) / 2, (dimension.height - h) / 2, w, h);
		setVisible(true);
	}
}
