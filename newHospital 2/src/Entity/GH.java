package Entity;

import Service.doctorService;

public class GH {
	private int Pno;
	private String Pname;
	private String Page;
	private String Psex;
	private int Dno;
	private String KSno;
	private int GHno;
	private int timereg;
	private String timedate;
	private int timeno;
	private String timetime;
	private String Dname;
	public GH() {
		
	}
	public GH(int pno, String pname, String page, String psex, int dno, String kSno, int gHno, int timereg) {
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		Dno = dno;
		KSno = kSno;
		GHno = gHno;
		this.timereg = timereg;
	}
	public GH(int pno, String kSno, int timeno) {
		Pno = pno;
		KSno = kSno;
		this.timeno = timeno;
	}
	public GH(int pno, int dno, int timeno) {
		Pno = pno;
		Dno = dno;
		this.timeno = timeno;
	}
	public GH(int pno, String kSno, int gHno, int timereg) {		
		Pno = pno;
		KSno = kSno;
		GHno = gHno;
		this.timereg = timereg;
	}
	public GH(int pno, int dno, int gHno, int timereg) {		
		Pno = pno;
		Dno = dno;
		GHno = gHno;
		this.timereg = timereg;
	}
	public GH(int pno, String pname, int dno, String kSno, int timereg, String timedate , int gHno) {
		Pno = pno;
		Pname = pname;
		Dno = dno;
		KSno = kSno;
		GHno = gHno;
		this.timereg = timereg;
		this.timedate = timedate;
		if(kSno == null || kSno.isEmpty()){
			doctorService service = new doctorService();
			Doctor doctor = service.queryDoctorByDno(Integer.toString(dno));
			Dname = doctor.getDname();
			KSno = doctor.getkSno();
		}
		switch (Integer.toString(timereg)) {
			case "1":
				this.timetime="0:00-6:00";
				break;
			case "2":
				this.timetime="6:00-12:00";
				break;
			case "3":
				this.timetime="12:00-18:00";
				break;
			case "4":
				this.timetime="18:00-24:00";
				break;
			default:
				break;
		}
	}
	public GH(int pno, String pname, String page, String psex, int gHno) {		
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		GHno = gHno;
	}
	public GH(int pno, String pname, String page, String psex, int gHno, int timereg, String timedate) {		
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		GHno = gHno;
		this.timereg = timereg;
		this.timedate = timedate;
	}
	public GH(int pno, String pname, String page, String psex, String kSno, int gHno) {		
		Pno = pno;
		Pname = pname;
		Page = page;
		Psex = psex;
		KSno = kSno;
		GHno = gHno;
	}
	
	public String getDname() {
		return Dname;
	}
	public void setDname(String dname) {
		Dname = dname;
	}
	public String getTimetime() {
		return timetime;
	}
	public void setTimetime(String timetime) {
		this.timetime = timetime;
	}
	public int getTimeno() {
		return timeno;
	}
	public void setTimeno(int timeno) {
		this.timeno = timeno;
	}
	public String getTimedate() {
		return timedate;
	}
	public void setTimedate(String timedate) {
		this.timedate = timedate;
	}
	public int getTimereg() {
		return timereg;
	}
	public void setTimereg(int timereg) {
		this.timereg = timereg;
	}
	public int getPno() {
		return Pno;
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
	public String getPage() {
		return Page;
	}
	public void setPage(String page) {
		Page = page;
	}
	public String getPsex() {
		return Psex;
	}
	public void setPsex(String psex) {
		Psex = psex;
	}
	public int getDno() {
		return Dno;
	}
	public void setDno(int dno) {
		Dno = dno;
	}
	public String getKSno() {
		return KSno;
	}
	public void setKSno(String kSno) {
		KSno = kSno;
	}
	public int getGHno() {
		return GHno;
	}
	public void setGHno(int gHno) {
		GHno = gHno;
	}	
}
