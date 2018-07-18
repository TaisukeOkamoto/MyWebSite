package ec;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Master
 */
@WebServlet("/Master")
public class Master extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Master() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		//商品の削除メッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String itemDeleteCompleteMsg = (String) session.getAttribute("itemDeleteCompleteMsg");
		if(!(itemDeleteCompleteMsg == null)) {
			request.setAttribute("itemDeleteCompleteMsg",itemDeleteCompleteMsg);
			session.removeAttribute("itemDeleteCompleteMsg");
		}
		//商品の新規登録メッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String itemRegistrationCompleteMsg = (String) session.getAttribute("itemRegistrationCompleteMsg");
		if(!(itemRegistrationCompleteMsg == null)) {
			request.setAttribute("itemRegistrationCompleteMsg",itemRegistrationCompleteMsg);
			session.removeAttribute("itemRegistrationCompleteMsg");
		}
		//商品の更新メッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String itemUpdateCompleteMsg = (String) session.getAttribute("itemUpdateCompleteMsg");
		if(!(itemUpdateCompleteMsg == null)) {
			request.setAttribute("itemUpdateCompleteMsg",itemUpdateCompleteMsg);
			session.removeAttribute("itemUpdateCompleteMsg");
		}
		//ユーザー削除のメッセージを受け取り、nullでなければリクエストスコープに保存後、セッションスコープは削除
		String userDeleteCompleteMsg = (String) session.getAttribute("userDeleteCompleteMsg");
		if(!(userDeleteCompleteMsg == null)) {
			request.setAttribute("userDeleteCompleteMsg",userDeleteCompleteMsg);
			session.removeAttribute("userDeleteCompleteMsg");
		}
		//管理者なら管理者トップページを表示、一般ユーザーなら一般ユーザー用のトップページにリダイレクト
		 if(userId == null || userId != 1) {
			response.sendRedirect("Index");
			return;
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_top.jsp");
			dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
