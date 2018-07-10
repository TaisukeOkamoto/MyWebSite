package ec;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class RegistrationDone
 */
@WebServlet("/RegistrationDone")
public class RegistrationDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationDone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserInfoBeans user = (UserInfoBeans) session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("Index");
		}

		String year = user.getBirthYear();
		String month = user.getBirthMonth();
		String day = user.getBirthDay();

		//String型の生年月日をDate型に変換
		String strbirthDate = year + "/" + month + "/" + day;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date birthDate;

		try {
			birthDate = sdFormat.parse(strbirthDate);
			UserDao.setUserInfo(user.getFamilyName(), user.getFirstName(), user.getAddress(), user.getPrefecture(), user.getCity(), user.getStreet(), user.getPhoneNumber(), birthDate, user.getMail(), user.getGender(), user.getPassword());
			session.removeAttribute("user");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration_done.jsp");
			dispatcher.forward(request, response);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
