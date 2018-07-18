package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserInfoBeans;
import dao.UserDao;

/**
 * Servlet implementation class Mypage
 */
@WebServlet("/Mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

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

		//ユーザーIDからユーザー情報を取得、セッションに保存
		try {
			UserInfoBeans user = UserDao.getUserInfoBeansByUserId(userId);
			session.setAttribute("user", user);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//会員情報更新メッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String UserUpdateMsg = (String) session.getAttribute("UserUpdateMsg");
		if(!(UserUpdateMsg == null)) {
			request.setAttribute("UserUpdateMsg",UserUpdateMsg);
			session.removeAttribute("UserUpdateMsg");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_top.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
