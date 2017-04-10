package com.zhixing.cn.MyView;
import java.awt.Button;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月9日 下午2:38:42
* 类说明
*/
import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zhixing.cn.MyUtil.UserDataBack;
import com.zhixing.model.Message;
import com.zhixing.model.User;
//import javax.swing.UIManager;
import com.zhixing.model.UserName;

//import com.ding.model.Message;
//import com.ding.util.Database;

public class UserMessage extends JFrame{
	private static final long serialVersionUID= -1L;
	static Vector data=new Vector();
	static int index=0;
	private JPanel ContentPanel;
	static JLabel UPlabel2=new JLabel();
	static JLabel UNlabel2=new JLabel();
	static JLabel UElabel2=new JLabel();
	static JLabel CNlabel2=new JLabel();
	static JLabel CNalabel2=new JLabel();

//	public static void main(String[] args){
//
//		
//		UserMessage frame=new UserMessage();
//		frame.setVisible(true);
//	}
	public UserMessage(){
		Toolkit toolKit = getToolkit();
		Image icon = toolKit.getImage(MyDataView.class.getResource("computer.png"));
//		setLocation(com.zhixing.cn.MyUtil.SwingUtil.centreContainer(getSize()));
		setLocation(500,300);
		setIconImage(icon);
		setTitle("用户信息");
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(400,300);
		setResizable(false);
		//初始化界面
		init();
		//showTextFieldData(0,u);
	}
	public void init(){
		ContentPanel=new JPanel();
		//ContentPanel.setBackground(Color.black);
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		//ContentPanel.setLayout(new BoxLayout(ContentPanel,BoxLayout.PAGE_AXIS));
		JPanel UPPanel=new JPanel();
		UPPanel.setLayout(null);
		JLabel UPlabel1=new JLabel("UserPhone :");
		UPlabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UPlabel1.setBounds(50, 0, 100, 25);
		//JLabel UPlabel2=new JLabel("13160676651");
		UPlabel2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UPlabel2.setBounds(150, 0, 200, 25);
		//UPPanel.setBackground(Color.RED);
		UPPanel.add(UPlabel1);
		UPPanel.add(UPlabel2);
		UPPanel.setSize(300,25);
		UPPanel.setLocation(25, 25);
		
		JPanel UNPanel=new JPanel();
		UNPanel.setLayout(null);
		JLabel UNlabel1=new JLabel("UserName :");
		UNlabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UNlabel1.setBounds(53, 0, 100, 25);
		//JLabel UNlabel2=new JLabel("dingcanbin");
		UNlabel2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UNlabel2.setBounds(150, 0, 200, 25);
		UNPanel.add(UNlabel1);
		UNPanel.add(UNlabel2);
		UNPanel.setSize(300,25);
		UNPanel.setLocation(25, 60);
		
		JPanel UEPanel=new JPanel();
		UEPanel.setLayout(null);
		JLabel UElabel1=new JLabel("UserEmail :");
		UElabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UElabel1.setBounds(58,0,100,25);
		//JLabel UElabel2=new JLabel("13160676651@163.com");
		UElabel2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UElabel2.setBounds(150,0,250,25);
		UEPanel.add(UElabel1);
		UEPanel.add(UElabel2);
		UEPanel.setSize(350,25);
		UEPanel.setLocation(25, 95);
		
		JPanel CNPanel=new JPanel();
		CNPanel.setLayout(null);
		JLabel CNlabel1=new JLabel("CarNo :");
		CNlabel1.setBounds(82,0,100,25);
		CNlabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		//JLabel CNlabel2=new JLabel("粤S397EC");
		CNlabel2.setBounds(150,0,200,25);
		CNlabel2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		CNPanel.add(CNlabel1);
		CNPanel.add(CNlabel2);
		CNPanel.setSize(300,25);
		CNPanel.setLocation(25, 130);
		
		JPanel CNaPanel=new JPanel();
		CNaPanel.setLayout(null);
		JLabel CNalabel1=new JLabel("CarName :");
		CNalabel1.setBounds(62, 0, 100, 25);
		CNalabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		//JLabel CNalabel2=new JLabel("保时捷911");
		CNalabel2.setBounds(150, 0, 200, 25);
		CNalabel2.setFont(new Font("微软雅黑",Font.PLAIN,15));
		CNaPanel.add(CNalabel1);
		CNaPanel.add(CNalabel2);
		CNaPanel.setSize(300,25);
		CNaPanel.setLocation(25, 165);
		

		JPanel ButtonPanel=new JPanel();
		ButtonPanel.setLayout(null);
		Button settingButton=new Button("设置信息");
		settingButton.setBounds(150,0,100,30);
		settingButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ButtonPanel.add(settingButton);
		ButtonPanel.setSize(500,30);
		ButtonPanel.setLocation(0,210);
		settingButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//保存登录的用户名字
				UserName userName=new UserName();
				userName.setUserName(UNlabel2.getText());
				ReviseInfo reviseInfoFrame=new ReviseInfo();
				ReviseInfo.showTextFieldData(0,userName);
				reviseInfoFrame.setVisible(true);
				dispose();
			}
		});
		
		ContentPanel.add(UPPanel);
		ContentPanel.add(UNPanel);
		ContentPanel.add(UEPanel);
		ContentPanel.add(CNPanel);
		ContentPanel.add(CNaPanel);
//		ContentPanel.add(text);
		ContentPanel.add(ButtonPanel);
//		ContentPanel.add(settingButton);
	
	}
	public static void showTextFieldData(int index,UserName userName){
//		User user=new User();
		String name=userName.getUserName();
		//System.out.println("<<<<<userName"+name);
		String sql="select tb_user.userPhone,tb_user.userName,userEmail,carNo,carName from tb_user,tb_car where tb_user.userPhone=tb_car.userPhone and tb_user.userName='"+name+"'";
		data=UserDataBack.queryData(sql);
		//System.out.println(data);
		if(data.size()>0){
			Message userMessage=new Message();
			Vector vUser=(Vector)data.get(index);
			userMessage.getUserMessageInfo(vUser);
			UPlabel2.setText(userMessage.userPhone);
			UNlabel2.setText(userMessage.userName);
			UElabel2.setText(userMessage.userEmail);
			CNlabel2.setText(userMessage.carNo);
			CNalabel2.setText(userMessage.carName);
		}
	}
	public static void showTextFieldData2(String userName){
//		User user=new User();
		String name=userName;
		//System.out.println("<<<<<userName"+name);
		String sql="select tb_user.userPhone,tb_user.userName,userEmail,carNo,carName from tb_user,tb_car where tb_user.userPhone=tb_car.userPhone and tb_user.userName='"+name+"'";
		data=UserDataBack.queryData(sql);
		//System.out.println(data);
		if(data.size()>0){
			Message userMessage=new Message();
			Vector vUser=(Vector)data.get(index);
			userMessage.getUserMessageInfo(vUser);
			UPlabel2.setText(userMessage.userPhone);
			UNlabel2.setText(userMessage.userName);
			UElabel2.setText(userMessage.userEmail);
			CNlabel2.setText(userMessage.carNo);
			CNalabel2.setText(userMessage.carName);
		}
	}
}
