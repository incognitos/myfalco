package com.falco.controller;

import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.falco.constants.Const;
import com.falco.dao.SystemUserDao;
import com.falco.dao.impl.SystemUserDaoImpl;

public class MainWindowController {

	private Preferences userpref;
	private SystemUserDao dao = new SystemUserDaoImpl();

	/**
	 * Prompt for user/lead password info on first load
	 * 
	 */
	public void sessionSetting(JFrame mainFrame) {
		userpref = Preferences.userNodeForPackage(MainWindowController.class);
		String activeUser = userpref.get(Const.USER_PREF, "");
		if (activeUser == null || activeUser.equals("")) {
			activeUser = JOptionPane.showInputDialog("Initalize user Name", "");
		}
		if (activeUser == null || activeUser.equals("")) {
			JOptionPane.showMessageDialog(mainFrame, "User must be declared!");
			mainFrame.dispatchEvent(new WindowEvent(mainFrame,
					WindowEvent.WINDOW_CLOSING));
		} else if (!dao.isValidUserEntry(activeUser)) {
			JOptionPane.showMessageDialog(mainFrame, "User not found in DB!");
			mainFrame.dispatchEvent(new WindowEvent(mainFrame,
					WindowEvent.WINDOW_CLOSING));
		} else {
			userpref.put(Const.USER_PREF, activeUser);
		}
	}
}
