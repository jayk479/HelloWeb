<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

	<%
		/*EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpList();*/
		
		//req에 담아둔 listInfo 정보 받아옴
		//request.getAttribute("listInfo");
		//--> list 형태로 반환하기 위해 캐스팅 (List로 형태 맞춰줘야 함)
		List<Employee> list = (List<Employee>) request.getAttribute("listInfo"); //반환유형 : Object (제일 상위에 있음)
		
		String fname = (String)request.getAttribute("reqInfo");
		String lname = (String)session.getAttribute("sesInfo");
	
	%>
	
	<p>Request : <%=fname %></p>
	<p>Session : <%=lname %></p>
	<table class="table">
		<thead>
			<tr><th>사원번호</th><th>이름</th><th>이메일</th><th>입사일</th><th>직무</th></tr>
		</thead>
		<tbody>
			<% for(Employee emp : list){
			%>
			<tr><td><a href="getMember.do?id=<%=emp.getEmployeeId() %>"><%=emp.getEmployeeId() %></a></td>
			<td><a href="modifyMember.do?id=<%=emp.getEmployeeId() %>"><%=emp.getFirstName()%></a></td>
			<td><%=emp.getEmail() %></td>
			<td><%= emp.getHireDate()%></td>
			<td><%=emp.getJobId() %></td></tr>
			<%} %>
		</tbody>
	</table>
	
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- <hr><a href="addMemberForm.do"> ▶ 회원 등록</a>
	<br><br><a href="delMemberForm.do"> ▶ 회원 삭제</a> -->
