package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import base.DBManager;
import beans.UserInfoBeans;
import ec.ECHelper;

public class UserDao {



	/**
	 * ユーザーIDを取得
	 * @param mail
	 * 			メールアドレス
	 * @param password
	 * 			パスワード
	 * @return int ログインIDとパスワードが正しい場合対象のユーザーID 正しくない||登録されていない場合0
	 *
	 */
	public static int getUserId(String mail,String password) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM user_info WHERE mail = ?");
			st.setString(1, mail);

			ResultSet rs = st.executeQuery();

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

	/**
	 * 新規会員登録
	 * @param familyName
	 * 			姓
	 * @param firstName
	 * 			名
	 * @param address
	 * 			郵便番号
	 * @param prefecture
	 * 			県
	 * @param city
	 * 			市区町村
	 * @param street
	 * 			町名番地
	 * @param phoneNumber
	 * 			電話番号
	 * @param birthDate
	 * 			誕生日
	 * @param mail
	 * 			メールアドレス
	 * @param gender
	 * 			性別
	 * @param password
	 * 			パスワード
	 */
	public static void setUserInfo(String familyName,String firstName,int address,String prefecture,String city,String street,int phoneNumber,Date birthDate,String mail,String gender,String password) {
		Connection conn = null;
		PreparedStatement st = null;


		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO user_info("
					+"family_name,first_name,address,prefecture,city,"
					+"street,phone_number,birth_date,mail,gender,"
					+"password,user_create_date,user_update_date,user_point)"
					+"values(?,?,?,?,?,?,?,?,?,?,?,Now(),Now(),0)");

			st.setString(1, familyName);
			st.setString(2, firstName);
			st.setInt(3, address);
			st.setString(4, prefecture);
			st.setString(5, city);
			st.setString(6, street);
			st.setInt(7, phoneNumber);

			Date birthDateUtil = birthDate;
			java.sql.Date birthDateSql = new java.sql.Date(birthDateUtil.getTime());
			st.setDate(8, birthDateSql);

			st.setString(9, mail);
			st.setString(10, gender);
			st.setString(11, ECHelper.convertEncryption(password));

			st.executeUpdate();

			System.out.println("Setting userInfo has been completed");

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

	/**
	 * メールアドレスの重複をチェック
	 * @param mail
	 * 			check対象のメールアドレス
	 * @return	bool
	 * @throws SQLException
	 */
	public static boolean isOverlapMail(String mail) throws SQLException {
		boolean isOverlap = false;
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();
			// 入力されたmailが存在するか調べる
			st = conn.prepareStatement("SELECT id FROM user_info WHERE mail = ?");
			st.setString(1, mail);
			ResultSet rs = st.executeQuery();

			System.out.println("searching id by mail has been completed");

			if (rs.next()) {
				isOverlap = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		System.out.println("overlap check has been completed");
		return isOverlap;

	}

	/**
	 * 管理者を除く全てのユーザーをリスト形式で保存
	 * @return <UserInfoBeans>
	 */
	public static ArrayList<UserInfoBeans> getAllUserList() {

		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();

			st = conn.prepareStatement("SELECT * FROM user_info WHERE id != 1");

			ResultSet rs = st.executeQuery();

			ArrayList<UserInfoBeans> userList = new ArrayList<UserInfoBeans>();

			while(rs.next()) {
				UserInfoBeans user = new UserInfoBeans();
				user.setId(rs.getInt("id"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setAddress(rs.getInt("address"));
				user.setPrefecture(rs.getString("prefecture"));
				user.setCity(rs.getString("city"));
				user.setStreet(rs.getString("street"));
				user.setPhoneNumber(rs.getInt("phone_number"));
				user.setBirthDate(rs.getDate("birth_date"));
				user.setMail(rs.getString("mail"));
				user.setGender(rs.getString("gender"));
				user.setPassword(rs.getString("password"));
				user.setUserCreateDate(rs.getTimestamp("user_create_date"));
				user.setUserUpdateDate(rs.getTimestamp("user_update_date"));
				user.setUserPoint(rs.getInt("user_point"));
				userList.add(user);
			}

			System.out.println("getAllUser has been completed");

			return userList;

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
		return null;
	}


	/**
	 * ユーザーIDからユーザーを取得
	 * @param Id
	 * 		ユーザーID
	 * @return UserInfoBeans
	 * @throws SQLException
	 */
	public static UserInfoBeans getUserInfoBeansByUserId(int id) throws SQLException {
		UserInfoBeans user = new UserInfoBeans();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM user_info WHERE id = ?");

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setFamilyName(rs.getString("family_name"));
				user.setFirstName(rs.getString("first_name"));
				user.setAddress(rs.getInt("address"));
				user.setPrefecture(rs.getString("prefecture"));
				user.setCity(rs.getString("city"));
				user.setStreet(rs.getString("street"));
				user.setPhoneNumber(rs.getInt("phone_number"));
				Date BirthDate = rs.getDate("birth_date");
				user.setBirthDate(BirthDate);
				//誕生日を年、月、日にわける
				SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
				String year = sdfYear.format(BirthDate.getTime());
				SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
				String month = sdfMonth.format(BirthDate.getTime());
				SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
				String day = sdfDay.format(BirthDate.getTime());
				user.setBirthYear(year);
				user.setBirthMonth(month);
				user.setBirthDay(day);
				user.setMail(rs.getString("mail"));
				user.setGender(rs.getString("gender"));
				user.setPassword(rs.getString("password"));
				user.setUserCreateDate(rs.getTimestamp("user_create_date"));
				user.setUserUpdateDate(rs.getTimestamp("user_update_date"));
				user.setUserPoint(rs.getInt("user_point"));
			}

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		System.out.println("searching UserInfoBeans by Id has been completed");
		return user;
	}


	/**
	 * ユーザー情報とユーザーインスタンスからユーザー情報を更新
	 * @param id
	 * 		ユーザーID
	 * @param user
	 * 		UserInfoBeans
	 * @throws SQLException
	 */
	public static void updateUserInfoBeansByUserId(int id,UserInfoBeans user) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("UPDATE user_info" +
					" SET family_name = ?," +
					" first_name = ?," +
					" address = ?," +
					" prefecture = ?," +
					" city = ?," +
					" street = ?," +
					" phone_number = ?," +
					" birth_date = ?," +
					" mail = ?," +
					" gender = ?," +
					" password = ?," +
					" user_update_date = Now()" +
					" WHERE id = ?");

			st.setString(1, user.getFamilyName());
			st.setString(2, user.getFirstName());
			st.setInt(3, user.getAddress());
			st.setString(4, user.getPrefecture());
			st.setString(5, user.getCity());
			st.setString(6, user.getStreet());
			st.setInt(7, user.getPhoneNumber());
			//年、月、日を結合してsql型のyyyy/MM/dd形式に変換
			java.sql.Date BirthDate = ECHelper.CovertSqlDateYMD(user.getBirthYear(), user.getBirthMonth(), user.getBirthDay());
			st.setDate(8, BirthDate);
			st.setString(9, user.getMail());
			st.setString(10, user.getGender());
			st.setString(11, ECHelper.convertEncryption(user.getPassword()));
			st.setInt(12, id);

			st.executeUpdate();

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		System.out.println("Update UserInfoBeans by User and Id has been completed");
	}

	/**
	 * ユーザーIDからユーザー情報を削除
	 * @param id
	 * 			ユーザーID
	 * @throws SQLException
	 */
	public static void deleteUserInfoBeansByUserId(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("DELETE FROM user_info WHERE id = ?");

			st.setInt(1, id);
			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		System.out.println("Delete UserInfoBeans by Id has been completed");
	}


	/**
	 * ユーザーにポイントを付与する
	 * @param userPoint
	 * 			ポイント
	 * @param userId
	 * 			ユーザーID
	 * @throws SQLException
	 */
	public static void setPointUserInfoBeans(int userPoint,int userId) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("UPDATE user_info" +
					" SET user_point = user_point + ? WHERE id = ?");

			st.setInt(1, userPoint);
			st.setInt(2, userId);

			st.executeUpdate();

			st.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

		System.out.println("Setting PointUserInfoBeans has been completed");
	}

}
