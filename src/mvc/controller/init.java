package mvc.controller;

import mvc.view.GameFrame;
import mvc.view.setFrame;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import mvc.model.LeftPanelModel;
import mvc.model.RightPanelModel;
import java.util.Timer;
import java.util.TimerTask;
public class init {
	
	public static void main(String[] args) {
    	//lpm.autoDown();
    	Controller c = new Controller();
    	c.move();
    	
    	
    	
    	
    	
    	
    /*	Connection c1 = null;

    	Statement stmt = null;

    	try {

    	//Class.forName("org.sqlite.JDBC");

    	c1 = DriverManager.getConnection("jdbc:sqlite:javabook.db");

    	System.out.println("Database Opened...\n");

    	stmt = c1.createStatement();

    	String sql = "drop table scoreHistory" ;

    	stmt.executeUpdate(sql);

    	stmt.close();

    	c1.close();

    	}

    	catch ( Exception e ) {

    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );

    	System.exit(0);

    	}*/
 
    	
    	
    }

	  
}
