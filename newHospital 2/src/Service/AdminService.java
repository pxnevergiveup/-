package Service;

import Dao.AdminDao;
import Entity.Admin;

public class AdminService {
	AdminDao dao = new AdminDao();
	Admin admin = new Admin();
	//²é
	public Admin queryAdminByGno(String gno) {
		return dao.queryAdminByGnoDao(gno);
	}
	//µÇÂ¼
	public boolean login(String gno,String pwd) {
		if(dao.isExist(gno)){
			admin = dao.queryAdminByGnoDao(gno);
			if(pwd.equals(admin.getGpw())){
				return true;
			}
			else {
				return false;
			}
		}
		return false;		
	}
}
