package com.yedam;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;


@WebServlet("/employee/addMemberServlet")
public class AddMemberServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//jdbc연결조회
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String job = req.getParameter("job");
		String hdate = req.getParameter("hdate");
		//String pnum = req.getParameter("pnum");
		
		Employee emp = new Employee();
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setEmail(email);
		emp.setJobId(job);
		emp.setHireDate(hdate);
		
		
		EmpDAO dao = new EmpDAO();
		boolean result = dao.insertEmployee(emp);
		
		if(result) {
			resp.sendRedirect("empList");
		}else {
			resp.sendRedirect("addForm.html");
		}
		// addform -> addMemberServlet 페이지로 정보를 넘겨줌 -> empList 호출 : 목록을 보는 페이지 
		
//		try {
//			//connection객체 가져옴
//			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr", "hr");
//			
//			//쿼리 조회 -> 처리결과 : PreparedStatement
//			String sql = "insert into employees(employee_id, last_name, email, hire_date, job_id, first_name, phone_number) values(employees_seq.nextval,?,?,?,?,?,?)";
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			psmt.setString(1,lname);
//			psmt.setString(2,email);
//			psmt.setString(3,hdate);
//			psmt.setString(4,job);
//			psmt.setString(5,fname);
//			psmt.setString(6, pnum);
//			
//			int r = psmt.executeUpdate();
//			System.out.println("처리된 건수 : "+r);
//			
//			resp.sendRedirect("empList"); // addform -> addMemberServlet 페이지로 정보를 넘겨줌 -> empList 호출 : 목록을 보는 페이지 
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("fname : "+fname + "_lname : "+lname+", email : "+email+", job : "+job+", 입사일: "+hdate);
	}
		
}
