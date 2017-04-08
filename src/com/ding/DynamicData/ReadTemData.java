package com.ding.DynamicData;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version ����ʱ�䣺2017��4��5�� ����4:46:51
* ��˵��
*/
public class ReadTemData implements Runnable {

	TemDatas temDatas;
	public ReadTemData(TemDatas temDatas){
		this.temDatas=temDatas;
	}
	public void run(){
		ScheduledExecutorService executorService=Executors.newScheduledThreadPool(1);	
	    executorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					temDatas.readText();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, 0, 10, TimeUnit.SECONDS);	
	}
}
