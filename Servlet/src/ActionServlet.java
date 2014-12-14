import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/12/9.
 */
//@WebServlet(value = "*.do",name = "ActionServlet")
public class ActionServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
        //str是放在JSP页面上显示的数据
        String str="欢迎你";
//        1,绑定数据
        request.setAttribute("msg",str);
//        2.获取转发器
        RequestDispatcher rd=request.getRequestDispatcher("a.jsp");
//        3.转发
        rd.forward(request,response);

    }


}
