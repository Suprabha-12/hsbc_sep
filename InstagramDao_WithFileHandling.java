package com.Instagram.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Instagram.entity.InstagramUser;
import com.Instagram.utility.InstagramException;


public class InstagramDao implements InstagramDaoInterface {

	
	
/*----------------------------------------------------CREATE PROFILE-------------------------------------------------------*/

	@Override
	public int createProfileDao(InstagramUser iu) throws InstagramException, IOException{
		/*
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		*/
		
		/* 	
		//Step 1: Load Driver
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		// Class.forName("oracle.jdbc.OracleDriver");
		// Class.forName("com.mysql.jdbc.Driver"); 
		
		//Step 2: Create connection with database
		con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
		
		
		//Step 3: Create query
		ps=con.prepareStatement("insert into instagramuser2 values(?,?,?,?)");
		ps.setString(1,iu.getName());
		ps.setString(2,iu.getPassword());
		ps.setString(3,iu.getEmail());
		ps.setString(4,iu.getAddress());
		
		
		//Step 4: Execute query
		i=ps.executeUpdate();
		*/
						
				File f=new File("d:/hsbc_file/InstaDB1.txt");
				
				FileOutputStream out=new FileOutputStream(f,true);
				
				int c=0;
				
				
				String name=iu.getName();
				
				for(int i=0;i<name.length();i++)
				{
					out.write(name.charAt(i));
				}
				
 
				String password=iu.getPassword();
				
				for(int i=0;i<password.length();i++)
				{
					out.write(password.charAt(i));
				}
				

				String email=iu.getEmail();
				
				for(int i=0;i<email.length();i++)
				{
					out.write(email.charAt(i));
				}
				

				String address=iu.getAddress();
				
				for(int i=0;i<address.length();i++)
				{
					out.write(address.charAt(i));
				}
				
				out.close();
				
			return 0;
		
		
	}	
		
		

/*----------------------------------------------------CREATE PROFILE-------------------------------------------------------*/
	
	

	
	
/*----------------------------------------------------EDIT PROFILE-------------------------------------------------------*/
	
	
	@Override
	public int editProfilebynameDao(InstagramUser iu) throws Exception {
	   		
	   		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	   	    Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
	   	    PreparedStatement ps=con.prepareStatement("update instagramuser2 set name=?  where email=?");
	   	    
	   	    //connect 'jdbc:derby:d:/instadb1;create=true;user=suprabha;password=123';
	   	    
	   		ps.setString(1, iu.getName());
	   	    ps.setString(2, iu.getEmail());
	   		
	   	    return ps.executeUpdate();
	   		
	   	}   
       
	
	@Override
	public int editProfilebypasswordDao(InstagramUser iu) throws Exception {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
   	        Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
   	        PreparedStatement ps=con.prepareStatement("update instagramuser2 set password=?  where email=?");
   	    
   		ps.setString(1, iu.getPassword());
   	        ps.setString(2, iu.getEmail());
   	 	
   	        return ps.executeUpdate();
		
	    }

   
	@Override
    public int editProfilebyaddressDao(InstagramUser iu) throws Exception {
   		
   		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
   		Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
   		PreparedStatement ps=con.prepareStatement("update instagramuser2 set address=? where email=?");
   		
   		ps.setString(1, iu.getAddress());
   		ps.setString(2, iu.getEmail());
   		
   		return ps.executeUpdate();
   		
   	}
             
      
	@Override
	public void editProfileDao() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
/*----------------------------------------------------EDIT PROFILE-------------------------------------------------------*/
       
	
       
       
	
       
/*----------------------------------------------------DELETE PROFILE-------------------------------------------------------*/

	@Override
	public int deleteProfileDao(InstagramUser iu) throws InstagramException{
		
		int i=0;
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
		ps=con.prepareStatement("delete * from instagramuser2 where name=?");
		ps.setString(1, iu.getName());
		
		i=ps.executeUpdate();
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}

	
	
/*----------------------------------------------------DELETE PROFILE-------------------------------------------------------*/

	
	
	
	
	
	
/*----------------------------------------------------VIEW PROFILE-------------------------------------------------------*/
	
	@Override
	public InstagramUser viewProfileDao(InstagramUser iu) throws InstagramException{
		
		InstagramUser uu=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		
		try{
			
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
		ps=con.prepareStatement("select * from instagramuser2 where name=?");
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		
		
		if(res.next()) {
			
			uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
		}
		
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return uu;
		
	}
/*----------------------------------------------------VIEW PROFILE-------------------------------------------------------*/

	
	
	
	
	
/*----------------------------------------------------SEARCH PROFILE-------------------------------------------------------*/
	
	@Override
	public List<InstagramUser> searchProfileDao(InstagramUser iu) throws InstagramException{
		
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
		ps=con.prepareStatement("select * from instagramuser2 where name=?");
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		
		
		while(res.next()) {
			
			InstagramUser uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		  }
		
		
		if(ll.size()==0) {
			throw new InstagramException("");
		}
		
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		
		return ll;
		
	}

/*----------------------------------------------------SEARCH PROFILE-------------------------------------------------------*/

	
	

	
	
	
/*----------------------------------------------------VIEW ALL PROFILE-------------------------------------------------------*/

	@Override
	public List<InstagramUser> viewallProfileDao() throws InstagramException{
		
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
		
		    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		    con=DriverManager.getConnection("jdbc:derby:d:/instadb1;create=true","suprabha","123");
		    ps=con.prepareStatement("select * from instagramuser2");
		
		    ResultSet res=ps.executeQuery();
		
		
		
        while(res.next()) {
			
			InstagramUser uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
        
		}
		
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		
		finally {
				try {
					con.close();
				} 
				catch (SQLException e) {

					e.printStackTrace();
				}
		}
		
		return ll;
		
	}

/*----------------------------------------------------VIEW ALL PROFILE-------------------------------------------------------*/




/*------------------------------------------------------USER HISTORY---------------------------------------------------------*/

	
	@Override
	public Map<String, List<InstagramUser>> UserdetailwithhistoryDao() throws Exception {
		Map<String, List<InstagramUser>> m=new HashMap<String, List<InstagramUser>>();
		
		List<InstagramUser> l1=viewallProfileDao();
		List<InstagramUser> l2=viewallProfileDao();
		
		m.put("Studentlist", l1);
		m.put("Professorlist", l2);
		
		return m;
	}

/*------------------------------------------------------USER HISTORY---------------------------------------------------------*/

	
}
