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
 * Servlet implementation class SaleItemList
 */
@WebServlet("/ItemSaleList")
public class ItemSaleList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSaleList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//ページ番号の初期値を設定
			int pageNumber = 1;
			String pageNumberstr = request.getParameter("pageNumber");
			//pageNumberがnullで無ければ初期値を設定
			if(pageNumberstr != null) {
				pageNumber = Integer.parseInt(pageNumberstr);
			}
			//割引商品リスト受け渡し
			ArrayList<ItemInfoBeans> discountItemList = ItemDao.getDiscountItem(pageNumber);
			request.setAttribute("pageNumber", pageNumber);
			request.setAttribute("discountItemList",discountItemList);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/item_sale_list.jsp");
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
