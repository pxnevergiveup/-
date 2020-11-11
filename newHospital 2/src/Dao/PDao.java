package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.P;
import Util.DBUtil;

public class PDao {
	//����û�
	public boolean addPDao(P p) {
		DBUtil util = new DBUtil();
		String sql = "insert into P(Pid,Pname,Page,Ppwd,Psex) values(?,?,?,?,?)";
		Object[] params = {p.getPid(),p.getPname(),p.getPage(),p.getPpwd(),p.getPsex()};
		return util.executeUpdate(sql, params);
	}
	//���ݹ��Ÿ����û�
	public boolean updatePByPnoDao(P p) {
		DBUtil util = new DBUtil();
		String sql = "update P set pid=?,pname=?,page=?,ppwd=?,psex=?,pjs=? where pno=?";
		Object[] params = {p.getPid(),p.getPname(),p.getPage(),p.getPpwd(),p.getPsex(),p.getPjs(),p.getPno()};
		return util.executeUpdate(sql, params);
	}
	//���ݹ���ɾ���û�
	public boolean delPByPndDao(int pno) {
		DBUtil util = new DBUtil();
		String sql = "delete from P where pno=?";
		Object[] params = {pno};
		return util.executeUpdate(sql, params);
	}
	
//	��ѯ�����û�
	public List<P> queryAllPDao() {
		P p = null;
		List<P> Ps = new ArrayList<P>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		try {
			String sql = "select * from P";
			rs = util.executeQuery(sql, null);
			while (rs.next()) {
				int no = rs.getInt("pno");
				String id= rs.getString("pid");
				String name = rs.getString("pname");
				Date age = rs.getDate("page");
				String pwd = rs.getString("ppwd");
				String sex = rs.getString("psex");
				String js = rs.getString("pjs");
				p = new P(no,id,name,age,pwd,sex,js);
				Ps.add(p);
			}
			return Ps;
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	//���ݹ��Ų�
	public P queryPByPnoDao(String pid) {
		P p = null;
		ResultSet rs = null;
		String sql = "select * from P where pno = ? or pid=?";
		long pno = Long.parseLong(pid);
		Object[] params={pno,pid};
		DBUtil util = new DBUtil();
		try{
			rs = util.executeQuery(sql, params);
			if(rs.next()){
				int no = rs.getInt("pno");
				String id = rs.getString("pid");
				String name = rs.getString("pname");
				Date age = rs.getDate("page");
				String pwd = rs.getString("ppwd");
				String sex = rs.getString("psex");
				String js = rs.getString("pjs");
				p = new P(no,id,name,age,pwd,sex,js);	
			}
			return p;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	//��ѯ�ù����û��Ƿ����
	public boolean isExist(int id) {
		String pno = Integer.toString(id);
		return queryPByPnoDao(pno)==null? false:true;
	}
	//��ѯ�绰 ҽ���Ƿ����
	public boolean isExist(String id) {
		return queryPByPnoDao(id)==null? false:true;
	}
}
