package studpkg; 
import java.sql.*; 
import java.util.*;
import studpkg.*;

public class StudDAO { 
	Connection conn;
	PreparedStatement ps; 
	ResultSet rs;

	String url, user, pass; 
	public StudDAO() {
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		url="jdbc:postgresql://localhost:5432/mydb"; 
		user="studx"; 
		pass="gkrtod123A!";
	}

	public int insertStuduser(String stud_id, String stud_passwd, String stud_name, String stud_phone,
			String stud_gender, String stud_email, String [] sHobby) throws SQLException { 
		String sql = "insert into studuser (stud_id, stud_passwd, stud_name, stud_phone, stud_gender, stud_email, stud_hobby1, stud_hobby2, stud_hobby3, stud_regdate) values (?,?,?,?,?,?,?,?,?,?);"; 
		try {
			conn = DriverManager.getConnection(url,user,pass); 
			ps = conn.prepareStatement(sql); 
			java.text. SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddHHmmss"); 
			String stud_regdate = formatter.format(new java.util.Date()); 
			ps.setString(1, stud_id); ps.setString(2,stud_passwd); ps.setString(3, stud_name); 
			ps.setString(4, stud_phone); ps.setString(5,stud_gender); ps.setString(6,stud_email); 
			ps.setString(7,sHobby[0]); ps.setString(8,sHobby[1]); ps.setString(9,sHobby[2]); 
			ps.setString(10, stud_regdate); 
			int rec_no = ps.executeUpdate();
			return rec_no; 
		} finally { 
			if (ps != null)
				ps.close(); 
			if (conn != null)
				conn.close();
		}
	}
	
	public boolean checkld(String stud_id) throws Exception { 
		boolean flag = false; 
		String sql="select * from studuser where stud_id=?"; 
		try{
			conn = DriverManager.getConnection(url,user,pass); 
			ps = conn.prepareStatement(sql); 
			ps.setString(1, stud_id); 
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()){
				flag = true;
			}
		} finally { 
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		return flag;
	}
	
	public boolean checkPwd(String stud_id, String stud_passwd) throws SQLException {
		boolean flag=false; 
		String sql = "select * from studuser where stud_id=?"; 
		try {
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql); 
			ps.setString(1, stud_id); 
			ResultSet rs = ps.executeQuery(); 
			if(rs.next()) { 
				if(stud_id.equals(rs.getString("stud_id").trim()) && stud_passwd.equals(rs.getString("stud_passwd").trim()))
				{
					flag=true; 
				} else {
					flag=false;
				}
			}
		} finally { 
			if (ps != null)
				ps.close(); 
			if (conn != null)
				conn.close();
		}
		return flag;
	}


public List<StudDTO> findAllStuduser(String stud_search) throws SQLException {
String sql = "select * from studuser where stud_id=? or stud_name=? or stud_email=? or stud_phone=? or stud_gender=? or stud_hobby1=? or stud_hobby2=? or stud_hobby3=?;";
List<StudDTO> list = new ArrayList<StudDTO>(); 
try {
	conn = DriverManager.getConnection(url,user,pass); 
	ps = conn.prepareStatement(sql); 
	ps.setString(1, stud_search); 
	ps.setString(2, stud_search);
	ps.setString(3, stud_search); 
	ps.setString(4,stud_search); 
	ps.setString(5,stud_search); 
	ps.setString(6, stud_search);
	ps.setString(7,stud_search); 
	ps.setString(8,stud_search); 
	ResultSet rs = ps.executeQuery(); 
	list = makelist(rs);
	return list; 
	} finally {
		if (ps != null) ps.close(); 
		if (conn != null) conn.close(); 
		if (rs != null)rs.close();
	}
}



public List<StudDTO> findHobbyStuduser(String stud_search) throws SQLException {
String sql = "select * from studuser where stud_hobby1=? or stud_hobby2=? or stud_hobby3=?;"; 
List<StudDTO>list = new ArrayList<StudDTO>(); 
try {
	conn = DriverManager.getConnection(url,user,pass); 
	ps = conn.prepareStatement(sql); 
	ps.setString(1, stud_search); 
	ps.setString(2, stud_search); 
	ps.setString(3,stud_search); 
	ResultSet rs = ps.executeQuery(); 
	list = makelist(rs); 
	return list; 
	} finally { 
		if (ps != null)
			ps.close(); 
		if (conn != null)
			conn.close(); 
		if (rs != null)
			rs.close();
	}
}

public List<StudDTO> findNameStuduser(String stud_search, String search_select) throws SQLException {
String sql = "select * from studuser where " + search_select + "=?;"; 
List<StudDTO> list = new ArrayList<StudDTO>(); 
try {
	conn = DriverManager.getConnection(url,user,pass); 
	ps = conn.prepareStatement(sql); 
	ps.setString(1, stud_search); 
	ResultSet rs = ps.executeQuery(); 
	list = makelist(rs); 
	return list;
	} finally { 
		if (ps != null)
			ps.close(); 
		if (conn != null)
			conn.close(); 
		if (rs != null)
			rs.close();
	}
}

public List<StudDTO> makelist(ResultSet rs) throws SQLException {
List<StudDTO> list = new ArrayList<StudDTO>(); 
while(rs.next()) {
	StudDTO dto = new StudDTO(); 
	dto.setStud_id(rs.getString("stud_id")); 
	dto.setStud_name(rs.getString("stud_name")); 
	dto.setStud_phone(rs.getString("stud_phone")); 
	dto.setStud_email(rs.getString("stud_email"));

	String shobby[] = {"","",""}; 
	shobby[0]=rs.getString("stud_hobby1"); 
	shobby[1]=rs.getString("stud_hobby2"); 
	shobby[2]=rs.getString("stud_hobby3"); 
	if (shobby[0]==null) shobby[0] =""; 
	if (shobby[1]==null) shobby[1] =""; 
	if (shobby[2]==null) shobby[2] ="";
	dto.setStud_hobby(shobby); 
	list.add(dto);
	}
	return list;
	}
}
