package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;

public class UserDao {
//	ユーザIDを取得
	public static int getUserId(String mail,String password) {
		Connection conn = null;
		PreparedStatement pStmt = null;

		try {
			conn = DBManager.getConnection();
			pStmt = conn.prepareStatement("SELECT * FROM user_info WHERE mail = ?");
			pStmt.setString(1, mail);

			ResultSet rs = pStmt.executeQuery();

			int userId = 0;
			while(rs.next()) {
				if(password.equals(rs.getString("password"))) {
					userId = rs.getInt("id");
					System.out.println("login succeeded");
					break;
				}
			}

			System.out.println("searching userId by loginId has been completed");
			return userId;

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return 0;
	}
}
