package pharmacy_application_withSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Branch {
	public String branch_Location;
	public String branch_phone;
	
	public Branch(String place,String phone) {
		this.branch_Location=place;
		this.branch_phone=phone;
	}
	
	public Branch() {
		
	}	
	public void add_branch(Branch b) throws SQLException {
		Connection con=DBConnection.getConnection();
		String query="insert into branch values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, 0);
		pst.setString(2,b.branch_phone);
		pst.setString(3,b.branch_Location);
		pst.executeUpdate();
		System.out.println("Branch inserted Sucessfully");
	}

}
