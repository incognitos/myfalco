package com.falco.dao;

public interface TimelogDao {
	String[][] getTimeLogs(String name,boolean isMonthly);
}
