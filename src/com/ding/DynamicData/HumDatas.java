package com.ding.DynamicData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HumDatas {
	private String humData=null;
	
	public synchronized void readText(){
		String file="D:\\Eclipse\\workspace\\VerchicleSystem2.0\\text\\hum.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String firstLine=br.readLine();
			String[] data=firstLine.split("[: }]");
			humData=data[1];
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("线程"+Thread.currentThread().getName()+"String:"+humData);
	}
	public String getString(){
		return humData;
	}
}
