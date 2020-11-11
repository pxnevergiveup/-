package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Entity.YD;
import Util.DBUtil;

public class YDDao {
	//添加医生注册表
		public boolean addYDDao(YD yd) {
			DBUtil util = new DBUtil();
			String sql = "insert into YD(ydid,ydname,ydate,ydksno,ydpwd,ydsex,ydsfzj) values(?,?,?,?,?,?,?)";
			Object[] params = {yd.getYdid(),yd.getYdname(),yd.getYdate(),yd.getYdKsno(),yd.getYdpwd(),yd.getYdsex(),yd.getYdsfzj()};
			return util.executeUpdate(sql, params);
		}
		//根据电话号删除医生注册表
		public boolean delYDByDnoDao(String ydid) {
			DBUtil util = new DBUtil();
			String sql = "delete from YD where ydid=?";
			Object[] params = {ydid};
			return util.executeUpdate(sql, params);
		}
		
//		查询所有医生注册表
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
		//根据手机或工号查
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
		//查询电话 医生注册表是否存在
		public boolean isExist(String id) {
			return queryYDByDnoDao(id)==null? false:true;
		}
}
