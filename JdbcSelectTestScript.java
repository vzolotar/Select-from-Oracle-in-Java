//javac -cp ojdbc7.jar JdbcSelectTest.java
//java -cp .;ojdbc7.jar JdbcSelectTest 
//java -cp .;ojdbc7.jar JdbcSelectTest > JdbcSelectTest.log


import java.sql.*;
public class JdbcSelectTest {
	public static void main(String[] args) {
		try (
		Connecion conn = DriverManager.get.Connection("jdbc:oracle:thin:@prod.myhost.com:1525/USERS","myusername","mypassword");
		Statement stmt = conn.createStatement();
		) 	{
			String strSelect = "select SCHEMA_NAME, TABLE_NAME, ROW_COUNT from MYSCHEMA.TABLE_NAME_T";
			System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo for debugging

			ResultSet rset = stmt.executeQuery(strSelect);

			System.out.println("The records selected are:");
			int rowCount = 0;
			while(rset.nect()) {
				String title = rset.getString("SHAMA_NAME");
				String price = rset.getString("TABLE_NAME");
				String qty = rset.getString("ROW_COUNT");
				System.out.println("title + ", " + price + ", " + qty);

				++rowCount;
				}
				System.out.println("Total number of records =  " + rowCount);

			} catch(SQLException ex)  {
				ex.prin	tStackTrace();
			}
		}
}
