package web;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2014/12/15.
 */
@WebServlet(name = "ActionServlet", value = "*.do")
public class ActionServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置读取参数的解码方式
        request.setCharacterEncoding("utf-8");
        //获取uri
        String uri=request.getRequestURI();
        //截取资源路径中的动作
        uri=uri.substring(uri.indexOf("/"),uri.lastIndexOf("."));
        //判断动作的种类,进行处理
        if (uri.equals("/regist")){
            //获取用户添加的用户名
            String username=request.getParameter("username");
            //实例化dao,吊用findByUserName方法
            UserDao dao=new UserDao();
            try {
                User u=dao.findByUserName(username);
                //按照用户名查到一个实体
                if (u!=null){
                    //绑定错误提示信息
                    request.setAttribute("err","用户名已经存在");
                    //转发回注册页面
                    request.getRequestDispatcher("regist.jsp").forward(request,response);
                }else{

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
