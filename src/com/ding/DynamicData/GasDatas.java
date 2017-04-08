package com.ding.DynamicData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GasDatas {
	private String gasData=null;
	
	public synchronized void readText(){
		String file="D:\\Eclipse\\workspace\\VerchicleSystem2.0\\text\\gas.txt";
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String firstLine=br.readLine();
			String[] data=firstLine.split("[: }]");
			gasData=data[1];
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println("�߳�"+Thread.currentThread().getName()+"String:"+gasData);
	}
	public String getString(){
		return gasData;
	}
}
