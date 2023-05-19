<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
	<%
		Employee emp = (Employee) request.getAttribute("empInfo"); //empInfo = id 정보(parameter)
		/*EmpDAO dao = new EmpDAO();
		Employee result = dao.getEmp(Integer.parseInt(id));*/
	%>
	<table border="1">
		<tr>
		  <th>사원번호</th>
		  <td><%=emp.getEmployeeId() %></td>
		</tr>
		<tr>
		  <th>이름</th>
		  <td><%=emp.getFirstName()+"_"+emp.getLastName()%></td>
		</tr>
		<tr>
		  <th>직무</th>
		  <td><%=emp.getJobId() %></td>
		</tr>
	</table>
<jsp:include page="footer.jsp"></jsp:include>
