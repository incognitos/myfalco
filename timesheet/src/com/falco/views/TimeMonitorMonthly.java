package com.falco.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeMonitorMonthly extends TimeMonitor implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeMonitorMonthly() {
		ctrl.populateGrid(true, getTimeTable());
		addRefreshListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ctrl.populateGrid(true, getTimeTable());
	}
}
