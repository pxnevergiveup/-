package websocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

@ServerEndpoint(value = "/chat")
public class MyWebSocketServer {
	private static Gson gson = new Gson();
	private static Map<String, List<String>> ks_name = new HashMap<String,List<String>>();// 在线列表<ksno, <"张三","李四">>	
	private static Map<Session, String> sessionGo = new HashMap<Session, String>();// 存储分组，发送信息<session,ksno>、
	private Map<String, String> userInfo;// 存储url传值用的
	private String utype;
	private String uno;
	private String uname;
	private String uksno;
	private String s_msg=null;
	private user user;
	
	@OnOpen
	public void onOpen(Session s) throws UnsupportedEncodingException {
		System.out.println("打开连接");
		String queryString = s.getQueryString();
		queryString = URLDecoder.decode(queryString, "UTF-8");
		userInfo = new HashMap<String, String>();
		if (queryString.contains("&")) {
			String[] split = queryString.split("\\&");
			for (String string : split) {
				String[] split2 = string.split("=");
				userInfo.put(split2[0], split2[1]);
			}
		} else {
			String[] split = queryString.split("=");
			userInfo.put(split[0], split[1]);
		}
		//System.out.println(userInfo.toString());
		uname = userInfo.get("Name");
		uksno = userInfo.get("ksno");
		utype = userInfo.get("type");
		uno = userInfo.get("no");		
		sessionGo.put(s, uksno);
		if ("p".equals(utype)) {
			s_msg="用户[" + uname + "]上线了！";		
		} else if("doctor".equals(utype)) {
			s_msg="医生[" + uname + "]上线了！";
			if(ks_name.containsKey(uksno)){
				ks_name.get(uksno).add(uname);
			}
			else {
				List<String> a = new ArrayList<String>();
				a.add(uname);
				ks_name.put(uksno, a);
			}
		}
		user = new user(uno, uksno, utype, ks_name.get(uksno), uname, "s", s_msg);
		String json = gson.toJson(user);
		sendMsg(uksno, sessionGo, json);
	}

	@OnClose
	public void onClose(Session s) {
		System.out.println("连接关闭");
		ks_name.get(uksno).remove(uname);		
		if ("p".equals(utype)) {
			s_msg="用户[" + uname + "]下线了";			
		} else if("doctor".equals(utype)) {
			s_msg="医生[" + uname + "]下线了";
			sessionGo.remove(uksno);
		}
		user = new user(uno, uksno, utype, ks_name.get(uksno), uname, "s", s_msg);
		String json = gson.toJson(user);
		sendMsg(uksno, sessionGo, json);
	}

	@OnError
	public void onError(Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	@OnMessage
	public void onMessage(String message) throws IOException {		
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		String time = timestamp.toString().substring(0,19);
		s_msg = time;
		user = new user(uno, uksno, utype, ks_name.get(uksno), uname, "s", s_msg);
		String json0 = gson.toJson(user);
		sendMsg(uksno, sessionGo, json0);
		user = new user(uno, uksno, utype, ks_name.get(uksno), uname, "u", message);
		String json = gson.toJson(user);
		sendMsg(uksno, sessionGo, json);
	}

	// 推送信息
	private void sendMsg(String ksno, Map<Session, String> m, String message) {
		List<Session> set = new ArrayList<Session>();
		for (Session key : m.keySet()) {
			String value = m.get(key);
			if (ksno.equals(value)) {
				set.add(key);
			}
		}
		try {
			for (Session session : set) {
				if(session.isOpen()){
					session.getBasicRemote().sendText(message);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}