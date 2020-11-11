package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.GH;
import Util.DBUtil;

public class GHDao {
	
	//添加医生预约
	public boolean addDGHDao(GH gh) {
		DBUtil util = new DBUtil();
		String sql = "insert into GH(pno,dno,timeno) values(?,?,?)";
		Object[] params = {gh.getPno(),gh.getDno(),gh.getTimeno()};
		return util.executeUpdate(sql, params);
	}	
	//添加科室预约
	public boolean addKSGHDao(GH gh) {
		DBUtil util = new DBUtil();
		String sql = "insert into GH(pno,ksno,timeno) values(?,?,?)";
		Object[] params = {gh.getPno(),gh.getKSno(),gh.getTimeno()};
		return util.executeUpdate(sql, params);
	}	
	//根据预约号删除预约
	public boolean delGHByGHnoDao(int ghno) {
		DBUtil util = new DBUtil();
		String sql = "delete from GH where ghno=?";
		Object[] params = {ghno};
		return util.executeUpdate(sql, params);
	}	
//	根据科室或医生查询科室所有预约
	public List<GH> queryAllGHByDksnoDao(String dksno) {
		GH gh = null;
		List<GH> ghs = new ArrayList<GH>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		int dno = 0;
		if(!dksno.isEmpty()){
			if(dksno.matches("^[0-9]*$")){
				dno = Integer.parseInt(dksno);
			}
		}
		Object[] params = {dno, dksno};
		try {
			String sql = "select * from (GH JOIN P USING(pno)) join doctor_worktime USING(timeno) WHERE GH.dno=? or ksno=?";
			rs = util.executeQuery(sql, params);
			while (rs.next()) {
				int no = rs.getInt("pno");
				String name = rs.getString("pname");
				String age = rs.getString("page");
				String sex = rs.getString("psex");
				int ghno = rs.getInt("ghno");
				int timereg = rs.getInt("timereg");
				String timedate = rs.getString("timedate");
				gh = new GH(no,name,age,sex,ghno,timereg,timedate);
				ghs.add(gh);
			}
			return ghs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	//根据用户查
	public List<GH> queryAllGHByPnoDao(int pno) {
		GH gh = null;
		List<GH> ghs = new ArrayList<GH>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		Object[] params = {pno};
		try {
			String sql = "select * from (GH JOIN P USING(pno)) join doctor_worktime USING(timeno) WHERE pno = ?";
			rs = util.executeQuery(sql, params);
			while (rs.next()) {
				int no = rs.getInt("GH.pno");
				String name = rs.getString("pname");
				int dno = rs.getInt("dno");
				String ksno = rs.getString("ksno");
				int ghno = rs.getInt("ghno");
				int timereg = rs.getInt("timereg");
				String timedate = rs.getString("timedate");
				gh = new GH(no,name,dno,ksno,timereg,timedate,ghno);
				
				ghs.add(gh);
			}
			return ghs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	//根据挂号查
	public boolean queryAllGHByGHnoDao(GH gh) {
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		Object[] params = {gh.getPno(),gh.getTimeno(),gh.getDno(),gh.getKSno()};
		try {
			String sql = "select * from GH where pno = ? and timeno = ? and (dno = ? or ksno = ?);";
			rs = util.executeQuery(sql, params);
			if(rs.next()){
				return true;			
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;	
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
}
