package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Doctor;
import Entity.KS;
import Util.DBUtil;

public class KSDao {
	//查询所有科室
	public List<KS> queryAllKSDao() {
		KS ks = null;
		List<KS> KSs = new ArrayList<KS>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		try {
			String sql = "select * from KS";
			rs = util.executeQuery(sql, null);
			while (rs.next()) {
				String no = rs.getString("ksno");
				String name = rs.getString("ksname");
				ks = new KS(no,name);
				KSs.add(ks);
			}
			return KSs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	//查询该科室的医生
	public List<Doctor> queryDoctorByksnoDao(String Ksno) {
		Doctor doctor = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		Object[] params = {Ksno};
		try {
			String sql = "select * from doctor JOIN ks USING(KSNO) where ksno = ?";
			rs = util.executeQuery(sql, params);
			while (rs.next()) {
				String ksno = rs.getString("ksno");	
				int no = rs.getInt("dno");
				String id = rs.getString("did");
				String name = rs.getString("dname");
				Date age = rs.getDate("dage");							
				String pwd = rs.getString("dpwd");
				String sex = rs.getString("dsex");
				int sfzj = rs.getInt("sfzj");
				String js = rs.getString("djs");
				String ksname = rs.getString("ksname");
				doctor = new Doctor(no,id,name,age,ksno,pwd,sex,sfzj,js,ksname);
				doctors.add(doctor);
			}
			return doctors;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}	
	}
	public KS queryKSByKSnoDao(String Ksno) {
		KS ks = null;
		ResultSet rs = null;
		String sql = "select * from ks where ksno = ?";
		Object[] params={Ksno};
		DBUtil util = new DBUtil();
		try{
			rs = util.executeQuery(sql, params);
			if(rs.next()){
				String ksno = rs.getString("ksno");	
				String ksname = rs.getString("ksname");
				ks = new KS(ksno,ksname);	
			}
			return ks;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}
	}
}
