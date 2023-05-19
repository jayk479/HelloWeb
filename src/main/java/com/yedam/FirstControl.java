package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class FirstControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("fistcontrol 실행.");
		
		
		//empList 
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
}
