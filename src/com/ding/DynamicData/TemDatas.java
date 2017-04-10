package com.ding.DynamicData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TemDatas {
	private String temData=null;
	
	public synchronized void readText(){
		String file="D:\\Eclipse\\workspace\\VerchicleSystem2.0\\text\\tem.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String firstLine=br.readLine();
			String[] data=firstLine.split("[: }]");
			temData=data[1];
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("线程"+Thread.currentThread().getName()+"String:"+temData);
	}
	public String getString(){
		return temData;
	}
}
