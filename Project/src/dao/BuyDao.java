package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyInfoBeans;

/**
 * 購入情報登録処理
 * @param bdb 購入情報
 * @throws SQLException 呼び出し元にスローさせるため
 */
public class BuyDao {
	public static int insertBuy(BuyInfoBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_buy(user_id,total_price,delivery_method_id,buy_date) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getUserId());
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDeliveryMethodId());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

			return autoIncKey;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BuyInfoBeans
	 * 				購入情報のデータを持つJavaBeansのリスト
	 * @throws SQLException
	 * 				呼び出し元にスローさせるため
	 */
	public static BuyInfoBeans getBuyInfoBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM t_buy"
							+ " JOIN t_delivery_method"
							+ " ON t_buy.delivery_method_id = t_delivery_method.id"
							+ " WHERE t_buy.id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();

			BuyInfoBeans bib = new BuyInfoBeans();
			if (rs.next()) {
				bib.setId(rs.getInt("id"));
				bib.setTotalPrice(rs.getInt("total_price"));
				bib.setBuyDate(rs.getTimestamp("buy_date"));
				bib.setDeliveryMethodId(rs.getInt("delivery_method_id"));
				bib.setUserId(rs.getInt("user_id"));
				bib.setDeliveryPrice(rs.getInt("delivery_price"));
				bib.setDeliveryName(rs.getString("delivery_name"));
			}

			System.out.println("searching BuyInfoBeans by buyID has been completed");

			return bib;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	/**
	 * ユーザーIDから購入情報を取得
	 * @param userId
	 * 			ユーザーID
	 * @return ArrayList<BuyInfoBeans>
	 * @throws SQLException
	 */
	public static ArrayList<BuyInfoBeans> getPurchaseInfo(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT t_buy.id,total_price,buy_date,delivery_name,delivery_price" +
					" FROM t_buy" +
					" JOIN t_delivery_method" +
					" ON t_buy.delivery_method_id =  t_delivery_method.id" +
					" WHERE user_id = ?" +
					" ORDER BY buy_date DESC");

			st.setInt(1, userId);
			ResultSet rs = st.executeQuery();

			ArrayList<BuyInfoBeans> BuyDataList = new ArrayList<BuyInfoBeans>();

			while(rs.next()) {
				int id = rs.getInt("t_buy.id");
				int totalPrice = rs.getInt("total_price");
				String deliveryName = rs.getString("delivery_name");
				int deliveryPrice = rs.getInt("delivery_price");
				java.util.Date buyDate = rs.getTimestamp("buy_date");
				BuyInfoBeans bib = new BuyInfoBeans(id,totalPrice,deliveryName,deliveryPrice,buyDate);
				BuyDataList.add(bib);
			}

			return BuyDataList;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
