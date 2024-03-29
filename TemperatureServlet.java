import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class TemperatureServlet extends HttpServlet {


  public void doGet(HttpServletRequest req,
                    HttpServletResponse res)
    throws ServletException, IOException
  {
    String str_f = req.getParameter("Fahrenheit");
    
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    
    try {
      int temp_f = Integer.parseInt(str_f);
      double temp_c = (temp_f - 32)*5.0 /9.0;
      out.println("Fahrenheit: " + temp_f + 
                  ", Celsius: " + temp_c);
    } catch (NumberFormatException e) {
      out.println("Invalid temperature: " + str_f);
    }
  } 
}
