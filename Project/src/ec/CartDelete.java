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
 * Servlet implementation class CartDelete
 */
@WebServlet("/CartDelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		//チェックボックスから削除用の商品IDのリストを受け取り
		String[] itemDeleteIdList = request.getParameterValues("cartDelete");

		//セッションスコープからカートを取り出す
		ArrayList <ItemInfoBeans> cart = (ArrayList<ItemInfoBeans>) session.getAttribute("cart");

		//カートの商品を全て取り出して、その中にチェックボックスから受け取った商品IDと同じ商品があれば、その商品をカートから削除する
		for (String itemDeleteId:itemDeleteIdList){
	    for (int i = 0 ; i < cart.size() ; i++){
	    	ItemInfoBeans cartInItem = cart.get(i);
	    	if(cartInItem.getId() == Integer.parseInt(itemDeleteId)) {
	    		cart.remove(cartInItem);
	    	}
	      }
		}
		//削除メッセージをセッションスコープで受け渡し
	    session.setAttribute("itemDeleteMsg", "カートから商品を削除しました");
	    response.sendRedirect("Cart");
	}

}
