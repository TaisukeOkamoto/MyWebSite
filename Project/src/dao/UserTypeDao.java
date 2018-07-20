package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class UserTypeDao {

	/**
	 * ユーザー種別IDからユーザー種別名を取得する
	 * @param id
	 * @return String
	 * @throws SQLException
	 */
	public static String getUsertypeNameById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT type FROM user_type WHERE id = ?");

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			String userTypeName = null;

			while(rs.next()) {
				userTypeName = rs.getString("type");
			}
			System.out.println("getting userTypeName by Id has been completed");
			return userTypeName;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
