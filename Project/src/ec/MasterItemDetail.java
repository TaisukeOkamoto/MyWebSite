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

import beans.ItemInfoBeans;
import dao.CategorySDao;
import dao.ItemDao;

/**
 * Servlet implementation class MasterItemDetail
 */
@WebServlet("/MasterItemDetail")
public class MasterItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemDetail() {
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
		 //商品IDを取得して数値に変換。該当商品を取得して、小カテゴリーIDから小カテゴリー名を取得して受け渡し。
		 String itemIdStr = (String) request.getParameter("itemId");
		 int itemId = Integer.parseInt(itemIdStr);
		try {
			ItemInfoBeans item = ItemDao.getItemrInfoBeansByItemId(itemId);
			int sCategory = item.getsCategory();
			String CategorysName = CategorySDao.getsCategoryName(sCategory);
			item.setsCategoryName(CategorysName);
			request.setAttribute("item",item);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_item_detail.jsp");
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
