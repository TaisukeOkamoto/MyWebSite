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

import beans.ItemInfoBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//商品削除メッセージを受け取りnullでなければリクエストスコープに保存し、セッションスコープは削除する
		String itemDeleteMsg = (String) session.getAttribute("itemDeleteMsg");
		if(itemDeleteMsg != null) {
			request.setAttribute("itemDeleteMsg", itemDeleteMsg);
			session.removeAttribute("itemDeleteMsg");
		}
		//商品個数変更メッセージを受け取りnullでなければリクエストスコープに保存し、セッションスコープは削除する
		String CartAmountChangeMsg = (String) session.getAttribute("CartAmountChangeMsg");
		if(CartAmountChangeMsg != null) {
			request.setAttribute("CartAmountChangeMsg", CartAmountChangeMsg);
			session.removeAttribute("CartAmountChangeMsg");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//セッションからカートを受け取る
		ArrayList <ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		//カートがなければカートを作成
		if(cart == null) {
			cart = new ArrayList <ItemInfoBeans>();
		}

		//カートに入れた商品IDを取得
		int itemId = Integer.parseInt(request.getParameter("itemId"));

		//カートの商品を全て取り出して、その中に受け取った商品IDがあれば、メッセージを保存。処理を終了する。
	    for (int i = 0 ; i < cart.size() ; i++){
	    	ItemInfoBeans cartInItem = cart.get(i);
	    	int cartInItemId = cartInItem.getId();
	    	if(itemId == cartInItemId) {
	    		request.setAttribute("CartAlreadyMsg", "その商品はすでにカートに入っています。数量を選択で商品の数を増やせます。");
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
	    		dispatcher.forward(request, response);
	    		return;
	    	}
	      }

		//商品IDから商品を取得
		try {
			ItemInfoBeans item = ItemDao.getItemrInfoBeansByItemId(itemId);

			//商品の個数を1にする
			item.setAmount(1);

			//カートに入れる
			cart.add(item);
			session.setAttribute("cart", cart);
			request.setAttribute("CartSetMsg", "商品をカートに入れました");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/cart.jsp");
		dispatcher.forward(request, response);
	}

}
