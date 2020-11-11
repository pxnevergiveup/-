package Entity;

public class KS {
	private String Ksno;
	private String Ksname;
	public KS() {

	}
	public KS(String ksno, String ksname) {
		Ksno = ksno;
		Ksname = ksname;
	}
	public String getKsno() {
		return Ksno;
	}
	public void setKsno(String ksno) {
		Ksno = ksno;
	}
	public String getKsname() {
		return Ksname;
	}
	public void setKsname(String ksname) {
		Ksname = ksname;
	}
	
}
