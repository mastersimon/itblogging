import java.sql.*; 
 
public class FirstSqlAccess 
{ 
  public static void main( String[] args ) 
  { 
    try 
    { 
      Class.forName( "org.hsqldb.jdbcDriver" ); 
    } 
    catch ( ClassNotFoundException e ) 
    { 
      System.err.println( "Keine Treiber-Klasse!" ); 
      return; 
    } 
 
    Connection con = null; 
 
    try 
    { 
      con = DriverManager.getConnection(  
              "jdbc:hsqldb:file:/home/simon/trash/hsql; shutdown=true", "root", "" ); 
      Statement stmt = con.createStatement(); 
      
//      String sql = "INSERT INTO CUSTOMER VALUES(50,'Simon','Michel')";
//      stmt.executeUpdate(sql); 
 
      ResultSet rs = stmt.executeQuery( "SELECT * FROM Customer" ); 
 
      while ( rs.next() ) 
      {
    	System.out.printf( "%s, %s %s%n", rs.getString(1),
          rs.getString(2), rs.getString(3) );
      }
             
 
      rs.close(); 
 
      stmt.close(); 
    } 
    catch ( SQLException e ) 
    { 
      e.printStackTrace(); 
    } 
    finally 
    { 
      if ( con != null ) 
        try { con.close(); } catch ( SQLException e ) { e.printStackTrace(); } 
    } 
  } 
}