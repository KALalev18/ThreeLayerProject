package Main;

import Model.Customer;
import Controllers.CustomersStore;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Main
{
	public static void main(String[] args) throws SQLException 
	{
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));

		CustomersStore cs = new CustomersStore();

		cs.showCustomers();

		System.out.println();
		System.out.println("Delete statement: ");
		System.out.println();

		cs.deleteCustomer(7);

		System.out.println();
		System.out.println("Update statement: ");
		System.out.println();

		cs.updateCustomer(8, "Mike", "Qdeneto");

		System.out.println();
		System.out.println("Insert statement: ");
		System.out.println();
	}

}
