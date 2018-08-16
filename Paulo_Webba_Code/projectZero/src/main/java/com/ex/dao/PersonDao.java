package com.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ex.pojos.Person;
import com.ex.pojos.User;
import com.ex.pojos.bank_account;
import com.ex.service.personService;
import com.ex.util.ConnectionFactory;


public class PersonDao implements InterDao<Person,Integer> {
    
	static personService pService = new personService();
	
	public PersonDao() {}
	@Override
	public Person findOne(Integer id) {
		Person p = null;
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String sql = "select * from person where personid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet info = ps.executeQuery();
			while(info.next()) {
			p = new Person();
			p.setId(info.getInt(1));
			p.setFirstName(info.getString(2));
			p.setLastName(info.getString(3));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		try(Connection conn = ConnectionFactory
				.getInstance().getConnection()){
			String query = "select * from Person";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
		
			while(rs.next()) {
				Person temp = new Person();
				temp.setId(rs.getInt(1)); 
				String fname = rs.getString(2);
				temp.setFirstName(fname);
				String lname = rs.getString(3);
				temp.setLastName(lname);
				persons.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return persons;
	}
	

	@Override
	public Person save(Person obj) {
		try(Connection conn = ConnectionFactory.getInstance()
				.getConnection()){
			conn.setAutoCommit(false);
			String sql = "insert into person(personid, Firstname, Lastname, Address, phone, email, st, city, Zip) "+
			"values(person_seq.nextval,?,?,?,?,?,?,?,?)";
			
			//code to get back auto-generated PK (other columns can be auto generated too!)
			
			
			String[] keys = {"PersonID"};
			
			PreparedStatement ps = conn.prepareStatement(sql, keys);
			
			ps.setString(1, obj.getFirstName());
			ps.setString(2, obj.getLastName());
			ps.setString(3, obj.getAddress());
			ps.setString(4, obj.getPhone());
			ps.setString(5, obj.getEmail());
			ps.setString(6, obj.getState());
			ps.setString(7, obj.getCity());
			ps.setString(8, obj.getZipCode());
			
			int numRowsAffected = ps.executeUpdate();
			//System.out.println("NumAFFECTED: " + numRowsAffected);
			if(numRowsAffected>0) {
				ResultSet pk = ps.getGeneratedKeys();
				while(pk.next()) {
					//System.out.println(pk.toString());
					obj.setId(pk.getInt(1));
				}
				conn.commit();
			}
			
		} catch (SQLException e) {
			System.out.println("SQL Exception");
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Person update(Person obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person obj) {
		// TODO Auto-generated method stub
		
	}

	

}
