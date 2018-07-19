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

import beans.ItemInfoBeans;
import dao.ItemDao;

/**
 * Servlet implementation class ItemCategoryList
 */
@WebServlet("/ItemCategoryList")
public class ItemCategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemCategoryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userTypestr = request.getParameter("userType");
		String lCategorystr = request.getParameter("lCategory");
		String sCategorystr = request.getParameter("sCategory");

		ArrayList<ItemInfoBeans> itemList = null;

		//ユーザー種別、大カテゴリー、小カテゴリーの選択がない場合は全ての商品を取得
		if(userTypestr == null && lCategorystr == null && sCategorystr == null) {
			try {
				itemList = ItemDao.getAllItemList();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//ユーザー種別のみ値がある場合
		if(userTypestr != null && lCategorystr == null && sCategorystr == null) {
			try {
				 int userType = Integer.parseInt(userTypestr);
				itemList = ItemDao.getCategoryItemList1(userType);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//ユーザー種別と大カテゴリーのみ値がある場合
		if(userTypestr != null && lCategorystr != null && sCategorystr == null) {
			try {
				 int userType = Integer.parseInt(userTypestr);
				 int lCategory = Integer.parseInt(lCategorystr);
				itemList = ItemDao.getCategoryItemList2(userType,lCategory);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//ユーザー種別、大カテゴリー、小カテゴリーに値がある場合
		if(userTypestr != null && lCategorystr != null && sCategorystr != null) {
			try {
				 int userType = Integer.parseInt(userTypestr);
				 int lCategory = Integer.parseInt(lCategorystr);
				 int sCategory = Integer.parseInt(sCategorystr);
				itemList = ItemDao.getCategoryItemList3(userType,lCategory,sCategory);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}

		request.setAttribute("itemList", itemList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/item_category_list.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
