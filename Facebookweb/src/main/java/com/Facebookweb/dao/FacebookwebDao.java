package com.Facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Facebookweb.entity.FacebookwebUser;

public class FacebookwebDao implements FacebookwebDaoInterface{
	
	private Connection con;
	
	
	public FacebookwebDao() {
		 
        try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
 	    con = DriverManager.getConnection("jdbc:derby:d:/facebookweb;create=true", "suprabha", "123");
        }
        
        catch(ClassNotFoundException|SQLException e) {
        	 e.printStackTrace();
        }
	}
	
	@Override
	public int createProfileDao(FacebookwebUser fu)  {

		int i=0;
		
 	    try {
 	    PreparedStatement ps= con.prepareStatement("insert into facebookuser values(?,?,?,?)");
	
 	    ps.setString(1,fu.getName());
 	    ps.setString(2,fu.getPassword());
 	    ps.setString(3,fu.getEmail());
 	    ps.setString(4,fu.getAddress());
 	    
 	    i=ps.executeUpdate();
 	    
 	    }
 	    
 	   catch(SQLException ee)
        {
        	 ee.printStackTrace();
        }
	
 	    return i;
 	    
	}

	@Override
	public boolean loginProfileDao(FacebookwebUser fu) {
		
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=? and password=?");
			ps.setString(1, fu.getName());
			ps.setString(2, fu.getPassword());
			
			
			ResultSet res=ps.executeQuery();
			
			if(res.next()) {
				i=true;
			}
		}
		
		catch(SQLException ea) {
			ea.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<FacebookwebUser> friendListDao(FacebookwebUser fu){
		
		List<FacebookwebUser> ll=new ArrayList<FacebookwebUser>();
		
		FacebookwebUser f=new FacebookwebUser();
		f.setName("Sangeeta");
		f.setAddress("Chennai");
		
		FacebookwebUser f1=new FacebookwebUser();
		f1.setName("Debdattaa");
		f1.setAddress("Pune");
		
		ll.add(f);
		ll.add(f1);
		
		return ll;
	}
	
	
}
