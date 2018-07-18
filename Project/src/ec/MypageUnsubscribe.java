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

import dao.UserDao;

/**
 * Servlet implementation class MypageUnsubscribe
 */
@WebServlet("/MypageUnsubscribe")
public class MypageUnsubscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageUnsubscribe() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/mypage_unsubscribe.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		try {
			UserDao.deleteUserInfoBeansByUserId(userId);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.removeAttribute("userId");
		session.removeAttribute("user");
		response.sendRedirect("Index");
	}

}
