package com.ding.DynamicData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version ����ʱ�䣺2017��4��5�� ����4:51:16
* ��˵��
*/
public class ReadHumData implements Runnable {

	HumDatas humDatas;
	public ReadHumData(HumDatas humDatas){
		this.humDatas=humDatas;
	}
	public void run(){
		ScheduledExecutorService executorService=Executors.newScheduledThreadPool(1);	
	    executorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					humDatas.readText();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 10, TimeUnit.SECONDS);	
	}
}
