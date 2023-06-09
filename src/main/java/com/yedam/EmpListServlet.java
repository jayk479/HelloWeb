package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/empList")
public class EmpListServlet extends HttpServlet{
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req : 요청정보,  resp : 응답정보
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();
					out.print("<table border='1'>");
					out.print("<thead><tr><th>사원번호</th><th>Name</th><th>email</th><th>직무</th><th>입사일</th></tr></thead>");
					out.print("<tbody>");
					for(Employee emp : list) {
						out.print("<tr><td><a href='serchMember?id="+emp.getEmployeeId()+"'>"+emp.getEmployeeId()+"</a></td>");
						out.print("<td>"+emp.getFirstName()+" "+emp.getLastName()+"</td>");
						out.print("<td>"+emp.getEmail()+"</td>");
						out.print("<td>"+emp.getJobId()+"</td>");
						out.print("<td>"+emp.getHireDate()+"</td></tr>");
					}
					
					out.print("</tbody>");
					out.print("</table>");
				}
	public static void main(String[] args) {
		
	}
}
