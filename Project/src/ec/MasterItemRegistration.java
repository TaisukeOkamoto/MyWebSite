package ec;

import java.io.IOException;

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
 * Servlet implementation class MasterItemRegistration
 */
@WebServlet("/MasterItemRegistration")
public class MasterItemRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemRegistration() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_item_registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String itemName = request.getParameter("itemName");
		String itemDetail = request.getParameter("itemDetail");
		String fileName = request.getParameter("fileName");
		//Stringで受け取りint型に変換
		String rateStr = request.getParameter("rate");
		int rate = Integer.parseInt(rateStr);
		//Stringで受け取りint型に変換
		String categoryIdStr = request.getParameter("categoryId");
		int categoryId = Integer.parseInt(categoryIdStr);

		//Stringで受け取りint型に変換
		String priceWithTaxStr = request.getParameter("priceWithTax");

		//商品の税込価格を初期化
		int priceWithTax = 0;

		//エラーが起きても入力内容は保持する
		ItemInfoBeans item = new ItemInfoBeans(itemName,itemDetail,priceWithTax,fileName,categoryId,rate);
		request.setAttribute("item", item);

		//商品の税込価格をint型に変換できれば変換、できなければエラーメッセージ
		 if(ECHelper.isNum(priceWithTaxStr)) {
			priceWithTax = Integer.parseInt(priceWithTaxStr);
			ItemDao.setItemInfo(itemName, itemDetail, priceWithTax, fileName, categoryId, rate);
			//セッションスコープに商品登録メッセージを保存
			session.setAttribute("itemRegistrationCompleteMsg", "商品は正常に登録されました");
			response.sendRedirect("Master");
		 } else {
			request.setAttribute("intItemPriceErr", "商品の税込価格は半角数字で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_item_registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
	}

}
