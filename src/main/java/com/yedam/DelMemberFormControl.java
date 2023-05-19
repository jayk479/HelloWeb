package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class DelMemberFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		
		// 삭제 처리
		String id = req.getParameter("id");

		EmpDAO dao = new EmpDAO();		// instance 선언
		boolean result = dao.deleteEmployee(Integer.parseInt(id));

		if (result) {
			try {
				resp.sendRedirect("main.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("modifyMember.do?id="+id);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
