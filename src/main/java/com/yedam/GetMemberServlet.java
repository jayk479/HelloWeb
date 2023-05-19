package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/serchMember")
public class GetMemberServlet extends HttpServlet {

//조회 : 사용자 입력(searchForm.html)
//처리 : 서블릿(select 기능 : serchMember)
//결과 : 처리결과(사원번호 처리결과 : 화면출력)  목록페이지x
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	resp.setContentType("text/html;charset=UTF-8");
	PrintWriter out = resp.getWriter();
	
	String id = req.getParameter("id"); //input emp_id
	
	EmpDAO dao = new EmpDAO(); //instance 선언
	Employee result = dao.getEmp(Integer.parseInt(id));
	
	if(result !=null) {
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>사원번호</th>");
		out.print("<td>"+result.getEmployeeId()+"</td>");
		out.print("<tr>");
		out.print("<th>이름</th>");
		out.print("<td>"+result.getFirstName()+"_"+result.getLastName()+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>email</th>");
		out.print("<td>"+result.getEmail()+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>Job</th>");
		out.print("<td>"+result.getJobId()+"</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>hire_date</th>");
		out.print("<td>"+result.getHireDate()+"</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<hr>");
		out.print("<a href='empList'>목록으로</a>");
	} else {
		resp.sendRedirect("serchForm.html");
	}
		
	}
	
}
