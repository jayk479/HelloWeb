<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

	<%		
	String lname = (String)session.getAttribute("sesInfo"); 
	%>
	
	<p>Session : <%=lname %></p>
	<form action="addMember.do">
	  <table border="1">
		<tr><th>First Name</th><td><input name="fname"></td></tr>
		<tr><th>Last Name</th><td><input name="lname"></td></tr>
		<tr><th>Email</th><td><input name="email"></td></tr>
		<tr><th>Job</th><td><input name="job"></td></tr>
		<tr><th>Hire Date</th><td><input name="hdate"></td></tr>
	  </table><br>
	  <input type="submit" value = "저장">
	</form>
<jsp:include page="footer.jsp"></jsp:include>
