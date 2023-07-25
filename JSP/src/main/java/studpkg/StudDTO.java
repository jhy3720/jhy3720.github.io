package studpkg;
public class StudDTO {
String stud_id;
 public String getStud_id() {
return stud_id;
}
public void setStud_id(String stud_id) {
this.stud_id = stud_id;
}
String stud_passwd;
public String getStud_passwd () { return stud_passwd; }
 public void setStud_passwd (String stud_passwd) { this.stud_passwd = stud_passwd;}
String stud_name;
 public String getStud_name() { return stud_name; } 
public void setStud_name(String stud_name) { this.stud_name = stud_name; }
 String stud_email; 
public String getStud_email() { return stud_email; }
 public void setStud_email (String stud_email) { this.stud_email = stud_email; } 
String stud_phone; 
public String getStud_phone () { return stud_phone; } 
public void setStud_phone (String stud_phone) { this.stud_phone = stud_phone; } 
String stud_gender; 
public String getStud_gender() { return stud_gender; } 
public void setStud_gender(String stud_gender) { this.stud_gender = stud_gender; }
String [] stud_hobby; 
public String[] getStud_hobby() { return stud_hobby; }
public void setStud_hobby(String[] stud_hobby) { this.stud_hobby = stud_hobby; } 
String stud_regdate; 
public String getStud_regdate() { return stud_regdate; } 
public void setStud_regdate(String stud_regdate) { this.stud_regdate = stud_regdate;}
//윗페이지는 동일
private boolean verified;
public boolean isVerified() {
	return verified;
}
public void setVerified(boolean verified) {
	this.verified = verified;
	}
}