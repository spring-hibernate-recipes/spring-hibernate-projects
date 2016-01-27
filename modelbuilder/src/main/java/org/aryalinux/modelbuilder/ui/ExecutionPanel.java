package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JProgressBar;

import org.aryalinux.modelbuilder.model.Task;

@SuppressWarnings("serial")
public class ExecutionPanel extends GenericPanel {
	private JProgressBar progressBar;
	private List<Task> tasks;

	public ExecutionPanel() {
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		tasks = new ArrayList<Task>();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 0.9;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(progressBar, 0, 0, 1, 1);
	}

	public void progress(String message, int value) {
		progressBar.setString(message);
		progressBar.setValue(value);
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void doTasks() {
		try {
			for (int i = 0; i < tasks.size(); i++) {
				final Task task = tasks.get(i);
				Thread th = new Thread(new Runnable() {
					public void run() {
						progressBar.setString(task.getName());
						task.doTask();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						int n = calculate(tasks.indexOf(task));
						progressBar.setValue(n);
					}
				});
				th.start();
				th.join();
			}
			MainFrame.mainFrame.doFinish();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	private int calculate(int i) {
		if (i == tasks.size() - 1) {
			return 100;
		} else {
			double part = 100 / tasks.size() * i;
			return (int) part;
		}
	}
}
