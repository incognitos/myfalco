package com.falco.views;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeMonitorPersonal  extends TimeMonitor implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeMonitorPersonal(){
		ctrl.populateGrid(false,getTimeTable());
		addRefreshListener(this);
	}
	@Override
	public Rectangle getTimeTableRecDim() {
		return new Rectangle(20, 20, 430, 40);//x,y,width,height
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		ctrl.populateGrid(false,getTimeTable());	
	}	
}
