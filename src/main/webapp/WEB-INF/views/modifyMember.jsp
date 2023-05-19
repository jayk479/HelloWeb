<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

	<%
		/*String id = request.getParameter("id");
		EmpDAO dao = new EmpDAO();
		Employee result = dao.getEmp(Integer.parseInt(id));*/
		Employee result = (Employee) request.getAttribute("empInfo");
	%>
	
	<!-- <form action="modifyMemberServlet"> -->
	<!-- 요청 방식을 post로 해서 modifyMember.jsp랑 구분해서 실행시킴 -->
	<form action="modifyMember.do" method ="post">
		<table border="1">
			<tr><th>사원번호</th><td><input type="text" name="id" value="<%=result.getEmployeeId() %>"></td></tr>
			<tr><th>Fristname</th><td><input type="text" name="first_name" value="<%=result.getFirstName() %>"></td></tr>
			<tr><th>Lastname</th><td><input type="text" name="last_name" value="<%=result.getLastName() %>"></td></tr>
			<tr><th>Email</th><td><input type="text" name="email" value="<%=result.getEmail() %>"></td></tr>
			<tr><td colspan="2">
				<input type="submit" value="수정">  <input type="button" value="삭제">
			</td></tr>
		</table>
	</form>
	
	<script>
	//Document Object Model.  
	// btn == Object  //btn.onclick = 메소드 / 함수 실행
		let btn = document.querySelector('input[type="button"]')
		console.log(btn);
		btn.onclick = function(){
			//alert("클릭되었습니다.");
			//삭제하는 함수 생성 후 실행
			//form 태그 읽어옴
			let frm = document.querySelector('form');
			frm.action = "deleteMember.do"; 
			frm.submit();  //form 태그 안에 있는 submit 실행됨
		}
	</script>
	
<jsp:include page="footer.jsp"></jsp:include>




