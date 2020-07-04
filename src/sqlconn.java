import java.sql.*;
import javax.swing.*;


public class sqlconn extends FirstGui {

	Connection conn= null;
	public static int temp;
	public static String atp;
	public static void main(String args[]) {
		//temp = amount_remaining;
		//atp = FirstGui.total_pan;
		//System.out.println(atp);
		sqlconn();
		
	}
	public static void sqlconn() {
		try {
				
//				Class.forName("org.sqlite.JDBC");
//				int amount =30000050;
//				Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
//				Statement stmt = conn.createStatement();
//				String sql = "UPDATE balance SET amount= ? WHERE PAN = ?";
//				PreparedStatement pst = conn.prepareStatement(sql);
//				
//				
//	            //pst.setInt(1,amount_remaining);
//	            pst.setInt(1, amount);
//	            pst.setString(2, "1234 5678 5678 1234");
//	            pst.executeUpdate();
//				
//				conn.close();
//				System.out.println("no error");
//				JOptionPane.showMessageDialog(null, "payment successful..");
	//			Class.forName("org.sqlite.JDBC");
	//			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
	//			Statement stmt = conn.createStatement();
	//
	////			String query = "select * from ATM where PAN = ? "
	////		             + "OR PIN = ?";
	//			int amount_left = 20000000;
	//			String sql = "UPDATE balance SET amount= "+amount_left+ " WHERE PAN = ?";
	//			PreparedStatement pst = conn.prepareStatement(sql);
	//            //pst.setInt(1,150000);
	//            pst.setString(1, "1234 5678 5678 1234");
	//            int rs = pst.executeUpdate();
	//			
	////			while(rs.next())
	////				System.out.println(rs.getString(1)+" "+rs.getString(2));
	//			
	//			conn.close();
	//			System.out.println("no error");
			} 
			catch (Exception e) {
				// TODO: handl exception
				JOptionPane.showMessageDialog(null, "error");
			}
		
	}

}
