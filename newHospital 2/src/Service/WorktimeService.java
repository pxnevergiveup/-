package Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import Dao.WorktimeDao;
import Entity.DoctorWorktime;

public class WorktimeService {
		WorktimeDao wtDao =new WorktimeDao();
		//��
		public boolean addWT(DoctorWorktime doctorWorktime) {
			if(!wtDao.isExist(doctorWorktime)){
				return wtDao.addWorktimeDao(doctorWorktime);
			}
			return false;
		}
		//ɾ����ʱ���ԤԼ��
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
		//ɾ
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
		//���ݹ��Ų�
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
					case "����һ":
						week_1.set(index, time);
						break;
					case "���ڶ�":
						week_2.set(index, time);
						break;
					case "������":
						week_3.set(index, time);
						break;
					case "������":
						week_4.set(index, time);
						break;
					case "������":
						week_5.set(index, time);
						break;
					case "������":
						week_6.set(index, time);
						break;
					case "������":
						week_7.set(index, time);
						break;
				}
			}
			map.put("����һ", week_1);
			map.put("���ڶ�", week_2);
			map.put("������", week_3);
			map.put("������", week_4);
			map.put("������", week_5);
			map.put("������", week_6);
			map.put("������", week_7);
			return map;
		}		
		
		public int queryWorktimeByWT(DoctorWorktime doctorWorktime){
			return wtDao.queryWorktimeByWTDao(doctorWorktime);
		}
}
