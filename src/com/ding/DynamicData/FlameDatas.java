package com.ding.DynamicData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FlameDatas {
	private String flameData=null;
	
	public synchronized void readText(){
		String file="D:\\Eclipse\\workspace\\VerchicleSystem2.0\\text\\flame.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String firstLine=br.readLine();
			String[] data=firstLine.split("[: }]");
			if(data[1].equals("1")){
				flameData="正常";
			}else {
				flameData="异常";
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("线程"+Thread.currentThread().getName()+"String:"+flameData);
	}
	public String getString(){
		return flameData;
	}
}
