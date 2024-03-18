package pharmacy_application_withSQL;

import java.util.Scanner;
import java.sql.*;
public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		Branch branch=new Branch();
		Customer customer=new Customer();
		Purchase purchase=new Purchase();
		Stock stock=new Stock();
		while(true) {
			System.out.println("---------------------------");
			System.out.println("1.Add a Branch");
			System.out.println("2.Add a product to pharmacy");
			System.out.println("3.Add a Customer");
			System.out.println("4.Purchase Product");
			System.out.println("5.print purchase summary");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
			{
				System.out.println("Enter the Branch Location :");
				String branch_name=sc.next();
				System.out.println("Enter the Branch Phone Number :");
				String phone=sc.next();
				Branch b=new Branch(branch_name,phone);
				branch.add_branch(b);
				break;
			}
			case 2:
			{
				System.out.println("Enter the branch Id");
				int id=sc.nextInt();
				System.out.println("Enter the medicine");
				String medicine=sc.next();
				System.out.println("Enter the Quantity");
				int qty=sc.nextInt();
				System.out.println("Enter the price");
				int price=sc.nextInt();
				Stock s=new Stock(id,medicine,qty,price);
				stock.add_stock(s);
				break;
			}
			case 3:
			{
				System.out.println("Enter Customer Name :");
				String name=sc.next();
				System.out.println("Enter the Customer Phone Number :");
				String phone=sc.next();
				Customer cus=new Customer(name,phone);
				customer.add_customer(cus);
				break;
			}
			case 4:
			{
				System.out.println("Enter the Customer id");
				int id=sc.nextInt();
				System.out.println("Enter the Branch id");
				int b_id=sc.nextInt();
				System.out.println("Enter the product");
				String medicine=sc.next();
				System.out.println("Enter the Quantity");
				int qty=sc.nextInt();
				Purchase pur=new Purchase(id,b_id,medicine,qty);
				purchase.Order(pur);
				break;
			}
			}
		}
		
	}

}
