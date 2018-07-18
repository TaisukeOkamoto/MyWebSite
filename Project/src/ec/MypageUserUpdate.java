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

import beans.UserInfoBeans;
import dao.UserDao;

/**
 * Servlet implementation class MypageUpdate
 */
@WebServlet("/MypageUserUpdate")
public class MypageUserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageUserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		//ユーザーIDが無ければトップページへ飛ばす、管理者なら管理者トップページを表示
		 if(userId == null) {
			response.sendRedirect("Index");
			return;
		} else if(userId == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_top.jsp");
			dispatcher.forward(request, response);
			return;
		}

		 try {
			UserInfoBeans user = UserDao.getUserInfoBeansByUserId(userId);
			session.setAttribute("user", user);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		//Getメソッドで取得したユーザー情報を削除
		session.removeAttribute("user");

		 String familyName = request.getParameter("familyName");
		 String firstName = request.getParameter("firstName");
		 String strAddress = request.getParameter("address");
		 String prefecture = request.getParameter("prefecture");
		 String city = request.getParameter("city");
		 String street = request.getParameter("street");
		 String strPhoneNumber = request.getParameter("phoneNumber");
		 String year = request.getParameter("year");
		 String month = request.getParameter("month");
		 String day = request.getParameter("day");
		 String gender = request.getParameter("gender");
		 String mail = request.getParameter("mail");
		 String mailConfirm = request.getParameter("mailConfirm");
		 String password = request.getParameter("password");
		 String passwordConfirm = request.getParameter("passwordConfirm");

		 //電話番号と郵便番号を初期化
		 int phoneNumber = 0;
		 int address = 0;

		 //パラメータの値をセッションスコープuserとして引き渡し
		UserInfoBeans user = new UserInfoBeans(familyName, firstName, address, prefecture, city, street, phoneNumber, year, month, day, mail, gender, password, 0);
		request.setAttribute("user", user);

		//未入力の時
		 if(familyName.equals("")||firstName.equals("")||strAddress.equals("")||prefecture.equals("")||city.equals("")||street.equals("")||strPhoneNumber.equals("")||gender == null||mail.equals("")||mailConfirm.equals("")||password.equals("")||passwordConfirm.equals("")) {
			request.setAttribute("emptyInputErr", "未入力項目があります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//生年月日が選択されていない時
		 if(year == null || month == null || day == null) {
			request.setAttribute("emptyBitrhDayErr", "生年月日を選択してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//パスワードと確認用パスワードが異なる時
		 if(!password.equals(passwordConfirm)) {
			request.setAttribute("differentPasswordErr", "パスワードと確認用パスワードが異なります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//メールアドレスと確認用メールアドレスが異なる時
		 if(!mail.equals(mailConfirm)) {
			request.setAttribute("differentMailErr", "メールアドレスと確認用メールアドレスが異なります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/master_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//電話番号をint型に変換できれば変換、できなければエラーメッセージ
		 if(ECHelper.isNum(strPhoneNumber)) {
			phoneNumber = Integer.parseInt(strPhoneNumber);
			user.setPhoneNumber(phoneNumber);
		 } else {
			request.setAttribute("StringPhoneNumberErr", "電話番号は半角数字で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//郵便番号をint型に変換できれば変換、できなければエラーメッセージ
		 if(ECHelper.isNum(strAddress)) {
			address = Integer.parseInt(strAddress);
			user.setAddress(address);
			int addressNumberLength = String.valueOf(address).length();
			//郵便番号が7桁でなければエラーメッセージ
			if(addressNumberLength != 7) {
				request.setAttribute("StringAddressNumberErr", "郵便番号は7桁の半角数字で入力してください。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
				dispatcher.forward(request, response);
				return;
			}
		 } else {
			request.setAttribute("StringAddressNumberErr", "郵便番号は7桁の数値で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mypage_user_update.jsp");
			dispatcher.forward(request, response);
			return;
		 }

		 //ユーザIDを取得
		 int userId = (int) session.getAttribute("userId");

		 //会員情報アップデート処理
		 try {
			UserDao.updateUserInfoBeansByUserId(userId, user);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		 session.setAttribute("UserUpdateMsg", "会員情報を更新しました");

		 response.sendRedirect("Mypage");
	}

}
