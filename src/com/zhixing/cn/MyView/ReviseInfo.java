package com.zhixing.cn.MyView;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.client.sei.ValueSetter;
import com.zhixing.cn.MyUtil.DBHelper;
import com.zhixing.cn.MyUtil.UserDataBack;
import com.zhixing.model.Message;
import com.zhixing.model.UserName;

/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月9日 下午9:24:46
* 类说明
*/
public class ReviseInfo extends JFrame{

	private static final long serialVersionUID = 1L;
	
	static Vector data=new Vector();
	
	private JPanel ContentPanel;
	static JLabel uPTextField=new JLabel();
	static JLabel uNTextField=new JLabel();
	static JTextField uETextField=new JTextField();
	static JTextField cNTextField=new JTextField();
	static JTextField cNaTextField=new JTextField();

	public static void main(String[] args){
		ReviseInfo fReviseInfo=new ReviseInfo();
		fReviseInfo.setVisible(true);
	}
	public ReviseInfo(){
		Toolkit toolKit = getToolkit();
		Image icon = toolKit.getImage(MyDataView.class.getResource("computer.png"));
//		setLocation(com.zhixing.cn.MyUtil.SwingUtil.centreContainer(getSize()));
		setLocation(500,300);
		setIconImage(icon);
		setTitle("设置信息");
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setSize(400,300);
		setResizable(false);
		//初始化界面
		init();
		//showTextFieldData(0);
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
		uPTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		uPTextField.setBounds(150, 0, 200, 25);
		//UPPanel.setBackground(Color.RED);
		UPPanel.add(UPlabel1);
		UPPanel.add(uPTextField);
		UPPanel.setSize(300,25);
		UPPanel.setLocation(25, 25);
		
		JPanel UNPanel=new JPanel();
		UNPanel.setLayout(null);
		JLabel UNlabel1=new JLabel("UserName :");
		UNlabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UNlabel1.setBounds(53, 0, 100, 25);
		//JLabel UNlabel2=new JLabel("dingcanbin");
		uNTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		uNTextField.setBounds(150, 0, 200, 25);
		UNPanel.add(UNlabel1);
		UNPanel.add(uNTextField);
		UNPanel.setSize(300,25);
		UNPanel.setLocation(25, 60);
		
		JPanel UEPanel=new JPanel();
		UEPanel.setLayout(null);
		JLabel UElabel1=new JLabel("UserEmail :");
		UElabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		UElabel1.setBounds(58,0,100,25);
		//JLabel UElabel2=new JLabel("13160676651@163.com");
		uETextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		uETextField.setBounds(150,0,250,25);
		UEPanel.add(UElabel1);
		UEPanel.add(uETextField);
		UEPanel.setSize(350,25);
		UEPanel.setLocation(25, 95);
		
		JPanel CNPanel=new JPanel();
		CNPanel.setLayout(null);
		JLabel CNlabel1=new JLabel("CarNo :");
		CNlabel1.setBounds(82,0,100,25);
		CNlabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		//JLabel CNlabel2=new JLabel("粤S397EC");
		cNTextField.setBounds(150,0,200,25);
		cNTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		CNPanel.add(CNlabel1);
		CNPanel.add(cNTextField);
		CNPanel.setSize(300,25);
		CNPanel.setLocation(25, 130);
		
		JPanel CNaPanel=new JPanel();
		CNaPanel.setLayout(null);
		JLabel CNalabel1=new JLabel("CarName :");
		CNalabel1.setBounds(62, 0, 100, 25);
		CNalabel1.setFont(new Font("微软雅黑",Font.PLAIN,15));
		//JLabel CNalabel2=new JLabel("保时捷911");
		cNaTextField.setBounds(150, 0, 200, 25);
		cNaTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		CNaPanel.add(CNalabel1);
		CNaPanel.add(cNaTextField);
		CNaPanel.setSize(300,25);
		CNaPanel.setLocation(25, 165);
		

		JPanel ButtonPanel=new JPanel();
		ButtonPanel.setLayout(null);
		Button submitButton=new Button("确定");
		submitButton.setBounds(150,0,100,30);
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ButtonPanel.add(submitButton);
		ButtonPanel.setSize(500,30);
		ButtonPanel.setLocation(0,210);
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				do_updateData(e);
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
	
	protected void do_updateData(ActionEvent e) {
		String userPhone=uPTextField.getText();
		String userName=uNTextField.getText();
		String userEmail=uETextField.getText();
		String carNo=cNTextField.getText();
		String carName=cNaTextField.getText();
		System.out.println(userPhone+userName+userEmail+carNo+carName);
		
		String update="UPDATE tb_user a INNER JOIN tb_car b ON a.userPhone=b.userPhone SET"
				+ " b.userEmail='"+userEmail+"',b.carNo='"+carNo+"',"
				+ "b.carName='"+carName+"' WHERE a.userName='"+userName+"'";
		//DBHelper.DataUpdate(update);
		if (DBHelper.DataUpdate(update)) {
			JOptionPane.showMessageDialog(this, "更新成功！", "Prompt Message", JOptionPane.INFORMATION_MESSAGE);
			UserMessage.showTextFieldData2(userName);
			return;
			} else {
			JOptionPane.showMessageDialog(this, "更新失败！", "Warning Message", JOptionPane.WARNING_MESSAGE);
			return;
			}
	}
	
	
	public static void showTextFieldData(int index,UserName userName){
//		User user=new User();
		String name=userName.getUserName();
		//System.out.println("<<<<<userName"+name);
		String sql="select tb_user.userPhone,tb_user.userName,userEmail,carNo,"
				+ "carName from tb_user,tb_car where tb_user.userPhone=tb_car.userPhone and tb_user.userName='"+name+"'";
		data=UserDataBack.queryData(sql);
		//System.out.println(data);
		if(data.size()>0){
			Message userMessage=new Message();
			Vector vUser=(Vector)data.get(index);
			userMessage.getUserMessageInfo(vUser);
			uPTextField.setText(userMessage.userPhone);
			uNTextField.setText(userMessage.userName);
			uETextField.setText(userMessage.userEmail);
			cNTextField.setText(userMessage.carNo);
			cNaTextField.setText(userMessage.carName);
		}
		
	}
}
