
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakia
 */
class Metoder {

    public enum MODE {SELECT, INSERT};
    public static Connection c;
    public static ResultSet kopplaDb(String query, MODE mode)  throws SQLException { 
        try { //EN EGEN METOD EGENTLIGEN FÖR FÖRSTA DRIVRUTINKONTROLLEN
            Class.forName("org.sqlite.JDBC"); 
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:" + cnfe.getMessage());
            System.exit(1);
        }
        System.out.println("Allt OK");
        
	Statement stat = null;
        ResultSet rs = null;
        try { 
            c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Zakia\\Desktop\\TIG058\\src\\databasen.db");//EV PEKA PÅ JAVA FOLDERN SÖKVÄGEN SOM SKAPAR I C:\Users\Robban\Documents\NetBeansProjects\test
            //System.out.print(" connection ser ut så här_ " + c);
            if (mode == MODE.SELECT) { 
                stat = c.createStatement();
                rs = stat.executeQuery(query);
            } else if (mode == MODE.INSERT) {
                stat = c.createStatement();
                stat.executeUpdate(query);
            }
        } catch (SQLException se) {
		System.out.println("We got an exception while executing our query:" +	
				"that probably means our SQL is invalid: " + se.getMessage() );
		System.exit(1);
	} catch (Exception e) {
            System.out.println("Could not create connection to database: "+ e.getMessage());
        }
                        
        if (c != null) {
              System.out.println("Hooray! We connected to the database!");
        } else {
              System.out.println("We should never get here.");
        }
    
        c.close();
        return rs;
    }

 
                
}


