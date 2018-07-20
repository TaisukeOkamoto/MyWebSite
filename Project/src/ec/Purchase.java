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

import beans.BuyInfoBeans;
import beans.DeliveryMethodInfoBeans;
import beans.ItemInfoBeans;
import beans.UserInfoBeans;
import dao.DeliveryMethodDao;
import dao.UserDao;

/**
 * Servlet implementation class Purchase
 */
@WebServlet("/Purchase")
public class Purchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Purchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//カートを取得して中身が無ければトップページへリダイレクト
		ArrayList <ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		if(cart.size() == 0) {
		  response.sendRedirect("Index");
		}

		//購入情報を作成してカートに入っている商品の合計金額を入れる。
		BuyInfoBeans bib = (BuyInfoBeans) session.getAttribute("bib");
		int totalPrice = ECHelper.getTotalItemPrice(cart);
		bib.setTotalPrice(totalPrice);

		session.setAttribute("bib", bib);

		//カートの中身があるなら購入ページへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/purchase.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//カートを取得して中身が無ければトップページへリダイレクト
		ArrayList <ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		if(cart.size() == 0) {
			response.sendRedirect("Index");
		}

		//購入情報を作成してカートに入っている商品の合計金額を入れる。
		BuyInfoBeans bib = new BuyInfoBeans();
		int totalPrice = ECHelper.getTotalItemPrice(cart);
		bib.setTotalPrice(totalPrice);

		//購入情報に配送方法ID「1（通常配送）」をセットしておく
		try {
			DeliveryMethodInfoBeans dmib = DeliveryMethodDao.getDeliveryMethodById(1);
			bib.setDeliveryMethodId(dmib.getId());
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//購入情報にユーザーIDを入れる
		int userId = (int) session.getAttribute("userId");
		bib.setUserId(userId);

		session.setAttribute("bib", bib);

		//ポイント使用の初期値に0をセット
		session.setAttribute("UserPointChange", 0);

		//ユーザーを取得して購入画面に送る
		try {
			UserInfoBeans user = UserDao.getUserInfoBeansByUserId(userId);
			session.setAttribute("user", user);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//カートの中身があるなら購入ページへ
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/purchase.jsp");
		dispatcher.forward(request, response);
	}

}
