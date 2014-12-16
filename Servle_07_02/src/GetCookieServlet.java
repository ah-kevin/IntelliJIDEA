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
@WebServlet(name = "GetCookieServlet" ,urlPatterns="/getCookie")
public class GetCookieServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charst=utf-8");
        PrintWriter out =response.getWriter();
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            //循环输出每一个cookie
            for (Cookie c:cookies){
                out.print(c.getName()+"<br>");
                out.print(c.getValue()+"<br>");
            }
        }else{
            out.println("没有cookie");
        }
    }


}
