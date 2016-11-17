package com.falco.controller;

import java.util.prefs.Preferences;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.falco.constants.Const;
import com.falco.dao.TimelogDao;
import com.falco.dao.impl.TimelogDaoImpl;

public class TimeMonitorController {
	public void populateGrid(boolean isMonthLy, JTable timeTable) {
		TimelogDao dao = new TimelogDaoImpl();
		String user = userpref().get(Const.USER_PREF, "");
		String[][] logs = dao.getTimeLogs(user,isMonthLy);
		timeTable.setModel(new DefaultTableModel(logs, new String[] { "Date",
				"CardId", "Name", "Time in", "Time out" }));
	}

	private Preferences userpref() {
		return Preferences.userNodeForPackage(MainWindowController.class);
	}
}
