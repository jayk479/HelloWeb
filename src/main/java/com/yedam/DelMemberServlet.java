package com.yedam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

//삭제 : 사용자 입력(delFrom.html)
//처리 : 서블릿(delete기능 : delMemberServlet)
//결과 : 목록페이지 출력.

//DAOConnection기능 : DAO.java
//getConnection() => Connection 객체 반환.
//CURD 처리 : EmpDAO.java
//  1. boolean insertEmp( 매개값 or 매개변수)
//  2. getEmp()
//  3. deleteEmp()
//  4. getEmpList()

//서블릿 :  목록, 입력, 삭제...abstract
//   /addMemberServlet
//   /delMemberServlet
//   /empList


//서블릿 : 처리
@WebServlet("/delMemberServlet")
public class DelMemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id"); //input emp_id
		
		EmpDAO dao = new EmpDAO(); //instance 선언
		boolean result = dao.deleteEmployee(Integer.parseInt(id));
		
		if(result) {
			resp.sendRedirect("empList");
		} else {
			resp.sendRedirect("delForm.html");
		}
		
	}
}
