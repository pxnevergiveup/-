package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Entity.YD;
import Util.DBUtil;

public class YDDao {
	//���ҽ��ע���
		public boolean addYDDao(YD yd) {
			DBUtil util = new DBUtil();
			String sql = "insert into YD(ydid,ydname,ydate,ydksno,ydpwd,ydsex,ydsfzj) values(?,?,?,?,?,?,?)";
			Object[] params = {yd.getYdid(),yd.getYdname(),yd.getYdate(),yd.getYdKsno(),yd.getYdpwd(),yd.getYdsex(),yd.getYdsfzj()};
			return util.executeUpdate(sql, params);
		}
		//���ݵ绰��ɾ��ҽ��ע���
		public boolean delYDByDnoDao(String ydid) {
			DBUtil util = new DBUtil();
			String sql = "delete from YD where ydid=?";
			Object[] params = {ydid};
			return util.executeUpdate(sql, params);
		}
		
//		��ѯ����ҽ��ע���
		public List<YD> queryAllYDDao() {
			YD yd = null;
			List<YD> yds = new ArrayList<YD>();
			ResultSet rs = null;
			DBUtil util = new DBUtil();
			try {
				String sql = "select * from yd";
				rs = util.executeQuery(sql, null);
				while (rs.next()) {
					String id = rs.getString("ydid");
					String name = rs.getString("ydname");
					Date age = rs.getDate("ydate");
					String ksno = rs.getString("ydksno");				
					String pwd = rs.getString("ydpwd");
					String sex = rs.getString("ydsex");
					int sfzj = rs.getInt("ydsfzj");
					yd = new YD(id,name,age,ksno,pwd,sex,sfzj);
					yds.add(yd);
				}
				return yds;
			} catch (Exception e) {
				e.printStackTrace();
				return null;	
			}
			finally {
				DBUtil.closeAll(rs, util.pstmt, util.connection);
			}	
		}
		//�����ֻ��򹤺Ų�
		public YD queryYDByDnoDao(String ydid) {
			YD yd = null;
			ResultSet rs = null;
			String sql = "select * from yd where ydid = ?";
			Object[] params={ydid};
			DBUtil util = new DBUtil();
			try{
				rs = util.executeQuery(sql, params);
				if(rs.next()){
					String id = rs.getString("ydid");
					String name = rs.getString("ydname");
					Date age = rs.getDate("ydate");
					String ksno = rs.getString("ydksno");				
					String pwd = rs.getString("ydpwd");
					String sex = rs.getString("ydsex");
					int sfzj = rs.getInt("ydsfzj");
					yd = new YD(id,name,age,ksno,pwd,sex,sfzj);	
				}
				return yd;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally{
				DBUtil.closeAll(rs, util.pstmt, util.connection);
			}
		}
		//��ѯ�绰 ҽ��ע����Ƿ����
		public boolean isExist(String id) {
			return queryYDByDnoDao(id)==null? false:true;
		}
}
