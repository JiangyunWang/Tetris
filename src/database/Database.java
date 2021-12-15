
package database;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Database {
	
	public ArrayList<String> findTop() {
		ResultSet rset = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection	connection = null;
		
			connection = DriverManager.getConnection("jdbc:sqlite:..\\..\\javabook.db"); //current directory is projects/Tetris/src
			String queryString = "select * from scoreHistory order by score DESC limit 1"; 
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			//System.out.println("Database connected"); 
			
			 rset = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			int numColumns = rsmd.getColumnCount();
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			 String  score = null;
			 String userName = null;
			while (rset.next() ) {
				
		        score= rset.getString("score");
		        userName = rset.getString("userName");
		        
		       // System.out.println(userName+ " " + score + " ");
			}
			
			
			list.add(score);
			list.add(userName);
			
			
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		//System.out.println(list.get(0) + list.get(1));
		return list;
	}
	
	
	public void storeNewUser(String userName, int currscore) {
		//string is null
		
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
				if(currscore > pastscore) {
					String sql1 = "UPDATE scoreHistory SET score = ? WHERE userName = ?";
					PreparedStatement updating = connection.prepareStatement(sql1);
					updating.setInt(1, currscore);
					updating.setString(2, userName);
					updating.execute();
				}
				
			}
			else {
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
		db.findTop();
		//db.storeNewUser("SX", 67);
		
}
}

