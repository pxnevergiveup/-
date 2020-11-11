package Service;

import java.util.List;

import Dao.DoctorDao;
import Dao.YDDao;
import Entity.Doctor;
import Entity.YD;

public class doctorService {
	DoctorDao doctorDao =new DoctorDao();
	YDDao ydDao = new YDDao();
	//医生申请注册
		public boolean addYD(YD yd) {
			if(!ydDao.isExist(yd.getYdid())){
				return ydDao.addYDDao(yd);
			}
			return false;
		}
		//删
		public boolean delYDByDno(String did) {
			if(ydDao.isExist(did)){
				return ydDao.delYDByDnoDao(did);
			}
			return false;
		}
		//根据手机或工号查
		public YD queryYDByDno(String dno) {
			return ydDao.queryYDByDnoDao(dno);
		}
		//管理员查待审核医生
		public List<YD> queryAllYD() {
			return ydDao.queryAllYDDao();
		}
		
		
	//管理员操作注册成功
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
	//管理员删医生
	public boolean delDoctorByDno(int dno) {
		if(doctorDao.isExist(dno)){
			return doctorDao.delDoctorByDnoDao(dno);
		}
		return false;
	}
	//改
	public boolean updateDoctor(Doctor doctor) {
		if(doctorDao.isExist(doctor.getDno())){
			return doctorDao.updateDoctorDao(doctor);
		}
		return false;
	}
	//根据手机或工号查
	public Doctor queryDoctorByDno(String dno) {
		return doctorDao.queryDoctorByDnoDao(dno);
	}
	//查全部医生
	public List<Doctor> queryAllDoctor() {
		return doctorDao.queryAllDoctorDao();
	}
	//登录
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

