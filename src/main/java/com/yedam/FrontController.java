package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	
	
	//key & value 저장할 수 있는 컬렉션. Map
	Map<String, Control> map;
//	Map<String, Object> map;
//	Map<String, String> map;
	
	public FrontController() {
		System.out.println("FrontController() call.");
		map = new HashMap<>();
		
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() call.");
		map.put("/first.do", new FirstControl());
		map.put("/second.do", new SecondControl());
		map.put("/main.do", new MainCotrol());
		map.put("/.do", new MainCotrol());
		
		//사원 상세페이지(getMember.jsp)
		map.put("/getMember.do", new GetMemberControl());
		
		//사원정보 수정페이지(modifyMember.jsp) (modifyMemberServlnet)
		map.put("/modifyMember.do", new ModifyMemberControl());
		
		
		//사원 등록 화면(addMemverForm.do -> AddMemberFormControl.java (사원 등록 화면만 열어주면 됨) /WEB-INF/views/addForm.jsp
		map.put("/addMemberForm.do", new AddMemberFormControl());
		
		//등록 처리
		//addMember.do -> AddMemberControl.java
		//성공 :  main.do
		//실패 : addMemberForm.do
		map.put("/addMember.do", new AddMemberControl());

		//삭제 처리
		map.put("/deleteMember.do", new DelMemberFormControl());
		
		//로그인 화면
		map.put("/loginForm.do", new LoginFormControl());
		
		//로그인 처리
		map.put("/login.do", new LoginControl());
		
		//로그아웃
		map.put("/logout.do", new LogoutControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청 정보에 한글 : utf-8 타입 지정
		resp.setContentType("text/html;charset=utf-8");  //응답 정보에 한글 : utf-8 타입 지정
		
		
		System.out.println("service() call.");
		//http://localhost:8081/HelloWeb/first.do
		String uri = req.getRequestURI();  // 호스트 정보를 제외한 값 : /HelloWeb/first.do
		String context = req.getContextPath();  //context : /HelloWeb (프로젝트 이름)
		String page = uri.substring(context.length()); ///first.do를 잘라옴
		
		System.out.println(page);  // /first.do 출력
		System.out.println(map.get(page)); // map key 값 찾기
		
		Control control = map.get(page);  //상속받아서 Control 사용 가능
		control.exec(req, resp); 

	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() call.");
	}
}
