package com.Instagramweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Instagramweb.entity.InstagramwebUser;

public class InstagramwebDao implements InstagramwebDaoInterface {
	
	private Connection con;
	
	public InstagramwebDao() {
		 
        try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
 	    con = DriverManager.getConnection("jdbc:derby:d:/facebookweb;create=true", "suprabha", "123");
        }
        
        catch(ClassNotFoundException|SQLException e) {
        	 e.printStackTrace();
        }
	}

	
	@Override
	public int createProfileDao(InstagramwebUser iu) {

		int i=0;
		
 	    try {
 	    PreparedStatement ps= con.prepareStatement("insert into facebookuser values(?,?,?,?)");
	
 	    ps.setString(1,iu.getName());
 	    ps.setString(2,iu.getPassword());
 	    ps.setString(3,iu.getEmail());
 	    ps.setString(4,iu.getAddress());
 	    
 	    i=ps.executeUpdate();
 	    
 	    }
 	    
 	   catch(SQLException ee)
        {
        	 ee.printStackTrace();
        }
	
 	    return i;
 	    
	}
	

	@Override
	public boolean loginProfileDao(InstagramwebUser iu) {

		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where name=? and password=?");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			
			
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
	public List<InstagramwebUser> friendListDao(InstagramwebUser iu) {

		List<InstagramwebUser> ll=new ArrayList<InstagramwebUser>();
		
		InstagramwebUser f=new InstagramwebUser();
		f.setName("Pooja");
		f.setAddress("Dehradun");
		
		InstagramwebUser f1=new InstagramwebUser();
		f1.setName("Megha");
		f1.setAddress("Secunderabad");
		
		ll.add(f);
		ll.add(f1);
		
		return ll;
	}

}
