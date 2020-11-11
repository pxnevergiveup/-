package Service;
import java.util.List;
import Dao.PDao;
import Entity.P;
public class PService {
	PDao pDao =new PDao();
	//增||注册
	public boolean addP(P p) {
		if(!pDao.isExist(p.getPid())){
			return pDao.addPDao(p);
		}
		return false;
	}
	//删
	public boolean delPByPno(int pno) {
		if(pDao.isExist(pno)){
			return pDao.delPByPndDao(pno);
		}
		return false;
	}
	//改
	public boolean updatePByPno(P p) {
		if(pDao.isExist(p.getPno())){
			return pDao.updatePByPnoDao(p);
		}
		return false;
	}
	//根据工号查
	public P queryPByPno(String pno) {
		return pDao.queryPByPnoDao(pno);
	}
	//查全部医生
	public List<P> queryAllP() {
		return pDao.queryAllPDao();
	}
	//登录
	public boolean loginP(String pno,String pwd) {
		P p =  pDao.queryPByPnoDao(pno);
		if (p!=null) {
			if(pwd.equals(p.getPpwd())){
				return true;
			}
			else {
				return false;
			}
		}	
		return false;
	}
}
