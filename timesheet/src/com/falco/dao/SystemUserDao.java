package com.falco.dao;

public interface SystemUserDao {
	boolean isValidLeadPassword(String password);
	boolean isValidUserEntry(String user);
}
