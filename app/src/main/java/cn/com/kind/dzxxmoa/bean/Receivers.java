package cn.com.kind.dzxxmoa.bean;

public class Receivers {
  private String ReceId;
  private String ReceName;
  private String ReceDeptid;
  private String ReceDeptname;
  private String ReceOrgid;
  private String ReceOrgname;
  private String ReceInfoid;
  private String ReceDate;
public String getReceId() {
	return ReceId;
}
public void setReceId(String receId) {
	ReceId = receId;
}
public String getReceName() {
	return ReceName;
}
public void setReceName(String receName) {
	ReceName = receName;
}
public String getReceDeptid() {
	return ReceDeptid;
}
public void setReceDeptid(String receDeptid) {
	ReceDeptid = receDeptid;
}
public String getReceDeptname() {
	return ReceDeptname;
}
public void setReceDeptname(String receDeptname) {
	ReceDeptname = receDeptname;
}
public String getReceOrgid() {
	return ReceOrgid;
}
public void setReceOrgid(String receOrgid) {
	ReceOrgid = receOrgid;
}
public String getReceOrgname() {
	return ReceOrgname;
}
public void setReceOrgname(String receOrgname) {
	ReceOrgname = receOrgname;
}
public String getReceInfoid() {
	return ReceInfoid;
}
public void setReceInfoid(String receInfoid) {
	ReceInfoid = receInfoid;
}
public String getReceDate() {
	return ReceDate;
}
public void setReceDate(String receDate) {
	ReceDate = receDate;
}
public Receivers(String receId, String receName, String receDeptid, String receDeptname, String receOrgid,
                 String receOrgname, String receInfoid, String receDate) {
	super();
	ReceId = receId;
	ReceName = receName;
	ReceDeptid = receDeptid;
	ReceDeptname = receDeptname;
	ReceOrgid = receOrgid;
	ReceOrgname = receOrgname;
	ReceInfoid = receInfoid;
	ReceDate = receDate;
}
public Receivers() {
	super();
}
@Override
public String toString() {
	return "Receivers [ReceId=" + ReceId + ", ReceName=" + ReceName + ", ReceDeptid=" + ReceDeptid + ", ReceDeptname="
			+ ReceDeptname + ", ReceOrgid=" + ReceOrgid + ", ReceOrgname=" + ReceOrgname + ", ReceInfoid=" + ReceInfoid
			+ ", ReceDate=" + ReceDate + "]";
}
  
  
  
  
  
  
}
