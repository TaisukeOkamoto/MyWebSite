package ec;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemInfoBeans;

/**
 * Servlet implementation class MypageLikeDelete
 */
@WebServlet("/MypageLikeDelete")
public class MypageLikeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageLikeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//ユーザーIDが無ければトップページへ飛ばす、管理者なら管理者トップページを表示
		Integer userId = (Integer) session.getAttribute("userId");
		 if(userId == null) {
			response.sendRedirect("Index");
			return;
		} else if(userId == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_top.jsp");
			dispatcher.forward(request, response);
			return;
		}

		//削除するお気に入り商品のIDを受け取る
		int itemId = Integer.parseInt(request.getParameter("itemid"));

		//セッションスコープからお気に入りを取り出す
		ArrayList <ItemInfoBeans> likeItems = (ArrayList<ItemInfoBeans>) session.getAttribute("likeItems");

		//お気に入りの商品を全て取り出して、その中にチェックボックスから受け取った商品IDと同じ商品があれば、その商品をお気に入りから削除する
		for (int i = 0;i < likeItems.size();i++){
	    	if(likeItems.get(i).getId() == itemId) {
	    		likeItems.remove(i);
	    	}
		}

		session.setAttribute("LikeDeleteMsg", "お気に入りから商品を削除しました");

		response.sendRedirect("MypageLike");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
