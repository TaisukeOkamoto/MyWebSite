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
	public static void setItemInfo(String itemName,String itemDetail,int priceWithTax,String fileName,int sCategory,int userType,int rate) {
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO item("
					+"item_name,item_detail,price_with_tax,file_name,"
					+"category_id,user_type,item_create_date,item_update_date,rate)"
					+"values(?,?,?,?,?,?,Now(),Now(),?)");

			st.setString(1, itemName);
			st.setString(2, itemDetail);
			st.setInt(3, priceWithTax);
			st.setString(4, fileName);
			st.setInt(5, sCategory);
			st.setInt(6, userType);
			st.setInt(7, rate);

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
					" user_type = ?," +
					" item_update_date = Now()," +
					" rate = ?" +
					" WHERE id = ?");

			st.setString(1, item.getItemName());
			st.setString(2, item.getItemDetail());
			st.setInt(3, item.getPriceWithTax());
			st.setString(4, item.getFileName());
			st.setInt(5, item.getsCategory());
			st.setInt(6, item.getUserType());
			st.setInt(7, item.getRate());
			st.setInt(8, id);

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
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
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
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
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
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
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
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
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

	/**
	 *	商品のキーワード検索結果を取得
	 * @return ItemInfoBeans
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getKeywordSearchItemList(String keyword) throws SQLException {
		ArrayList<ItemInfoBeans> KeywordSearchItemList = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item WHERE item_name LIKE ?");

			st.setString(1, "%" + keyword + "%");

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				KeywordSearchItemList.add(item);
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
		return KeywordSearchItemList;
	}


	/**
	 * 小カテゴリーIDから大カテゴリーIDを取得する
	 * @param sCategory
	 * @return
	 * @throws SQLException
	 */
	public static int getlCategoryBysCategory(int sCategory) throws SQLException {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT category_l FROM category_s WHERE id = ?");

			st.setInt(1, sCategory);

			ResultSet rs = st.executeQuery();

			int category_l = 0;
			while(rs.next()) {
				category_l = rs.getInt("category_l");
			}
			System.out.println("getting lCategory by sCategory has been completed");
			return category_l;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * ユーザー種別から商品を取得
	 * @param userType
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getCategoryItemList1(int userType) throws SQLException {
		ArrayList<ItemInfoBeans> getCategoryItemList1 = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item"
					+ " WHERE item.user_type = ?");

			st.setInt(1,userType);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				getCategoryItemList1.add(item);
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

		System.out.println("getting CategoryItemList1 has been completed");
		return getCategoryItemList1;
	}

	/**
	 * ユーザー種別、大カテゴリーIDから商品を取得
	 * @param userType
	 * @param sCategory
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getCategoryItemList2(int userType,int lCategory) throws SQLException {
		ArrayList<ItemInfoBeans> getCategoryItemList2 = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item"
					+ " JOIN category_s"
					+ " ON item.category_id = category_s.id"
					+ " JOIN category_l"
					+ " ON category_s.category_l = category_l.id"
					+ " WHERE item.user_type = ?"
					+ " AND category_l.id = ?");

			st.setInt(1,userType);
			st.setInt(2,lCategory);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				getCategoryItemList2.add(item);
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

		System.out.println("getting CategoryItemList2 has been completed");
		return getCategoryItemList2;
	}

	/**
	 * ユーザー種別、大カテゴリーID、小カテゴリーIDから商品を取得
	 * @param userType
	 * @param lCategory
	 * @param sCategory
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<ItemInfoBeans> getCategoryItemList3(int userType,int lCategory,int sCategory) throws SQLException {
		ArrayList<ItemInfoBeans> getCategoryItemList3 = new ArrayList<ItemInfoBeans>();
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM item"
					+ " JOIN category_s"
					+ " ON item.category_id = category_s.id"
					+ " JOIN category_l"
					+ " ON category_s.category_l = category_l.id"
					+ " WHERE item.user_type = ?"
					+ " AND category_l.id = ?"
					+ " AND category_s.id = ?");

			st.setInt(1,userType);
			st.setInt(2,lCategory);
			st.setInt(3,sCategory);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				ItemInfoBeans item = new ItemInfoBeans();
				item.setId(rs.getInt("id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemDetail(rs.getString("item_detail"));
				item.setPriceWithTax(rs.getInt("price_with_tax"));
				item.setFileName(rs.getString("file_name"));
				item.setsCategory(rs.getInt("category_id"));
				item.setUserType(rs.getInt("user_type"));
				item.setItemCreateDate(rs.getTimestamp("item_create_date"));
				item.setItemUpdateDate(rs.getTimestamp("item_update_date"));
				item.setRate(rs.getInt("rate"));
				getCategoryItemList3.add(item);
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

		System.out.println("getting CategoryItemList3 has been completed");
		return getCategoryItemList3;
	}

}
