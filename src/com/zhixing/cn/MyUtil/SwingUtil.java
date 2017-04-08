package com.zhixing.cn.MyUtil;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:45:10
* 类说明
*/
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class SwingUtil {
	public static Point centreContainer(Dimension size){
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(screenSize.width-size.width)/2;
		int y=(screenSize.height-size.height)/2;
		return new Point(x,y);
	}
}
