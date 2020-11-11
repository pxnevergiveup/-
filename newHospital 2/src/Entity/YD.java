package Entity;

import java.util.Date;

public class YD {
	private String Ydid;
	private String Ydname;
	private Date Ydate;
	private String YdKsno;
	private String Ydpwd;
	private String Ydsex;
	private int Ydsfzj;

	public YD() {
	}
	public int getYdsfzj() {
		return Ydsfzj;
	}
	public void setYdsfzj(int ydsfzj) {
		Ydsfzj = ydsfzj;
	}
	public YD(String ydid, String ydname, Date ydate, String ydKsno, String ydpwd, String ydsex, int ydsfzj) {
		Ydid = ydid;
		Ydname = ydname;
		Ydate = ydate;
		YdKsno = ydKsno;
		Ydpwd = ydpwd;
		Ydsex = ydsex;
		Ydsfzj = ydsfzj;
	}
	public String getYdid() {
		return Ydid;
	}
	public void setYdid(String ydid) {
		Ydid = ydid;
	}
	public String getYdname() {
		return Ydname;
	}
	public void setYdname(String ydname) {
		Ydname = ydname;
	}
	public Date getYdate() {
		return Ydate;
	}
	public void setYdate(Date ydate) {
		Ydate = ydate;
	}
	public String getYdKsno() {
		return YdKsno;
	}
	public void setYdKsno(String ydKsno) {
		YdKsno = ydKsno;
	}
	public String getYdpwd() {
		return Ydpwd;
	}
	public void setYdpwd(String ydpwd) {
		Ydpwd = ydpwd;
	}
	public String getYdsex() {
		return Ydsex;
	}
	public void setYdsex(String ydsex) {
		Ydsex = ydsex;
	}
}
