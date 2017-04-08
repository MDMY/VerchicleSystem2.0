package com.zhixing.cn.MyUtil;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:44:40
* 类说明
*/
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class DocumentSizeListener implements DocumentListener {
	private JLabel tipLabel;
	private int maxSize;
	public DocumentSizeListener(JLabel tipLabel,int maxSize){
		this.tipLabel=tipLabel;
		this.maxSize=maxSize;
	}
	@Override
	public void insertUpdate(DocumentEvent e){
		setTipText(e);
	}
	@Override
	public void removeUpdate(DocumentEvent e){
		setTipText(e);
	}
	@Override
	public void changedUpdate(DocumentEvent e){
		setTipText(e);
	}
	private void setTipText(DocumentEvent e){
		Document doc=e.getDocument();
		tipLabel.setForeground(Color.BLACK);
		if(doc.getLength()>(maxSize*4/5)){
			tipLabel.setForeground(Color.RED);
		}else{
			tipLabel.setForeground(Color.BLACK);
		}
		tipLabel.setText("提示消息"+doc.getLength()+"/"+maxSize);
	}

}
