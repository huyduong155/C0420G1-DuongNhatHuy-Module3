import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscoundServlet", urlPatterns = "/DiscoundServletPath")
public class DiscoundServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Description = request.getParameter("ProductDescription");
        String price = request.getParameter("ListPrice");
        String Discount = request.getParameter("DiscountPercent");
        double result = Double.parseDouble(price) * Double.parseDouble(Discount)* 0.01;
        double afterprice = Double.parseDouble(price) - result;
        request.setAttribute("afterprice", afterprice);
        request.setAttribute("ProductDescription",Description);
        request.setAttribute("resultServlet", result);
        request.getRequestDispatcher("final.jsp").forward(request,response);
    }
}
