package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class GetMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		// 매개값으로 사원번호 -> 요청정보에 담겨있음
		String id = req.getParameter("id");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(id));
		req.setAttribute("empInfo", emp);
//		 req 요청 정보에 setAttribute 매소드로 "empInfo 라는 이름으로 emp 정보를 담아서 넘겨줌
//		 -> getMember.jsp  ->  	Employee emp = (Employee) request.getAttribute("empInfo");
		
		//page 재지정 control -> getMember.jsp
		try {
			req.getRequestDispatcher("WEB-INF/views/getMember.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

//	맴버 조회 시 getMember.do로 확인 할 수 있음
//	--> http://localhost:8081/HelloWeb/getMember.do?id=206
