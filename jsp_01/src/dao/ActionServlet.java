package dao;

import javax.servlet.*;
import javax.servlet.http.*;

import entity.Employee;

import java.io.*;
import java.util.List;

public class ActionServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 获取请求资源路径
        String uri = request.getRequestURI();
        // 获取请求资源路径中除应用名以外的部分
        String action = uri.substring(uri.lastIndexOf("/") + 1,
                uri.lastIndexOf("."));

        if (action.equals("list")) {
            try {
                EmployeeDAO dao = new EmployeeDAO();
                List<Employee> emps = dao.findAll();
                out.println("<table>");
                out.println("<caption>员工信息列表</caption>");
                out.println("<tr><td>编号</td><td>姓名</td><td>薪水</td><td>年龄</td><td>操作</td></tr>");
                for (Employee employee : emps) {
                    out.println("<tr>");
                    out.println("<td >"+ employee.getId() + "</td>");
                    out.println("<td>" + employee.getName() + "</td>");
                    out.println("<td>" + employee.getSalary() + "</td>");
                    out.println("<td>" + employee.getAge() + "</td>");

                    out.println("<td><a href='del.do?id="+employee.getId()+"'" +
                            ""+"onclick=\"return confirm('是否确定删除"+employee.getName()+"');\">删除</a>");
                    out.println("<a href='load.do?id="+employee.getId()+"'>修改</a></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<a href='addEmp.html'>增加新员工</a>");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("系统繁忙");
            }
        } else if (action.equals("add")) {
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));
            int age = Integer.parseInt(request.getParameter("age"));
            try {
                Employee emp = new Employee();
                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                EmployeeDAO dao = new EmployeeDAO();
                dao.save(emp);
                System.out.println("增加成功");
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
                out.print("系统繁忙");
            }
        }else if (action.equals("del")) {
            int id=Integer.parseInt(request.getParameter("id"));
            try {
                Employee emp=new Employee();
                emp.setId(id);
                EmployeeDAO dao=new EmployeeDAO();
                dao.del(id);
                System.out.println("删除成功");
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (action.equals("load")){
            //根据id查询获取员工的信息
            int id=Integer.parseInt(request.getParameter("id"));
            System.out.println(id);
            try {
                EmployeeDAO dao=new EmployeeDAO();
                Employee emp=dao.findById(id);

                out.println("<html><head></head><body style='font-size:30px'>");
                out.println("<form action='modify.do' method='post'>");
                out.println("编号:" + id + "<br>");
                out.println("<input type='hidden' name='id' value='"+id+"'/><br>");
                out.println("姓名:<input name='name' value='"+emp.getName()+"'/><br>");
                out.println("薪水:<input name='salary' value='"+emp.getSalary()+"'/><br>");
                out.println("年龄:<input name='age' value='"+emp.getAge()+"'/><br>");
                out.println("<input type='submit' value='修改'/>");
                out.println("</form>");
                out.println("</body></html>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(action.equals("modify")){
            int id=Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double salary = Double.parseDouble(request.getParameter("salary"));
            int age = Integer.parseInt(request.getParameter("age"));
            try {
                Employee emp = new Employee();
                emp.setId(id);
                emp.setName(name);
                emp.setSalary(salary);
                emp.setAge(age);
                EmployeeDAO dao = new EmployeeDAO();
                dao.modify(emp);
                System.out.println("修改成功");
                response.sendRedirect("list.do");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("修改失败");
            }
        }


    }
}
