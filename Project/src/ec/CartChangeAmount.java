package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemInfoBeans;

/**
 * Servlet implementation class CartChangeAmount
 */
@WebServlet("/CartChangeAmount")
public class CartChangeAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartChangeAmount() {
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

		//それぞれの商品の個数を取得
		String[] itemAmounts = request.getParameterValues("itemAmount");

		//セッションからカートを受け取る
		ArrayList <ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		//カートの商品を全て取り出して、それぞれの商品に個数をセット、完了したらメッセージを保存。
	    for (int i = 0 ; i < cart.size() ; i++){
	    	ItemInfoBeans cartInItem = cart.get(i);
	    		String itemAmountstr = itemAmounts[i];
	    		int itemAmount = Integer.parseInt(itemAmountstr);
	    		cartInItem.setAmount(itemAmount);
	      }
		session.setAttribute("CartAmountChangeMsg", "商品の個数を変更しました");
		response.sendRedirect("Cart");



	}

}
