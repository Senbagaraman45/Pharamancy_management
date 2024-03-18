package pharmacy_application_withSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
	
	private String name;
	private String phone;
	
	public Customer(String name,String phone) {
		this.name=name;
		this.phone=name;
	}
	
	public Customer() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void add_customer(Customer c) throws SQLException {
		Connection con=DBConnection.getConnection();
		String query="insert into customer values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, 0);
		pst.setString(2,c.name);
		pst.setString(3,c.phone);
		pst.executeUpdate();
		System.out.println("Branch inserted Sucessfully");
	}

}
