package tig058;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class myDB {
	Connection c;
	Statement s;
	ResultSet rs;
       public enum MODE {SELECT, INSERT};
    public static ResultSet kopplaDb(String query, MODE mode)  throws SQLException{
             public Connection createConnection() {
		Connection localConn = null;
		try { 
	    Class.forName("org.sqlite.JDBC"); //Sqlite-drivrutin
	} catch (ClassNotFoundException cnfe) {
		System.err.println("Couldn't find driver class:");
		cnfe.printStackTrace();
		System.exit(1);
	}
	System.out.println("Allt OK");
	
	try {
		localConn = DriverManager.getConnection("jdbc:sqlite:C:\\Zakia\\Desktop\\TIG058\\src\\databasen.db"); 
                        
	} catch (SQLException se) {
		System.out.println("Couldn't connect: print out a stack trace and exit.");
		se.printStackTrace();
		System.exit(1);
	}
	
	if (localConn != null)
		System.out.println("Hooray! We connected to the database!");
	else
		System.out.println("We should never get here.");

	return localConn;
}

public Statement myCreateStatement(Connection c) {
	Statement s = null;

	try {
		s = c.createStatement();
	} catch (SQLException se) {
		System.out.println("We got an exception while creating a statement:" +
			"that probably means we're no longer connected.");
		System.out.println(se.getMessage());
		System.exit(1);
	}
	return s;
}

public ResultSet myCreateResultSet(Statement s) {

	try {
		rs = s.executeQuery("SELECT * FROM medlem");
	} catch (SQLException se) {
		System.out.println("We got an exception while executing our query:" +
			"that probably means our SQL is invalid");
		System.out.println(se.getMessage());
		System.exit(1);
	}
	return rs;
}

public void printResultSet(ResultSet rs) {
	int index = 0;

	try {
		while (rs.next()) {
			System.out.print("Here's the result of row " + index++ + ": ");
			System.out.println(rs.getString(1) + " som bor i " + rs.getString(2));
		}
	} catch (SQLException se) {
		System.out.println("We got an exception while getting a result:this " +
			"shouldn't happen: we've done something really bad.");
		System.out.println(se.getMessage());
		System.exit(1);
	}


}
   private void allMembersKnapp(){
     
       
   }

    void runMe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

public void searchMember(String familyName) {
	c = createConnection();

	s = myCreateStatement(c);

	//s.executeQuery("SELECT * FROM medlem INNER JOIN Children ON medlem.Id=Children.id(parent)INNER JOIN funktion ON Children.id(parent)=funktion.id");
        

	printResultSet(rs);

}
/*public void searchMember(String id) {
	c = createConnection();

	s = myCreateStatement(c);

	s.executeQuery();
        

	printResultSet(rs);

}

inte klar*/
public void createMember() {
	c = createConnection();

	s = myCreateStatement(c);

	s.executeQuery("");

	printResultSet(rs);

}

public void runMe() {
	c = createConnection();

	s = myCreateStatement(c);

	rs = myCreateResultSet(s);

	printResultSet(rs);

}

}

