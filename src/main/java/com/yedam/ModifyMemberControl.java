package com.yedam;

import java.io.IOException;
import java.nio.channels.AcceptPendingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
//		View에서 요청한 method를 구분. GET / POST
//		★★★ if(get방식으로 요청이 들어오면) -> modifyMember.jsp
		if (req.getMethod().equals("GET")) {

			// id(emp_id) 파라미터.
			// MVC 패턴. 컨트롤러에서 DB의 처리. View화면으로 정보를 전송.
			// emp 변수에 조회결과를 담아서 empInfo(=id 정보) 속성으로 modifyMember.jsp 재지정

			String id = req.getParameter("id");

			EmpDAO dao = new EmpDAO();
			Employee emp = dao.getEmp(Integer.parseInt(id));

			req.setAttribute("empInfo", emp);
			
			//화면 호출
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

//		--> modifyMember.jsp로 이동해서 수정


//		★★★ POST 방식으로 요청이 들어오면 -> modifyMemberServlet
		} else if (req.getMethod().equals("POST")) {
			// DB 업데이트 처리. 목록 이동.
			String id = req.getParameter("id"); // ("emp_id) 파라미터.
			String fname = req.getParameter("first_name");
			String lname = req.getParameter("last_name");
			String email = req.getParameter("email");

			Employee emp = new Employee();
			emp.setEmployeeId(Integer.parseInt(id));
			emp.setFirstName(fname);
			emp.setLastName(lname);
			emp.setEmail(email);

			EmpDAO dao = new EmpDAO();
			boolean result = dao.modifyEmployee(emp);


			if (result) {
				try {
					resp.sendRedirect("main.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					resp.sendRedirect("modifyMember.do");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
//			if(result) {
//				resp.sendRedirect("main.do");				
//			}else {
//				resp.sendRedirect("modifyMember.do");
//			}
//			=====>
			
		}

	}

}
