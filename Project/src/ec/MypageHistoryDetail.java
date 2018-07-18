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

import beans.BuyInfoBeans;
import beans.ItemInfoBeans;
import dao.BuyDao;
import dao.BuyDetailDao;

/**
 * Servlet implementation class MypageHistoryDetail
 */
@WebServlet("/MypageHistoryDetail")
public class MypageHistoryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageHistoryDetail() {
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

		//購入IDを取得
		int buyId = Integer.parseInt(request.getParameter("buyId"));

		//購入情報を取得してリクエストスコープにセット
		try {
			BuyInfoBeans bib = BuyDao.getBuyInfoBeansByBuyId(buyId);
			request.setAttribute("bib", bib);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			ArrayList<ItemInfoBeans> buyDetailItemList = BuyDetailDao.getItemInfoBeansListByBuyId(buyId);
			request.setAttribute("buyDetailItemList", buyDetailItemList);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_history_detail.jsp");
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
