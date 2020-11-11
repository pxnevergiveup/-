package Entity;

public class Article {
	private int address;
	private int dno;
	private String head;
	private String partsString;
	private int part;
	
	public String getPartsString() {
		return partsString;
	}
	public void setPartsString(String partsString) {
		this.partsString = partsString;
	}
	public int getPart() {
		return part;
	}
	public void setPart(int part) {
		this.part = part;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Article() {

	}
	public Article(int dno, String head, int part) {
		this.dno = dno;
		this.head = head;
		this.part = part;
	}
	public Article(int address, int dno, String head) {
		this.address = address;
		this.dno = dno;
		this.head = head;
	}
	public Article(int address, int dno, String head, int part) {
		this.address = address;
		this.dno = dno;
		this.head = head;
		this.part = part;
	}
	public Article(int address, int dno, String head, String partsString) {
		this.address = address;
		this.dno = dno;
		this.head = head;
		this.partsString = partsString;
	}
}
