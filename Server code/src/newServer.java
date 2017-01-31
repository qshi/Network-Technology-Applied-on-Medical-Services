import java.io.*; 
import java.net.*; 
import java.util.*;
import java.sql.*;

class newServer implements Runnable{

	Socket connectionSocket;

	public newServer(Socket connectionSocket){
		this.connectionSocket = connectionSocket;
		
		
	}

	public static void main(String argv[]) throws Exception { 
	
		ServerSocket ms = new ServerSocket(10000); 

		while(true) { 
			System.out.println("1");
			Socket connectionSocket = ms.accept(); 
			System.out.println("2");
			newServer s = new newServer(connectionSocket);

			Thread threads = new Thread(s);
            
			System.out.println("3");
    		threads.start();
    		/*
    		String from = "xenoasuka";
    		
            String pass = "0701011474eva";
            String[] to = { "neonasuka@gmail.com" }; // list of recipient email addresses
            String subject = "Notification from hospital";
            String body ="Registion Success!!!";
            */

            //sendFromGMail(from, pass, to, subject, body);
	
		} 
	}

	public void run(){
		 Connection c = null;
		    Statement stmt = null;
		
		try{
			
			Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      System.out.println("Opened database successfully");
		      stmt = c.createStatement();
		    
			DataInputStream inc1 = new DataInputStream(this.connectionSocket.getInputStream());
			DataOutputStream otc1 = new DataOutputStream(this.connectionSocket.getOutputStream()); 
			
			String ID=inc1.readUTF();
			System.out.println("ID"+ID);
			String PW=inc1.readUTF();
			System.out.println("PW"+PW);
			String Dr=inc1.readUTF();
			System.out.println("Dr"+Dr);  //DOCTOR1  DOCTOR2  DOCTOR3
			String Workday=inc1.readUTF();
			System.out.println("Workday"+Workday); // MON TUE...
			String Time=inc1.readUTF();
			System.out.println("Time"+Time); //AM or PM
			String ID_data = "'" + ID + "'";
			String Workday_data = " ";
			if(Workday.equals("MON")){Workday_data= "1";}
			if(Workday.equals("TUE")){Workday_data= "2";}
			if(Workday.equals("WED")){Workday_data= "3";}
			if(Workday.equals("THU")){Workday_data= "4";}
			if(Workday.equals("FRI")){Workday_data= "5";}
			if(Workday.equals("SAT")){Workday_data= "6";}
			if(Workday.equals("SUN")){Workday_data= "7";}
			
			
			if(Dr.equals("111")){  //add register information
				  String eeid5= ID;
                  String eecode5=PW;
                  String eeid5_data = "'" + eeid5+ "'";
                  String eecode5_data = "'" + eecode5+ "'";
                  String sql = "INSERT INTO REGISTER (ID,PASSWORD) " +
          	              "VALUES ("+eeid5_data+", "+ eecode5_data +" );"; 
          	      stmt.executeUpdate(sql);
          	     stmt.close();
                 c.commit();
                 c.close();
			}
			else if(Dr.equals("222")){ //verify login information
				
				
				 ResultSet rs = stmt.executeQuery( "SELECT * FROM REGISTER;" );
			      String[] id=new String[100];
			      String[] password=new String[100];
				    int l=0;
			      while ( rs.next() ) {
			    	
			         id[l] = rs.getString("id");
			         password[l] = rs.getString("password");
			         l++;
			        
			      }
			      rs.close();
			      
			      boolean flag = false;
			      for(int i = 0; i <l; i++){
			    	  if(ID.equals(id[i])&&PW.equals(password[i])){
			    		  flag = true;
			    		  otc1.writeUTF("YES");	
			    		  break;
			    	  }
			      }
			      if(!flag) otc1.writeUTF("NO");	
			      
	               c.commit();
	               c.close();
	
			 }
			else{
			
			
 /*SELECT register*/  
			
		      ResultSet rs = stmt.executeQuery( "SELECT * FROM REGISTER;" );
		      String[] id=new String[100];
		      String[] password=new String[100];
			    int l=0;
		      while ( rs.next() ) {
		    	
		         id[l] = rs.getString("id");
		         password[l] = rs.getString("password");
		         
		        /*
		        System.out.println( "ID = " + id[l] );
		         System.out.println( "PW = " + password[l] );

		         System.out.println();*/
		         l++;
		        
		      }
		      rs.close();
			
//doc get day info					      
		      String word= "SELECT * FROM "+ Dr+";" ;
		      ResultSet judge = stmt.executeQuery(word);
		      String[] day=new String[100];
		      String[] Am=new String[100];
		      String[] Pm=new String[100];
			    int i=0,num[]=new int[50];
		      while ( judge.next() ) {
		    	num[i]=i;
		         Am[i] = judge.getString("am");
		         Pm[i] = judge.getString("pm");
		         day[i] = judge.getString("day");// MON TUE...	
		         
		         
		         System.out.println( "am = " + Am[i] );
		         System.out.println( "pm = " + Pm[i] );
		         System.out.println( "day = " + day[i] );

		         System.out.println();
		         i++;
		      }
		      judge.close();
		      
		      
		  
		      
//id authentication			
		 //     if((ID.equals(id[0])&&PW.equals(password[0]))||(ID.equals(id[1])&&PW.equals(password[1]))||(ID.equals(id[2])&&PW.equals(password[2]))||(ID.equals(id[3])&&PW.equals(password[3])))
		      
		      boolean flag_ = false;
		      for(int j =0; j < l; j++){
		    	  if(ID.equals(id[i])&&PW.equals(password[i])){
		    		  flag_ = true;
		    		  break;
		    	  } 
		      }		
		      
		      if(flag_)
		      {
		    	 
//whether conflict		
		    	  int count=0;
				for (int k=0; k< day.length; k++)
				{
					if (((Workday.equals(day[k]))&&(Time.equals("AM"))&&(Am[k].equals(" ")))||((Workday.equals(day[k]))&&(Time.equals("PM"))&&(Pm[k].equals(" "))))
					{count=1;break;}
				}
					
					 if (count==1)
				     //if (true)	
					{
						 
			         String sql = "UPDATE "+ Dr +" set "+ Time +" = "+ID_data +" where NUM = "+ Workday_data +";";
			  
			          stmt.executeUpdate(sql);
			          
			          
			          String sql4= "SELECT * FROM "+ Dr+";" ;			       
			          ResultSet judge4 = stmt.executeQuery(sql4);
			          String[] aa=new String[100];
				      String[] bb=new String[100];
				      String[] cc=new String[100];
					    int q=0;
				      while ( judge4.next() ) {
				    	aa[q] = judge4.getString("am");
				         bb[q] = judge4.getString("pm");
				         cc[q] = judge4.getString("num");
				        System.out.println( "aa = " + aa[q] );
				         System.out.println( "bb = " + bb[q] );
				         System.out.println( "cc = " + cc[q] );
				         System.out.println();
				         q++;
				        
				      }
				      judge4.close();
			          
			          
			          //System.out.println("Timeaaa"+Time);
			          	
			         
						otc1.writeUTF("1");
						otc1.flush();
						
						System.out.println("Regist success");
						//String body = "successful";
						
						String from = "xenoasuka";
			            String pass = "0701011474eva";
			            String[] to = { "neonasuka@gmail.com" }; // list of recipient email addresses
			            String subject = "Notification from hospital";
			            String body ="Regist Success!!!";

			          
				     	}
				         else
				         {
								otc1.writeUTF("2");
								otc1.flush();
								
								System.out.println("Regist fail");
							
				         }	
				
		    	  
				/*
				 * check crash
				 */
			}
			else
			{
				/*
				DataOutputStream ouc1s = new DataOutputStream(this.connectionSocket.getOutputStream()); 
				int s2=0;
				ouc1s.writeInt(s2);
				ouc1s.flush();
				*/
				otc1.writeUTF("0");
				otc1.flush();
				
				System.out.println("ID or password is wrong, please check");
				//String body="Wrong";
			}
		      
		      

		       
		      
		      
			System.out.println(Thread.currentThread().getName());
			
			 stmt.close();
		        c.commit();
		        c.close();
		        
		}

		} catch (IOException io) {
			io.printStackTrace();
		}
		catch(Exception e ){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}
		
	}
	


}