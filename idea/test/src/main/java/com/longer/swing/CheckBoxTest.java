package com.longer.swing;

import javax.swing.*;

/**
 * @program: test
 * @description: 应该与FrameUniversal油罐
 * @author: PuTao
 * @create: 2018-09-19 09:10
 **/
public class CheckBoxTest {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		JPanel jPanel = new JPanel();

//		JPanel jPanel = FrameUniversal.init("checkbox", "zidongsh");
		JCheckBox jCheckBox = new JCheckBox();
		JCheckBox jCheckBox1 = new JCheckBox();
		jCheckBox.setText("haaa");
		jCheckBox.setEnabled(false);
//		jCheckBox.addActionListener(e -> {
//			if (jCheckBox.isSelected()) {
//				System.out.println("haaaa");
//				System.out.println("haaaa");
//				System.out.println("haaaa");
//			}
//		});


		jCheckBox1.setText("aa");
		jCheckBox1.setEnabled(true);
		jPanel.add(jCheckBox1);
		jPanel.add(jCheckBox);
		jPanel.setVisible(true);

		jFrame.add(jPanel);
		jFrame.setSize(400,400);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);

	}
}
