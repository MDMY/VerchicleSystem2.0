package com.zhixing.cn.MyView;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:29:49
* 登录界面
*/

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.commons.lang.RandomStringUtils;

import com.zhixing.cn.MyUtil.CAPTCHALabel;
import com.zhixing.cn.MyUtil.DBHelper;
import com.zhixing.model.UserName;

public class Login extends JFrame{
	private static final long serialVersionUID= -4655235896173916415L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JTextField validateTextField;
	private String randomText;
	
	public String userNameBack;
	
	
	public static void main(String args[]){
		/*try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Throwable e){
			e.printStackTrace();
		}*/
		EventQueue.invokeLater(new Runnable(){
			public void run(){
			try{
				Login frame=new Login();
				frame.setVisible(true);
			}catch(Exception e){
				e.printStackTrace();
			}
			}
		});
	}
	
	
	public Login(){
		//设置window的icon
		Toolkit toolkit=getToolkit();
		Image icon=toolkit.getImage(Login.class.getResource("computer.png"));
		setIconImage(icon);
		setBackground(Color.white);
		setTitle("The Vehicle network system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane=new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
		setSize(400,250);	
		setResizable(false);
		JPanel usernamePanel=new JPanel();
		contentPane.add(usernamePanel);
		JLabel usernameLabel=new JLabel("UserName");
		usernameLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		usernamePanel.add(usernameLabel);
		//usernamePanel.setLocation(100, 100);
		usernameTextField=new JTextField();
		usernameTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		usernamePanel.add(usernameTextField);
		usernameTextField.setColumns(10);
		JPanel passwordPanel=new JPanel();
		contentPane.add(passwordPanel);
		JLabel passwordLabel=new JLabel("Password");
		passwordLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		passwordPanel.add(passwordLabel);
		passwordField=new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		passwordPanel.add(passwordField);
		JPanel validatePanel=new JPanel();
		contentPane.add(validatePanel);
		JLabel validateLabel=new JLabel("Verification");
		validateLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		validatePanel.add(validateLabel);
		validateTextField=new JTextField();
		validateTextField.setFont(new Font("微软雅黑",Font.PLAIN,15));
		validatePanel.add(validateTextField);
		validateTextField.setColumns(5);
		randomText=RandomStringUtils.randomAlphanumeric(4);
		CAPTCHALabel label=new CAPTCHALabel(randomText);
		label.setFont(new Font("微软雅黑",Font.PLAIN,15));
		validatePanel.add(label);
		
		JPanel buttonPanel=new JPanel();
		contentPane.add(buttonPanel);
		JButton submitButton=new JButton("Submit");
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_submitButton_actionPerformed(e);
			}
		});
		submitButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
		buttonPanel.add(submitButton);
		
		JButton cancelButton=new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_cancelButton_actionPerformed(e);
			}
		});
		cancelButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
		buttonPanel.add(cancelButton);
		JPanel buttonPanel2=new JPanel();
		contentPane.add(buttonPanel2);
		JButton registerButton=new JButton("Register");
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_registerButton_actionPerformed(e);
			}
		});
		registerButton.setFont(new Font("微软雅黑",Font.PLAIN,15));
		buttonPanel2.add(registerButton);
		
		
		//pack();
		setLocation(com.zhixing.cn.MyUtil.SwingUtil.centreContainer(getSize()));
		
	
	}


	protected void do_registerButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Register register=new Register();
		register.setVisible(true);
		this.dispose();
	}


	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}


	protected void do_submitButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username=usernameTextField.getText();
		String  password=passwordField.getText();
		String validate=validateTextField.getText();
		
		//保存登录的用户名字
		UserName userName=new UserName();
		userName.setUserName(usernameTextField.getText());
		userNameBack=usernameTextField.getText();
		//System.out.println("1111111111 :"+userName.getUserName());
		//返回用户的登录信息
		UserMessage.showTextFieldData(0,userName);
		
		if(username.isEmpty()){
			JOptionPane.showMessageDialog(null,"UserName cannot be empty！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(new String(password).isEmpty()){
			JOptionPane.showMessageDialog(null,"Password cannot be empty！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(validate.isEmpty()){
			JOptionPane.showMessageDialog(null,"Verification cannot be empty！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!DBHelper.exists(username)){
			JOptionPane.showMessageDialog(null,"UserName does not exist！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!DBHelper.check(username,password.toCharArray())){
			JOptionPane.showMessageDialog(null,"Password Error！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		if(!validate.equals(randomText)){
			JOptionPane.showMessageDialog(null,"Verification Code Error！","Warning Message",JOptionPane.WARNING_MESSAGE);
			return;
	    }
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run(){
				try{
					//MainFrame frame=new MainFrame();
					/*MyClient frame=new MyClient();
					frame.setVisible(true);*/
					new MyClient().launchFrame();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		this.dispose();
	}
}

