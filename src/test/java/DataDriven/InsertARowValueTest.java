package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertARowValueTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
         //step 01 register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//step 02 eshtablish the connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		
		//step 03 issue the statement
		Statement statement = connection.createStatement();
		
		//step 04 execute the query
		int result = statement.executeUpdate("insert into student_info values('4','manju','gajre','glb')");
		if(result==1) {
			System.out.println("Data is added to the database");
		}else {
			System.out.println("Data is not added to the database");
		}
		//step 05 close the connection
		
		connection.close();
		
	}

}
