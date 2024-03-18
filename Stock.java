package pharmacy_application_withSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Stock {
	
	private int branch_id;
	private String medicine;
	private int quantity;
	private int price;
	
	public Stock(int id,String medicine,int qty,int price) {
		this.branch_id=id;
		this.medicine=medicine;
		this.quantity=qty;
		this.price=price;
	}
	
	public Stock() {
		
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void add_stock(Stock s) throws SQLException {
		Connection con=DBConnection.getConnection();
		String query="insert into stock values(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, s.branch_id);
		pst.setString(2,s.medicine);
		pst.setInt(3,s.quantity);
		pst.setInt(4,s.price);
		pst.executeUpdate();
		System.out.println("Stock Added Succesfully");
	}
	
}
