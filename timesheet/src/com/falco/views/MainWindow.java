package com.falco.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.falco.controller.MainWindowController;

public class MainWindow {

	private JFrame mainFrame;
	private MainWindowController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initializeMainFrame();
		sessionSetting(mainFrame);
		initializeTabbedPane();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeMainFrame() {

		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 490, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the tabs
	 */
	private void initializeTabbedPane() {
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); 
		mainFrame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
	
		tabbedPane
				.addTab("In/Out Today", null, new TimeMonitorPersonal(), null); 

		tabbedPane.addTab("In/Out Last Month", null, new TimeMonitorMonthly(),
				null); 
		
		tabbedPane.addTab("User Setting", null, new UserManagement(), null);
	}

	/**
	 * Prompt for user info on first load
	 * 
	 */
	private void sessionSetting(JFrame mainFrame) {
		controller = new MainWindowController();
		controller.sessionSetting(mainFrame);
	}
}
