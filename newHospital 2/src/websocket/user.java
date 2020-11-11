package websocket;

import java.util.List;

public class user {
	private String msgNo;
	private String msgKsno;
	private String msgType;
	private List<String> userList;
	private String msgOder;
	private String msgOppo;
	private String msgInfo;
	private String msgKsname;
	
	public user(String msgNo, String msgKsno, String msgType, List<String> userList, String msgOder, String msgOppo, String msgInfo) {
		this.msgNo = msgNo;
		this.msgKsno = msgKsno;
		this.msgType = msgType;
		this.userList = userList;
		this.msgOder = msgOder;
		this.msgOppo = msgOppo;
		this.msgInfo = msgInfo;
	}

	public user(String msgNo, String msgKsno, String msgType, String msgOder, String msgKsname) {
		this.msgNo = msgNo;
		this.msgKsno = msgKsno;
		this.msgType = msgType;
		this.msgOder = msgOder;
		this.msgKsname = msgKsname;
	}

	public user() {
		
	}
	public String getMsgKsname() {
		return msgKsname;
	}
	public void setMsgKsname(String msgKsname) {
		this.msgKsname = msgKsname;
	}
	public String getMsgNo() {
		return msgNo;
	}
	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}
	public String getMsgKsno() {
		return msgKsno;
	}
	public void setMsgKsno(String msgKsno) {
		this.msgKsno = msgKsno;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	public List<String> getUserList() {
		return userList;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	public String getMsgOder() {
		return msgOder;
	}
	public void setMsgOder(String msgOder) {
		this.msgOder = msgOder;
	}
	public String getMsgOppo() {
		return msgOppo;
	}
	public void setMsgOppo(String msgOppo) {
		this.msgOppo = msgOppo;
	}
	public String getMsgInfo() {
		return msgInfo;
	}
	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}
}
