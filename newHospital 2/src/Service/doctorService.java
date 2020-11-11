package Service;

import java.util.List;

import Dao.DoctorDao;
import Dao.YDDao;
import Entity.Doctor;
import Entity.YD;

public class doctorService {
	DoctorDao doctorDao =new DoctorDao();
	YDDao ydDao = new YDDao();
	//ҽ������ע��
		public boolean addYD(YD yd) {
			if(!ydDao.isExist(yd.getYdid())){
				return ydDao.addYDDao(yd);
			}
			return false;
		}
		//ɾ
		public boolean delYDByDno(String did) {
			if(ydDao.isExist(did)){
				return ydDao.delYDByDnoDao(did);
			}
			return false;
		}
		//�����ֻ��򹤺Ų�
		public YD queryYDByDno(String dno) {
			return ydDao.queryYDByDnoDao(dno);
		}
		//����Ա������ҽ��
		public List<YD> queryAllYD() {
			return ydDao.queryAllYDDao();
		}
		
		
	//����Ա����ע��ɹ�
	public boolean addDoctor(YD yd) {
		if(!doctorDao.isExist(yd.getYdid())){
			Doctor doctor = new Doctor(yd.getYdid(),yd.getYdname(),yd.getYdate(),yd.getYdKsno(),yd.getYdpwd(),yd.getYdsex(),yd.getYdsfzj());
			if(delYDByDno(yd.getYdid())){
				return doctorDao.addDoctorDao(doctor);
			}
			else {
				return false;
			}
		}
		return false;
	}
	//����Աɾҽ��
	public boolean delDoctorByDno(int dno) {
		if(doctorDao.isExist(dno)){
			return doctorDao.delDoctorByDnoDao(dno);
		}
		return false;
	}
	//��
	public boolean updateDoctor(Doctor doctor) {
		if(doctorDao.isExist(doctor.getDno())){
			return doctorDao.updateDoctorDao(doctor);
		}
		return false;
	}
	//�����ֻ��򹤺Ų�
	public Doctor queryDoctorByDno(String dno) {
		return doctorDao.queryDoctorByDnoDao(dno);
	}
	//��ȫ��ҽ��
	public List<Doctor> queryAllDoctor() {
		return doctorDao.queryAllDoctorDao();
	}
	//��¼
	public boolean loginDoctor(String id,String pwd) {
		Doctor doctor =  doctorDao.queryDoctorByDnoDao(id);
		if (doctor!=null) {
			if(pwd.equals(doctor.getDpwd())){
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public boolean isExist(String id) {
		return doctorDao.isExist(id);
	}
}

