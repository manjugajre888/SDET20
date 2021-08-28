package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDataBaseByFinallyBlockTest {
 
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 Connection connection=null;
		try {
		//step 01 register the data
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//step 02 eshtablish the connection
		 connection = DriverManager.getConnection("'jdbc:mysql://localhost:3306/student", "root", "root");
		
		//step 03 issue the statement
		Statement statement = connection.createStatement();
		
		//step 04 execute the query
		ResultSet result = statement.executeQuery("select*from student_info");
		
		while(result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		}catch(Exception e) {
			
		}finally {
			//step 05 close the connection
			connection.close();
		}
		

	}

}
