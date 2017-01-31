import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


import java.util.*;
import java.net.*;
import java.io.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class plus extends JFrame{	
	
	
	
	private JTextField jtfID = new JTextField(32);
	
	private JTextField jtfPW = new JTextField(32);
	
	 
	
	private JButton jbtSub = new JButton("Submit");
	
	
	public plus(){
		this.init();
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(5,1));
		p1.add(new JLabel("   Your New ID"));
		
		p1.add(jtfID);
		p1.add(new JLabel("   Your New Passwords"));
		p1.add(jtfPW);
		
		
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtSub);
		
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		
		
		jbtSub.addActionListener(new ButtonListener());
		
	}
		
	private void init() {
        this.setBounds(234,200,555,300); // 注意，设置初始位置必须在注册监听器之前
        //this.lastPoisition = this.getLocation();

        }	
	
	
	
	    
		
	     private class ButtonListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ID = jtfID.getText().trim();
				String PW = jtfPW.getText().trim();
				String Dr = " ";				
				String Time = " ";
				String AP = " ";
				
				try {
					/*
					Socket socket = new Socket("localhost", 10000);
					
					DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
					DataInputStream fromServer = new DataInputStream(socket.getInputStream());
					
					
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
					*/					
					if(true){
						JOptionPane.showMessageDialog(null,"Your new account is available");					
					}
					
					
					
					else {
						JOptionPane.showMessageDialog(null,"PLEASE ENTER THE RIGHT USERNAME AND PASSWORD!");
					}
					
					
					
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,e);
				}
			}
		}
		
	
	 ////////////////////////////////////////////////
	 


	   /* 
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
	    
	    */
	    
		
			
		
	
	public static void main(String[] args) {
		plus frameplus = new plus();
		frameplus.pack();
		frameplus.setTitle("Regist");
		frameplus.setLocationRelativeTo(null);
		frameplus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameplus.setVisible(true);
	
	}
}
