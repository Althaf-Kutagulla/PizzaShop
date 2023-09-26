
import com.databaseoperations.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmOrder
 */
@WebServlet("/ConfirmOrder")
public class ConfirmOrder extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ConfirmOrder");
		int pizzaNameId=Integer.parseInt(request.getParameter("pizza"));
		int pizzaToppingId = Integer.parseInt(request.getParameter("topping"));
		System.out.println(pizzaNameId+" "+pizzaToppingId);
		
		CreateOrderDB.createOrderOnSql(pizzaNameId, pizzaToppingId);
		
		response.sendRedirect("home.jsp");
		
	}

}
