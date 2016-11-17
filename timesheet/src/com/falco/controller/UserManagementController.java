package com.falco.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;

import com.falco.constants.Const;
import com.falco.views.UserManagement;

public class UserManagementController implements ActionListener {

	private UserManagement sm;
	private String user;

	public UserManagementController(UserManagement sm) {
		this.sm = sm;
		initialize(sm);
	}

	private void initialize(UserManagement sm) {
		user = userpref().get(Const.USER_PREF, "");
		sm.getUserField().setText(user);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {

		int isDeleteOk = JOptionPane.showConfirmDialog(sm, "Delete " + user
				+ "?", "confirmation", JOptionPane.YES_NO_OPTION);

		if (isDeleteOk == JOptionPane.YES_OPTION) {
			userpref().remove(Const.USER_PREF);
			JOptionPane.showMessageDialog(sm,
					"User deleted new user must be declared on restart");
		}
	}

	public Preferences userpref() {
		return Preferences.userNodeForPackage(MainWindowController.class);
	}
}
