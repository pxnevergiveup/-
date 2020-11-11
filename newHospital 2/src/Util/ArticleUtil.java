package Util;

import java.io.*;
import java.util.ArrayList;

public class ArticleUtil {
	//写
    public void writeToText(String musicInfo, String fileName) throws IOException {
        String path = "D:\\wenzhang\\" + fileName + ".txt"; 
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(musicInfo);
        bw.flush();
        bw.close();
        fw.close();
    }
    //遍历文件夹文件
    public ArrayList<String> GetWn()
    {
        File dir = new File("D:\\wenzhang");
        String[] names = dir.list();
    	ArrayList<String> wl=new ArrayList<String>();
        for (String name : names) {
        	String result = name.substring(0,name.length()-4);
        	wl.add(result);
        }
    	return wl;
    }
    //读
    public String readToText(String name){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\wenzhang\\"+name+".txt"), "utf-8"));
            String s = null;
            while((s = br.readLine())!=null){
                result = result + "\n\n" +s;
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    //删
    public boolean deleteFile(String fileName) {  
    	String s = "D:\\wenzhang\\" + fileName + ".txt";
    	   File file = new File(s);
    	   if(file.exists()){
    		   if(file.delete()){
    			   return true;
	    	   }
    		   return false;
    	   }
    	   return false;
    }  
}