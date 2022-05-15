package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Power {
	// Connect to the DB
	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powermanagementdb", "root", "");

			// For testing
			System.out.print("Succesfully connected to the DB");
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}

	         //Insert Power
			public String insertPower(String District, String ConsumedPower, String Month, String Year, String NoOfHours,String NoOfDays,String PowerSaved)
			{ 
				Connection con = connect();
				String output = "";
				try
				 { 
					  
					 if (con == null) 
					 { 
					    return "Error while connecting to the database"; 
					 } 
					 
					 // create a prepared statement
					 String query = " insert into powermanagement (PlanID,District,ConsumedPower,Month,Year, NoOfHours, NoOfDays,PowerSaved)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
					 PreparedStatement Pstatement = con.prepareStatement(query); 
					 
					 // binding values
					 Pstatement.setInt(1, 0); 
					 Pstatement.setString(2, District); 
					 Pstatement.setString(3, ConsumedPower); 
					 Pstatement.setString(4, Month); 
					 Pstatement.setString(5, Year);
					 Pstatement.setString(6, NoOfHours);
					 Pstatement.setString(7, NoOfDays);
					 Pstatement.setString(8, PowerSaved);
					 
					 
					//execute the statement
					 
					 Pstatement.execute(); 
					 con.close();
					// System.out.println(query);
					 String newPower = readPower(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newPower + "\"}"; 
					 
					// output = "Power Inserted successfully"; 
				 } 
				
				catch (Exception e) 
				 { 
					 output = "{\"status\":\"error\", \"data\": \"Error while inserting the Power.\"}"; 
					// output = "Error while inserting"; 
					 
					System.err.println(e.getMessage()); 
				 } 
				//binding values
				return output; 
			}

			//Read the Power
			public String readPower()
			{ 
				 String output = ""; 
				 
				 try
				 { 
				
			     Connection con = connect(); 
				 if (con == null) 
				 { 
					 return "Error while connecting to the database for reading the Power."; 
				 } 
				 
				 
				 // Prepare the html table to be displayed
				 output = "<table border='1' class='table bg-dark text-light text-center table-hover'>"
				 		 + "<tr><th>District</th>" 
						 +"<th>ConsumedPower</th>"
						 + "<th>Month</th>"
						 + "<th>Year</th>" 
						 +"<th>NoOfHours</th>"
						 +"<th>NoOfDays</th>"
						 +"<th>PowerSaved</th>"
						 +"<th>Update</th>"
						 + "<th>Delete</th></tr>"; 
				 
				 String query = "select * from powermanagement"; 
				 
				 Statement stmt = (Statement) con.createStatement(); 
				 ResultSet res = ((java.sql.Statement) stmt).executeQuery(query); 
				 
				 // iterate through the rows in the result set
				 while (res.next()) 
				 { 
					 String PlanID  = Integer.toString(res.getInt("PlanID")); 
					 String District  = res.getString("District"); 
					 String ConsumedPower  = res.getString("ConsumedPower"); 
					 String Month  = res.getString("Month"); 
					 String Year  = res.getString("Year"); 
					 String NoOfHours  = res.getString("NoOfHours"); 
					 String NoOfDays   = res.getString("NoOfDays"); 
					 String PowerSaved   = res.getString("PowerSaved");
					 
					 // Add a row into the html table
					 output += "<tr><td>" + District  + "</td>"; 
					 output += "<td>" + ConsumedPower + "</td>"; 
					 output += "<td>" + Month  + "</td>";
					 output += "<td>" + Year  + "</td>"; 
					 output += "<td>" + NoOfHours   + "</td>";
					 output += "<td>" + NoOfDays   + "</td>"; 
					 output += "<td>" + PowerSaved    + "</td>"; 
					 
					 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' "
							 + "class='btnUpdate btn btn-secondary' data-powerid='" + PlanID  + "'></td>"
							 + "<td><input name='btnRemove' type='button' value='Remove' "
							 + "class='btnRemove btn btn-danger' data-powerid='" + PlanID + "'></td></tr>";
				 } 
				 
				con.close(); 
				
				     // Complete the html table
				     output += "</table>"; 
				 } 
				 
				catch (Exception e) 
				 { 
					 output = "Error while reading the Power details."; 
					 System.err.println(e.getMessage()); 
				 } 
				
				
				return output; 
			}

	// Update buyers in the table
	public String updatePower(String PlanID, String District , String ConsumedPower, String Month, String Year, String NoOfHours,String NoOfDays,String PowerSaved)
			{ 
				 String output = ""; 
				 try
				 { 
				 Connection con = connect(); 
				 if (con == null) 
				 {
					 return "Error while connecting to the database for updating the power."; 
					 
				 } 
				 // create a prepared statement
				 String query = "UPDATE powermanagement  SET District =?,ConsumedPower =?,Month =?,Year =?,NoOfHours=?,NoOfDays=?,PowerSaved=? WHERE PlanID =? ";
					
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 
				 preparedStmt.setString(1, District); 
				 preparedStmt.setString(2, ConsumedPower); 
				 preparedStmt.setString(3, Month); 
				 preparedStmt.setString(4, Year); 
				 preparedStmt.setString(5, NoOfHours); 
				 preparedStmt.setString(6, NoOfDays); 
				 preparedStmt.setString(7, PowerSaved ); 
				 preparedStmt.setInt(8, Integer.parseInt(PlanID)); 
				 
				 
				 // execute the statement
				    preparedStmt.execute(); 
				    con.close(); 
				    String newPower = readPower(); 
					 output = "{\"status\":\"success\", \"data\": \"" + 
					 newPower + "\"}"; 
					 
				   // output = "Power Updated successfully"; 
				 } 
				 
				 catch (Exception e) 
				 { 
					 output = "{\"status\":\"error\", \"data\": \"Error while Updating the Power.\"}"; 
				     //output = "Error while updating the power details."; 
				     System.err.println(e.getMessage()); 
				 } 
				 
				 return output; 
				 }

	// Delete buyer in the table
	public String deletePower(String PlanID ) {
		String output = "";

		try {
			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database for deleting the Power.";
			}

			// create a prepared statement
			String query = "delete from powermanagement where PlanID =?";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(PlanID));

			// execute the statement
			preparedStmt.execute();
			con.close();

			  String newPower = readPower(); 
				 output = "{\"status\":\"success\", \"data\": \"" + 
				 newPower + "\"}"; 
		//	output = "Power details Deleted successfully";

		} catch (Exception e) {
			 output = "{\"status\":\"error\", \"data\": \"Error while Deleting the Power.\"}"; 
		//	output = "Error while deleting the Power details.";
			System.err.println(e.getMessage());
		}

		return output;
	}

}

