package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Entity.DoctorWorktime;
import Entity.GH;
import Util.DBUtil;
import cn.itcast.jdbc.TxQueryRunner;


public class WorktimeDao {
		private QueryRunner qr = new TxQueryRunner();
		//���ݹ���ʱ��鿴�Ƿ���ڹҺű�
		public boolean GHisExist(int timeno) {
			String sql = "select * from gh where timeno = ?";
			try{
				GH query = qr.query(sql, new BeanHandler<GH>(GH.class), timeno);
				if (query!=null) {
					return true;
				}
				else {
					return false;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		//ɾ�������ù���ʱ��ĹҺű�
		public boolean delGHbytimenoDao(int timeno) {
			String sql = "delete from gh where timeno = ?";
			try{
				int update = qr.update(sql,timeno);
				if(update > 0){
					return true;
				}
				return false;			
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}			
		}
		//��ӹ�����
		public boolean addWorktimeDao(DoctorWorktime time) {
			String sql = "insert into doctor_worktime(dno,timedate,timereg) values(?,?,?)";
			try {
				Object[] params = {time.getDno(),time.getTimedate(),time.getTimereg()};
				if (qr.update(sql,params)>0) {
					return true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return false;
		}
		//���ݹ���ɾ��������
		public boolean delWorktimeByDnoDao(int timeno) {
			String sql = "delete from doctor_worktime where timeno=?";
			try {
				if (qr.update(sql,timeno)>0) {
					return true;
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return false;
		}
		
		//���ݹ��Ų�
		public List<DoctorWorktime> queryWorktimeByDnoDao(int dno) {
			DoctorWorktime doctor = null;
			List<DoctorWorktime> doctors = new ArrayList<DoctorWorktime>();
			ResultSet rs = null;
			DBUtil util = new DBUtil();
			try {
				String sql = "select * from doctor_worktime join worktime using(timereg) where dno = ?";
				Object[] params = {dno};
				rs = util.executeQuery(sql, params);
				while (rs.next()) {
					int no = rs.getInt("dno");
					String timedate = rs.getString("timedate");
					int timereg = rs.getInt("timereg");
					String timetime = rs.getString("timetime");
					doctor = new DoctorWorktime(no,timedate,timereg,timetime);
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
		//���ݹ����������ҵ�timeno
		public int queryWorktimeByWTDao(DoctorWorktime doctorWorktime) {			
			String sql = "select * from doctor_worktime where dno = ? and timereg = ? and timedate = ?";
			Object parmas[] = {doctorWorktime.getDno(),doctorWorktime.getTimereg(),doctorWorktime.getTimedate()};
			try {
				DoctorWorktime query = qr.query(sql, new BeanHandler<DoctorWorktime>(DoctorWorktime.class),parmas);
				if (query!=null) {
					return query.getTimeno();
				}
				else {
					return -1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}
		//��ѯ���� �������Ƿ����
		public boolean isExist(DoctorWorktime doctorWorktime) {
			return queryWorktimeByWTDao(doctorWorktime)>0? true:false;
		}
	}
