package com.zhixing.cn.MyUtil;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:36:45
* 类说明
*/
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
public class CAPTCHALabel extends JLabel{
	private static final long serialVersionUID=-963570191302793615L;
    private String text;
    public CAPTCHALabel(String text){
    	this.text=text;
    	setPreferredSize(new Dimension(60,36));
    }
    @Override
    public void paint(Graphics g){
    	super.paint(g);
    	g.setFont(new Font("微软雅黑",Font.PLAIN,16));
    	g.drawString(text, 5, 25);
    }
}
