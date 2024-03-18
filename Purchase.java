package pharmacy_application_withSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Purchase {
	
	private int customer_id;
	private int branch_id;
	private String medicine;
	private int quantity;
	
	public Purchase(int id,int b_id,String medicine,int qty) {
		this.customer_id=id;
		this.branch_id=b_id;
		this.medicine=medicine;
		this.quantity=qty;
	}
	
	public Purchase() {
		
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void Order(Purchase p) throws SQLException {
		int id=p.branch_id;
		String query="select medicine,quantity,price from stock where branch_id="+id;
		ResultSet set=DBConnection.readDB(query);
		set.next();
		String medicine=set.getString(1);
//		String query1="select quantity,price from stock where branch_id="+p.branch_id+"and medicine="+p.medicine;
//		ResultSet set1=DBConnection.readDB(query1);
		int qty=set.getInt(2);
		int price=set.getInt(3);
		if(qty<=0) {
			System.out.println("Stock is Not Available");
			return;
		}
		int amount=price*p.quantity;
		int new_qty=qty-p.quantity;
		
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		String query2="Update stock set quantity="+new_qty+" where branch_id="+id;
		st.executeUpdate(query2);
		
		String transaction="insert into purchase values(?,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(transaction);
		pst.setInt(1,0);
		pst.setInt(2,p.branch_id);
		pst.setInt(3,p.branch_id);
		pst.setString(4,p.medicine);
		pst.setInt(5,p.quantity);
		pst.setInt(6, amount);
		pst.executeUpdate();
		System.out.println("Order Successfully Placed");
		
	}

}
