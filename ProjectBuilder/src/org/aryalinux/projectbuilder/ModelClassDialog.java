package org.aryalinux.projectbuilder;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModelClassDialog extends GenericDialog implements ActionListener {
	private JTextField name;
	private JTextField de;
	private JButton ok, cancel;
	private JPanel okCancelPanel;
	private ModelClass modelClass;

	public ModelClassDialog(Window parent) {
		super(parent, "Entity");

		okCancelPanel = new JPanel(new GridLayout(1, 2));
		okCancelPanel.add(ok = new JButton("Ok"));
		okCancelPanel.add(cancel = new JButton("Cancel"));

		ok.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if (actionEvent.getSource() == ok) {

		} else {

		}
		this.dispose();
	}

	public ModelClass getModelClass() {
		return modelClass;
	}

	public void setModelClass(ModelClass modelClass) {
		this.modelClass = modelClass;
	}

}
