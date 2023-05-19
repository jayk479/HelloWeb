package com.yedam;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class MainCotrol implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		try {
//			views 하위 파일에 접근 못해서 새로 지정하는 로그
//			=>페이지 재지정
			
			//resp.sendRedirect()
//			-> 응답정보가 가지고 있는 정보를 가지고 페이지 재지정
//			-> 내.외부 값을 가능
//			-> 파라미터 값은 받아올 수 없음.
			
			//empList.jsp 
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			
			req.setAttribute("listInfo", list);  // ---> 참조 list 정보를 listInfo라는 이름으로 empList.jsp에 재 지정
			
			//요청정보가 가지고 있는 정보를 가지고 페이지 재지정
//			req.getRequestDispatcher("WEB-INF/views/empList.jsp").forward(req, resp);  
//			======>
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/empList.jsp");
			rd.forward(req, resp);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}

	}

}


//		HelloWeb 접속 -> web.xml : index.jsp -> /main.do -> empList.jsp 활성화



