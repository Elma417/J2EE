import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;


/**
 * Servlet implementation class Index
 */
@WebServlet("/sessionindex.do")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();//查询浏览器存储的本地Cookie,返回结果是数组。
        if (cookies != null) {
            for (Cookie cookie : cookies) {//Cookie由name和value两部分组成
                String name = cookie.getName();
                String value = cookie.getValue();
                if ("user".equals(name) && "Admin".equals(value)) {
                    request.setAttribute(name, value);
                        request.getRequestDispatcher("/sessionuser.view").forward(request, response);
                    return;
                }
            }
        }
        response.sendRedirect("SessionLogin.html");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        processRequest(request, response);

    }

}