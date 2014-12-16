package web;

import dao.EmployeeDAO;
import entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2014/12/14.
 */
@WebServlet(name = "Servlet", value = "*.do")
public class actionServlet_emp extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //        1.获取uri
        String uri = request.getRequestURI();
        //       2.截取uir中的动作
        uri = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
        if (uri.equals("/list")) {
            try {
                //1.创建dao对象
                EmployeeDAO dao = new EmployeeDAO();
                //2.吊用findAll()方法获取数据
                List<Employee> emps = dao.findAll();
                //3.绑定数据到request中
                request.setAttribute("allEmp", emps);
                //4.转发
                request.getRequestDispatcher("listemp.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("msg","系统繁忙");
                request.getRequestDispatcher("err.jsp").forward(request,response);
            }
        } else if (uri.equals("/add")) {
            //获取表单数据封装成对象
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));
            int age = Integer.parseInt(request.getParameter("age"));
            Employee emp = new Employee();
            emp.setName(name);
            emp.setSalary(salary);
            emp.setAge(age);
            try {
                //实例化dao,掉sava方法
                EmployeeDAO dao = new EmployeeDAO();
                dao.save(emp);
                //重定向daolist.do
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
                //讲异常抛给容器
                throw new  ServletException(e);
            }

        } else if (uri.equals("/del")) {
            //获取地址栏中的id
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                //实例化dao,调用删除方法
                EmployeeDAO dao = new EmployeeDAO();
                dao.del(id);
                //重定向到list.do查看新的查询结果
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (uri.equals("/load")) {
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                EmployeeDAO dao = new EmployeeDAO();
                 Employee emp=dao.findById(id);
                //绑定
                request.setAttribute("emp",emp);
                //转发
                request.getRequestDispatcher("updateEmp.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (uri.equals("/modify")){
            //获取数据,组装对象
            int id=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            double salary=Double.parseDouble(request.getParameter("salary"));
            int age=Integer.parseInt(request.getParameter("age"));
            Employee emp =new Employee(id,name,salary,age);
            try {
                EmployeeDAO dao=new EmployeeDAO();
                dao.modify(emp);
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
