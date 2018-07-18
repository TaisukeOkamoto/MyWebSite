package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.DBManager;
import beans.DeliveryMethodInfoBeans;

public class DeliveryMethodDao {


	/**
	 * 配送方法情報を配送方法IDから取得
	 * @param id
	 * 		配送方法ID
	 * @return
	 * 		DeliveryMethodInfoBeans
	 * @throws SQLException
	 */
	public static DeliveryMethodInfoBeans getDeliveryMethodById(int id) throws SQLException {

		DeliveryMethodInfoBeans dmib = new DeliveryMethodInfoBeans();
		Connection conn = null;
		PreparedStatement st = null;

		try {
			conn = DBManager.getConnection();
			st = conn.prepareStatement("SELECT * FROM t_delivery_method WHERE id = ?");
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				dmib.setId(id);
				dmib.setDeliveryName(rs.getString("delivery_name"));
				dmib.setDeliveryPrice(rs.getInt("delivery_price"));
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
		return dmib;
	}
}
