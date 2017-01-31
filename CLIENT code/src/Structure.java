import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


import java.util.*;
import java.net.*;
import java.io.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Structure extends JFrame{	
	
	trans test =new trans("DOCTOR1","MON","AM");
	
	private JTextField jtfID = new JTextField(32);
	private JTextField jtfPW = new JTextField(32);
	
	 String[] combo1= {"DOCTOR1","DOCTOR2","DOCTOR3"};
	 String[] combo2= {"MON","TUE","WED","THU","FRI"};
	 String[] combo3= {"AM","PM"};
	
	 JComboBox jtfDr  = new JComboBox(combo1);
	 JComboBox jtfTime = new JComboBox(combo2);
	 JComboBox jtfAP = new JComboBox(combo3);
	
	private JButton jbtRegister = new JButton("Register to the server");
	//private JButton jbtPlus = new JButton("Get a new account");//注册，必要时删除
	
	
	private void init() {
        this.setBounds(234,200,555,300); // 注意，设置初始位置必须在注册监听器之前
        //this.lastPoisition = this.getLocation();

        }	
	
	
	public Structure(){
		
		this.init();
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(5,1));
		p1.add(new JLabel("   Re-enter your ID"));
		p1.add(jtfID);
		p1.add(new JLabel("   Re-enter your Passwords"));
		p1.add(jtfPW);
		p1.add(new JLabel("   Doctor"));
		p1.add(jtfDr);
		p1.add(new JLabel("   Time"));
		p1.add(jtfTime);
		p1.add(new JLabel("   AM/PM"));
		p1.add(jtfAP);
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtRegister);
		
		/*注册部分，必要删除
		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p3.add(jbtPlus);
		*/
	
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.CENTER);
		//add(p3,BorderLayout.SOUTH);
		
		jbtRegister.addActionListener(new ButtonListener());
		//jbtPlus.addActionListener(new PlusListener());//plus为注册功能，必要时删除
		jtfDr.addItemListener(itemListener1);
		jtfTime.addItemListener(itemListener2);
		jtfAP.addItemListener(itemListener3);
	}
		
		
	
	
	
	    ItemListener itemListener1 = new ItemListener() {
	        public void itemStateChanged(ItemEvent itemEvent) {
	        	String pop1 = (String)jtfDr.getSelectedItem(); 
	        	test.Doc=pop1;
	        	System.out.print(test.Doc+"\n");
	        	
	        //int state1 = itemEvent.getStateChange();
	          //System.out.print(state1);
	          //System.out.print(ItemEvent.SELECTED);
	          //System.out.println((state1 == ItemEvent.SELECTED) ? "Selected" : "Deselected");
	          //System.out.println("Item: " + itemEvent.getItem());
	          //ItemSelectable is1 = itemEvent.getItemSelectable();
	          //String tran1= selectedString(is1);
	          //String fin1=tran1.substring(0, 7);
	          //System.out.print(fin1);
	          //System.out.println(", Selected: " + selectedString(is));
	        }
	      };
	      
	      ItemListener itemListener2 = new ItemListener() {
		        public void itemStateChanged(ItemEvent itemEvent) {
		        	String pop2 = (String)jtfTime.getSelectedItem(); 
		        	test.Tim=pop2;
		        	System.out.print(test.Tim+"\n");
		        	//int state2 = itemEvent.getStateChange();
		          //System.out.print(state2);
		          //System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
		          //System.out.println("Item: " + itemEvent.getItem());
		          //ItemSelectable is = itemEvent.getItemSelectable();
		          //System.out.println(", Selected: " + selectedString(is));
		        }
		      };
		   
		      ItemListener itemListener3 = new ItemListener() {
			        public void itemStateChanged(ItemEvent itemEvent) {
			        	String pop3 = (String)jtfAP.getSelectedItem(); 
			        	test.APM=pop3;
			        	System.out.print(test.APM+"\n");
			        	//int state3 = itemEvent.getStateChange();
			          //System.out.print(state3);
			          //System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
			          //System.out.println("Item: " + itemEvent.getItem());
			          //ItemSelectable is = itemEvent.getItemSelectable();
			          //System.out.println(", Selected: " + selectedString(is));
			        }
			      };
			      
		
	     private class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ID = jtfID.getText().trim();
				String PW = jtfPW.getText().trim();
				String Dr = test.Doc;
				System.out.print("Dr"+Dr);
				String Time = test.Tim;
				String AP = test.APM;
				
				try {
					Socket socket = new Socket("128.119.72.66", 10000);
					
					DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
					DataInputStream fromServer = new DataInputStream(socket.getInputStream());
					
					/*
					String Dr = (String)jtfDr.getSelectedItem();
					String Time = (String)jtfTime.getSelectedItem();
					String AP = (String)jtfAP.getSelectedItem();
					*/
					String y=md5(ID);
					
					toServer.writeUTF(y);
					System.out.print("ID"+ID);
					System.out.print("Y"+y);
					
					String x=md5(PW);
					
					toServer.writeUTF(x);
					System.out.print("PW"+PW);
					System.out.print("X"+x);
					
					toServer.writeUTF(Dr);
					System.out.print("Dr"+Dr);
					toServer.writeUTF(Time);
					System.out.print("Time"+Time);
					toServer.writeUTF(AP);
					System.out.print("AP"+AP);
					
					String dia=fromServer.readUTF();						
					if(dia.equals("1")){
						JOptionPane.showMessageDialog(null,"Regist successful");					
					}
					
					
					else if (dia.equals("2")){
						JOptionPane.showMessageDialog(null,"Your time might crash with others");					
					}
					
					else {
						JOptionPane.showMessageDialog(null,"PLEASE ENTER THE RIGHT USERNAME AND PASSWORD!");
					}
					
					
					
				}
				catch (IOException ex) {
					System.err.println(ex);
				}
			}
		}
		
	     /*注册部分，必要时删除
	     private class PlusListener implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					plus strikenfreedom = new plus();
					strikenfreedom.setVisible(true);
						
						
					
				}
			}
	*/
	 ////////////////////////////////////////////////
	     
	    static private String selectedString(ItemSelectable is) {
	    	    Object selected[] = is.getSelectedObjects();
	    	    return ((selected.length == 0) ? "null" : (String) selected[0]);
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
	    
	    
	    
		
			
		
	
	public static void main(String[] args) {
		Structure frame = new Structure();
		frame.pack();
		frame.setTitle("Client");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
}
