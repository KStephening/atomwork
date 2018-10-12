package com.longer.swing;

		import javax.swing.*;

/**
 * @program: test
 * @description:
 * @author: PuTao
 * @create: 2018-09-19 18:32
 **/
public class JFrameTemp {
	private JFrame jFrame;
	private JPanel jPanel;
	private JFrameTemp() {
		jFrame = new JFrame();
		jPanel = new JPanel();
		jFrame.setSize(500,500);
		jFrame.add(jPanel);
//		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public  static  JFrame getJFame(){
		JFrameTemp jFrameTemp = new JFrameTemp();
		return jFrameTemp.jFrame;
	}
	public static void main(String[] args){
		JFrame jFrame=getJFame();
		JPanel jPanel = (JPanel) jFrame.getContentPane();
		JLabel jLabel = new JLabel("hello");
		jPanel.add(jLabel);
		jFrame.setVisible(true);
	}
}
