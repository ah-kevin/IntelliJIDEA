import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/12/16.
 */
@WebServlet(name = "ModifyCookiesServlet",value = "/modifycookie")
public class ModifyCookiesServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //如果cookie中包含名字叫city的直则修改为guangzhou
        //1.获取所有cookie
        Cookie[] cs = request.getCookies();
        //2.便利cs,查找符合规则的cookie
        if (cs != null) {
            for (Cookie c : cs) {
                if (c.getName().equals("city")) {
                    c.setValue("Guangzhong");
                    response.addCookie(c);
                }
            }
        }
    }
}
