package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBManager;
import beans.ItemInfoBeans;

public class ItemDao {

	/**
	 * 商品情報を登録
	 * @param itemName
	 * 			商品名
	 * @param itemDetail
	 * 			商品の説明
	 * @param priceWithTax
	 * 			商品の税込価格
	 * @param fileName
	 * 			商品のファイル名
	 * @param categoryId
	 * 			商品のカテゴリーID
	 * @param rate
	 * 			商品の割引率
	 */
	public static void setItemInfo(String itemName,String itemDetail,int priceWithTax,String fileName,int categoryId,int rate) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO item("
					+"item_name,item_detail,price_with_tax,file_name,"
					+"category_id,item_create_date,item_update_date,rate)"
					+"values(?,?,?,?,?,Now(),Now(),?)");

			st.setString(1, itemName);
			st.setString(2, itemDetail);
			st.setInt(3, priceWithTax);
			st.setString(4, fileName);
			st.setInt(5, categoryId);
			st.setInt(6, rate);

			st.executeUpdate();

			System.out.println("Inserting itemInfo has been completed");

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
	 * 商品情報と商品インスタンスから商品情報を更新
	 * @param id
	 * 			商品ID
	 * @param item
	 * 			ItemInfoBeans
	 * @throws SQLException
	 */
	public static void updateItemInfoBeansByItemId(int id,ItemInfoBeans item) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("UPDATE item" +
					" SET item_name = ?," +
					" item_detail = ?," +
					" price_with_tax = ?," +
					" file_name = ?," +
					" category_id = ?," +
					" item_update_date = Now()," +
					" rate = ?" +
					" WHERE id = ?");

			st.setString(1, item.getItemName());
			st.setString(2, item.getItemDetail());
			st.setInt(3, item.getPriceWithTax());
			st.setString(4, item.getFileName());
			st.setInt(5, item.getCategoryId());
			st.setInt(6, item.getRate());
			st.setInt(7, id);

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

		System.out.println("Update ItemInfoBeans by Item and Id has been completed");
	}

	/**
	 * 商品IDから商品情報を取得する
	 * @param id
	 * 		商品ID
	 * @return ItemInfoBeans
	 * @throws SQLException
	 */
	public static ItemInfoBeans getItemrInfoBeansByItemId(int id) throws SQLException {
		ItemInfoBeans item = new ItemInfoBeans();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item WHERE id = ?");

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
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

		System.out.println("searching ItemInfoBeans by Id has been completed");
		return item;
	}

	/**
	 *	全商品情報を取得
	 * @return ItemInfoBeans
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getAllItemList() throws SQLException {
		ArrayList<ItemInfoBeans> allItemList = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				allItemList.add(item);
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

		System.out.println("getting allItemList has been completed");
		return allItemList;
	}

	/**
	 * 割引商品を全て取得
	 * @return discountItemList
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getDiscountItem() throws SQLException {
		ArrayList<ItemInfoBeans> discountItemList = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item WHERE rate <> 0");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				discountItemList.add(item);
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

		System.out.println("getting discountItemList has been completed");
		return discountItemList;
	}

	/**
	 *	最新商品情報を取得
	 * @return ItemInfoBeans
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getLatestItemList() throws SQLException {
		ArrayList<ItemInfoBeans> latestItemList = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item ORDER BY item_update_date DESC");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				latestItemList.add(item);
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

		System.out.println("getting latestItemList has been completed");
		return latestItemList;
	}


	/**商品IDから商品情報を削除
	 * @param id
	 * 			商品ID
	 * @throws SQLException
	 */
	public static void deleteItemInfoBeansByItemId(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("DELETE FROM item WHERE id = ?");

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

		System.out.println("Delete ItemInfoBeans by Id has been completed");
	}
}
