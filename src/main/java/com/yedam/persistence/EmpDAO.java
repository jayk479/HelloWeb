package com.yedam.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.membership.McastServiceImpl.SenderThread;

import com.yedam.common.DAO;
import com.yedam.domain.Employee;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 단건조회
	public Employee getEmp(int empId) {

		String sql = "select * from employees where employee_id =?";
		conn = DAO.getConnect();
		Employee emp = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery(); // select 조회 시 사용
			if (rs.next()) { // 조회 시
				emp = new Employee();
				emp.setEmployeeId(empId);
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return emp;
	}

	// 사원 삭제
	public boolean deleteEmployee(int empId) {
		conn = DAO.getConnect();
		String sql = "delete from employees where employee_id = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);

			int r = psmt.executeUpdate();
			System.out.println("처리된 건수 : " + r);

			if (r > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}

	// 사원 수정
	public boolean modifyEmployee(Employee emp) {
		conn = DAO.getConnect();
		String sql = "update employees\r\n" + "set first_name = ?,\r\n" + "last_name = ?,\r\n" + "email = ?\r\n"
				+ "where employee_id =?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getFirstName());
			psmt.setString(2, emp.getLastName());
			psmt.setString(3, emp.getEmail());
			psmt.setInt(4, emp.getEmployeeId());

			int r = psmt.executeUpdate();
			System.out.println("처리된 건수 : " + r);

			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}

	// 사원 등록
	public boolean insertEmployee(Employee emp) {
		conn = DAO.getConnect();
		String sql = "insert into employees(employee_id, last_name, email, hire_date, job_id, first_name) values(employees_seq.nextval,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			psmt.setString(5, emp.getFirstName());

			int r = psmt.executeUpdate();
			System.out.println("처리된 건수 : " + r);

			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return false;
	}

	// 사원 목록(전체조회)
	public List<Employee> getEmpList() {
		List<Employee> list = new ArrayList<>();
		String sql = "select * from employees order by 1 desc";
		conn = DAO.getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // select 조회할때 사용함
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setJobId(rs.getString("job_id"));
				emp.setHireDate(rs.getString("hire_date"));

				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 로그인(사원번호, 이메일)
	public Employee loginCheck (Employee emp){
		conn = DAO.getConnect();
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ? AND EMAIL = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getEmail());
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				//값이 있으면 result인스턴스에 담아줌
				Employee result = new Employee();
				result.setEmployeeId(rs.getInt("employee_id"));
				result.setFirstName(rs.getString("first_name"));
				result.setLastName(rs.getString("last_name"));
				result.setEmail(rs.getString("email"));
				result.setJobId(rs.getString("job_id"));
				
				return result;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return null;
	}
}
