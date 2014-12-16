import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2014/12/16.
 */
@WebServlet(name = "AddcookieServlet",urlPatterns = "/addCookie")
public class AddcookieServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        //创建cookie
        Cookie c1 =new Cookie("uname","aaa");
        //讲cookie添加到响应对象中,响应对象在那里,cookie到哪里
        response.addCookie(c1);
        Cookie c2 =new Cookie("city","beijing");
        response.addCookie(c2);
        out.close();
    }

}
