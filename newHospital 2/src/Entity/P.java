package Entity;

import java.util.Date;

public class P {
	private int Pno;
	private String Pname;
	private Date Page;
	private String Ppwd;	
	private String Pid;
	private String Psex;
	private String Pjs;
	public String getPid() {
		return Pid;
	}
	public void setPid(String pid) {
		Pid = pid;
	}
	public int getPno() {
		return Pno;
	}
	public void info(int pno, String pid, String pname, Date page, String psex, String pjs) {
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		Pid = pid;
		Pjs = pjs;
	}
	public P(String pid, String pname, Date page, String ppwd, String psex) {
		Pname = pname;
		Page = page;
		Ppwd = ppwd;
		Psex = psex;
		Pid = pid;
	}
	public P(int pno, String pid, String pname, Date page, String psex, String pjs) {
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		Pid = pid;
		Pjs = pjs;
	}
	public P(int pno, String pid, String pname, Date page, String ppwd, String psex, String pjs) {
		Pno = pno;
		Pname = pname;
		Page = page;
		Ppwd = ppwd;
		Psex = psex;
		Pid = pid;
		Pjs = pjs;
	}
	public P() {
		
	}
	public void setPno(int pno) {
		Pno = pno;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public Date getPage() {
		return Page;
	}
	public void setPage(Date page) {
		Page = page;
	}
	public String getPpwd() {
		return Ppwd;
	}
	public void setPpwd(String ppwd) {
		Ppwd = ppwd;
	}
	public String getPsex() {
		return Psex;
	}
	public void setPsex(String psex) {
		Psex = psex;
	}
	public String getPjs() {
		return Pjs;
	}
	public void setPjs(String pjs) {
		Pjs = pjs;
	}
}
