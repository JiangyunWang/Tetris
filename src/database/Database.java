
package database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class Database {
	
	public void findTopThree() {
				
		try {
			Connection	connection = null;
		
			connection = DriverManager.getConnection("jdbc:sqlite:javabook.db"); //current directory is projects/Tetris/src
			String queryString = "select * from scoreHistory order by score DESC limit 3"; 
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			//System.out.println("Database connected"); 
			
			ResultSet rset = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int numColumns = rsmd.getColumnCount();
			
			Map<String, Integer> m = new HashMap<String, Integer>();
		
			while (rset.next() ) {
		
		        String  score= rset.getString("score");
		        String userName = rset.getString("userName");
		        System.out.println(userName+ " " + score + " ");
			}
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void storeNewUser(String userName, int currscore) {
		
		
		try {
			Connection connection = null;
		
			connection = DriverManager.getConnection("jdbc:sqlite:..\\..\\javabook.db");
			String sql2 = "select score from scoreHistory where userName = ?";
			
			
			PreparedStatement findScore = connection.prepareStatement(sql2);
			
			findScore.setString(1,userName);
			
			
			ResultSet rset = findScore.executeQuery();
			
			
			if(rset.next()) {
				String s = rset.getString("score");
				int pastscore =  Integer.valueOf(s);
				String sql1 = "UPDATE scoreHistory SET score = ? WHERE userName = ?";
				PreparedStatement updating = connection.prepareStatement(sql1);
				updating.setInt(1, currscore);
				updating.setString(2, userName);
				updating.execute();
				
			}
			else {
				System.out.println("ye1");
				String sql1 = "INSERT INTO scoreHistory VALUES (?,?)";
				
				PreparedStatement updating = connection.prepareStatement(sql1);
				
				updating.setString(1, userName);
				updating.setInt(2, currscore);
				
				updating.execute();
				
			}
			
			
		}catch (SQLException e) {
			
		}	
	}
	

public static void main(String[] args) {
		Database db = new Database();
		db.findTopThree();
		//db.storeNewUser("SX", 67);
		
}
}

