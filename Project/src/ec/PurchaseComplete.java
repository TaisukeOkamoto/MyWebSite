package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDetailInfoBeans;
import beans.BuyInfoBeans;
import beans.DeliveryMethodInfoBeans;
import beans.ItemInfoBeans;
import dao.BuyDao;
import dao.BuyDetailDao;
import dao.DeliveryMethodDao;
import dao.UserDao;

/**
 * Servlet implementation class PurchaseResult
 */
@WebServlet("/PurchaseComplete")
public class PurchaseComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		ArrayList<ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		//購入情報取得
		BuyInfoBeans bib = (BuyInfoBeans) session.getAttribute("bib");

		//配送方法IDを取得
		int DeliveryMethodId = Integer.parseInt(request.getParameter("DeliveryMethodChange"));

		//購入情報に配送方法IDをセットする
		bib.setDeliveryMethodId(DeliveryMethodId);

		try {
			// 購入情報を登録
			int buyId = BuyDao.insertBuy(bib);
			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ItemInfoBeans cartInItem : cart) {
				BuyDetailInfoBeans bdib = new BuyDetailInfoBeans();
				bdib.setBuyId(buyId);
				bdib.setBuyHowmany(cartInItem.getAmount());
				bdib.setItemId(cartInItem.getId());
				BuyDetailDao.insertBuyDetail(bdib);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		int totalPrice = bib.getTotalPrice();
		int userId = (int) session.getAttribute("userId");
		try {
			DeliveryMethodInfoBeans DeliveryMethodInfo = DeliveryMethodDao.getDeliveryMethodById(DeliveryMethodId);
			int deliveryMethodPrice = DeliveryMethodInfo.getDeliveryPrice();

			int userPoint = (int) Math.round(Math.floor((double)(totalPrice + deliveryMethodPrice)/100));
			UserDao.setPointUserInfoBeans(userPoint,userId);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		session.removeAttribute("cart");
		session.removeAttribute("bib");

		//購入完了画面へ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/purchase_complete.jsp");
		dispatcher.forward(request, response);

	}

}
