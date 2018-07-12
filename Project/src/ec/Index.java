package ec;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemInfoBeans;
import dao.ItemDao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		session.removeAttribute("LoginErrMsg");

		try {
			//最新商品7件を受け渡し
			ArrayList<ItemInfoBeans> LatestItem7List = ItemDao.getLatestItem7();
			request.setAttribute("LatestItem7List",LatestItem7List);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			//割引商品リストをシャッフルして受け渡し
			ArrayList<ItemInfoBeans> discountItemList = ItemDao.getDiscountItem();
			Collections.shuffle(discountItemList);
			request.setAttribute("discountItemList",discountItemList);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if(userId == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(userId == 0) {
			request.setAttribute("LoginErrMsg", "メールアドレスまたはパスワードが違います。");
			session.removeAttribute("userId");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
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
