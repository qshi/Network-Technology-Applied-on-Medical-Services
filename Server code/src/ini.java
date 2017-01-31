import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ini
{
  public static void main( String args[] )
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      
  /*CREATE  DOCTOR1 */      
      String  sql = "CREATE TABLE DOCTOR1 " +
              "(NUM         TEXT    NOT NULL," +
              "DAY           TEXT      NOT NULL, " + 
              " AM           TEXT    NOT NULL, " + 
              " PM           TEXT    NOT NULL )"; 
      

      stmt.executeUpdate(sql);
      
      sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
                   "VALUES (1, 'MON', ' ', ' ');"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
            "VALUES (2, 'TUE', ' ', ' ' );"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
            "VALUES (3, 'WED', ' ', ' ');"; 
      stmt.executeUpdate(sql);

      sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
            "VALUES (4, 'THU',' ', ' ');"; 
      stmt.executeUpdate(sql);
      
      sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
              "VALUES (5, 'FRI',' ', ' ');"; 
        stmt.executeUpdate(sql);
        
        sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
                "VALUES (6, 'SAT', ' ', ' ');"; 
          stmt.executeUpdate(sql);
          
          sql = "INSERT INTO DOCTOR1 (NUM, DAY, AM, PM) " +
                  "VALUES (7, 'SUN',' ', ' ');"; 
            stmt.executeUpdate(sql);    
           
 /*CREATE  DOCTOR2 */      
            sql = "CREATE TABLE DOCTOR2 " +
                    "(NUM         TEXT     NOT NULL," +
                    "DAY           TEXT      NOT NULL, " + 
                    " AM           TEXT    NOT NULL, " + 
                    " PM           TEXT    NOT NULL )"; 
            

            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                         "VALUES (1, 'MON', ' ', ' ');"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                  "VALUES (2, 'TUE', ' ', ' ' );"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                  "VALUES (3, 'WED', ' ', ' ');"; 
            stmt.executeUpdate(sql);

            sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                  "VALUES (4, 'THU',' ', ' ');"; 
            stmt.executeUpdate(sql);
            
            sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                    "VALUES (5, 'FRI',' ', ' ');"; 
              stmt.executeUpdate(sql);
              
              sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                      "VALUES (6, 'SAT', ' ', ' ');"; 
                stmt.executeUpdate(sql);
                
                sql = "INSERT INTO DOCTOR2 (NUM, DAY, AM, PM) " +
                        "VALUES (7, 'SUN',' ', ' ');"; 
                  stmt.executeUpdate(sql);    
            
/*CREATE  DOCTOR3 */      
                  sql = "CREATE TABLE DOCTOR3 " +
                          "(NUM         TEXT    NOT NULL," +
                          "DAY           TEXT      NOT NULL, " + 
                          " AM           TEXT    NOT NULL, " + 
                          " PM           TEXT    NOT NULL )"; 
                  
 
                  stmt.executeUpdate(sql);
                  
                  sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                               "VALUES (1, 'MON', ' ', ' ');"; 
                  stmt.executeUpdate(sql);

                  sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                        "VALUES (2, 'TUE', ' ', ' ' );"; 
                  stmt.executeUpdate(sql);

                  sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                        "VALUES (3, 'WED', ' ', ' ');"; 
                  stmt.executeUpdate(sql);

                  sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                        "VALUES (4, 'THU',' ', ' ');"; 
                  stmt.executeUpdate(sql);
                  
                  sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                          "VALUES (5, 'FRI',' ', ' ');"; 
                    stmt.executeUpdate(sql);
                    
                    sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                            "VALUES (6, 'SAT', ' ', ' ');"; 
                      stmt.executeUpdate(sql);
                      
                      sql = "INSERT INTO DOCTOR3 (NUM, DAY, AM, PM) " +
                              "VALUES (7, 'SUN',' ', ' ');"; 
                        stmt.executeUpdate(sql);            

 //CREATE  REGISTER      
                        
                        String eid1=md5("shiquan");
                        String ecode1=md5("12345");
                        String eid2=md5("chengran");
                        String ecode2=md5("54321");
                        String eid3=md5("lihaochen");
                        String ecode3=md5("11111");
                        String eid4=md5("wangwenchao");
                        String ecode4=md5("22222");
                        
                        String eid1_data = "'" + eid1+ "'";
                        String eid2_data = "'" + eid2+ "'";
                        String eid3_data = "'" + eid3+ "'";
                        String eid4_data = "'" + eid4+ "'";
                        String ecode1_data = "'" + ecode1+ "'";
                        String ecode2_data = "'" + ecode2+ "'";
                        String ecode3_data = "'" + ecode3+ "'";
                        String ecode4_data = "'" + ecode4+ "'";
                
                        
              	      sql = "CREATE TABLE REGISTER " +
              	    		  "(ID                 TEXT     NOT NULL," +
              	              " PASSWORD            TEXT     NOT NULL)"; 
              	      stmt.executeUpdate(sql);
              	      
              	      sql = "INSERT INTO REGISTER (ID,PASSWORD) " +
              	              "VALUES ("+eid1_data+", "+ ecode1_data +" );"; 
              	        stmt.executeUpdate(sql);

              	        sql = "INSERT INTO REGISTER (ID,PASSWORD) " +
              	        		"VALUES ("+eid2_data+", "+ecode2_data+" );";  
              	        stmt.executeUpdate(sql);

              	        sql = "INSERT INTO REGISTER (ID,PASSWORD) " +
              	        		"VALUES ("+eid3_data+", "+ecode3_data+" );";  
              	        stmt.executeUpdate(sql);
            
              	        sql = "INSERT INTO REGISTER (ID,PASSWORD) " +
              	        		"VALUES ("+eid4_data+", "+ecode4_data+" );"; 
                	        stmt.executeUpdate(sql);
                	        
                	        
                	        
                	        //CREATE  REGISTER2      
                            
                            String eeid1="doctorsq";
                            String eecode1="12345";
                            String eeid2="doctorcr";
                            String eecode2="54321";
                            String eeid3="doctorlhc";
                            String eecode3="11111";
                            String eeid4="doctorwwc";
                            String eecode4="22222";
                            
                            String eeid1_data = "'" + eeid1+ "'";
                            String eeid2_data = "'" + eeid2+ "'";
                            String eeid3_data = "'" + eeid3+ "'";
                            String eeid4_data = "'" + eeid4+ "'";
                            String eecode1_data = "'" + eecode1+ "'";
                            String eecode2_data = "'" + eecode2+ "'";
                            String eecode3_data = "'" + eecode3+ "'";
                            String eecode4_data = "'" + eecode4+ "'";
                    
                            
                  	      sql = "CREATE TABLE REGISTER2 " +
                  	    		  "(ID                 TEXT     NOT NULL," +
                  	              " PASSWORD            TEXT     NOT NULL)"; 
                  	      stmt.executeUpdate(sql);
                  	      
                  	      sql = "INSERT INTO REGISTER2 (ID,PASSWORD) " +
                  	              "VALUES ("+eeid1_data+", "+ eecode1_data +" );"; 
                  	        stmt.executeUpdate(sql);

                  	        sql = "INSERT INTO REGISTER2 (ID,PASSWORD) " +
                  	        		"VALUES ("+eeid2_data+", "+eecode2_data+" );";  
                  	        stmt.executeUpdate(sql);

                  	        sql = "INSERT INTO REGISTER2 (ID,PASSWORD) " +
                  	        		"VALUES ("+eeid3_data+", "+eecode3_data+" );";  
                  	        stmt.executeUpdate(sql);
                
                  	        sql = "INSERT INTO REGISTER2 (ID,PASSWORD) " +
                  	        		"VALUES ("+eeid4_data+", "+eecode4_data+" );"; 
                    	        stmt.executeUpdate(sql);
                	        
                	        
        stmt.close();
        c.commit();
        c.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
      System.out.println("Records created successfully");
    }
  
  
  public static String md5(String plainText) {
      String result = null;
      try {
          MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(plainText.getBytes());
          byte b[] = md.digest();

          int i;

          StringBuffer buf = new StringBuffer("");
          for (int offset = 0; offset < b.length; offset++) {
              i = b[offset];
              if (i < 0)
                  i += 256;
              if (i < 16)
                  buf.append("0");
              buf.append(Integer.toHexString(i));
          }
          result = buf.toString();
      } catch (NoSuchAlgorithmException e) {
          e.printStackTrace();
      }
      return result;
  }

}