package Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Dao.WorktimeDao;
import Entity.DoctorWorktime;

public class WorktimeService {
		WorktimeDao wtDao =new WorktimeDao();
		//增
		public boolean addWT(DoctorWorktime doctorWorktime) {
			if(!wtDao.isExist(doctorWorktime)){
				return wtDao.addWorktimeDao(doctorWorktime);
			}
			return false;
		}
		//删除该时间的预约表
		public boolean delGHBytimeno(int timeno) {	
			if(timeno > 0){
				if(wtDao.GHisExist(timeno)){
					if(wtDao.delGHbytimenoDao(timeno)){
						if(wtDao.delWorktimeByDnoDao(timeno)){
							return true;
						}
					}
				}
			}
			return false;
		}
		//删
		public int delWTByWT(DoctorWorktime doctorWorktime) {
			int timeno = wtDao.queryWorktimeByWTDao(doctorWorktime);
			if(timeno > 0){
				if(wtDao.GHisExist(timeno)){
					return -1;
				}
				else if(wtDao.delWorktimeByDnoDao(timeno)){
					return 1;
				}
				return 2;
			}
			return 0;
		}
		//根据工号查
		public Map<String, ArrayList<String>> queryWTByDno(int dno) {
			ArrayList<String> week_1 = new ArrayList<String>();
			ArrayList<String> week_2 = new ArrayList<String>();
			ArrayList<String> week_3 = new ArrayList<String>();
			ArrayList<String> week_4 = new ArrayList<String>();
			ArrayList<String> week_5 = new ArrayList<String>();
			ArrayList<String> week_6 = new ArrayList<String>();
			ArrayList<String> week_7 = new ArrayList<String>();
			for(int a=0;a<4;a++){
				week_1.add(" ");
				week_2.add(" ");
				week_3.add(" ");
				week_4.add(" ");
				week_5.add(" ");	
				week_6.add(" ");
				week_7.add(" ");
			}
			int index;
			String time = null;
			Map<String, ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();			
			for (DoctorWorktime wtd:wtDao.queryWorktimeByDnoDao(dno)) {
				index = wtd.getTimereg() - 1;
				time = wtd.getTimetime();
				switch (wtd.getTimedate()) {
					case "星期一":
						week_1.set(index, time);
						break;
					case "星期二":
						week_2.set(index, time);
						break;
					case "星期三":
						week_3.set(index, time);
						break;
					case "星期四":
						week_4.set(index, time);
						break;
					case "星期五":
						week_5.set(index, time);
						break;
					case "星期六":
						week_6.set(index, time);
						break;
					case "星期日":
						week_7.set(index, time);
						break;
				}
			}
			map.put("星期一", week_1);
			map.put("星期二", week_2);
			map.put("星期三", week_3);
			map.put("星期四", week_4);
			map.put("星期五", week_5);
			map.put("星期六", week_6);
			map.put("星期日", week_7);
			return map;
		}		
		
		public int queryWorktimeByWT(DoctorWorktime doctorWorktime){
			return wtDao.queryWorktimeByWTDao(doctorWorktime);
		}
}
