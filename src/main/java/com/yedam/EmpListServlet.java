package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/employee/empList")
public class EmpListServlet extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
	

		out.print("<table border='1'>");
		out.print("<thead><tr><th>EmployeeId</th><th>Name</th><th>email</th><th>JobID</th><th>HireDate</th></tr></thead>");
		out.print("<tbody>");
		// while(rs.next()) {
			for (Employee emp : list) {
				//System.out.println("eid:" + rs.getInt("employee_id")+", name: " + rs.getString("first_name")+", email : "+rs.getString("last_name"));
				out.print("<tr><td>"+"<a href = 'searchMember?empId="+emp.getEmployeeId()+"'>"+emp.getEmployeeId()+"</a>"+"</td>");
				out.print("<td>"+emp.getFirstName()+ ", "+emp.getLastName()+"</td>");
				out.print("<td>"+emp.getEmail()+"</td>");
				out.print("<td>"+emp.getJobId()+"</td>");
				out.print("<td>"+emp.getHireDate()+"</td></tr>");
				//out.print("<td>"+rs.getString("phone_nunber")+"</td></tr>");
			}
		// }
		
		out.print("</tbody>");
		out.print("</table>");
		
		out.print("<a href = '../index.html'>"+"인덱스로이동"+"</a>");

	}
	public static void main(String[] args) {
		
	}
}
