package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class CategoryLDao {

	/**
	 * 大カテゴリーIDから大カテゴリー名を取得する
	 * @param lCategory
	 * @return String
	 * @throws SQLException
	 */
	public static String getlCategoryName(int lCategory) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT name FROM category_l WHERE id = ?");

			st.setInt(1, lCategory);

			ResultSet rs = st.executeQuery();

			String categorylName = null;
			while(rs.next()) {
				categorylName = rs.getString("name");
			}
			System.out.println("getting lCategoryName by lCategoryId has been completed");
			return categorylName;

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
