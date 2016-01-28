package org.aryalinux.modelbuilder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import org.aryalinux.modelbuilder.model.Task;
import org.aryalinux.modelbuilder.task.CopyPOMTask;
import org.aryalinux.modelbuilder.task.MavenProjectCreationTask;
import org.aryalinux.modelbuilder.task.ModelClassGenerationTask;
import org.aryalinux.modelbuilder.task.ProjectPreparationTask;

@SuppressWarnings("serial")
public class MainFrame extends WizardFrame implements ActionListener {
	private DBPropertiesPanel dbPropertiesPanel;
	private TablesPanel tablesPanel;
	private String currentScreen;
	private TablePropertiesPanel tablePropertiesPanel;
	private ProjectPropertiesPanel projectPropertiesPanel;
	private ExecutionPanel executionPanel;
	public static MainFrame mainFrame;
	public static Map<String, String> settings;

	public MainFrame() {
		super("Model Builder");
		center(1000, 500);
		addButtons();
		addScreens();
		validate();
		repaint();
		mainFrame = this;
	}

	private void addScreens() {
		WelcomePanel panel = new WelcomePanel();
		Screen screen = new Screen(panel, "welcome", "Welcome to Model Builder", false, true, false, true);
		addScreen(screen);

		dbPropertiesPanel = new DBPropertiesPanel();
		Screen screen1 = new Screen(dbPropertiesPanel, "dbProperties",
				"Please specify the details to connect to database", true, true, false, true);
		addScreen(screen1);

		tablesPanel = new TablesPanel();
		Screen screen2 = new Screen(tablesPanel, "tables", "Remove the tables you do not want in the result.", true,
				true, false, true);
		addScreen(screen2);

		tablePropertiesPanel = new TablePropertiesPanel();
		Screen screen3 = new Screen(tablePropertiesPanel, "tableProperties", "Review the table details and proceed.",
				true, true, false, true);
		addScreen(screen3);

		projectPropertiesPanel = new ProjectPropertiesPanel();
		Screen screen4 = new Screen(projectPropertiesPanel, "projectProperties",
				"Specify the details about the Maven webapp that would be generated.", true, false, true, true);
		addScreen(screen4);

		executionPanel = new ExecutionPanel();
		Screen screen5 = new Screen(executionPanel, "executionPanel", "Generating Maven Project.", false, false, false,
				false);
		addScreen(screen5);

		currentScreen = "welcome";
		show(currentScreen);
	}

	private void addButtons() {
		addButton("Previous", this);
		addButton("Next", this);
		addButton("Finish", this);
		addButton("Cancel", this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Next")) {
			currentScreen = nextScreen();
		} else if (e.getActionCommand().equals("Previous")) {
			currentScreen = previousScreen();
		}
		if (currentScreen.equals("tables")) {
			if (tablesPanel.getDatabaseProperties() == null) {
				tablesPanel.setDatabaseProperties(dbPropertiesPanel.getDatabaseProperties());
			}
		}
		if (currentScreen.equals("tableProperties")) {
			if (tablePropertiesPanel.getDatabaseProperties() == null) {
				tablePropertiesPanel.setDatabaseProperties(dbPropertiesPanel.getDatabaseProperties());
				tablePropertiesPanel.setTables(tablesPanel.getTables());
			}
		}
		if (currentScreen.equals("projectProperties")) {
			if (projectPropertiesPanel.getDatabaseProperties() == null) {
				projectPropertiesPanel.setDatabaseProperties(dbPropertiesPanel.getDatabaseProperties());
				projectPropertiesPanel.setTableProperties(tablePropertiesPanel.getTableProperties());
			}
		}
		if (e.getActionCommand().equals("Finish")) {
			show("executionPanel");
			try {
				Thread th = new Thread(new Runnable() {
					public void run() {
						Task task = new MavenProjectCreationTask();
						task.setData(projectPropertiesPanel.getProjectProperties());
						executionPanel.getTasks().add(task);

						Task task1 = new CopyPOMTask();
						task1.setData(projectPropertiesPanel.getProjectProperties());
						executionPanel.getTasks().add(task1);

						ProjectPreparationTask task2 = new ProjectPreparationTask();
						task2.setData(projectPropertiesPanel.getProjectProperties());
						task2.setDatabaseProperties(dbPropertiesPanel.getDatabaseProperties());
						executionPanel.getTasks().add(task2);

						ModelClassGenerationTask task3 = new ModelClassGenerationTask();
						task3.setData(tablePropertiesPanel.getTableProperties());
						task3.setProjectProperties(projectPropertiesPanel.getProjectProperties());
						executionPanel.getTasks().add(task3);

						executionPanel.doTasks();

					}
				});
				th.start();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
		if (e.getActionCommand().equals("Cancel")) {
			System.exit(0);
		}
	}

	public void doFinish() {
		getButtonPanel().removeButton("Previous");
		getButtonPanel().removeButton("Next");
		getButtonPanel().removeButton("Finish");
		getButtonPanel().removeButton("Cancel");
		getButtonPanel().addButton("Exit", new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		validate();
		repaint();
	}
}
