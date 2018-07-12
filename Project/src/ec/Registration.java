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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//エンコーディング設定
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

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
		 String check = request.getParameter("check");

		 //電話番号と郵便番号を初期化
		 int phoneNumber = 0;
		 int address = 0;

		 //パラメータの値をセッションスコープuserとして引き渡し
		UserInfoBeans user = new UserInfoBeans(familyName, firstName, address, prefecture, city, street, phoneNumber, year, month, day, mail, gender, password, 0);
		session.setAttribute("user", user);

		//未入力の時
		 if(familyName.equals("")||firstName.equals("")||strAddress.equals("")||prefecture.equals("")||city.equals("")||street.equals("")||strPhoneNumber.equals("")||gender == null||mail.equals("")||mailConfirm.equals("")||password.equals("")||passwordConfirm.equals("")||check == null) {
			request.setAttribute("emptyInputErr", "未入力項目があります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//生年月日が選択されていない時
		 if(year == null || month == null || day == null) {
			request.setAttribute("emptyBitrhDayErr", "生年月日を選択してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		 try {
			if(UserDao.isOverlapMail(mail) == true) {
				request.setAttribute("OverlapMailErr", "メールアドレスはすでに使用されています。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
				dispatcher.forward(request, response);
				return;
			 }
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//パスワードと確認用パスワードが異なる時
		 if(!password.equals(passwordConfirm)) {
			request.setAttribute("differentPasswordErr", "パスワードと確認用パスワードが異なります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//メールアドレスと確認用メールアドレスが異なる時
		 if(!mail.equals(mailConfirm)) {
			request.setAttribute("differentMailErr", "メールアドレスと確認用メールアドレスが異なります。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//電話番号をint型に変換できれば変換、できなければエラーメッセージ
		 if(ECHelper.isNum(strPhoneNumber)) {
			phoneNumber = Integer.parseInt(strPhoneNumber);
			user.setPhoneNumber(phoneNumber);
		 } else {
			request.setAttribute("StringPhoneNumberErr", "電話番号は半角数字で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
				dispatcher.forward(request, response);
				return;
			}
		 } else {
			request.setAttribute("StringAddressNumberErr", "郵便番号は7桁の数値で入力してください。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//会員規約にチェックがない時はエラー
		 if(!check.equals("on")) {
			request.setAttribute("memberCheckErr", "会員規約に同意の上、チェックしてください");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
			dispatcher.forward(request, response);
			return;
		 }
		//確認画面へリダイレクト
		response.sendRedirect("RegistrationConfirm");
	}

}
