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
 * Servlet implementation class MypageLike
 */
@WebServlet("/MypageLike")
public class MypageLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageLike() {
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

		 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/mypage_like.jsp");
		 dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//セッションからお気に入りを受け取る
		ArrayList <ItemInfoBeans> likeItems = (ArrayList<ItemInfoBeans>) session.getAttribute("likeItems");

		//お気に入りがなければお気に入りを作成
		if(likeItems == null) {
			likeItems = new ArrayList <ItemInfoBeans>();
		}

		//お気に入りの商品IDを取得
		int itemId = Integer.parseInt(request.getParameter("itemId"));

		//お気に入りの商品を全て取り出して、その中に受け取った商品IDがあれば、メッセージを保存。処理を終了する。
	    for (int i = 0 ; i < likeItems.size() ; i++){
	    	ItemInfoBeans likeItem = likeItems.get(i);
	    	int likeItemId = likeItem.getId();
	    	if(itemId == likeItemId) {
	    		request.setAttribute("LikeAlreadyMsg", "その商品はすでにお気に入りに入っています");
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_like.jsp");
	    		dispatcher.forward(request, response);
	    		return;
	    	}
	      }

	    //商品IDから商品を取得
	    try {
			ItemInfoBeans item = ItemDao.getItemrInfoBeansByItemId(itemId);

			//お気に入りに入れる
			likeItems.add(item);
			session.setAttribute("likeItems", likeItems);
			request.setAttribute("LikeSetMsg", "商品をお気に入りに入れました");
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//お気に入りメッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String LikeDeleteMsg = (String) session.getAttribute("LikeDeleteMsg");
		if(!(LikeDeleteMsg == null)) {
			request.setAttribute("LikeDeleteMsg",LikeDeleteMsg);
			session.removeAttribute("LikeDeleteMsg");
		}

		 RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/mypage_like.jsp");
		 dispatcher.forward(request, response);

	}

}
