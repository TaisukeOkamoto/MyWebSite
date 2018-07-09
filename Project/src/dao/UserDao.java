package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

//	新規会員登録
	public static void setUserInfo(String familyName,String firstName,int address,String prefecture,String city,String street,int phoneNumber,Date birthDate,String mail,String gender,String password) {
		Connection conn = null;
		PreparedStatement pStmt = null;


		try {
			conn = DBManager.getConnection();
			pStmt = conn.prepareStatement(
					"INSERT INTO user_info("
					+"family_name,first_name,address,prefecture,city,"
					+"street,phone_number,birth_date,mail,gender,"
					+"password,user_create_date,user_update_date,user_point)"
					+"values(familyName,firstName,address,prefecture,city,street,phoneNumber,?,mail,gender,password,Now(),Now(),0)");

			Date birthDateUtil = birthDate;
			java.sql.Date birthDateSql = new java.sql.Date(birthDateUtil.getTime());

			pStmt.setDate(1, birthDateSql);

			pStmt.executeUpdate();

			System.out.println("Inserting userInfo has been completed");

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
	}

}
