package Entity;

import java.util.Date;

public class Doctor {
	private int Dno;
	private String Dname;
	private Date Dage;
	private String kSno;
	private String Dpwd;
	private String Dsex;
	private int Sfzj;
	private String Djs;
	private String Did;
	private String Ksname;
	
	public Doctor(String did, String dname, Date dage, String kSno, String dpwd, String dsex, int sfzj) {
		Dname = dname;
		Dage = dage;
		this.kSno = kSno;
		Dpwd = dpwd;
		Dsex = dsex;
		Did = did;
		Sfzj = sfzj;
	}
	public void info(int dno, String did, String dname, Date dage, String dsex, String djs) {		
		Dno = dno;
		Dname = dname;
		Dage = dage;
		Dsex = dsex;
		Djs = djs;
		Did = did;
	}

	public Doctor(int dno, String did, String dname, Date dage, String kSno, String dpwd, String dsex, int sfzj, String djs,String ksname) {
		Dno = dno;
		Dname = dname;
		Dage = dage;
		this.kSno = kSno;
		Dpwd = dpwd;
		Dsex = dsex;
		Sfzj = sfzj;
		Djs = djs;
		Did = did;
		Ksname =ksname;
	}
	public Doctor() {
		
	}
	public String getKsname() {
		return Ksname;
	}
	public void setKsname(String ksname) {
		Ksname = ksname;
	}
	public String getDid() {
		return Did;
	}
	public void setDid(String did) {
		Did = did;
	}
	public Date getDage() {
		return Dage;
	}
	public void setDage(Date dage) {
		Dage = dage;
	}
	public int getDno() {
		return Dno;
	}
	public void setDno(int dno) {
		Dno = dno;
	}
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getkSno() {
		return kSno;
	}
	public void setkSno(String kSno) {
		this.kSno = kSno;
	}
	public String getDpwd() {
		return Dpwd;
	}
	public void setDpwd(String dpwd) {
		Dpwd = dpwd;
	}
	public String getDsex() {
		return Dsex;
	}
	public void setDsex(String dsex) {
		Dsex = dsex;
	}
	public int getSfzj() {
		return Sfzj;
	}
	public void setSfzj(int sfzj) {
		Sfzj = sfzj;
	}
	public String getDjs() {
		return Djs;
	}
	public void setDjs(String djs) {
		Djs = djs;
	}	
} 
