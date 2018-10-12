package com.longer.swing;

import javax.swing.*;

/**
 * @program: test
 * @description: 通用框架
 * @author: PuTao
 * @create: 2018-09-17 17:05
 **/
public class FrameUniversal {
	private JFrame jFrame = new JFrame();
	private JPanel jPanel = new JPanel();
	private JLabel label = new JLabel();
	public  FrameUniversal(){
		jFrame.setSize(500,500);
		jPanel.add(label);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static JPanel init(String frameName,String labelName){
		FrameUniversal fu = new FrameUniversal();
		fu.jFrame.setTitle(frameName);
		fu.label.setText(labelName);
		return fu.getjPanel();
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JPanel getjPanel() {
		return jPanel;
	}

	public void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}
