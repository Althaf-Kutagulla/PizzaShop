import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.databaseoperations.UserAuthenticationDao;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	

	public void doGet(HttpServletRequest request ,HttpServletResponse response) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserAuthenticationDao logincheck = new UserAuthenticationDao();
		if(logincheck.checkUser(username, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			
			try {
				response.sendRedirect("home.jsp");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}else {
			try {
				response.sendRedirect("login.jsp");
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
	
	
}
