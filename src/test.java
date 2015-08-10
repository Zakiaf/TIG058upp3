
import java.sql.ResultSet;
import java.sql.*;
import java.util.*;
import javax.swing.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zakia
 */
public class test {
    public static String infoExists(String query) //kolla ifall namn existerar
  {
      ResultSet rs;
      String efternamn = null;
      try {
          rs = Metoder.kopplaDb(query, Metoder.MODE.SELECT);
          efternamn = rs.getString("familyName");
          if (!rs.next()) {
       
          }
      } catch (Exception e) {
          System.out.println("ERROR3: " + e.getMessage());
      }
   return efternamn;
  }
    
   
    
    
    
}
