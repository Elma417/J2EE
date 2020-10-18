import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionUser
 */
@WebServlet("/sessionuser.view")
public class SessionUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public SessionUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    private void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {

        String user=(String) request.getAttribute("user");
        //forward过来的request,需要通过getAttribute方法获得，不是getParameter
        PrintWriter out= response.getWriter();
        if(user==null) {
            response.sendRedirect("SessionLogin.html");
        }
        else {
            out.println("<html><head><title>Servlet User</title></head><body>"+user+"  Welcome!</body></html>");
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        //processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        processRequest(request,response);

    }

}