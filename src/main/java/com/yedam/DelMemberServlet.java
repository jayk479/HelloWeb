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

import com.yedam.persistence.EmpDAO;

@WebServlet("/employee/delMemberServlet")
public class DelMemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//String empId = req.getParameter("empId");
		String empId = req.getParameter("empId"); //delForm에서 왔음ㅇㅇ
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.deleteEmployee(Integer.parseInt(empId)); 
		
		if(result) {
			resp.sendRedirect("empList");
		}else {
			resp.sendRedirect("delForm.html");
		}
	}
}	
		//jdbc연결조회
//		try {
//			//connection객체 가져옴
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr", "hr");
//			
//			//쿼리 조회 -> 처리결과 : PreparedStatement
//			String sql = "delete from employees where employee_id = ?";
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			psmt.setString(1, empId);
//			
//			int r = psmt.executeUpdate();
//			System.out.println("처리된 건수 : "+r);
//		
//			resp.sendRedirect("empList");
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//		
//		System.out.println("empId : " + empId);
//	}
//	


