
package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.sql.*;



public class Database {
	
	public void findTopThree() {
				
		try {
			
			Connection	connection = null;
		
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			String queryString = "select * from scoreHistory order by score DESC limit 3"; 
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			System.out.println("Database connected"); 
			
			ResultSet rset = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int numColumns = rsmd.getColumnCount();
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			Set<String> columns = new HashSet<String>();
			//find the name of sql
			/*for (int i=1;i<=numColumns;i++) {
				System.out.println("column " + i + ": " +rsmd.getColumnName(i));
				m.put(rsmd.getColumnName(i), new Integer(i));
				columns.add(rsmd.getColumnName(i));
			}*/
			
			System.out.println("Results:");
			while (rset.next() ) {
				/*String result = "";
				for (String col : columns) {
					result += rset.getString(col);
					result += " ";
				}
				System.out.println(result);
				continue;*/
		        String  score= rset.getString("score");
		        String date = rset.getString("TIME");
		        String userName = rset.getString("userName");
		        System.out.println(score + " " + date + " " + userName);
			}
			
			/*String sql1 = "UPDATE Student SET LastName = 'Stevens' WHERE lastName = 'Stevensen'";
			String sql2 = "UPDATE Student SET LastName = 'Haddad' WHERE lastName = 'Smith'";
			// put errors in sql2 to in order to show who rollback works
			Statement stmt = connection.createStatement();
			stmt.execute(sql1);
			
			/* if autocommit is off:
			try { 
				stmt.execute(sql2);
			} catch (SQLiteException e) {
				connection.rollback();
			}
			connection.commit();
			*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void storeNewUser(String userName, int score) {
		try {
			Connection connection = null;
		
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db");
			String sql2 = "select score from scoreHistory where userName = ?";
			PreparedStatement findScore = connection.prepareStatement(sql2);
			findScore.setString(1,userName);
			ResultSet rset = findScore.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			String name = rset.getString("userName");
			System.out.println();
			//String queryString = "select * from scoreHistory order by score DESC limit 3"; 
					
			//String sql1 = "UPDATE Student SET LastName = 'Stevens' WHERE lastName = 'Stevensen'";
		}catch (SQLException e) {
			
		}	
	}
	


public static void main(String[] args) {
		Database db = new Database();
		db.findTopThree();
		//db.storeNewUser("yihan", 3);
		
}
}

