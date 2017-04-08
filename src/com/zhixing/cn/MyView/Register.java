package com.zhixing.cn.MyView;
/**
* @author DingCanbin  E-mail:13160676651@163.com
* @version 创建时间：2017年4月8日 下午3:48:16
* 类说明
*/
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.AbstractDocument;

import com.zhixing.model.User;
import com.zhixing.cn.MyUtil.DBHelper;
import com.zhixing.cn.MyUtil.DocumentSizeFilter;
import com.zhixing.cn.MyUtil.DocumentSizeListener;
import com.zhixing.cn.MyUtil.SwingUtil;

public class Register extends JFrame {
	
	private static final long serialVersionUID=2491294229716316338L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField1;
	private JPasswordField passwordField2;
    private JTextField emailTextField;
    private JLabel tipLabel=new JLabel();
    
    
    public static void main(String[] args){
    	try{
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");	
    	}catch(Throwable e){
    		e.printStackTrace();
    	}
    	EventQueue.invokeLater(new Runnable(){
    		@Override
    		public void run(){
    			try{
    				Register frame=new Register();
    				frame.setVisible(true);
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    	});
    }
    public Register() {
    	setTitle("Register");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(400,250);
    	//设置window的icon
    	Toolkit toolkit=getToolkit();
    	Image icon=toolkit.getImage(Login.class.getResource("computer.png"));
    	setIconImage(icon);
    	setResizable(false);
    	contentPane = new JPanel();
    	setContentPane(contentPane);
    	contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
    	JPanel usernamePanel = new JPanel();
    	contentPane.add(usernamePanel);
    	JLabel usernameLabel = new JLabel("UserName");
    	usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	usernamePanel.add(usernameLabel);
    	usernameTextField = new JTextField();
    	usernameTextField.setToolTipText("");
    	AbstractDocument doc = (AbstractDocument) usernameTextField.getDocument();
    	doc.setDocumentFilter(new DocumentSizeFilter(15));// 限制文本域内可以输入字符长度为15
    	doc.addDocumentListener(new DocumentSizeListener(tipLabel, 15));
    	usernameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	usernamePanel.add(usernameTextField);
    	usernameTextField.setColumns(10);
    	JPanel passwordPanel1 = new JPanel();
    	contentPane.add(passwordPanel1);
    	JLabel passwordLabel1 = new JLabel("Password");
    	passwordLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	passwordPanel1.add(passwordLabel1);
    	passwordField1 = new JPasswordField();
    	doc = (AbstractDocument) passwordField1.getDocument();
    	doc.setDocumentFilter(new DocumentSizeFilter(20));// 限制密码域内可以输入字符长度为20
    	doc.addDocumentListener(new DocumentSizeListener(tipLabel, 20));
    	passwordField1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	passwordField1.setColumns(10);
    	passwordPanel1.add(passwordField1);
    	JPanel passwordPanel2 = new JPanel();
    	contentPane.add(passwordPanel2);
    	JLabel passwordLabel2 = new JLabel("ConfirmPassword");
    	passwordLabel2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	passwordPanel2.add(passwordLabel2);
    	passwordField2 = new JPasswordField();
    	doc = (AbstractDocument) passwordField2.getDocument();
    	doc.setDocumentFilter(new DocumentSizeFilter(20));// 限制密码域内可以输入字符长度为20
    	doc.addDocumentListener(new DocumentSizeListener(tipLabel, 20));
    	passwordField2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	passwordField2.setColumns(10);
    	passwordPanel2.add(passwordField2);
    	JPanel emailPanel = new JPanel();
    	contentPane.add(emailPanel);
    	JLabel emailLabel = new JLabel("Email");
    	emailLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	emailPanel.add(emailLabel);
    	emailTextField = new JTextField();
    	doc = (AbstractDocument) emailTextField.getDocument();
    	doc.setDocumentFilter(new DocumentSizeFilter(45));// 限制文本域内可以输入字符长度为45
    	doc.addDocumentListener(new DocumentSizeListener(tipLabel, 45));
    	emailTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	emailPanel.add(emailTextField);
    	emailTextField.setColumns(10);
    	JPanel buttonPanel = new JPanel();
    	contentPane.add(buttonPanel);
    	JButton submitButton = new JButton("Sumbit");
    	submitButton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    	        do_submitButton_actionPerformed(e);
    	}
    	});
    	buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
    	tipLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	buttonPanel.add(tipLabel);
    	Component glue = Box.createGlue();
    	buttonPanel.add(glue);
    	submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	buttonPanel.add(submitButton);
    	JButton cancelButton = new JButton("Return");
    	cancelButton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
    			do_cancelButton_actionPerformed(e);
    	}
    	});
    	cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
    	buttonPanel.add(cancelButton);
    	//pack();// 自动调整窗体大小
    	setLocation(SwingUtil.centreContainer(getSize()));// 让窗体居中显示
    	}
	protected void do_cancelButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Login back=new Login();
		back.setVisible(true);
		this.dispose();
		
	}
	protected void do_submitButton_actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username=usernameTextField.getText();
		String  password1=passwordField1.getText();
		String  password2=passwordField2.getText();
		String email=emailTextField.getText();
		if (username.isEmpty()) {// 判断用户名是否为空
			JOptionPane.showMessageDialog(this, "UserName cannot be empty！", "Warning Message", JOptionPane.WARNING_MESSAGE);
			return;
			}
		if (new String(password1).isEmpty()) {// 判断密码是否为空
			JOptionPane.showMessageDialog(this, "Password cannot be empty！", "Warning Message", JOptionPane.WARNING_MESSAGE);
			return;
			}
		if (new String(password2).isEmpty()) {// 判断确认密码是否为空
			JOptionPane.showMessageDialog(this, "Confirm password cannot be empty！", "Warning Message", JOptionPane.WARNING_MESSAGE);
			return;
			}
		if (email.isEmpty()) {// 判断电子邮箱是否为空
			JOptionPane.showMessageDialog(this, "E-mail can not be empty！", "Warning Message", JOptionPane.WARNING_MESSAGE);
			return;
			}
		// 校验用户名是否合法
		if (!Pattern.matches("^[\u4e00-\u9fa5_a-zA-Z0-9]+$", username)) {
		JOptionPane.showMessageDialog(this, "Please enter a valid username！", "Warning Message", JOptionPane.WARNING_MESSAGE);
		return;
		}
		// 校验两次输入的密码是否相同
		if (!Arrays.equals(password1.toCharArray(), password2.toCharArray())) {
		JOptionPane.showMessageDialog(this, "Two different passwords！", "Warning Message", JOptionPane.WARNING_MESSAGE);
		return;
		}
		// 校验电子邮箱是否合法
		if (!Pattern.matches("\\w+@\\w+\\.\\w+", email)) {
		JOptionPane.showMessageDialog(this, "Please enter a valid e-mail address！", "Warning Message", JOptionPane.WARNING_MESSAGE);
		return;
		}
		// 校验用户名是否存在
		if (DBHelper.exists(username)) {
		JOptionPane.showMessageDialog(this, "User name already exists", "Warning Message", JOptionPane.WARNING_MESSAGE);
		return;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(new String(password1));
		user.setEmail(email);
		Arrays.fill(password1.toCharArray(), '0');// 清空保存密码的字符数组
		Arrays.fill(password2.toCharArray(), '0');// 清空保存密码的字符数组
		if (DBHelper.save(user)) {
		JOptionPane.showMessageDialog(this, "User registration success！", "Prompt Message", JOptionPane.INFORMATION_MESSAGE);
		return;
		} else {
		JOptionPane.showMessageDialog(this, "User registration failed！", "Warning Message", JOptionPane.WARNING_MESSAGE);
		return;
		}
		}
		
	}



