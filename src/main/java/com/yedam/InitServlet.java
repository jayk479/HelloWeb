package com.yedam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//페이지 호출 로그
@WebServlet("/initServlet")
public class InitServlet extends HttpServlet{
	
	//서블릿 : 서버측에서 실행되는 웹페이지(자바코드)
	//	tomcat 컨테이너가 실행시켜줌.<->클라이언트의 요청이 있어야 실행. 
	//	-> url : locahost:8081/HelloWeb/initServlet
	// java 확장자 -> .class 파일 컴파일이 된 후 .class 파일이 실행.
	// ==>server restart
	public InitServlet() {
		System.out.println("InitServlet() Call.");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() Call.");
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() Call.");
		//크롬 새로고침 하면 service() Call만 실행됨
		
		//화면에 출력되는 컨텐츠 타입지정 - 한글 지정
		resp.setContentType("text/html;charset=UTF-8");
		
		//사용자 화면에 출력 : html -> "출력스트림" 생성 (HttpServletResponse : 응답 처리해주는 기능 == resp)
		PrintWriter out = resp.getWriter(); //출력스티림 생성.
		out.print("initServlet 페이지 입니다.");
		out.print("<h3>InitPage</h3>");
		out.print("<a href='index.html'>index 페이지로</a>");
	}
	
}
