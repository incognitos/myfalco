package com.falco.views;

import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.falco.controller.TimeMonitorController;

public class TimeMonitor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton refreshBtn;

	private JTable timeTable;

	protected TimeMonitorController ctrl;

	private Rectangle timeTableRecDim = new Rectangle(20, 20, 430, 150);// x,y,width,height

	public TimeMonitor() {
		initialize();
	}

	private void initialize() {
		setLayout(null);
		ctrl = new TimeMonitorController();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(getTimeTableRecDim());
		add(scrollPane);

		timeTable = new JTable();

		scrollPane.setViewportView(timeTable);
		refreshBtn = new JButton("Refresh");
		add(refreshBtn);
		refreshBtn.setBounds(200, 170, 100, 30);
	}

	protected Rectangle getTimeTableRecDim() {
		return timeTableRecDim;
	}

	protected void setTimeTableRecDim(Rectangle timeTableRecDim) {
		this.timeTableRecDim = timeTableRecDim;
	}

	protected void addRefreshListener(ActionListener action) {
		refreshBtn.addActionListener(action);
	}

	protected JTable getTimeTable() {
		return timeTable;
	}

}
