package com.falco.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.falco.dao.SystemUserDao;
import com.falco.db.DBConnection;

public class SystemUserDaoImpl implements SystemUserDao {

	@Override
	public boolean isValidLeadPassword(String password) {

		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) as count from systemuser");
		sb.append(" where userid='LEADS'");
		sb.append(" and passwd=?");
		boolean isValidLeadPassword = false;
		isValidLeadPassword = isDataIsNotZero(password, sb);
		return isValidLeadPassword;
	}

	/**
	 * true if not zero select count sql (e.g. select count(*) as count from X)
	 * 
	 * @param parame
	 * @param sb
	 * @return
	 */
	private boolean isDataIsNotZero(String param, StringBuilder sb) {
		boolean isDataIsNotZero = false;
		try {
			DBConnection db=new DBConnection();
			db.getConnection();
			PreparedStatement pst = db.getConnection().prepareStatement(
					sb.toString());
			final int paramIndex = 1;
			pst.setString(paramIndex, param);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				isDataIsNotZero = !rs.getString("count").equals("0");
			}
			rs.close();
			pst.close();
			db.closeConnection();
		} catch (SQLException e) {
			// TO DO some handling here
			e.printStackTrace();
		}
		return isDataIsNotZero;
	}

	@Override
	public boolean isValidUserEntry(String user) {

		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) count");
		sb.append(" from carddb cdb ");
		sb.append(" where name=?");
		boolean isValidUserEntry = false;
		isValidUserEntry = isDataIsNotZero(user, sb);
		return isValidUserEntry;
	}

}
