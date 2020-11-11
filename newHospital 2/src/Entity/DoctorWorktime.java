package Entity;


public class DoctorWorktime {
	private int timeno;
	private int dno;
	private String timedate;
	private int timereg;
	private String timetime;
	
	public DoctorWorktime(int timeno, int dno, String timedate, int timereg, String timetime) {
		this.timeno = timeno;
		this.dno = dno;
		this.timedate = timedate;
		this.timereg = timereg;
		this.timetime = timetime;
	}
	public DoctorWorktime() {
		
	}
	public DoctorWorktime(int dno, String timedate, int timereg) {
		this.dno = dno;
		this.timedate = timedate;
		this.timereg= timereg;
	}
	public DoctorWorktime(int dno, String timedate, int timereg, String timetime) {
		this.dno = dno;
		this.timedate = timedate;
		this.timereg= timereg;
		this.timetime = timetime;
	}
	public DoctorWorktime(String timetime) {
		switch (timetime) {
			case "0:00-6:00":
				this.timereg=1;
				break;
			case "6:00-12:00":
				this.timereg=2;
				break;
			case "12:00-18:00":
				this.timereg=3;
				break;
			case "18:00-24:00":
				this.timereg=4;
				break;
			default:
				break;
		}
		
	}
	public int getTimeno() {
		return timeno;
	}
	public void setTimeno(int timeno) {
		this.timeno = timeno;
	}
	public String getTimetime() {
		return timetime;
	}
	public void setTimetime(String timetime) {
		this.timetime = timetime;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
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
}
