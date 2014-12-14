package dao;

import entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    /**查询所有员工
     * @throws Exception */
    public List<Employee> findAll() throws Exception{
        List<Employee> emps=new ArrayList<Employee>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=DBUtil.getConnection();
            ps=con.prepareStatement("select * from t_emp");
            rs=ps.executeQuery();
            while(rs.next()){
                Employee emp=new Employee(
                        rs.getInt("id"),rs.getString("name")
                        ,rs.getDouble("salary"),rs.getInt("age"));
                emps.add(emp);
            };
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(con);
        }
        return emps;

    }


    /**增加员工*/
    public void save(Employee emp) throws Exception{
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=DBUtil.getConnection();
            ps=con.prepareStatement("insert into t_emp values(emp_id_seq.nextval,?,?,?)");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getAge());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(con);
        }

    }

    /**删除员工信息*/
    public void del(int id)throws Exception{
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=DBUtil.getConnection();
            ps=con.prepareStatement("delete from t_emp where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(con);
        }
    }

    /**根据id查询员工信息*/
    public Employee findById(int id)throws Exception{
        Employee emp=null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            con=DBUtil.getConnection();
            ps=con.prepareStatement("SELECT * from t_emp where id=?");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                emp=new Employee( rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary"),
                        rs.getInt("age"));

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(con);
        }
        return emp;

    }


    /**保存修改员工信息*/
    public void modify(Employee emp)throws Exception{
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=DBUtil.getConnection();
            ps = con.prepareStatement("update t_emp set name=?,salary=?,age=? where id=?");
            ps.setString(1, emp.getName());
            ps.setDouble(2, emp.getSalary());
            ps.setInt(3, emp.getAge());
            ps.setInt(4, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(con);
        }



    }
}
