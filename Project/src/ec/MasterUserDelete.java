package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class MasterUserDelete
 */
@WebServlet("/MasterUserDelete")
public class MasterUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterUserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		//管理者IDがセッションに保存されていなければトップページへリダイレクト、保存されていれば次の処理へ
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		 if(userId == null || userId != 1) {
			response.sendRedirect("Index");
			return;
		}

		//ユーザーのIDを取得し、ユーザー情報を削除
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);

		try {
			UserDao.deleteUserInfoBeansByUserId(id);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("Master");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
