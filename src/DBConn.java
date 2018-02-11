import java.sql.*;

public class DBConn {
	String connectionURL;
	Connection con = null;



	public void ConnectDB () {
		//DBConnections
		try {
			connectionURL = "jdbc:sqlserver://localhost:1433;"+"databaseName=FantaspickDB;integratedSecurity=true;";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionURL);
			System.out.println("Connected");
		} catch (Exception e) {
			System.err.println(e);
		}
	}


	public void ModDB(String inputQuery) { // add to database 
		String SQL = inputQuery;
		try {			
			con.createStatement().execute(SQL); //send and execute SQL manipulation statement
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void QueryDB(String inputQuery) {  //use to Query database
		ResultSet result = null;		
		String SQL = inputQuery;

		try {
			result = con.createStatement().executeQuery(SQL); //send and execute query on SQL
			int columnsNumber = result.getMetaData().getColumnCount(); // Get the length (# of columns) in result set			
			while (result.next()) { //Concatenate DB results & print
				for(int i = 2; i < columnsNumber; i++)
					System.out.print(result.getString(i) + " ");
				System.out.println();
			}
		}catch (Exception e)		{
			e.printStackTrace();
		}

	}




}//end class
