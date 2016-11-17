package com.falco.views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.falco.controller.UserManagementController;

public class UserManagement extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField userField;

	public UserManagement() {
		initialize();
	}

	private void initialize() {
		setLayout(null); 
		userField = new JTextField();
		userField.setBounds(120, 50, 220, 20);
		add(userField);
		userField.setColumns(10);

		JButton btnDeleteUserInfo = new JButton("delete");
		btnDeleteUserInfo.addActionListener(new UserManagementController(this));
		btnDeleteUserInfo.setBounds(180, 80, 115, 20);
		add(btnDeleteUserInfo);
	}

	public JTextField getUserField() {
		return userField;
	}
}
