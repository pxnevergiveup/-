package Dao;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import Entity.Admin;
import cn.itcast.jdbc.TxQueryRunner;

public class AdminDao {
	//根据管理员账号查
	private QueryRunner qr = new TxQueryRunner();
	public Admin queryAdminByGnoDao(String gno) {
		String sql = "select * from g where gno = ?";
		try {
			Admin query = qr.query(sql, new BeanHandler<Admin>(Admin.class),gno);
			return query;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	//查询账号 管理员是否存在
	public boolean isExist(String gno) {
		return queryAdminByGnoDao(gno)==null? false:true;
	}
}
