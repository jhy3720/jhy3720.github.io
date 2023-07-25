package db.test; 
import java.util.List; 
import java.util.ArrayList; 
import java.sql.*; 

public class Mselect { 
	private Connection conn=null; 
	public List<Userinfo> mselect(String idx, String stud_id) throws SQLException {
	PreparedStatement pstmt=null; 
	ResultSet rs=null;
	List<Userinfo> userlists = null;
	try{ 
		userlists = new ArrayList<Userinfo>();
		conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/mydb","studx","gkrtod123A!"); 
		if (idx=="all") {
			pstmt = conn.prepareStatement("select * from badge"); 
		} else {
			pstmt = conn.prepareStatement("select * from badge where stud_id=?"); 
			pstmt.setString(1, stud_id);
		}
		rs=pstmt.executeQuery();		
		while(rs.next()) { 
			Userinfo userlist = new Userinfo(); 
			userlist.setStud_id(rs.getString("stud_id")); 
			userlist.setStud_passwd(rs.getString("stud_passwd")); 
			userlist.setStud_name(rs.getString("stud_name")); 
			userlist.setStud_email(rs.getString("stud_email")); 
			userlist.setStud_gender(rs.getString("stud_gender")); 
			userlists.add(userlist);
		}
	}catch(Exception e) { e.printStackTrace(); 
	} finally {
		try { if(conn !=null) conn.close(); if(pstmt !=null) pstmt.close(); 
		} catch(Exception e) { e.printStackTrace(); }
	}
	return userlists;
	}
}