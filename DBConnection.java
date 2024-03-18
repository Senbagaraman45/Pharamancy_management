package pharmacy_application_withSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	public static  String  url="jdbc:mysql://127.0.0.1:3306/pharmacyApplication";
    public static  String username="springstudent";
    public static String password="springstudent";

    public static ResultSet readDB(String query) throws SQLException{

       Connection con=DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
        return st.executeQuery(query);
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,username,password);
    }

}
