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
import dao.ItemDao;

/**
 * Servlet implementation class MasterItemUpdate
 */
@WebServlet("/MasterItemUpdate")
public class MasterItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MasterItemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		//管理者なら管理者トップページを表示、一般ユーザーなら一般ユーザー用のトップページにリダイレクト
		 if(userId == null || userId != 1) {
			response.sendRedirect("Index");
			return;
		}

			//商品のIDを取得し、数値に変換
			String strItemId = request.getParameter("itemId");
			int itemid = Integer.parseInt(strItemId);

			//商品IDを引き渡し
			session.setAttribute("itemid", itemid);

			try {
				//商品IDから商品を取得。小カテゴリーから大カテゴリーを取得する
				ItemInfoBeans item = ItemDao.getItemrInfoBeansByItemId(itemid);
				int sCategory = item.getsCategory();
				int lCategory = ItemDao.getlCategoryBysCategory(sCategory);
				item.setlCategory(lCategory);
				request.setAttribute("item", item);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_item_update.jsp");
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
		String userTypeStr = request.getParameter("userType");
		int userType = Integer.parseInt(userTypeStr);
		//Stringで受け取りint型に変換
		String lCategoryStr = request.getParameter("lCategory");
		int lCategory = Integer.parseInt(lCategoryStr);
		//Stringで受け取りint型に変換
		String sCategoryStr = request.getParameter("sCategory");
		int sCategory = Integer.parseInt(sCategoryStr);

		//Stringで受け取りint型に変換
		String priceWithTaxStr = request.getParameter("priceWithTax");

		//商品の税込価格を初期化
		int priceWithTax = 0;

		//エラーが起きても入力内容は保持する
		ItemInfoBeans item = new ItemInfoBeans(itemName,itemDetail,priceWithTax,fileName,lCategory,sCategory,userType,rate);
		request.setAttribute("item", item);

		//商品の税込価格をint型に変換できれば変換、できなければエラーメッセージ
		 if(ECHelper.isNum(priceWithTaxStr)) {
			priceWithTax = Integer.parseInt(priceWithTaxStr);
			//商品IDを受け取り、商品に商品の税込価格をセット、商品のアップデート処理をしてセッションスコープに保存された商品IDを削除
			int itemid = (int) session.getAttribute("itemid");
			item.setPriceWithTax(priceWithTax);
			try {
				ItemDao.updateItemInfoBeansByItemId(itemid,item);
				session.removeAttribute("itemid");
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//セッションスコープに商品登録メッセージを保存
			session.setAttribute("itemUpdateCompleteMsg", "商品は正常に更新されました");
			response.sendRedirect("Master");
		 } else {
			request.setAttribute("intItemPriceErr", "商品の税込価格は半角数字で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_item_registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
	}

}
