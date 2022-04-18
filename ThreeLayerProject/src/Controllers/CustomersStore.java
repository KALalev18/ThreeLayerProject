package Controllers;

import Model.Customer;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class CustomersStore {
	String url = "jdbc:sqlserver://localhost\\SQLEXPRESS01;databaseName=Project_Database;encrypt=false;trustServerCertificate=true";
	private Connection conn;

	public CustomersStore() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public List<Customer> getCustomers() throws SQLException {
		List<Customer> customers = new ArrayList<Customer>();
		String query = "SELECT TOP 5 * FROM sales.customers";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) 
		{
			Customer customerObj = new Customer();
			customerObj.setUser_ID(Integer.parseInt(rs.getString("User_ID")));
			customerObj.setRegistration_ID(Integer.parseInt(rs.getString("Registration_ID")));
			customerObj.setUser_Email(rs.getString("User_Email"));
			customerObj.setUser_Password(rs.getString("User_Password"));
			customerObj.setFirst_Name(rs.getString("First_Name"));
			customerObj.setLast_Name(rs.getString("Last_Name"));
			customerObj.setPhone_Number(rs.getString("Phone_Number"));
			System.out.println(customers);
		}
		return customers;
	}

	public void showCustomers() throws SQLException {
		String query = "SELECT TOP 5 * FROM dbo.User_Info";
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(Integer.parseInt(rs.getString("User_ID"))));
			System.out.println(rs.getString(Integer.parseInt(rs.getString("Registration_ID"))));
			System.out.println(rs.getString("User_Email"));
			System.out.println(rs.getString("User_Password"));
			System.out.println(rs.getString("First_Name"));
			System.out.println(rs.getString("Last_Name"));
			System.out.println(rs.getString("Phone_Number"));
		}
	}

	public void showCustomerById(int id) throws SQLException {
		String query = "Select * From dbo.User_Info WHERE User_ID = ? " + id;
		PreparedStatement stmt = conn.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(Integer.parseInt(rs.getString("User_ID"))));
			System.out.println(rs.getString(Integer.parseInt(rs.getString("Registration_ID"))));
			System.out.println(rs.getString("User_Email"));
			System.out.println(rs.getString("User_Password"));
			System.out.println(rs.getString("First_Name"));
			System.out.println(rs.getString("Last_Name"));
			System.out.println(rs.getString("Phone_Number"));
		}
	}

	public void updateCustomer(int id, String fName, String lName) throws SQLException {
		String query = "UPDATE dbo.User_Info " + "SET First_Name = ?, Last_Name = ? " + "WHERE User_ID = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, fName);
		stmt.setString(2, lName);
		stmt.setInt(3, id);
		int rowsAffected = stmt.executeUpdate();
		System.out.println(String.format("Rows affected: %d", rowsAffected));
	}

	public void deleteCustomer(int id) throws SQLException {
		String query = "DELETE FROM dbo.User_Info " + "WHERE User_ID = ? ";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		int rowsAffected = stmt.executeUpdate();
		System.out.println(String.format("Rows affected: %d", rowsAffected));
	}
}