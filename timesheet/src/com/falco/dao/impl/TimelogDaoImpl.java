package com.falco.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.falco.dao.TimelogDao;
import com.falco.db.DBConnection;
import com.falco.model.TimeLog;

/**
 * DOCUMENT ME!
 * 
 * @version $Revision$, $Date$
 */
public class TimelogDaoImpl implements TimelogDao {
	// ~ Methods ----------------------------------
	/** @see com.falco.dao.TimelogDao#getTimeLogs(java.lang.String, boolean) */
	@Override
	public String[][] getTimeLogs(String name, boolean isMonthly) {
		List<TimeLog> logs = new ArrayList<TimeLog>();

		StringBuilder sb = new StringBuilder();

		sb.append(" SELECT DISTINCT trdate                     AS date,");
		sb.append("                 cardno,");
		sb.append("                 trname,");
		sb.append("                 (SELECT Min(trtime)");
		sb.append("                  FROM   tbltransaction");
		sb.append("                  WHERE  cardno = txn.cardno");
		sb.append("                         AND CONVERT(VARCHAR, trdate, 112) =");
		sb.append("                             CONVERT(VARCHAR, txn.trdate, 112)");
		sb.append("                         AND trcode = 'C0') timein,");
		sb.append("                 (SELECT Max(trtime)");
		sb.append("                  FROM   tbltransaction");
		sb.append("                  WHERE  cardno = txn.cardno");
		sb.append("                         AND CONVERT(VARCHAR, trdate, 112) =");
		sb.append("                             CONVERT(VARCHAR, txn.trdate, 112)");
		sb.append("                         AND trcode = 'CI') timeout");
		sb.append(" FROM   tbltransaction txn");
		sb.append(" WHERE  trname = ?");
		if (!isMonthly) {
			sb.append("        AND trdate>getDate()-1 ");
		} else {
			sb.append("        AND Datename(month, trdate) = Datename(month, DATEADD(month,-1,Getdate()))");
		}
		sb.append("        AND Datename(year, trdate) = Datename(year, Getdate()) order by trdate");

		try {
			DBConnection db = new DBConnection();
			PreparedStatement pst = db.getConnection().prepareStatement(
					sb.toString());

			final int nameIndex = 1;
			pst.setString(nameIndex, name);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				TimeLog log = new TimeLog();

				log.setDate(rs.getString("date"));
				log.setCardId(rs.getString("cardno"));
				log.setName(rs.getString("trname"));
				log.setTimeIn(rs.getString("timein"));
				log.setTimeOut(rs.getString("timeout"));

				logs.add(log);
			}
			rs.close();
			pst.close();
			db.closeConnection();
		} catch (SQLException e) {
			// TO DO some handling here
			e.printStackTrace();
		}
		String[][] logArray = new String[logs.size()][5];
		for (int i = 0; i < logs.size(); i++) {
			logArray[i][0] = logs.get(i).getDate();
			logArray[i][1] = logs.get(i).getCardId();
			logArray[i][2] = logs.get(i).getName();
			logArray[i][3] = logs.get(i).getTimeIn();
			logArray[i][4] = logs.get(i).getTimeOut();
		}

		return logArray;
	}
}
