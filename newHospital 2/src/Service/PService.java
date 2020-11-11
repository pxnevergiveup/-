package Service;
import java.util.List;
import Dao.PDao;
import Entity.P;
public class PService {
	PDao pDao =new PDao();
	//��||ע��
	public boolean addP(P p) {
		if(!pDao.isExist(p.getPid())){
			return pDao.addPDao(p);
		}
		return false;
	}
	//ɾ
	public boolean delPByPno(int pno) {
		if(pDao.isExist(pno)){
			return pDao.delPByPndDao(pno);
		}
		return false;
	}
	//��
	public boolean updatePByPno(P p) {
		if(pDao.isExist(p.getPno())){
			return pDao.updatePByPnoDao(p);
		}
		return false;
	}
	//���ݹ��Ų�
	public P queryPByPno(String pno) {
		return pDao.queryPByPnoDao(pno);
	}
	//��ȫ��ҽ��
	public List<P> queryAllP() {
		return pDao.queryAllPDao();
	}
	//��¼
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
