package ec;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyInfoBeans;
import beans.DeliveryMethodInfoBeans;
import dao.DeliveryMethodDao;

/**
 * Servlet implementation class DeliveryMethodChange
 */
@WebServlet("/DeliveryMethodChange")
public class DeliveryMethodChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryMethodChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		//配送方法IDを取得
		int DeliveryMethodId = Integer.parseInt(request.getParameter("DeliveryMethodChange"));
		try {
			//配送データを取得してセッションスコープで受け渡し
			DeliveryMethodInfoBeans dmib = DeliveryMethodDao.getDeliveryMethodById(DeliveryMethodId);
			session.setAttribute("dmib", dmib);
			//購入情報に配送方法IDをセットする
			BuyInfoBeans bib = (BuyInfoBeans) session.getAttribute("bib");
			bib.setDeliveryMethodId(DeliveryMethodId);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		response.sendRedirect("Purchase");
	}

}
