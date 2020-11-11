package Dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entity.Doctor;
import Util.DBUtil;
public class DoctorDao {
	//���ҽ��
	public boolean addDoctorDao(Doctor doctor) {
		DBUtil util = new DBUtil();
		String sql = "insert into Doctor(did,dname,dage,ksno,dpwd,dsex,sfzj,djs) values(?,?,?,?,?,?,?,?)";
		Object[] params = {doctor.getDid(),doctor.getDname(),doctor.getDage(),doctor.getkSno(),doctor.getDpwd(),doctor.getDsex(),doctor.getSfzj(),doctor.getDjs()};
		return util.executeUpdate(sql, params);
	}
	//���ݹ��Ÿ���ҽ��
	public boolean updateDoctorDao(Doctor doctor) {
		DBUtil util = new DBUtil();
		String sql = "update Doctor set did=?,dname=?,dage=?,ksno=?,dpwd=?,dsex=?,sfzj=?,djs=? where dno=?";
		Object[] params = {doctor.getDid(),doctor.getDname(),doctor.getDage(),doctor.getkSno(),doctor.getDpwd(),doctor.getDsex(),doctor.getSfzj(),doctor.getDjs(),doctor.getDno()};
		return util.executeUpdate(sql, params);
	}
	//���ݹ���ɾ��ҽ��
	public boolean delDoctorByDnoDao(int dno) {
		DBUtil util = new DBUtil();
		String sql = "delete from Doctor where dno=?";
		Object[] params = {dno};
		return util.executeUpdate(sql, params);
	}
	
//	��ѯ����ҽ��
	public List<Doctor> queryAllDoctorDao() {
		Doctor doctor = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		ResultSet rs = null;
		DBUtil util = new DBUtil();
		try {
			String sql = "select * from doctor JOIN ks USING(KSNO)";
			rs = util.executeQuery(sql, null);
			while (rs.next()) {
				int no = rs.getInt("dno");
				String id = rs.getString("did");
				String name = rs.getString("dname");
				Date age = rs.getDate("dage");
				String ksno = rs.getString("ksno");				
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
	//�����ֻ��򹤺Ų�
	public Doctor queryDoctorByDnoDao(String did) {
		Doctor doctor = null;
		ResultSet rs = null;
		String sql = "select * from doctor JOIN ks USING(KSNO) where dno = ? or did = ?";
		long dno = Long.parseLong(did);
		Object[] params={dno,did};
		DBUtil util = new DBUtil();
		try{
			rs = util.executeQuery(sql, params);
			if(rs.next()){
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
			}
			return doctor;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			DBUtil.closeAll(rs, util.pstmt, util.connection);
		}
	}
	//��ѯ���� ҽ���Ƿ����
	public boolean isExist(int dno) {
		String id = Integer.toString(dno);
		return queryDoctorByDnoDao(id)==null? false:true;
	}
	//��ѯ�绰 ҽ���Ƿ����
	public boolean isExist(String id) {
		return queryDoctorByDnoDao(id)==null? false:true;
	}
}
