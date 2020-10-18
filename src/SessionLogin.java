
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sessionlogin.do")
public class SessionLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        request.setCharacterEncoding("UTF-8");
        String user = URLDecoder.decode(request.getParameter("user"), "UTF-8");
        String password = request.getParameter("password");
        String autologin = request.getParameter("autologin");
        if (user.equals("Admin") && password.equals("123456")) {
            if ("auto".equals(autologin)) {
                //自动登录时，创建Cookie,保存用户名。
                Cookie cookieLogin = new Cookie("user", user);
                cookieLogin.setMaxAge(10* 60);
                //设置保存时间为10分钟
                response.addCookie(cookieLogin);
            }
            request.setAttribute("user", user);
            request.setAttribute("password", password);
            request.getRequestDispatcher("sessionuser.view").forward(request, response);
        } else {
            response.sendRedirect("SessionLogin.html");
        }

    }

}