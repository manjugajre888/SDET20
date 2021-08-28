package DataDriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteRowFromTableByFinallyBlockTest {
           
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		 Connection connection=null;
		        try {
				//step 01 register the driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//step 02 eshtablish the connection
			     connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");	
				//step 03 issue the statement
				Statement statement = connection.createStatement();
				
				//step 04 execute the query
				int result = statement.executeUpdate("delete from student_info where regno='6'");
				
				if(result==1) {
					System.out.println("Data is deleted");
				}else {
					System.out.println("Data is not deleted");
				}
		        }catch(Exception e) {
		        	
		        }finally {
		        	//step 05 close the connection
					connection.close();

		        }
	}

}
