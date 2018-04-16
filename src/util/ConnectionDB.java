package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionDB  {
   private static Connection conn;
   private  static Connection connection() throws ClassNotFoundException,SQLException{
	   Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ROOT");
		return conn;
   }
   public static Connection getConnection()throws ClassNotFoundException,SQLException{
	if(conn==null){
		return connection();
	}else{
		return conn;
	}
}
}