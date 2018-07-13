package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ItemDao;

/**
 * Servlet implementation class MasterItemDelete
 */
@WebServlet("/MasterItemDelete")
public class MasterItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//管理者IDがセッションに保存されていなければトップページへリダイレクト、保存されていれば次の処理へ
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		 if(userId == null || userId != 1) {
			response.sendRedirect("Index");
			return;
		}

		//商品のIDを取得し、商品情報を削除
		String strItemId = request.getParameter("itemid");
		int itemid = Integer.parseInt(strItemId);

		try {
			ItemDao.deleteItemInfoBeansByItemId(itemid);
			//商品の削除メッセージをsessionスコープに保存
			session.setAttribute("itemDeleteCompleteMsg", "商品は正常に削除されました");
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
