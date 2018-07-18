package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.BuyDetailInfoBeans;
import beans.ItemInfoBeans;

public class BuyDetailDao {

	/**
	 * 購入詳細登録処理
	 * @param bdIb BuyDetailInfoBeans
	 * @throws SQLException
	 */
	public static void insertBuyDetail(BuyDetailInfoBeans bdib) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO t_buy_detail(buy_id,item_id,buy_howmany) VALUES(?,?,?)");
			st.setInt(1, bdib.getBuyId());
			st.setInt(2, bdib.getItemId());
			st.setInt(3, bdib.getBuyHowmany());
			st.executeUpdate();
			System.out.println("inserting BuyDetail has been completed");

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
	 * @return {BuyDataDetailBeans}
	 * @throws SQLException
	 */
	public static ArrayList<BuyDetailInfoBeans> getBuyInfoBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM t_buy_detail WHERE buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<BuyDetailInfoBeans> buyDetailList = new ArrayList<BuyDetailInfoBeans>();

			while (rs.next()) {
				BuyDetailInfoBeans bddb = new BuyDetailInfoBeans();
				bddb.setId(rs.getInt("id"));
				bddb.setBuyId(rs.getInt("buy_id"));
				bddb.setItemId(rs.getInt("item_id"));
				bddb.setBuyHowmany(rs.getInt("buy_howmany"));
				buyDetailList.add(bddb);
			}

			System.out.println("searching BuyInfoBeansList by BuyID has been completed");
			return buyDetailList;
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
     * 購入IDによる購入詳細情報検索
     * @param buyId
     * @return buyDetailItemList ArrayList<ItemDataBeans>
     *             購入詳細情報のデータを持つJavaBeansのリスト
     * @throws SQLException
     */
	public static ArrayList<ItemInfoBeans> getItemInfoBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT item.id,"
					+ " item.item_name,"
					+ " item.price_with_tax,"
					+ " item.rate,"
					+ " buy_howmany"
					+ " FROM t_buy_detail"
					+ " JOIN item"
					+ " ON t_buy_detail.item_id = item.id"
					+ " WHERE t_buy_detail.buy_id = ?");
			st.setInt(1, buyId);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemInfoBeans> buyDetailItemList = new ArrayList<ItemInfoBeans>();

			while (rs.next()) {
				ItemInfoBeans iib = new ItemInfoBeans();
				iib.setId(rs.getInt("id"));
				iib.setItemName(rs.getString("item_name"));
				iib.setPriceWithTax(rs.getInt("price_with_tax"));
				iib.setRate(rs.getInt("rate"));
				iib.setAmount(rs.getInt("buy_howmany"));

				buyDetailItemList.add(iib);
			}

			System.out.println("searching ItemInfoBeansList by BuyID has been completed");
			return buyDetailItemList;
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
