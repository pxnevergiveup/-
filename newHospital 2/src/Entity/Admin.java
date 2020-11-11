package Entity;

public class Admin {
	private String Gno;
	private String Gpw;
	public Admin() {
		
	}
	public Admin(String gno, String gpw) {
		Gno = gno;
		Gpw = gpw;
	}
	public String getGno() {
		return Gno;
	}
	public void setGno(String gno) {
		Gno = gno;
	}
	public String getGpw() {
		return Gpw;
	}
	public void setGpw(String gpw) {
		Gpw = gpw;
	}
}
