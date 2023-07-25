package db.test; 
import java.sql.*; 
import java.util.List; 
import java.util.ArrayList; 

public class DbMain { 
	public static void main(String[]args){
		boolean flag=false; 
		Connection conn=null; 
		try{
			Class.forName("org.postgresql.Driver"); //postgreSQL 
		} catch(ClassNotFoundException e) { e.printStackTrace(); }
		PreparedStatement pstmt=null; 
		String stud_id, stud_passwd, stud_name, stud_email, stud_gender;
		try{
			System.out.println("모두 지웁니다"); 
			Mdelete mdelete = new Mdelete(); 
			flag = mdelete.mdelete("all", "");
		} catch(Exception e) { e.printStackTrace(); 
		} finally {
			try { if(conn !=null) conn.close(); if(pstmt !=null) pstmt.close(); 
			}catch(Exception e) { e.printStackTrace(); 
		}
	}
//수정 윗페이지는 동일!!
		try{
			System.out.println("홍길동 입력합니다.");
			stud_id ="kdhong"; 
			stud_passwd ="1234"; 
			stud_name = "홍길동";
			stud_email = "kdhong@abc.com";
			stud_gender = "남자";
			Minsert minst = new Minsert(); 
			flag = minst.minsert(stud_id, stud_passwd, stud_name, stud_email, stud_gender); 
			System.out.println("이몽룡 입력합니다");
			stud_id ="mrlee"; 
			stud_passwd ="4321"; 
			stud_name = "변학도"; 
			stud_email = "hdbyun@abc.com";
			stud_gender = "남자"; 
			flag = minst.minsert(stud_id, stud_passwd, stud_name, stud_email, stud_gender); 
			System.out.println("입력 결과 보기");
			Mselect mselect = new Mselect();
			List<Userinfo> userlists = new ArrayList<Userinfo>();
			userlists = mselect.mselect("all", "");
			for(int i=0;i<userlists.size();i++) {
				System.out.println(userlists.get(i).getStud_id()+","+userlists.get(i).getStud_name());
			}	
			System.out.println("수정합니다.");
			stud_id="mrlee";stud_passwd="1289";stud_name="이몽룡";stud_email="mrlee@a.com";
			stud_gender="여자";
			Mupdate mupdate = new Mupdate();
			flag = mupdate.mupdate(stud_id, stud_passwd, stud_name, stud_email, stud_gender);
			System.out.println("수정결과 보기");
			userlists = mselect.mselect("", stud_id);
			for(int i=0;i<userlists.size();i++) {
				System.out.println(userlists.get(i).getStud_id()+","+userlists.get(i).getStud_name());
			}
			//윗페이지는 동일
			System.out.println("삭제합니다.");
			stud_id = "mrlee";
			Mdelete mdelete = new Mdelete();
			flag = mdelete.mdelete("",stud_id);
			System.out.println("삭제결과 보기");
			userlists = mselect.mselect("all", stud_id);
			for(int i=0;i<userlists.size();i++) {
				System.out.println(userlists.get(i).getStud_id()+","+userlists.get(i).getStud_name());
			}			
		}catch(Exception e) { e.printStackTrace();
		} finally { 
			try {
				if(conn !=null) conn.close(); if(pstmt !=null) pstmt.close();
			} catch(Exception e) { e.printStackTrace();
			}
		}
	}
}