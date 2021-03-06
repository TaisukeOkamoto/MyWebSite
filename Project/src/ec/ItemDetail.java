package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemInfoBeans;
import dao.CategoryLDao;
import dao.CategorySDao;
import dao.ItemDao;
import dao.UserTypeDao;

/**
 * Servlet implementation class ItemDetail
 */
@WebServlet("/ItemDetail")
public class ItemDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");
		//商品IDを取得
		String itemIdStr = request.getParameter("itemid");
		int itemId = Integer.parseInt(itemIdStr);

		try {
			//商品を取得
			ItemInfoBeans item = ItemDao.getItemrInfoBeansByItemId(itemId);
			//ユーザー種別を取得して商品にセット
			int userTypeId = item.getUserType();
			String userTypeName = UserTypeDao.getUsertypeNameById(userTypeId);
			item.setUserTypeName(userTypeName);
			//小カテゴリー名を取得して商品にセット
			int sCategory = item.getsCategory();
			String sCategoryName = CategorySDao.getsCategoryName(sCategory);
			item.setsCategoryName(sCategoryName);
			//大カテゴリー名を取得して商品にセット
			int lCategory = ItemDao.getlCategoryBysCategory(sCategory);
			String lCategoryName = CategoryLDao.getlCategoryName(lCategory);
			item.setlCategory(lCategory);
			item.setlCategoryName(lCategoryName);
			request.setAttribute("item", item);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/item_detail.jsp");
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
