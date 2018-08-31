package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ex.pojos.Employee;
import com.ex.util.ConnectionFactory;


public class EmployeeDao implements Dao<Employee, Integer> {

	@Override
	public List<Employee> findAll() {
		
		List<Employee> employee = new ArrayList<Employee>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
			String query = "select * from Employee";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				Employee temp = new Employee();
				temp.setEmpID(rs.getInt(1));
				temp.setUsername(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setFirstname(rs.getString(4));
				temp.setLastname(rs.getString(5));
				temp.setEmail(rs.getString(6));
				temp.setRoleID(rs.getInt(7));
				employee.add(temp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee findOne(Integer id) {
		return null;
	}
	
	public Employee findOneEmp(String username) {
    	Employee temp = null;
	        try(Connection conn = ConnectionFactory
	                .getInstance().getConnection()){
	            String sql = "select * from employee where emp_username = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, username);
	            ResultSet rs = ps.executeQuery( );
	            
	        while(rs.next()) {
	                temp = new Employee();
	                temp.setEmpID(rs.getInt(1));
	                temp.setUsername(rs.getString(2));
	                temp.setPassword(rs.getString(3));
	                temp.setFirstname(rs.getString(4));
	                temp.setLastname(rs.getString(5));
	                temp.setEmail(rs.getString(6));
	                temp.setRoleID(rs.getInt(7));
	            }
	            
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return temp;
	    }
	

	@Override
	public Employee save(Employee obj) {
		return null;
	}

	@Override
	public Employee update(Employee obj) {
		return null;
	}

	@Override
	public void delete(Employee obj) {
		
	}

}
