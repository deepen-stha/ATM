import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class PieChart_AWT extends ApplicationFrame {
	
	public static String temp;
   
   public PieChart_AWT( String title ) {
      super( title ); 
      setContentPane(createDemoPanel( ));
   }
   
   private static PieDataset createDataset( ) {
	   temp = FirstGui.total_pan;
	   System.out.println(temp);
	   
	   try {
			//connecting to the database
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\customer.db");
			Statement stmt = conn.createStatement();
			
			//temp ="1234 5678 5678 1234";
			String query="Select * from Expenses WHERE PAN =? ";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,temp);
			 
			ResultSet rs = pst.executeQuery();
			DefaultPieDataset dataset = new DefaultPieDataset( );
		    dataset.setValue( "Rent" , new Double( rs.getInt(1) ) );  
		    dataset.setValue( "Water" , new Double( rs.getInt(3) ) );   
		    dataset.setValue( "Electricity" , new Double( rs.getInt(2) ) );    
		    dataset.setValue( "Savings" , new Double( rs.getInt(4) ) );  
		    
		    
			conn.close();
		    return dataset;         
			 
		}
		
		catch(Exception e1) {
			//if you donot enter the correct pan and pin
			System.out.println(e1);
			return null;
		}
	//return dataset;		
	   
     }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "EXPENDTURE",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( ) {
      JFreeChart chart = createChart(createDataset( ) );  
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
      PieChart_AWT demo = new PieChart_AWT( "EXPENDITURE VS SAVING" );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}