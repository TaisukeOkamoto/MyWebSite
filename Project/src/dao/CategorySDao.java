package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class CategorySDao {

	public static String getsCategoryName(int sCategory) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT name FROM category_s WHERE id = ?");

			st.setInt(1, sCategory);

			ResultSet rs = st.executeQuery();

			String categorysName = null;
			while(rs.next()) {
				categorysName = rs.getString("name");
			}
			System.out.println("getting sCategoryName by sCategoryId has been completed");
			return categorysName;

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
