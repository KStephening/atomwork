package com.longer.swing;

import javax.swing.*;
import java.io.File;

/**
 * @program: test
 * @description: 文件路径选择
 * @author: PuTao
 * @create: 2018-09-17 16:42
 **/
public class FileChooser {
	JTextField dirTextField=new JTextField(25);
	JFrame jFrame = new JFrame();
	public void init(){
		JPanel jPanel = new JPanel();
		jFrame.setTitle("haa");

		jPanel.add(dirTextField);
		JButton button = new JButton("file choose");
//		button.addActionListener(e -> {
//				setPath();
//			}
//
//		);
		jPanel.add(button);
		jFrame.add(jPanel);
		jFrame.setSize(400,400);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setPath(){
		JFileChooser fDialog = new JFileChooser();
// 设置文件选择框的标题
		fDialog.setDialogTitle("请选择文件夹");
		File dir = new File(getDataDir());
// 打开的窗口路径为当前路径
		fDialog.setCurrentDirectory(dir);
// 弹出选择框
		fDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fDialog.showOpenDialog(null);
// 如果是选择了文件
		if (JFileChooser.APPROVE_OPTION == returnVal) {
			dirTextField.setText(fDialog.getSelectedFile().getPath() + File.separator);
		}
	}

	private String getDataDir() {

		return System.getProperty("user.dir");
	}

	public static void main(String[] args){
		FileChooser fileChooser = new FileChooser();
		fileChooser.init();

	}
}
